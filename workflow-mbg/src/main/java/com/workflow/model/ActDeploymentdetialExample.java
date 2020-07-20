package com.workflow.model;

import java.util.ArrayList;
import java.util.List;

public class ActDeploymentdetialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActDeploymentdetialExample() {
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

        public Criteria andDeploymentidIsNull() {
            addCriterion("deploymentid is null");
            return (Criteria) this;
        }

        public Criteria andDeploymentidIsNotNull() {
            addCriterion("deploymentid is not null");
            return (Criteria) this;
        }

        public Criteria andDeploymentidEqualTo(String value) {
            addCriterion("deploymentid =", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidNotEqualTo(String value) {
            addCriterion("deploymentid <>", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidGreaterThan(String value) {
            addCriterion("deploymentid >", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidGreaterThanOrEqualTo(String value) {
            addCriterion("deploymentid >=", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidLessThan(String value) {
            addCriterion("deploymentid <", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidLessThanOrEqualTo(String value) {
            addCriterion("deploymentid <=", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidLike(String value) {
            addCriterion("deploymentid like", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidNotLike(String value) {
            addCriterion("deploymentid not like", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidIn(List<String> values) {
            addCriterion("deploymentid in", values, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidNotIn(List<String> values) {
            addCriterion("deploymentid not in", values, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidBetween(String value1, String value2) {
            addCriterion("deploymentid between", value1, value2, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidNotBetween(String value1, String value2) {
            addCriterion("deploymentid not between", value1, value2, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
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

        public Criteria andNodeversionIsNull() {
            addCriterion("nodeversion is null");
            return (Criteria) this;
        }

        public Criteria andNodeversionIsNotNull() {
            addCriterion("nodeversion is not null");
            return (Criteria) this;
        }

        public Criteria andNodeversionEqualTo(String value) {
            addCriterion("nodeversion =", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionNotEqualTo(String value) {
            addCriterion("nodeversion <>", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionGreaterThan(String value) {
            addCriterion("nodeversion >", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionGreaterThanOrEqualTo(String value) {
            addCriterion("nodeversion >=", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionLessThan(String value) {
            addCriterion("nodeversion <", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionLessThanOrEqualTo(String value) {
            addCriterion("nodeversion <=", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionLike(String value) {
            addCriterion("nodeversion like", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionNotLike(String value) {
            addCriterion("nodeversion not like", value, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionIn(List<String> values) {
            addCriterion("nodeversion in", values, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionNotIn(List<String> values) {
            addCriterion("nodeversion not in", values, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionBetween(String value1, String value2) {
            addCriterion("nodeversion between", value1, value2, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andNodeversionNotBetween(String value1, String value2) {
            addCriterion("nodeversion not between", value1, value2, "nodeversion");
            return (Criteria) this;
        }

        public Criteria andBelongrouteIsNull() {
            addCriterion("belongroute is null");
            return (Criteria) this;
        }

        public Criteria andBelongrouteIsNotNull() {
            addCriterion("belongroute is not null");
            return (Criteria) this;
        }

        public Criteria andBelongrouteEqualTo(String value) {
            addCriterion("belongroute =", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteNotEqualTo(String value) {
            addCriterion("belongroute <>", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteGreaterThan(String value) {
            addCriterion("belongroute >", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteGreaterThanOrEqualTo(String value) {
            addCriterion("belongroute >=", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteLessThan(String value) {
            addCriterion("belongroute <", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteLessThanOrEqualTo(String value) {
            addCriterion("belongroute <=", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteLike(String value) {
            addCriterion("belongroute like", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteNotLike(String value) {
            addCriterion("belongroute not like", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteIn(List<String> values) {
            addCriterion("belongroute in", values, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteNotIn(List<String> values) {
            addCriterion("belongroute not in", values, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteBetween(String value1, String value2) {
            addCriterion("belongroute between", value1, value2, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteNotBetween(String value1, String value2) {
            addCriterion("belongroute not between", value1, value2, "belongroute");
            return (Criteria) this;
        }

        public Criteria andExportrouteIsNull() {
            addCriterion("exportroute is null");
            return (Criteria) this;
        }

        public Criteria andExportrouteIsNotNull() {
            addCriterion("exportroute is not null");
            return (Criteria) this;
        }

        public Criteria andExportrouteEqualTo(String value) {
            addCriterion("exportroute =", value, "exportroute");
            return (Criteria) this;
        }

        public Criteria andExportrouteNotEqualTo(String value) {
            addCriterion("exportroute <>", value, "exportroute");
            return (Criteria) this;
        }

        public Criteria andExportrouteGreaterThan(String value) {
            addCriterion("exportroute >", value, "exportroute");
            return (Criteria) this;
        }

        public Criteria andExportrouteGreaterThanOrEqualTo(String value) {
            addCriterion("exportroute >=", value, "exportroute");
            return (Criteria) this;
        }

        public Criteria andExportrouteLessThan(String value) {
            addCriterion("exportroute <", value, "exportroute");
            return (Criteria) this;
        }

        public Criteria andExportrouteLessThanOrEqualTo(String value) {
            addCriterion("exportroute <=", value, "exportroute");
            return (Criteria) this;
        }

        public Criteria andExportrouteLike(String value) {
            addCriterion("exportroute like", value, "exportroute");
            return (Criteria) this;
        }

        public Criteria andExportrouteNotLike(String value) {
            addCriterion("exportroute not like", value, "exportroute");
            return (Criteria) this;
        }

        public Criteria andExportrouteIn(List<String> values) {
            addCriterion("exportroute in", values, "exportroute");
            return (Criteria) this;
        }

        public Criteria andExportrouteNotIn(List<String> values) {
            addCriterion("exportroute not in", values, "exportroute");
            return (Criteria) this;
        }

        public Criteria andExportrouteBetween(String value1, String value2) {
            addCriterion("exportroute between", value1, value2, "exportroute");
            return (Criteria) this;
        }

        public Criteria andExportrouteNotBetween(String value1, String value2) {
            addCriterion("exportroute not between", value1, value2, "exportroute");
            return (Criteria) this;
        }

        public Criteria andNodetypeIsNull() {
            addCriterion("nodetype is null");
            return (Criteria) this;
        }

        public Criteria andNodetypeIsNotNull() {
            addCriterion("nodetype is not null");
            return (Criteria) this;
        }

        public Criteria andNodetypeEqualTo(Integer value) {
            addCriterion("nodetype =", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeNotEqualTo(Integer value) {
            addCriterion("nodetype <>", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeGreaterThan(Integer value) {
            addCriterion("nodetype >", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("nodetype >=", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeLessThan(Integer value) {
            addCriterion("nodetype <", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeLessThanOrEqualTo(Integer value) {
            addCriterion("nodetype <=", value, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeIn(List<Integer> values) {
            addCriterion("nodetype in", values, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeNotIn(List<Integer> values) {
            addCriterion("nodetype not in", values, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeBetween(Integer value1, Integer value2) {
            addCriterion("nodetype between", value1, value2, "nodetype");
            return (Criteria) this;
        }

        public Criteria andNodetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("nodetype not between", value1, value2, "nodetype");
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