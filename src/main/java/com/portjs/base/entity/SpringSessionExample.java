package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.List;

public class SpringSessionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpringSessionExample() {
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

        public Criteria andPrimaryIdIsNull() {
            addCriterion("PRIMARY_ID is null");
            return (Criteria) this;
        }

        public Criteria andPrimaryIdIsNotNull() {
            addCriterion("PRIMARY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPrimaryIdEqualTo(String value) {
            addCriterion("PRIMARY_ID =", value, "primaryId");
            return (Criteria) this;
        }

        public Criteria andPrimaryIdNotEqualTo(String value) {
            addCriterion("PRIMARY_ID <>", value, "primaryId");
            return (Criteria) this;
        }

        public Criteria andPrimaryIdGreaterThan(String value) {
            addCriterion("PRIMARY_ID >", value, "primaryId");
            return (Criteria) this;
        }

        public Criteria andPrimaryIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRIMARY_ID >=", value, "primaryId");
            return (Criteria) this;
        }

        public Criteria andPrimaryIdLessThan(String value) {
            addCriterion("PRIMARY_ID <", value, "primaryId");
            return (Criteria) this;
        }

        public Criteria andPrimaryIdLessThanOrEqualTo(String value) {
            addCriterion("PRIMARY_ID <=", value, "primaryId");
            return (Criteria) this;
        }

        public Criteria andPrimaryIdLike(String value) {
            addCriterion("PRIMARY_ID like", value, "primaryId");
            return (Criteria) this;
        }

        public Criteria andPrimaryIdNotLike(String value) {
            addCriterion("PRIMARY_ID not like", value, "primaryId");
            return (Criteria) this;
        }

        public Criteria andPrimaryIdIn(List<String> values) {
            addCriterion("PRIMARY_ID in", values, "primaryId");
            return (Criteria) this;
        }

        public Criteria andPrimaryIdNotIn(List<String> values) {
            addCriterion("PRIMARY_ID not in", values, "primaryId");
            return (Criteria) this;
        }

        public Criteria andPrimaryIdBetween(String value1, String value2) {
            addCriterion("PRIMARY_ID between", value1, value2, "primaryId");
            return (Criteria) this;
        }

        public Criteria andPrimaryIdNotBetween(String value1, String value2) {
            addCriterion("PRIMARY_ID not between", value1, value2, "primaryId");
            return (Criteria) this;
        }

        public Criteria andSessionIdIsNull() {
            addCriterion("SESSION_ID is null");
            return (Criteria) this;
        }

