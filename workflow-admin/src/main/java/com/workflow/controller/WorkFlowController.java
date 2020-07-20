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

    @PostMapping(value="/saveDeployment")
    @ApiOperation(value="保存/修改流程定义")
    public CommonResult saveOrUpdateDeploy(@RequestParam(value="jsondata",required = true) String jonsdata){
        activityService.saverOrUpdateDeployment(jonsdata);

        return CommonResult.success("");
    }

}
