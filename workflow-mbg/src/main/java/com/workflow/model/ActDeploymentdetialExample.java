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

        public Criteria andDeploymentidIsNull() {
            addCriterion("deploymentid is null");
            return (Criteria) this;
        }

        public Criteria andDeploymentidIsNotNull() {
            addCriterion("deploymentid is not null");
            return (Criteria) this;
        }

        public Criteria andDeploymentidEqualTo(Long value) {
            addCriterion("deploymentid =", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidNotEqualTo(Long value) {
            addCriterion("deploymentid <>", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidGreaterThan(Long value) {
            addCriterion("deploymentid >", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidGreaterThanOrEqualTo(Long value) {
            addCriterion("deploymentid >=", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidLessThan(Long value) {
            addCriterion("deploymentid <", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidLessThanOrEqualTo(Long value) {
            addCriterion("deploymentid <=", value, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidIn(List<Long> values) {
            addCriterion("deploymentid in", values, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidNotIn(List<Long> values) {
            addCriterion("deploymentid not in", values, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidBetween(Long value1, Long value2) {
            addCriterion("deploymentid between", value1, value2, "deploymentid");
            return (Criteria) this;
        }

        public Criteria andDeploymentidNotBetween(Long value1, Long value2) {
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

        public Criteria andPidEqualTo(Long value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andNodecodeIsNull() {
            addCriterion("nodecode is null");
            return (Criteria) this;
        }

        public Criteria andNodecodeIsNotNull() {
            addCriterion("nodecode is not null");
            return (Criteria) this;
        }

        public Criteria andNodecodeEqualTo(String value) {
            addCriterion("nodecode =", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotEqualTo(String value) {
            addCriterion("nodecode <>", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeGreaterThan(String value) {
            addCriterion("nodecode >", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeGreaterThanOrEqualTo(String value) {
            addCriterion("nodecode >=", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeLessThan(String value) {
            addCriterion("nodecode <", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeLessThanOrEqualTo(String value) {
            addCriterion("nodecode <=", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeLike(String value) {
            addCriterion("nodecode like", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotLike(String value) {
            addCriterion("nodecode not like", value, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeIn(List<String> values) {
            addCriterion("nodecode in", values, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotIn(List<String> values) {
            addCriterion("nodecode not in", values, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeBetween(String value1, String value2) {
            addCriterion("nodecode between", value1, value2, "nodecode");
            return (Criteria) this;
        }

        public Criteria andNodecodeNotBetween(String value1, String value2) {
            addCriterion("nodecode not between", value1, value2, "nodecode");
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

        public Criteria andBelongrouteIsNull() {
            addCriterion("belongroute is null");
            return (Criteria) this;
        }

        public Criteria andBelongrouteIsNotNull() {
            addCriterion("belongroute is not null");
            return (Criteria) this;
        }

        public Criteria andBelongrouteEqualTo(Long value) {
            addCriterion("belongroute =", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteNotEqualTo(Long value) {
            addCriterion("belongroute <>", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteGreaterThan(Long value) {
            addCriterion("belongroute >", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteGreaterThanOrEqualTo(Long value) {
            addCriterion("belongroute >=", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteLessThan(Long value) {
            addCriterion("belongroute <", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteLessThanOrEqualTo(Long value) {
            addCriterion("belongroute <=", value, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteIn(List<Long> values) {
            addCriterion("belongroute in", values, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteNotIn(List<Long> values) {
            addCriterion("belongroute not in", values, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteBetween(Long value1, Long value2) {
            addCriterion("belongroute between", value1, value2, "belongroute");
            return (Criteria) this;
        }

        public Criteria andBelongrouteNotBetween(Long value1, Long value2) {
            addCriterion("belongroute not between", value1, value2, "belongroute");
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

        public Criteria andNodeuserlistIsNull() {
            addCriterion("nodeuserlist is null");
            return (Criteria) this;
        }

        public Criteria andNodeuserlistIsNotNull() {
            addCriterion("nodeuserlist is not null");
            return (Criteria) this;
        }

        public Criteria andNodeuserlistEqualTo(String value) {
            addCriterion("nodeuserlist =", value, "nodeuserlist");
            return (Criteria) this;
        }

        public Criteria andNodeuserlistNotEqualTo(String value) {
            addCriterion("nodeuserlist <>", value, "nodeuserlist");
            return (Criteria) this;
        }

        public Criteria andNodeuserlistGreaterThan(String value) {
            addCriterion("nodeuserlist >", value, "nodeuserlist");
            return (Criteria) this;
        }

        public Criteria andNodeuserlistGreaterThanOrEqualTo(String value) {
            addCriterion("nodeuserlist >=", value, "nodeuserlist");
            return (Criteria) this;
        }

        public Criteria andNodeuserlistLessThan(String value) {
            addCriterion("nodeuserlist <", value, "nodeuserlist");
            return (Criteria) this;
        }

        public Criteria andNodeuserlistLessThanOrEqualTo(String value) {
            addCriterion("nodeuserlist <=", value, "nodeuserlist");
            return (Criteria) this;
        }

        public Criteria andNodeuserlistLike(String value) {
            addCriterion("nodeuserlist like", value, "nodeuserlist");
            return (Criteria) this;
        }

        public Criteria andNodeuserlistNotLike(String value) {
            addCriterion("nodeuserlist not like", value, "nodeuserlist");
            return (Criteria) this;
        }

        public Criteria andNodeuserlistIn(List<String> values) {
            addCriterion("nodeuserlist in", values, "nodeuserlist");
            return (Criteria) this;
        }

        public Criteria andNodeuserlistNotIn(List<String> values) {
            addCriterion("nodeuserlist not in", values, "nodeuserlist");
            return (Criteria) this;
        }

        public Criteria andNodeuserlistBetween(String value1, String value2) {
            addCriterion("nodeuserlist between", value1, value2, "nodeuserlist");
            return (Criteria) this;
        }

        public Criteria andNodeuserlistNotBetween(String value1, String value2) {
            addCriterion("nodeuserlist not between", value1, value2, "nodeuserlist");
            return (Criteria) this;
        }

        public Criteria andConditionnodesIsNull() {
            addCriterion("conditionnodes is null");
            return (Criteria) this;
        }

        public Criteria andConditionnodesIsNotNull() {
            addCriterion("conditionnodes is not null");
            return (Criteria) this;
        }

        public Criteria andConditionnodesEqualTo(String value) {
            addCriterion("conditionnodes =", value, "conditionnodes");
            return (Criteria) this;
        }

        public Criteria andConditionnodesNotEqualTo(String value) {
            addCriterion("conditionnodes <>", value, "conditionnodes");
            return (Criteria) this;
        }

        public Criteria andConditionnodesGreaterThan(String value) {
            addCriterion("conditionnodes >", value, "conditionnodes");
            return (Criteria) this;
        }

        public Criteria andConditionnodesGreaterThanOrEqualTo(String value) {
            addCriterion("conditionnodes >=", value, "conditionnodes");
            return (Criteria) this;
        }

        public Criteria andConditionnodesLessThan(String value) {
            addCriterion("conditionnodes <", value, "conditionnodes");
            return (Criteria) this;
        }

        public Criteria andConditionnodesLessThanOrEqualTo(String value) {
            addCriterion("conditionnodes <=", value, "conditionnodes");
            return (Criteria) this;
        }

        public Criteria andConditionnodesLike(String value) {
            addCriterion("conditionnodes like", value, "conditionnodes");
            return (Criteria) this;
        }

        public Criteria andConditionnodesNotLike(String value) {
            addCriterion("conditionnodes not like", value, "conditionnodes");
            return (Criteria) this;
        }

        public Criteria andConditionnodesIn(List<String> values) {
            addCriterion("conditionnodes in", values, "conditionnodes");
            return (Criteria) this;
        }

        public Criteria andConditionnodesNotIn(List<String> values) {
            addCriterion("conditionnodes not in", values, "conditionnodes");
            return (Criteria) this;
        }

        public Criteria andConditionnodesBetween(String value1, String value2) {
            addCriterion("conditionnodes between", value1, value2, "conditionnodes");
            return (Criteria) this;
        }

        public Criteria andConditionnodesNotBetween(String value1, String value2) {
            addCriterion("conditionnodes not between", value1, value2, "conditionnodes");
            return (Criteria) this;
        }

        public Criteria andExecutionmodeIsNull() {
            addCriterion("executionmode is null");
            return (Criteria) this;
        }

        public Criteria andExecutionmodeIsNotNull() {
            addCriterion("executionmode is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionmodeEqualTo(Integer value) {
            addCriterion("executionmode =", value, "executionmode");
            return (Criteria) this;
        }

        public Criteria andExecutionmodeNotEqualTo(Integer value) {
            addCriterion("executionmode <>", value, "executionmode");
            return (Criteria) this;
        }

        public Criteria andExecutionmodeGreaterThan(Integer value) {
            addCriterion("executionmode >", value, "executionmode");
            return (Criteria) this;
        }

        public Criteria andExecutionmodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("executionmode >=", value, "executionmode");
            return (Criteria) this;
        }

        public Criteria andExecutionmodeLessThan(Integer value) {
            addCriterion("executionmode <", value, "executionmode");
            return (Criteria) this;
        }

        public Criteria andExecutionmodeLessThanOrEqualTo(Integer value) {
            addCriterion("executionmode <=", value, "executionmode");
            return (Criteria) this;
        }

        public Criteria andExecutionmodeIn(List<Integer> values) {
            addCriterion("executionmode in", values, "executionmode");
            return (Criteria) this;
        }

        public Criteria andExecutionmodeNotIn(List<Integer> values) {
            addCriterion("executionmode not in", values, "executionmode");
            return (Criteria) this;
        }

        public Criteria andExecutionmodeBetween(Integer value1, Integer value2) {
            addCriterion("executionmode between", value1, value2, "executionmode");
            return (Criteria) this;
        }

        public Criteria andExecutionmodeNotBetween(Integer value1, Integer value2) {
            addCriterion("executionmode not between", value1, value2, "executionmode");
            return (Criteria) this;
        }

        public Criteria andScenecodingIsNull() {
            addCriterion("scenecoding is null");
            return (Criteria) this;
        }

        public Criteria andScenecodingIsNotNull() {
            addCriterion("scenecoding is not null");
            return (Criteria) this;
        }

        public Criteria andScenecodingEqualTo(Integer value) {
            addCriterion("scenecoding =", value, "scenecoding");
            return (Criteria) this;
        }

        public Criteria andScenecodingNotEqualTo(Integer value) {
            addCriterion("scenecoding <>", value, "scenecoding");
            return (Criteria) this;
        }

        public Criteria andScenecodingGreaterThan(Integer value) {
            addCriterion("scenecoding >", value, "scenecoding");
            return (Criteria) this;
        }

        public Criteria andScenecodingGreaterThanOrEqualTo(Integer value) {
            addCriterion("scenecoding >=", value, "scenecoding");
            return (Criteria) this;
        }

        public Criteria andScenecodingLessThan(Integer value) {
            addCriterion("scenecoding <", value, "scenecoding");
            return (Criteria) this;
        }

        public Criteria andScenecodingLessThanOrEqualTo(Integer value) {
            addCriterion("scenecoding <=", value, "scenecoding");
            return (Criteria) this;
        }

        public Criteria andScenecodingIn(List<Integer> values) {
            addCriterion("scenecoding in", values, "scenecoding");
            return (Criteria) this;
        }

        public Criteria andScenecodingNotIn(List<Integer> values) {
            addCriterion("scenecoding not in", values, "scenecoding");
            return (Criteria) this;
        }

        public Criteria andScenecodingBetween(Integer value1, Integer value2) {
            addCriterion("scenecoding between", value1, value2, "scenecoding");
            return (Criteria) this;
        }

        public Criteria andScenecodingNotBetween(Integer value1, Integer value2) {
            addCriterion("scenecoding not between", value1, value2, "scenecoding");
            return (Criteria) this;
        }

        public Criteria andSqlstringIsNull() {
            addCriterion("sqlstring is null");
            return (Criteria) this;
        }

        public Criteria andSqlstringIsNotNull() {
            addCriterion("sqlstring is not null");
            return (Criteria) this;
        }

        public Criteria andSqlstringEqualTo(String value) {
            addCriterion("sqlstring =", value, "sqlstring");
            return (Criteria) this;
        }

        public Criteria andSqlstringNotEqualTo(String value) {
            addCriterion("sqlstring <>", value, "sqlstring");
            return (Criteria) this;
        }

        public Criteria andSqlstringGreaterThan(String value) {
            addCriterion("sqlstring >", value, "sqlstring");
            return (Criteria) this;
        }

        public Criteria andSqlstringGreaterThanOrEqualTo(String value) {
            addCriterion("sqlstring >=", value, "sqlstring");
            return (Criteria) this;
        }

        public Criteria andSqlstringLessThan(String value) {
            addCriterion("sqlstring <", value, "sqlstring");
            return (Criteria) this;
        }

        public Criteria andSqlstringLessThanOrEqualTo(String value) {
            addCriterion("sqlstring <=", value, "sqlstring");
            return (Criteria) this;
        }

        public Criteria andSqlstringLike(String value) {
            addCriterion("sqlstring like", value, "sqlstring");
            return (Criteria) this;
        }

        public Criteria andSqlstringNotLike(String value) {
            addCriterion("sqlstring not like", value, "sqlstring");
            return (Criteria) this;
        }

        public Criteria andSqlstringIn(List<String> values) {
            addCriterion("sqlstring in", values, "sqlstring");
            return (Criteria) this;
        }

        public Criteria andSqlstringNotIn(List<String> values) {
            addCriterion("sqlstring not in", values, "sqlstring");
            return (Criteria) this;
        }

        public Criteria andSqlstringBetween(String value1, String value2) {
            addCriterion("sqlstring between", value1, value2, "sqlstring");
            return (Criteria) this;
        }

        public Criteria andSqlstringNotBetween(String value1, String value2) {
            addCriterion("sqlstring not between", value1, value2, "sqlstring");
            return (Criteria) this;
        }

        public Criteria andJumpIsNull() {
            addCriterion("jump is null");
            return (Criteria) this;
        }

        public Criteria andJumpIsNotNull() {
            addCriterion("jump is not null");
            return (Criteria) this;
        }

        public Criteria andJumpEqualTo(Boolean value) {
            addCriterion("jump =", value, "jump");
            return (Criteria) this;
        }

        public Criteria andJumpNotEqualTo(Boolean value) {
            addCriterion("jump <>", value, "jump");
            return (Criteria) this;
        }

        public Criteria andJumpGreaterThan(Boolean value) {
            addCriterion("jump >", value, "jump");
            return (Criteria) this;
        }

        public Criteria andJumpGreaterThanOrEqualTo(Boolean value) {
            addCriterion("jump >=", value, "jump");
            return (Criteria) this;
        }

        public Criteria andJumpLessThan(Boolean value) {
            addCriterion("jump <", value, "jump");
            return (Criteria) this;
        }

        public Criteria andJumpLessThanOrEqualTo(Boolean value) {
            addCriterion("jump <=", value, "jump");
            return (Criteria) this;
        }

        public Criteria andJumpIn(List<Boolean> values) {
            addCriterion("jump in", values, "jump");
            return (Criteria) this;
        }

        public Criteria andJumpNotIn(List<Boolean> values) {
            addCriterion("jump not in", values, "jump");
            return (Criteria) this;
        }

        public Criteria andJumpBetween(Boolean value1, Boolean value2) {
            addCriterion("jump between", value1, value2, "jump");
            return (Criteria) this;
        }

        public Criteria andJumpNotBetween(Boolean value1, Boolean value2) {
            addCriterion("jump not between", value1, value2, "jump");
            return (Criteria) this;
        }

        public Criteria andHandlertypeIsNull() {
            addCriterion("handlertype is null");
            return (Criteria) this;
        }

        public Criteria andHandlertypeIsNotNull() {
            addCriterion("handlertype is not null");
            return (Criteria) this;
        }

        public Criteria andHandlertypeEqualTo(Integer value) {
            addCriterion("handlertype =", value, "handlertype");
            return (Criteria) this;
        }

        public Criteria andHandlertypeNotEqualTo(Integer value) {
            addCriterion("handlertype <>", value, "handlertype");
            return (Criteria) this;
        }

        public Criteria andHandlertypeGreaterThan(Integer value) {
            addCriterion("handlertype >", value, "handlertype");
            return (Criteria) this;
        }

        public Criteria andHandlertypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("handlertype >=", value, "handlertype");
            return (Criteria) this;
        }

        public Criteria andHandlertypeLessThan(Integer value) {
            addCriterion("handlertype <", value, "handlertype");
            return (Criteria) this;
        }

        public Criteria andHandlertypeLessThanOrEqualTo(Integer value) {
            addCriterion("handlertype <=", value, "handlertype");
            return (Criteria) this;
        }

        public Criteria andHandlertypeIn(List<Integer> values) {
            addCriterion("handlertype in", values, "handlertype");
            return (Criteria) this;
        }

        public Criteria andHandlertypeNotIn(List<Integer> values) {
            addCriterion("handlertype not in", values, "handlertype");
            return (Criteria) this;
        }

        public Criteria andHandlertypeBetween(Integer value1, Integer value2) {
            addCriterion("handlertype between", value1, value2, "handlertype");
            return (Criteria) this;
        }

        public Criteria andHandlertypeNotBetween(Integer value1, Integer value2) {
            addCriterion("handlertype not between", value1, value2, "handlertype");
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