        public Criteria andSessionIdIsNotNull() {
            addCriterion("SESSION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSessionIdEqualTo(String value) {
            addCriterion("SESSION_ID =", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotEqualTo(String value) {
            addCriterion("SESSION_ID <>", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThan(String value) {
            addCriterion("SESSION_ID >", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdGreaterThanOrEqualTo(String value) {
            addCriterion("SESSION_ID >=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThan(String value) {
            addCriterion("SESSION_ID <", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLessThanOrEqualTo(String value) {
            addCriterion("SESSION_ID <=", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdLike(String value) {
            addCriterion("SESSION_ID like", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotLike(String value) {
            addCriterion("SESSION_ID not like", value, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdIn(List<String> values) {
            addCriterion("SESSION_ID in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotIn(List<String> values) {
            addCriterion("SESSION_ID not in", values, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdBetween(String value1, String value2) {
            addCriterion("SESSION_ID between", value1, value2, "sessionId");
            return (Criteria) this;
        }

        public Criteria andSessionIdNotBetween(String value1, String value2) {
            addCriterion("SESSION_ID not between", value1, value2, "sessionId");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNull() {
            addCriterion("CREATION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNotNull() {
            addCriterion("CREATION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeEqualTo(Long value) {
            addCriterion("CREATION_TIME =", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotEqualTo(Long value) {
            addCriterion("CREATION_TIME <>", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThan(Long value) {
            addCriterion("CREATION_TIME >", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("CREATION_TIME >=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThan(Long value) {
            addCriterion("CREATION_TIME <", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThanOrEqualTo(Long value) {
            addCriterion("CREATION_TIME <=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIn(List<Long> values) {
            addCriterion("CREATION_TIME in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotIn(List<Long> values) {
            addCriterion("CREATION_TIME not in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeBetween(Long value1, Long value2) {
            addCriterion("CREATION_TIME between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotBetween(Long value1, Long value2) {
            addCriterion("CREATION_TIME not between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeIsNull() {
            addCriterion("LAST_ACCESS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeIsNotNull() {
            addCriterion("LAST_ACCESS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeEqualTo(Long value) {
            addCriterion("LAST_ACCESS_TIME =", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeNotEqualTo(Long value) {
            addCriterion("LAST_ACCESS_TIME <>", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeGreaterThan(Long value) {
            addCriterion("LAST_ACCESS_TIME >", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("LAST_ACCESS_TIME >=", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeLessThan(Long value) {
            addCriterion("LAST_ACCESS_TIME <", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeLessThanOrEqualTo(Long value) {
            addCriterion("LAST_ACCESS_TIME <=", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeIn(List<Long> values) {
            addCriterion("LAST_ACCESS_TIME in", values, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeNotIn(List<Long> values) {
            addCriterion("LAST_ACCESS_TIME not in", values, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeBetween(Long value1, Long value2) {
            addCriterion("LAST_ACCESS_TIME between", value1, value2, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeNotBetween(Long value1, Long value2) {
            addCriterion("LAST_ACCESS_TIME not between", value1, value2, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andMaxInactiveIntervalIsNull() {
            addCriterion("MAX_INACTIVE_INTERVAL is null");
            return (Criteria) this;
        }

        public Criteria andMaxInactiveIntervalIsNotNull() {
            addCriterion("MAX_INACTIVE_INTERVAL is not null");
            return (Criteria) this;
        }

        public Criteria andMaxInactiveIntervalEqualTo(Integer value) {
            addCriterion("MAX_INACTIVE_INTERVAL =", value, "maxInactiveInterval");
            return (Criteria) this;
        }

        public Criteria andMaxInactiveIntervalNotEqualTo(Integer value) {
            addCriterion("MAX_INACTIVE_INTERVAL <>", value, "maxInactiveInterval");
            return (Criteria) this;
        }

        public Criteria andMaxInactiveIntervalGreaterThan(Integer value) {
            addCriterion("MAX_INACTIVE_INTERVAL >", value, "maxInactiveInterval");
            return (Criteria) this;
        }

        public Criteria andMaxInactiveIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAX_INACTIVE_INTERVAL >=", value, "maxInactiveInterval");
            return (Criteria) this;
        }

        public Criteria andMaxInactiveIntervalLessThan(Integer value) {
            addCriterion("MAX_INACTIVE_INTERVAL <", value, "maxInactiveInterval");
            return (Criteria) this;
        }

        public Criteria andMaxInactiveIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("MAX_INACTIVE_INTERVAL <=", value, "maxInactiveInterval");
            return (Criteria) this;
        }

        public Criteria andMaxInactiveIntervalIn(List<Integer> values) {
            addCriterion("MAX_INACTIVE_INTERVAL in", values, "maxInactiveInterval");
            return (Criteria) this;
        }

        public Criteria andMaxInactiveIntervalNotIn(List<Integer> values) {
            addCriterion("MAX_INACTIVE_INTERVAL not in", values, "maxInactiveInterval");
            return (Criteria) this;
        }

        public Criteria andMaxInactiveIntervalBetween(Integer value1, Integer value2) {
            addCriterion("MAX_INACTIVE_INTERVAL between", value1, value2, "maxInactiveInterval");
            return (Criteria) this;
        }

        public Criteria andMaxInactiveIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("MAX_INACTIVE_INTERVAL not between", value1, value2, "maxInactiveInterval");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeIsNull() {
            addCriterion("EXPIRY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeIsNotNull() {
            addCriterion("EXPIRY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeEqualTo(Long value) {
            addCriterion("EXPIRY_TIME =", value, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeNotEqualTo(Long value) {
            addCriterion("EXPIRY_TIME <>", value, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeGreaterThan(Long value) {
            addCriterion("EXPIRY_TIME >", value, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("EXPIRY_TIME >=", value, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeLessThan(Long value) {
            addCriterion("EXPIRY_TIME <", value, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeLessThanOrEqualTo(Long value) {
            addCriterion("EXPIRY_TIME <=", value, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeIn(List<Long> values) {
            addCriterion("EXPIRY_TIME in", values, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeNotIn(List<Long> values) {
            addCriterion("EXPIRY_TIME not in", values, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeBetween(Long value1, Long value2) {
            addCriterion("EXPIRY_TIME between", value1, value2, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andExpiryTimeNotBetween(Long value1, Long value2) {
            addCriterion("EXPIRY_TIME not between", value1, value2, "expiryTime");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameIsNull() {
            addCriterion("PRINCIPAL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameIsNotNull() {
            addCriterion("PRINCIPAL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameEqualTo(String value) {
            addCriterion("PRINCIPAL_NAME =", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameNotEqualTo(String value) {
            addCriterion("PRINCIPAL_NAME <>", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameGreaterThan(String value) {
            addCriterion("PRINCIPAL_NAME >", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRINCIPAL_NAME >=", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameLessThan(String value) {
            addCriterion("PRINCIPAL_NAME <", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameLessThanOrEqualTo(String value) {
            addCriterion("PRINCIPAL_NAME <=", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameLike(String value) {
            addCriterion("PRINCIPAL_NAME like", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameNotLike(String value) {
            addCriterion("PRINCIPAL_NAME not like", value, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameIn(List<String> values) {
            addCriterion("PRINCIPAL_NAME in", values, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameNotIn(List<String> values) {
            addCriterion("PRINCIPAL_NAME not in", values, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameBetween(String value1, String value2) {
            addCriterion("PRINCIPAL_NAME between", value1, value2, "principalName");
            return (Criteria) this;
        }

        public Criteria andPrincipalNameNotBetween(String value1, String value2) {
            addCriterion("PRINCIPAL_NAME not between", value1, value2, "principalName");
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