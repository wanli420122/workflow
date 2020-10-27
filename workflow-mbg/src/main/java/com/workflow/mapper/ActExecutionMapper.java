package com.workflow.mapper;

import com.workflow.model.ActExecution;
import com.workflow.model.ActExecutionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActExecutionMapper {
    long countByExample(ActExecutionExample example);

    int deleteByExample(ActExecutionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ActExecution record);

    int insertSelective(ActExecution record);

    List<ActExecution> selectByExample(ActExecutionExample example);

    ActExecution selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ActExecution record, @Param("example") ActExecutionExample example);

    int updateByExample(@Param("record") ActExecution record, @Param("example") ActExecutionExample example);

    int updateByPrimaryKeySelective(ActExecution record);

    int updateByPrimaryKey(ActExecution record);
}