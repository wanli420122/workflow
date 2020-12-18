package com.workflow.controller;

import cn.hutool.json.JSONObject;
import com.workflow.common.api.CommonResult;
import com.workflow.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.management.modelmbean.RequiredModelMBean;
import java.util.Map;

/**
 * 工作流处理controller
 * Create by wl on 2020/7/15
 */
@RestController
@Api(tags = "WorkFlowController", description = "工作流管理")
@RequestMapping("/act")
public class WorkFlowController {

    @Autowired
    private ActivityService activityService;

    @PostMapping(value = "/saveOrUpdateDeploy")
    @ApiOperation(value = "保存/修改流程定义")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jsondata", dataType = "String",
                    required = true, value = "流程实例json字符串"),
            @ApiImplicitParam(name = "deployid", dataType = "Long",
                    required = true, value = "流程定义id")
    })
    public CommonResult saveOrUpdateDeploy(String jsondata,
                                           Long deployid) {
        try {
            activityService.saverOrUpdateDeployment(jsondata, deployid);
        } catch (Exception e) {


            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success("生成成功");
    }

    @PostMapping(value = "/start")
    @ApiOperation(value = "启动流程")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "deployid", dataType = "Long",
                    required = true, value = "流程定义id"),
            @ApiImplicitParam(paramType = "query", name = "formdata", dataType = "String",
                    required = true, value = "表单数据"),
            @ApiImplicitParam(paramType = "query", name = "userid", dataType = "String",
                    required = true, value = "用户id")
    })
    public CommonResult startActivity(
            @RequestBody Map<String,String> params
//                                      @RequestParam(value = "deployid", required = false) Long deployid,
//                                      @RequestParam(value = "formdata", required = true) String formdata,
//                                      @RequestParam(value = "userid", required = true) String userid
     ) {
        try {
//            activityService.startActivity(deployid,formdata,userid);
            activityService.startActivity(Long.parseLong((String)params.get("deployid")) ,
                    (String)params.get("formdata"), (String)params.get("userid"));
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success("启动成功");
    }

    @PostMapping(value = "/handle")
    @ApiOperation(value = "流程办理")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "agentid", dataType = "Long",
                    required = true, value = "待办人id"),
            @ApiImplicitParam(paramType = "query", name = "formdata", dataType = "String",
                    required = true, value = "表单数据"),
            @ApiImplicitParam(paramType = "query", name = "flag", dataType = "int",
                    required = true, value = "办理人标识 0->通过,1->驳回,2->撤销"),
            @ApiImplicitParam(paramType = "query", name = "rejectToNode", dataType = "String",
                    required = true, value = "驳回到某环节"),
            @ApiImplicitParam(paramType = "query", name = "suggestStr", dataType = "String",
                    required = true, value = "办理建议")
    })
    public CommonResult activityHandle(
            @RequestBody @Validated Map<String,Object> params
//                                       @RequestParam(value = "agentid", required = true) Long agentid,
//                                       @RequestParam(value = "formdata", required = true) String formdata,
//                                       @RequestParam(value = "flag", required = false) int flag,
//                                       @RequestParam(value = "rejectToNode", required = false) String rejectToNode,
//                                       @RequestParam(value="suggestStr", required=false) String suggestStr
    ){
        try {
            Long agentid= Long.parseLong((String) params.get("agentid"));
            String formdata = (String) params.get("formdata");
            int flag =Integer.parseInt((String) params.get("flag"));
            String rejectToNode = (String) params.get("rejectToNode");
            String suggestStr =(String) params.get("suggestStr");
            activityService.handleActivity(agentid, formdata,suggestStr,flag,rejectToNode);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());

        }
        return CommonResult.success("办理成功！");
    }
}
