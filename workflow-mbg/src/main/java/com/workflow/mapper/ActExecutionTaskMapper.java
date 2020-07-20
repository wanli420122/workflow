package com.workflow.mapper;

import com.workflow.model.ActExecutionTask;
import com.workflow.model.ActExecutionTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActExecutionTaskMapper {
    long countByExample(ActExecutionTaskExample example);

    int deleteByExample(ActExecutionTaskExample example);

    int deleteByPrimaryKey(String id);

    int insert(ActExecutionTask record);

    int insertSelective(ActExecutionTask record);

    List<ActExecutionTask> selectByExample(ActExecutionTaskExample example);

    ActExecutionTask selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ActExecutionTask record, @Param("example") ActExecutionTaskExample example);

    int updateByExample(@Param("record") ActExecutionTask record, @Param("example") ActExecutionTaskExample example);

    int updateByPrimaryKeySelective(ActExecutionTask record);

    int updateByPrimaryKey(ActExecutionTask record);
}