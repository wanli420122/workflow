package com.workflow.controller;

import com.workflow.common.api.CommonResult;
import com.workflow.model.ActDeployment;
import com.workflow.service.QueryDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public CommonResult updateDeployment(@RequestBody ActDeployment actDeployment){
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
    public CommonResult updateDeployment(@RequestParam(value = "deployid",required = true) Long deployid){
        try {
            queryDataService.deleteDeployment(deployid);
            return CommonResult.success("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
    }

}
