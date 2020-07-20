package com.workflow.model;

import java.util.ArrayList;
import java.util.List;

public class ActExecutionTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActExecutionTaskExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andExecutionidIsNull() {
            addCriterion("executionid is null");
            return (Criteria) this;
        }

        public Criteria andExecutionidIsNotNull() {
            addCriterion("executionid is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionidEqualTo(String value) {
            addCriterion("executionid =", value, "executionid");
            return (Criteria) this;
        }

        public Criteria andExecutionidNotEqualTo(String value) {
            addCriterion("executionid <>", value, "executionid");
            return (Criteria) this;
        }

        public Criteria andExecutionidGreaterThan(String value) {
            addCriterion("executionid >", value, "executionid");
            return (Criteria) this;
        }

        public Criteria andExecutionidGreaterThanOrEqualTo(String value) {
            addCriterion("executionid >=", value, "executionid");
            return (Criteria) this;
        }

        public Criteria andExecutionidLessThan(String value) {
            addCriterion("executionid <", value, "executionid");
            return (Criteria) this;
        }

        public Criteria andExecutionidLessThanOrEqualTo(String value) {
            addCriterion("executionid <=", value, "executionid");
            return (Criteria) this;
        }

        public Criteria andExecutionidLike(String value) {
            addCriterion("executionid like", value, "executionid");
            return (Criteria) this;
        }

        public Criteria andExecutionidNotLike(String value) {
            addCriterion("executionid not like", value, "executionid");
            return (Criteria) this;
        }

        public Criteria andExecutionidIn(List<String> values) {
            addCriterion("executionid in", values, "executionid");
            return (Criteria) this;
        }

        public Criteria andExecutionidNotIn(List<String> values) {
            addCriterion("executionid not in", values, "executionid");
            return (Criteria) this;
        }

        public Criteria andExecutionidBetween(String value1, String value2) {
            addCriterion("executionid between", value1, value2, "executionid");
            return (Criteria) this;
        }

        public Criteria andExecutionidNotBetween(String value1, String value2) {
            addCriterion("executionid not between", value1, value2, "executionid");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidIsNull() {
            addCriterion("deploymentdetialid is null");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidIsNotNull() {
            addCriterion("deploymentdetialid is not null");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidEqualTo(String value) {
            addCriterion("deploymentdetialid =", value, "deploymentdetialid");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidNotEqualTo(String value) {
            addCriterion("deploymentdetialid <>", value, "deploymentdetialid");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidGreaterThan(String value) {
            addCriterion("deploymentdetialid >", value, "deploymentdetialid");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidGreaterThanOrEqualTo(String value) {
            addCriterion("deploymentdetialid >=", value, "deploymentdetialid");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidLessThan(String value) {
            addCriterion("deploymentdetialid <", value, "deploymentdetialid");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidLessThanOrEqualTo(String value) {
            addCriterion("deploymentdetialid <=", value, "deploymentdetialid");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidLike(String value) {
            addCriterion("deploymentdetialid like", value, "deploymentdetialid");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidNotLike(String value) {
            addCriterion("deploymentdetialid not like", value, "deploymentdetialid");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidIn(List<String> values) {
            addCriterion("deploymentdetialid in", values, "deploymentdetialid");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidNotIn(List<String> values) {
            addCriterion("deploymentdetialid not in", values, "deploymentdetialid");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidBetween(String value1, String value2) {
            addCriterion("deploymentdetialid between", value1, value2, "deploymentdetialid");
            return (Criteria) this;
        }

        public Criteria andDeploymentdetialidNotBetween(String value1, String value2) {
            addCriterion("deploymentdetialid not between", value1, value2, "deploymentdetialid");
            return (Criteria) this;
        }

        public Criteria andNodenameIsNull() {
            addCriterion("nodename is null");
            return (Criteria) this;
        }

        public Criteria andNodenameIsNotNull() {
            addCriterion("nodename is not null");
            return (Criteria) this;
        }

        public Criteria andNodenameEqualTo(String value) {
            addCriterion("nodename =", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameNotEqualTo(String value) {
            addCriterion("nodename <>", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameGreaterThan(String value) {
            addCriterion("nodename >", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameGreaterThanOrEqualTo(String value) {
            addCriterion("nodename >=", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameLessThan(String value) {
            addCriterion("nodename <", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameLessThanOrEqualTo(String value) {
            addCriterion("nodename <=", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameLike(String value) {
            addCriterion("nodename like", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameNotLike(String value) {
            addCriterion("nodename not like", value, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameIn(List<String> values) {
            addCriterion("nodename in", values, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameNotIn(List<String> values) {
            addCriterion("nodename not in", values, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameBetween(String value1, String value2) {
            addCriterion("nodename between", value1, value2, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodenameNotBetween(String value1, String value2) {
            addCriterion("nodename not between", value1, value2, "nodename");
            return (Criteria) this;
        }

        public Criteria andNodestatusIsNull() {
            addCriterion("nodestatus is null");
            return (Criteria) this;
        }

        public Criteria andNodestatusIsNotNull() {
            addCriterion("nodestatus is not null");
            return (Criteria) this;
        }

        public Criteria andNodestatusEqualTo(Integer value) {
            addCriterion("nodestatus =", value, "nodestatus");
            return (Criteria) this;
        }

        public Criteria andNodestatusNotEqualTo(Integer value) {
            addCriterion("nodestatus <>", value, "nodestatus");
            return (Criteria) this;
        }

        public Criteria andNodestatusGreaterThan(Integer value) {
            addCriterion("nodestatus >", value, "nodestatus");
            return (Criteria) this;
        }

        public Criteria andNodestatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("nodestatus >=", value, "nodestatus");
            return (Criteria) this;
        }

        public Criteria andNodestatusLessThan(Integer value) {
            addCriterion("nodestatus <", value, "nodestatus");
            return (Criteria) this;
        }

        public Criteria andNodestatusLessThanOrEqualTo(Integer value) {
            addCriterion("nodestatus <=", value, "nodestatus");
            return (Criteria) this;
        }

        public Criteria andNodestatusIn(List<Integer> values) {
            addCriterion("nodestatus in", values, "nodestatus");
            return (Criteria) this;
        }

        public Criteria andNodestatusNotIn(List<Integer> values) {
            addCriterion("nodestatus not in", values, "nodestatus");
            return (Criteria) this;
        }

        public Criteria andNodestatusBetween(Integer value1, Integer value2) {
            addCriterion("nodestatus between", value1, value2, "nodestatus");
            return (Criteria) this;
        }

        public Criteria andNodestatusNotBetween(Integer value1, Integer value2) {
            addCriterion("nodestatus not between", value1, value2, "nodestatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}