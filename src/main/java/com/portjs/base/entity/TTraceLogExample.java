package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TTraceLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TTraceLogExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeIsNull() {
            addCriterion("consume_TIME is null");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeIsNotNull() {
            addCriterion("consume_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeEqualTo(Integer value) {
            addCriterion("consume_TIME =", value, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeNotEqualTo(Integer value) {
            addCriterion("consume_TIME <>", value, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeGreaterThan(Integer value) {
            addCriterion("consume_TIME >", value, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("consume_TIME >=", value, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeLessThan(Integer value) {
            addCriterion("consume_TIME <", value, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeLessThanOrEqualTo(Integer value) {
            addCriterion("consume_TIME <=", value, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeIn(List<Integer> values) {
            addCriterion("consume_TIME in", values, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeNotIn(List<Integer> values) {
            addCriterion("consume_TIME not in", values, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeBetween(Integer value1, Integer value2) {
            addCriterion("consume_TIME between", value1, value2, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andConsumeTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("consume_TIME not between", value1, value2, "consumeTime");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNull() {
            addCriterion("model_name is null");
            return (Criteria) this;
        }

        public Criteria andModelNameIsNotNull() {
            addCriterion("model_name is not null");
            return (Criteria) this;
        }

        public Criteria andModelNameEqualTo(String value) {
            addCriterion("model_name =", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotEqualTo(String value) {
            addCriterion("model_name <>", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThan(String value) {
            addCriterion("model_name >", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameGreaterThanOrEqualTo(String value) {
            addCriterion("model_name >=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThan(String value) {
            addCriterion("model_name <", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLessThanOrEqualTo(String value) {
            addCriterion("model_name <=", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameLike(String value) {
            addCriterion("model_name like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotLike(String value) {
            addCriterion("model_name not like", value, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameIn(List<String> values) {
            addCriterion("model_name in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotIn(List<String> values) {
            addCriterion("model_name not in", values, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameBetween(String value1, String value2) {
            addCriterion("model_name between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andModelNameNotBetween(String value1, String value2) {
            addCriterion("model_name not between", value1, value2, "modelName");
            return (Criteria) this;
        }

        public Criteria andMethodInfoIsNull() {
            addCriterion("METHOD_INFO is null");
            return (Criteria) this;
        }

        public Criteria andMethodInfoIsNotNull() {
            addCriterion("METHOD_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andMethodInfoEqualTo(String value) {
            addCriterion("METHOD_INFO =", value, "methodInfo");
            return (Criteria) this;
        }

        public Criteria andMethodInfoNotEqualTo(String value) {
            addCriterion("METHOD_INFO <>", value, "methodInfo");
            return (Criteria) this;
        }

        public Criteria andMethodInfoGreaterThan(String value) {
            addCriterion("METHOD_INFO >", value, "methodInfo");
            return (Criteria) this;
        }

        public Criteria andMethodInfoGreaterThanOrEqualTo(String value) {
            addCriterion("METHOD_INFO >=", value, "methodInfo");
            return (Criteria) this;
        }

        public Criteria andMethodInfoLessThan(String value) {
            addCriterion("METHOD_INFO <", value, "methodInfo");
            return (Criteria) this;
        }

        public Criteria andMethodInfoLessThanOrEqualTo(String value) {
            addCriterion("METHOD_INFO <=", value, "methodInfo");
            return (Criteria) this;
        }

        public Criteria andMethodInfoLike(String value) {
            addCriterion("METHOD_INFO like", value, "methodInfo");
            return (Criteria) this;
        }

        public Criteria andMethodInfoNotLike(String value) {
            addCriterion("METHOD_INFO not like", value, "methodInfo");
            return (Criteria) this;
        }

        public Criteria andMethodInfoIn(List<String> values) {
            addCriterion("METHOD_INFO in", values, "methodInfo");
            return (Criteria) this;
        }

        public Criteria andMethodInfoNotIn(List<String> values) {
            addCriterion("METHOD_INFO not in", values, "methodInfo");
            return (Criteria) this;
        }

        public Criteria andMethodInfoBetween(String value1, String value2) {
            addCriterion("METHOD_INFO between", value1, value2, "methodInfo");
            return (Criteria) this;
        }

        public Criteria andMethodInfoNotBetween(String value1, String value2) {
            addCriterion("METHOD_INFO not between", value1, value2, "methodInfo");
            return (Criteria) this;
        }

        public Criteria andMethodNameIsNull() {
            addCriterion("METHOD_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMethodNameIsNotNull() {
            addCriterion("METHOD_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMethodNameEqualTo(String value) {
            addCriterion("METHOD_NAME =", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotEqualTo(String value) {
            addCriterion("METHOD_NAME <>", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThan(String value) {
            addCriterion("METHOD_NAME >", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameGreaterThanOrEqualTo(String value) {
            addCriterion("METHOD_NAME >=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThan(String value) {
            addCriterion("METHOD_NAME <", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLessThanOrEqualTo(String value) {
            addCriterion("METHOD_NAME <=", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameLike(String value) {
            addCriterion("METHOD_NAME like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotLike(String value) {
            addCriterion("METHOD_NAME not like", value, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameIn(List<String> values) {
            addCriterion("METHOD_NAME in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotIn(List<String> values) {
            addCriterion("METHOD_NAME not in", values, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameBetween(String value1, String value2) {
            addCriterion("METHOD_NAME between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andMethodNameNotBetween(String value1, String value2) {
            addCriterion("METHOD_NAME not between", value1, value2, "methodName");
            return (Criteria) this;
        }

        public Criteria andRequestMessageIsNull() {
            addCriterion("REQUEST_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andRequestMessageIsNotNull() {
            addCriterion("REQUEST_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andRequestMessageEqualTo(String value) {
            addCriterion("REQUEST_MESSAGE =", value, "requestMessage");
            return (Criteria) this;
        }

        public Criteria andRequestMessageNotEqualTo(String value) {
            addCriterion("REQUEST_MESSAGE <>", value, "requestMessage");
            return (Criteria) this;
        }

        public Criteria andRequestMessageGreaterThan(String value) {
            addCriterion("REQUEST_MESSAGE >", value, "requestMessage");
            return (Criteria) this;
        }

        public Criteria andRequestMessageGreaterThanOrEqualTo(String value) {
            addCriterion("REQUEST_MESSAGE >=", value, "requestMessage");
            return (Criteria) this;
        }

        public Criteria andRequestMessageLessThan(String value) {
            addCriterion("REQUEST_MESSAGE <", value, "requestMessage");
            return (Criteria) this;
        }

        public Criteria andRequestMessageLessThanOrEqualTo(String value) {
            addCriterion("REQUEST_MESSAGE <=", value, "requestMessage");
            return (Criteria) this;
        }

        public Criteria andRequestMessageLike(String value) {
            addCriterion("REQUEST_MESSAGE like", value, "requestMessage");
            return (Criteria) this;
        }

        public Criteria andRequestMessageNotLike(String value) {
            addCriterion("REQUEST_MESSAGE not like", value, "requestMessage");
            return (Criteria) this;
        }

        public Criteria andRequestMessageIn(List<String> values) {
            addCriterion("REQUEST_MESSAGE in", values, "requestMessage");
            return (Criteria) this;
        }

        public Criteria andRequestMessageNotIn(List<String> values) {
            addCriterion("REQUEST_MESSAGE not in", values, "requestMessage");
            return (Criteria) this;
        }

        public Criteria andRequestMessageBetween(String value1, String value2) {
            addCriterion("REQUEST_MESSAGE between", value1, value2, "requestMessage");
            return (Criteria) this;
        }

        public Criteria andRequestMessageNotBetween(String value1, String value2) {
            addCriterion("REQUEST_MESSAGE not between", value1, value2, "requestMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageIsNull() {
            addCriterion("RESPONSE_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andResponseMessageIsNotNull() {
            addCriterion("RESPONSE_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andResponseMessageEqualTo(String value) {
            addCriterion("RESPONSE_MESSAGE =", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageNotEqualTo(String value) {
            addCriterion("RESPONSE_MESSAGE <>", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageGreaterThan(String value) {
            addCriterion("RESPONSE_MESSAGE >", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageGreaterThanOrEqualTo(String value) {
            addCriterion("RESPONSE_MESSAGE >=", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageLessThan(String value) {
            addCriterion("RESPONSE_MESSAGE <", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageLessThanOrEqualTo(String value) {
            addCriterion("RESPONSE_MESSAGE <=", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageLike(String value) {
            addCriterion("RESPONSE_MESSAGE like", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageNotLike(String value) {
            addCriterion("RESPONSE_MESSAGE not like", value, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageIn(List<String> values) {
            addCriterion("RESPONSE_MESSAGE in", values, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageNotIn(List<String> values) {
            addCriterion("RESPONSE_MESSAGE not in", values, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageBetween(String value1, String value2) {
            addCriterion("RESPONSE_MESSAGE between", value1, value2, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andResponseMessageNotBetween(String value1, String value2) {
            addCriterion("RESPONSE_MESSAGE not between", value1, value2, "responseMessage");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNull() {
            addCriterion("OPERATOR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("OPERATOR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("OPERATOR_NAME =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("OPERATOR_NAME <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("OPERATOR_NAME >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR_NAME >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("OPERATOR_NAME <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR_NAME <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("OPERATOR_NAME like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("OPERATOR_NAME not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("OPERATOR_NAME in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("OPERATOR_NAME not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("OPERATOR_NAME between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("OPERATOR_NAME not between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andRemoteIpIsNull() {
            addCriterion("remote_ip is null");
            return (Criteria) this;
        }

        public Criteria andRemoteIpIsNotNull() {
            addCriterion("remote_ip is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteIpEqualTo(String value) {
            addCriterion("remote_ip =", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpNotEqualTo(String value) {
            addCriterion("remote_ip <>", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpGreaterThan(String value) {
            addCriterion("remote_ip >", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpGreaterThanOrEqualTo(String value) {
            addCriterion("remote_ip >=", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpLessThan(String value) {
            addCriterion("remote_ip <", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpLessThanOrEqualTo(String value) {
            addCriterion("remote_ip <=", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpLike(String value) {
            addCriterion("remote_ip like", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpNotLike(String value) {
            addCriterion("remote_ip not like", value, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpIn(List<String> values) {
            addCriterion("remote_ip in", values, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpNotIn(List<String> values) {
            addCriterion("remote_ip not in", values, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpBetween(String value1, String value2) {
            addCriterion("remote_ip between", value1, value2, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteIpNotBetween(String value1, String value2) {
            addCriterion("remote_ip not between", value1, value2, "remoteIp");
            return (Criteria) this;
        }

        public Criteria andRemoteUserIsNull() {
            addCriterion("remote_user is null");
            return (Criteria) this;
        }

        public Criteria andRemoteUserIsNotNull() {
            addCriterion("remote_user is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteUserEqualTo(String value) {
            addCriterion("remote_user =", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserNotEqualTo(String value) {
            addCriterion("remote_user <>", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserGreaterThan(String value) {
            addCriterion("remote_user >", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserGreaterThanOrEqualTo(String value) {
            addCriterion("remote_user >=", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserLessThan(String value) {
            addCriterion("remote_user <", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserLessThanOrEqualTo(String value) {
            addCriterion("remote_user <=", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserLike(String value) {
            addCriterion("remote_user like", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserNotLike(String value) {
            addCriterion("remote_user not like", value, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserIn(List<String> values) {
            addCriterion("remote_user in", values, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserNotIn(List<String> values) {
            addCriterion("remote_user not in", values, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserBetween(String value1, String value2) {
            addCriterion("remote_user between", value1, value2, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andRemoteUserNotBetween(String value1, String value2) {
            addCriterion("remote_user not between", value1, value2, "remoteUser");
            return (Criteria) this;
        }

        public Criteria andReserved1IsNull() {
            addCriterion("reserved1 is null");
            return (Criteria) this;
        }

        public Criteria andReserved1IsNotNull() {
            addCriterion("reserved1 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved1EqualTo(String value) {
            addCriterion("reserved1 =", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotEqualTo(String value) {
            addCriterion("reserved1 <>", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1GreaterThan(String value) {
            addCriterion("reserved1 >", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1GreaterThanOrEqualTo(String value) {
            addCriterion("reserved1 >=", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1LessThan(String value) {
            addCriterion("reserved1 <", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1LessThanOrEqualTo(String value) {
            addCriterion("reserved1 <=", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1Like(String value) {
            addCriterion("reserved1 like", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotLike(String value) {
            addCriterion("reserved1 not like", value, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1In(List<String> values) {
            addCriterion("reserved1 in", values, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotIn(List<String> values) {
            addCriterion("reserved1 not in", values, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1Between(String value1, String value2) {
            addCriterion("reserved1 between", value1, value2, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved1NotBetween(String value1, String value2) {
            addCriterion("reserved1 not between", value1, value2, "reserved1");
            return (Criteria) this;
        }

        public Criteria andReserved2IsNull() {
            addCriterion("reserved2 is null");
            return (Criteria) this;
        }

        public Criteria andReserved2IsNotNull() {
            addCriterion("reserved2 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved2EqualTo(String value) {
            addCriterion("reserved2 =", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotEqualTo(String value) {
            addCriterion("reserved2 <>", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2GreaterThan(String value) {
            addCriterion("reserved2 >", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2GreaterThanOrEqualTo(String value) {
            addCriterion("reserved2 >=", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2LessThan(String value) {
            addCriterion("reserved2 <", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2LessThanOrEqualTo(String value) {
            addCriterion("reserved2 <=", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2Like(String value) {
            addCriterion("reserved2 like", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotLike(String value) {
            addCriterion("reserved2 not like", value, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2In(List<String> values) {
            addCriterion("reserved2 in", values, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotIn(List<String> values) {
            addCriterion("reserved2 not in", values, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2Between(String value1, String value2) {
            addCriterion("reserved2 between", value1, value2, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved2NotBetween(String value1, String value2) {
            addCriterion("reserved2 not between", value1, value2, "reserved2");
            return (Criteria) this;
        }

        public Criteria andReserved3IsNull() {
            addCriterion("reserved3 is null");
            return (Criteria) this;
        }

        public Criteria andReserved3IsNotNull() {
            addCriterion("reserved3 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved3EqualTo(String value) {
            addCriterion("reserved3 =", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3NotEqualTo(String value) {
            addCriterion("reserved3 <>", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3GreaterThan(String value) {
            addCriterion("reserved3 >", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3GreaterThanOrEqualTo(String value) {
            addCriterion("reserved3 >=", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3LessThan(String value) {
            addCriterion("reserved3 <", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3LessThanOrEqualTo(String value) {
            addCriterion("reserved3 <=", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3Like(String value) {
            addCriterion("reserved3 like", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3NotLike(String value) {
            addCriterion("reserved3 not like", value, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3In(List<String> values) {
            addCriterion("reserved3 in", values, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3NotIn(List<String> values) {
            addCriterion("reserved3 not in", values, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3Between(String value1, String value2) {
            addCriterion("reserved3 between", value1, value2, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved3NotBetween(String value1, String value2) {
            addCriterion("reserved3 not between", value1, value2, "reserved3");
            return (Criteria) this;
        }

        public Criteria andReserved4IsNull() {
            addCriterion("reserved4 is null");
            return (Criteria) this;
        }

        public Criteria andReserved4IsNotNull() {
            addCriterion("reserved4 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved4EqualTo(String value) {
            addCriterion("reserved4 =", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4NotEqualTo(String value) {
            addCriterion("reserved4 <>", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4GreaterThan(String value) {
            addCriterion("reserved4 >", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4GreaterThanOrEqualTo(String value) {
            addCriterion("reserved4 >=", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4LessThan(String value) {
            addCriterion("reserved4 <", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4LessThanOrEqualTo(String value) {
            addCriterion("reserved4 <=", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4Like(String value) {
            addCriterion("reserved4 like", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4NotLike(String value) {
            addCriterion("reserved4 not like", value, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4In(List<String> values) {
            addCriterion("reserved4 in", values, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4NotIn(List<String> values) {
            addCriterion("reserved4 not in", values, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4Between(String value1, String value2) {
            addCriterion("reserved4 between", value1, value2, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved4NotBetween(String value1, String value2) {
            addCriterion("reserved4 not between", value1, value2, "reserved4");
            return (Criteria) this;
        }

        public Criteria andReserved5IsNull() {
            addCriterion("reserved5 is null");
            return (Criteria) this;
        }

        public Criteria andReserved5IsNotNull() {
            addCriterion("reserved5 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved5EqualTo(String value) {
            addCriterion("reserved5 =", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5NotEqualTo(String value) {
            addCriterion("reserved5 <>", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5GreaterThan(String value) {
            addCriterion("reserved5 >", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5GreaterThanOrEqualTo(String value) {
            addCriterion("reserved5 >=", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5LessThan(String value) {
            addCriterion("reserved5 <", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5LessThanOrEqualTo(String value) {
            addCriterion("reserved5 <=", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5Like(String value) {
            addCriterion("reserved5 like", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5NotLike(String value) {
            addCriterion("reserved5 not like", value, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5In(List<String> values) {
            addCriterion("reserved5 in", values, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5NotIn(List<String> values) {
            addCriterion("reserved5 not in", values, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5Between(String value1, String value2) {
            addCriterion("reserved5 between", value1, value2, "reserved5");
            return (Criteria) this;
        }

        public Criteria andReserved5NotBetween(String value1, String value2) {
            addCriterion("reserved5 not between", value1, value2, "reserved5");
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