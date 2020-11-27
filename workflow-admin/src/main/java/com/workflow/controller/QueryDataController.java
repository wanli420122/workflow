package com.workflow.controller;

import com.workflow.common.api.CommonResult;
import com.workflow.model.ActAgenting;
import com.workflow.model.ActDeployment;
import com.workflow.service.QueryDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 工作流后台查询接口
 * Create by wl on 2020/11/2
 */
@RestController
@Api(tags = "QueryDataController", description = "工作流数据查询接口")
@RequestMapping("/qdc")
public class QueryDataController {

    @Autowired
    QueryDataService queryDataService;

    @GetMapping(value = "/queryDeploylist")
    @ApiOperation(value = "查询流程定义列表")
    public CommonResult getActList(){
        try {
            List<ActDeployment> deployments= queryDataService.queryDeplymentList();
            return CommonResult.success(deployments);
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }
    @PostMapping(value = "/addDeploy")
    @ApiOperation(value = "新增流程定义")
    public CommonResult addDeployment(@RequestBody ActDeployment actDeployment){
        try {
            queryDataService.addDeployment(actDeployment);
            return CommonResult.success("保存成功");
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }
    @PostMapping(value = "/updateDeploy")
    @ApiOperation(value = "修改流程定义")
    public CommonResult updateDeployment(@RequestBody ActDeployment actDeployment

    ){
        try {
            queryDataService.updateDeployment(actDeployment);
            return CommonResult.success("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }
    @GetMapping(value = "/deleteDeploy")
    @ApiOperation(value = "删除流程定义")
    public CommonResult deleteDeployment(@RequestParam(value = "deployid",required = false) String deployid){
        try {
            queryDataService.deleteDeployment(Long.parseLong(deployid));
            return CommonResult.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }
    @GetMapping(value = "/queryTaskLists")
    @ApiOperation(value = "查询待办/已办任务")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userid", dataType = "String",
                    required = true, value = "用户id"),
            @ApiImplicitParam(paramType = "query", name = "flag", dataType = "String",
                    required = true, value = "待办已办状态 0-待办 ，1-已办")
    })
    public CommonResult queryTaskLists(@RequestParam(value = "userid",required = false) String userid,
                                       @RequestParam(value = "flag",required = false) String flag){
        try {
            List<Map> actAgentings=queryDataService.queryTaskLists(userid,flag);
            return CommonResult.success(actAgentings);
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }

    @GetMapping(value = "/queryNode")
    @ApiOperation(value = "查询流程跟踪环节信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "agentingid", dataType = "String",
                    required = true, value = "待办/已办id")
    })
    public CommonResult queryExectionNode(@RequestParam(value="agentingid",required = true) String agentingid){
        try {
            List<Map> actAgentings=queryDataService.queryExectionNodes(agentingid);
            return CommonResult.success(actAgentings);
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }
    @GetMapping(value = "/queryTaskStatus")
    @ApiOperation(value = "查询流程跟踪任务状态")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "agentingid", dataType = "String",
                    required = true, value = "待办/已办id")
    })
    public CommonResult queryTaskStatus(@RequestParam(value="agentingid",required = true) String agentingid){
        try {
            int taskStatus=queryDataService.queryTaskStatus(agentingid);
            return CommonResult.success(taskStatus);
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }
}
