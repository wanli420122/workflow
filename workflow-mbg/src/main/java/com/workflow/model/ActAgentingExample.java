package com.workflow.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActAgentingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActAgentingExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNull() {
            addCriterion("taskid is null");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNotNull() {
            addCriterion("taskid is not null");
            return (Criteria) this;
        }

        public Criteria andTaskidEqualTo(Long value) {
            addCriterion("taskid =", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotEqualTo(Long value) {
            addCriterion("taskid <>", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThan(Long value) {
            addCriterion("taskid >", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThanOrEqualTo(Long value) {
            addCriterion("taskid >=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThan(Long value) {
            addCriterion("taskid <", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThanOrEqualTo(Long value) {
            addCriterion("taskid <=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidIn(List<Long> values) {
            addCriterion("taskid in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotIn(List<Long> values) {
            addCriterion("taskid not in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidBetween(Long value1, Long value2) {
            addCriterion("taskid between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotBetween(Long value1, Long value2) {
            addCriterion("taskid not between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andUseidIsNull() {
            addCriterion("useid is null");
            return (Criteria) this;
        }

        public Criteria andUseidIsNotNull() {
            addCriterion("useid is not null");
            return (Criteria) this;
        }

        public Criteria andUseidEqualTo(String value) {
            addCriterion("useid =", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidNotEqualTo(String value) {
            addCriterion("useid <>", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidGreaterThan(String value) {
            addCriterion("useid >", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidGreaterThanOrEqualTo(String value) {
            addCriterion("useid >=", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidLessThan(String value) {
            addCriterion("useid <", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidLessThanOrEqualTo(String value) {
            addCriterion("useid <=", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidLike(String value) {
            addCriterion("useid like", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidNotLike(String value) {
            addCriterion("useid not like", value, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidIn(List<String> values) {
            addCriterion("useid in", values, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidNotIn(List<String> values) {
            addCriterion("useid not in", values, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidBetween(String value1, String value2) {
            addCriterion("useid between", value1, value2, "useid");
            return (Criteria) this;
        }

        public Criteria andUseidNotBetween(String value1, String value2) {
            addCriterion("useid not between", value1, value2, "useid");
            return (Criteria) this;
        }

        public Criteria andAgentingstatusIsNull() {
            addCriterion("agentingstatus is null");
            return (Criteria) this;
        }

        public Criteria andAgentingstatusIsNotNull() {
            addCriterion("agentingstatus is not null");
            return (Criteria) this;
        }

        public Criteria andAgentingstatusEqualTo(Integer value) {
            addCriterion("agentingstatus =", value, "agentingstatus");
            return (Criteria) this;
        }

        public Criteria andAgentingstatusNotEqualTo(Integer value) {
            addCriterion("agentingstatus <>", value, "agentingstatus");
            return (Criteria) this;
        }

        public Criteria andAgentingstatusGreaterThan(Integer value) {
            addCriterion("agentingstatus >", value, "agentingstatus");
            return (Criteria) this;
        }

        public Criteria andAgentingstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("agentingstatus >=", value, "agentingstatus");
            return (Criteria) this;
        }

        public Criteria andAgentingstatusLessThan(Integer value) {
            addCriterion("agentingstatus <", value, "agentingstatus");
            return (Criteria) this;
        }

        public Criteria andAgentingstatusLessThanOrEqualTo(Integer value) {
            addCriterion("agentingstatus <=", value, "agentingstatus");
            return (Criteria) this;
        }

        public Criteria andAgentingstatusIn(List<Integer> values) {
            addCriterion("agentingstatus in", values, "agentingstatus");
            return (Criteria) this;
        }

        public Criteria andAgentingstatusNotIn(List<Integer> values) {
            addCriterion("agentingstatus not in", values, "agentingstatus");
            return (Criteria) this;
        }

        public Criteria andAgentingstatusBetween(Integer value1, Integer value2) {
            addCriterion("agentingstatus between", value1, value2, "agentingstatus");
            return (Criteria) this;
        }

        public Criteria andAgentingstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("agentingstatus not between", value1, value2, "agentingstatus");
            return (Criteria) this;
        }

        public Criteria andAgentingsignIsNull() {
            addCriterion("agentingsign is null");
            return (Criteria) this;
        }

        public Criteria andAgentingsignIsNotNull() {
            addCriterion("agentingsign is not null");
            return (Criteria) this;
        }

        public Criteria andAgentingsignEqualTo(Integer value) {
            addCriterion("agentingsign =", value, "agentingsign");
            return (Criteria) this;
        }

        public Criteria andAgentingsignNotEqualTo(Integer value) {
            addCriterion("agentingsign <>", value, "agentingsign");
            return (Criteria) this;
        }

        public Criteria andAgentingsignGreaterThan(Integer value) {
            addCriterion("agentingsign >", value, "agentingsign");
            return (Criteria) this;
        }

        public Criteria andAgentingsignGreaterThanOrEqualTo(Integer value) {
            addCriterion("agentingsign >=", value, "agentingsign");
            return (Criteria) this;
        }

        public Criteria andAgentingsignLessThan(Integer value) {
            addCriterion("agentingsign <", value, "agentingsign");
            return (Criteria) this;
        }

        public Criteria andAgentingsignLessThanOrEqualTo(Integer value) {
            addCriterion("agentingsign <=", value, "agentingsign");
            return (Criteria) this;
        }

        public Criteria andAgentingsignIn(List<Integer> values) {
            addCriterion("agentingsign in", values, "agentingsign");
            return (Criteria) this;
        }

        public Criteria andAgentingsignNotIn(List<Integer> values) {
            addCriterion("agentingsign not in", values, "agentingsign");
            return (Criteria) this;
        }

        public Criteria andAgentingsignBetween(Integer value1, Integer value2) {
            addCriterion("agentingsign between", value1, value2, "agentingsign");
            return (Criteria) this;
        }

        public Criteria andAgentingsignNotBetween(Integer value1, Integer value2) {
            addCriterion("agentingsign not between", value1, value2, "agentingsign");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andNownodeidIsNull() {
            addCriterion("nownodeid is null");
            return (Criteria) this;
        }

        public Criteria andNownodeidIsNotNull() {
            addCriterion("nownodeid is not null");
            return (Criteria) this;
        }

        public Criteria andNownodeidEqualTo(Long value) {
            addCriterion("nownodeid =", value, "nownodeid");
            return (Criteria) this;
        }

        public Criteria andNownodeidNotEqualTo(Long value) {
            addCriterion("nownodeid <>", value, "nownodeid");
            return (Criteria) this;
        }

        public Criteria andNownodeidGreaterThan(Long value) {
            addCriterion("nownodeid >", value, "nownodeid");
            return (Criteria) this;
        }

        public Criteria andNownodeidGreaterThanOrEqualTo(Long value) {
            addCriterion("nownodeid >=", value, "nownodeid");
            return (Criteria) this;
        }

        public Criteria andNownodeidLessThan(Long value) {
            addCriterion("nownodeid <", value, "nownodeid");
            return (Criteria) this;
        }

        public Criteria andNownodeidLessThanOrEqualTo(Long value) {
            addCriterion("nownodeid <=", value, "nownodeid");
            return (Criteria) this;
        }

        public Criteria andNownodeidIn(List<Long> values) {
            addCriterion("nownodeid in", values, "nownodeid");
            return (Criteria) this;
        }

        public Criteria andNownodeidNotIn(List<Long> values) {
            addCriterion("nownodeid not in", values, "nownodeid");
            return (Criteria) this;
        }

        public Criteria andNownodeidBetween(Long value1, Long value2) {
            addCriterion("nownodeid between", value1, value2, "nownodeid");
            return (Criteria) this;
        }

        public Criteria andNownodeidNotBetween(Long value1, Long value2) {
            addCriterion("nownodeid not between", value1, value2, "nownodeid");
            return (Criteria) this;
        }

        public Criteria andNodeversionIsNull() {
            addCriterion("nodeversion is null");
            return (Criteria) this;
        }

        public Criteria andNodeversionIsNotNull() {
            addCriterion("nodeversion is not null");
            return (Criteria) this;
        }

        public Criteria andNodeversionEqualTo(Long value) {
            addCriterion("nodeversion =", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionNotEqualTo(Long value) {
            addCriterion("nodeversion <>", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionGreaterThan(Long value) {
            addCriterion("nodeversion >", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionGreaterThanOrEqualTo(Long value) {
            addCriterion("nodeversion >=", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionLessThan(Long value) {
            addCriterion("nodeversion <", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionLessThanOrEqualTo(Long value) {
            addCriterion("nodeversion <=", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionIn(List<Long> values) {
            addCriterion("nodeversion in", values, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionNotIn(List<Long> values) {
            addCriterion("nodeversion not in", values, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionBetween(Long value1, Long value2) {
            addCriterion("nodeversion between", value1, value2, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionNotBetween(Long value1, Long value2) {
            addCriterion("nodeversion not between", value1, value2, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andSuggeststrIsNull() {
            addCriterion("suggeststr is null");
            return (Criteria) this;
        }

        public Criteria andSuggeststrIsNotNull() {
            addCriterion("suggeststr is not null");
            return (Criteria) this;
        }

        public Criteria andSuggeststrEqualTo(String value) {
            addCriterion("suggeststr =", value, "suggeststr");
            return (Criteria) this;
        }

        public Criteria andSuggeststrNotEqualTo(String value) {
            addCriterion("suggeststr <>", value, "suggeststr");
            return (Criteria) this;
        }

        public Criteria andSuggeststrGreaterThan(String value) {
            addCriterion("suggeststr >", value, "suggeststr");
            return (Criteria) this;
        }

        public Criteria andSuggeststrGreaterThanOrEqualTo(String value) {
            addCriterion("suggeststr >=", value, "suggeststr");
            return (Criteria) this;
        }

        public Criteria andSuggeststrLessThan(String value) {
            addCriterion("suggeststr <", value, "suggeststr");
            return (Criteria) this;
        }

        public Criteria andSuggeststrLessThanOrEqualTo(String value) {
            addCriterion("suggeststr <=", value, "suggeststr");
            return (Criteria) this;
        }

        public Criteria andSuggeststrLike(String value) {
            addCriterion("suggeststr like", value, "suggeststr");
            return (Criteria) this;
        }

        public Criteria andSuggeststrNotLike(String value) {
            addCriterion("suggeststr not like", value, "suggeststr");
            return (Criteria) this;
        }

        public Criteria andSuggeststrIn(List<String> values) {
            addCriterion("suggeststr in", values, "suggeststr");
            return (Criteria) this;
        }

        public Criteria andSuggeststrNotIn(List<String> values) {
            addCriterion("suggeststr not in", values, "suggeststr");
            return (Criteria) this;
        }

        public Criteria andSuggeststrBetween(String value1, String value2) {
            addCriterion("suggeststr between", value1, value2, "suggeststr");
            return (Criteria) this;
        }

        public Criteria andSuggeststrNotBetween(String value1, String value2) {
            addCriterion("suggeststr not between", value1, value2, "suggeststr");
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