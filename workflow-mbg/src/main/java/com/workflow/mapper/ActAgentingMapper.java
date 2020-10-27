package com.workflow.mapper;

import com.workflow.model.ActAgenting;
import com.workflow.model.ActAgentingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActAgentingMapper {
    long countByExample(ActAgentingExample example);

    int deleteByExample(ActAgentingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActAgenting record);

    int insertSelective(ActAgenting record);

    List<ActAgenting> selectByExample(ActAgentingExample example);

    ActAgenting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActAgenting record, @Param("example") ActAgentingExample example);

    int updateByExample(@Param("record") ActAgenting record, @Param("example") ActAgentingExample example);

    int updateByPrimaryKeySelective(ActAgenting record);

    int updateByPrimaryKey(ActAgenting record);
}