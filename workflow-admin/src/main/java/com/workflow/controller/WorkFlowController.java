package com.workflow.controller;

import com.workflow.common.api.CommonResult;
import com.workflow.service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping (value = "/saveDeployment")
    @ApiOperation(value = "保存/修改流程定义")
    public CommonResult saveOrUpdateDeploy(String jsondata,
                                           Long deployid) {
        try {
            activityService.saverOrUpdateDeployment(jsondata,deployid);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success("生成成功");
    }
    @PostMapping(value = "/start")
    @ApiOperation(value = "启动流程")
    public CommonResult startActivity(@RequestParam(value = "deployid",required = true) Long deployid,
                                      @RequestParam(value = "formdata",required = true) String formdata,
                                      @RequestParam(value="userid",required = true) String userid){
        try {
            activityService.startActivity(deployid,formdata,userid);
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success("启动成功");
    }
    @GetMapping(value = "/handle")
    @ApiOperation(value = "流程办理")
    public CommonResult activityHandle(@RequestParam(value = "agentid",required = true) Long agentid,
                                       @RequestParam(value="formdata",required = true) String formdata){
        try {
            activityService.handleActivity(agentid,formdata);
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success("");
    }
}
