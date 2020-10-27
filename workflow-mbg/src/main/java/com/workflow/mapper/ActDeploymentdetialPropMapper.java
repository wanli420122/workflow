package com.workflow.mapper;

import com.workflow.model.ActDeploymentdetialProp;
import com.workflow.model.ActDeploymentdetialPropExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActDeploymentdetialPropMapper {
    long countByExample(ActDeploymentdetialPropExample example);

    int deleteByExample(ActDeploymentdetialPropExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActDeploymentdetialProp record);

    int insertSelective(ActDeploymentdetialProp record);

    List<ActDeploymentdetialProp> selectByExample(ActDeploymentdetialPropExample example);

    ActDeploymentdetialProp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActDeploymentdetialProp record, @Param("example") ActDeploymentdetialPropExample example);

    int updateByExample(@Param("record") ActDeploymentdetialProp record, @Param("example") ActDeploymentdetialPropExample example);

    int updateByPrimaryKeySelective(ActDeploymentdetialProp record);

    int updateByPrimaryKey(ActDeploymentdetialProp record);
}