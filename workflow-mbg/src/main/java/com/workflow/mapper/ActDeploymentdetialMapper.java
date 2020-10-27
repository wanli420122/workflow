package com.workflow.mapper;

import com.workflow.model.ActDeploymentdetial;
import com.workflow.model.ActDeploymentdetialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActDeploymentdetialMapper {
    long countByExample(ActDeploymentdetialExample example);

    int deleteByExample(ActDeploymentdetialExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActDeploymentdetial record);

    int insertSelective(ActDeploymentdetial record);

    List<ActDeploymentdetial> selectByExample(ActDeploymentdetialExample example);

    ActDeploymentdetial selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActDeploymentdetial record, @Param("example") ActDeploymentdetialExample example);

    int updateByExample(@Param("record") ActDeploymentdetial record, @Param("example") ActDeploymentdetialExample example);

    int updateByPrimaryKeySelective(ActDeploymentdetial record);

    int updateByPrimaryKey(ActDeploymentdetial record);
}