package com.workflow.mapper;

import com.workflow.model.ActDeployment;
import com.workflow.model.ActDeploymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActDeploymentMapper {
    long countByExample(ActDeploymentExample example);

    int deleteByExample(ActDeploymentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActDeployment record);

    int insertSelective(ActDeployment record);

    List<ActDeployment> selectByExampleWithBLOBs(ActDeploymentExample example);

    List<ActDeployment> selectByExample(ActDeploymentExample example);

    ActDeployment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActDeployment record, @Param("example") ActDeploymentExample example);

    int updateByExampleWithBLOBs(@Param("record") ActDeployment record, @Param("example") ActDeploymentExample example);

    int updateByExample(@Param("record") ActDeployment record, @Param("example") ActDeploymentExample example);

    int updateByPrimaryKeySelective(ActDeployment record);

    int updateByPrimaryKeyWithBLOBs(ActDeployment record);

    int updateByPrimaryKey(ActDeployment record);
}