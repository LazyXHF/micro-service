package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TUserExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLoginAccountIsNull() {
            addCriterion("login_account is null");
            return (Criteria) this;
        }

        public Criteria andLoginAccountIsNotNull() {
            addCriterion("login_account is not null");
            return (Criteria) this;
        }

        public Criteria andLoginAccountEqualTo(String value) {
            addCriterion("login_account =", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotEqualTo(String value) {
            addCriterion("login_account <>", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountGreaterThan(String value) {
            addCriterion("login_account >", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountGreaterThanOrEqualTo(String value) {
            addCriterion("login_account >=", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountLessThan(String value) {
            addCriterion("login_account <", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountLessThanOrEqualTo(String value) {
            addCriterion("login_account <=", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountLike(String value) {
            addCriterion("login_account like", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotLike(String value) {
            addCriterion("login_account not like", value, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountIn(List<String> values) {
            addCriterion("login_account in", values, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotIn(List<String> values) {
            addCriterion("login_account not in", values, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountBetween(String value1, String value2) {
            addCriterion("login_account between", value1, value2, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginAccountNotBetween(String value1, String value2) {
            addCriterion("login_account not between", value1, value2, "loginAccount");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIsNull() {
            addCriterion("login_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIsNotNull() {
            addCriterion("login_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordEqualTo(String value) {
            addCriterion("login_PASSWORD =", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotEqualTo(String value) {
            addCriterion("login_PASSWORD <>", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThan(String value) {
            addCriterion("login_PASSWORD >", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("login_PASSWORD >=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThan(String value) {
            addCriterion("login_PASSWORD <", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLessThanOrEqualTo(String value) {
            addCriterion("login_PASSWORD <=", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordLike(String value) {
            addCriterion("login_PASSWORD like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotLike(String value) {
            addCriterion("login_PASSWORD not like", value, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordIn(List<String> values) {
            addCriterion("login_PASSWORD in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotIn(List<String> values) {
            addCriterion("login_PASSWORD not in", values, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordBetween(String value1, String value2) {
            addCriterion("login_PASSWORD between", value1, value2, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginPasswordNotBetween(String value1, String value2) {
            addCriterion("login_PASSWORD not between", value1, value2, "loginPassword");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNull() {
            addCriterion("login_name is null");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNotNull() {
            addCriterion("login_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoginNameEqualTo(String value) {
            addCriterion("login_name =", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotEqualTo(String value) {
            addCriterion("login_name <>", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThan(String value) {
            addCriterion("login_name >", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("login_name >=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThan(String value) {
            addCriterion("login_name <", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThanOrEqualTo(String value) {
            addCriterion("login_name <=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLike(String value) {
            addCriterion("login_name like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotLike(String value) {
            addCriterion("login_name not like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameIn(List<String> values) {
            addCriterion("login_name in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotIn(List<String> values) {
            addCriterion("login_name not in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameBetween(String value1, String value2) {
            addCriterion("login_name between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotBetween(String value1, String value2) {
            addCriterion("login_name not between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNull() {
            addCriterion("DEPARTMENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("DEPARTMENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("DEPARTMENT_ID =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("DEPARTMENT_ID <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("DEPARTMENT_ID >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT_ID >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("DEPARTMENT_ID <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT_ID <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("DEPARTMENT_ID like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("DEPARTMENT_ID not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("DEPARTMENT_ID in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("DEPARTMENT_ID not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("DEPARTMENT_ID between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("DEPARTMENT_ID not between", value1, value2, "departmentId");
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

        public Criteria andSortIsNull() {
            addCriterion("SORT is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("SORT is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("SORT =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("SORT <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("SORT >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("SORT <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("SORT <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("SORT in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("SORT not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("SORT between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("last_login_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("last_login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("last_login_time =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("last_login_time <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("last_login_time >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_time >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("last_login_time <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_login_time <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("last_login_time in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("last_login_time not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("last_login_time between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdPasswdTimeIsNull() {
            addCriterion("last_upd_passwd_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdPasswdTimeIsNotNull() {
            addCriterion("last_upd_passwd_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdPasswdTimeEqualTo(Date value) {
            addCriterion("last_upd_passwd_time =", value, "lastUpdPasswdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdPasswdTimeNotEqualTo(Date value) {
            addCriterion("last_upd_passwd_time <>", value, "lastUpdPasswdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdPasswdTimeGreaterThan(Date value) {
            addCriterion("last_upd_passwd_time >", value, "lastUpdPasswdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdPasswdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_upd_passwd_time >=", value, "lastUpdPasswdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdPasswdTimeLessThan(Date value) {
            addCriterion("last_upd_passwd_time <", value, "lastUpdPasswdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdPasswdTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_upd_passwd_time <=", value, "lastUpdPasswdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdPasswdTimeIn(List<Date> values) {
            addCriterion("last_upd_passwd_time in", values, "lastUpdPasswdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdPasswdTimeNotIn(List<Date> values) {
            addCriterion("last_upd_passwd_time not in", values, "lastUpdPasswdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdPasswdTimeBetween(Date value1, Date value2) {
            addCriterion("last_upd_passwd_time between", value1, value2, "lastUpdPasswdTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdPasswdTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_upd_passwd_time not between", value1, value2, "lastUpdPasswdTime");
            return (Criteria) this;
        }

        public Criteria andPasswordModifyCycleIsNull() {
            addCriterion("password_modify_cycle is null");
            return (Criteria) this;
        }

        public Criteria andPasswordModifyCycleIsNotNull() {
            addCriterion("password_modify_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordModifyCycleEqualTo(Integer value) {
            addCriterion("password_modify_cycle =", value, "passwordModifyCycle");
            return (Criteria) this;
        }

        public Criteria andPasswordModifyCycleNotEqualTo(Integer value) {
            addCriterion("password_modify_cycle <>", value, "passwordModifyCycle");
            return (Criteria) this;
        }

        public Criteria andPasswordModifyCycleGreaterThan(Integer value) {
            addCriterion("password_modify_cycle >", value, "passwordModifyCycle");
            return (Criteria) this;
        }

        public Criteria andPasswordModifyCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("password_modify_cycle >=", value, "passwordModifyCycle");
            return (Criteria) this;
        }

        public Criteria andPasswordModifyCycleLessThan(Integer value) {
            addCriterion("password_modify_cycle <", value, "passwordModifyCycle");
            return (Criteria) this;
        }

        public Criteria andPasswordModifyCycleLessThanOrEqualTo(Integer value) {
            addCriterion("password_modify_cycle <=", value, "passwordModifyCycle");
            return (Criteria) this;
        }

        public Criteria andPasswordModifyCycleIn(List<Integer> values) {
            addCriterion("password_modify_cycle in", values, "passwordModifyCycle");
            return (Criteria) this;
        }

        public Criteria andPasswordModifyCycleNotIn(List<Integer> values) {
            addCriterion("password_modify_cycle not in", values, "passwordModifyCycle");
            return (Criteria) this;
        }

        public Criteria andPasswordModifyCycleBetween(Integer value1, Integer value2) {
            addCriterion("password_modify_cycle between", value1, value2, "passwordModifyCycle");
            return (Criteria) this;
        }

        public Criteria andPasswordModifyCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("password_modify_cycle not between", value1, value2, "passwordModifyCycle");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordIsNull() {
            addCriterion("history_password is null");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordIsNotNull() {
            addCriterion("history_password is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordEqualTo(String value) {
            addCriterion("history_password =", value, "historyPassword");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordNotEqualTo(String value) {
            addCriterion("history_password <>", value, "historyPassword");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordGreaterThan(String value) {
            addCriterion("history_password >", value, "historyPassword");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("history_password >=", value, "historyPassword");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordLessThan(String value) {
            addCriterion("history_password <", value, "historyPassword");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordLessThanOrEqualTo(String value) {
            addCriterion("history_password <=", value, "historyPassword");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordLike(String value) {
            addCriterion("history_password like", value, "historyPassword");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordNotLike(String value) {
            addCriterion("history_password not like", value, "historyPassword");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordIn(List<String> values) {
            addCriterion("history_password in", values, "historyPassword");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordNotIn(List<String> values) {
            addCriterion("history_password not in", values, "historyPassword");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordBetween(String value1, String value2) {
            addCriterion("history_password between", value1, value2, "historyPassword");
            return (Criteria) this;
        }

        public Criteria andHistoryPasswordNotBetween(String value1, String value2) {
            addCriterion("history_password not between", value1, value2, "historyPassword");
            return (Criteria) this;
        }

        public Criteria andPasswdWrongCountIsNull() {
            addCriterion("passwd_wrong_count is null");
            return (Criteria) this;
        }

        public Criteria andPasswdWrongCountIsNotNull() {
            addCriterion("passwd_wrong_count is not null");
            return (Criteria) this;
        }

        public Criteria andPasswdWrongCountEqualTo(Integer value) {
            addCriterion("passwd_wrong_count =", value, "passwdWrongCount");
            return (Criteria) this;
        }

        public Criteria andPasswdWrongCountNotEqualTo(Integer value) {
            addCriterion("passwd_wrong_count <>", value, "passwdWrongCount");
            return (Criteria) this;
        }

        public Criteria andPasswdWrongCountGreaterThan(Integer value) {
            addCriterion("passwd_wrong_count >", value, "passwdWrongCount");
            return (Criteria) this;
        }

        public Criteria andPasswdWrongCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("passwd_wrong_count >=", value, "passwdWrongCount");
            return (Criteria) this;
        }

        public Criteria andPasswdWrongCountLessThan(Integer value) {
            addCriterion("passwd_wrong_count <", value, "passwdWrongCount");
            return (Criteria) this;
        }

        public Criteria andPasswdWrongCountLessThanOrEqualTo(Integer value) {
            addCriterion("passwd_wrong_count <=", value, "passwdWrongCount");
            return (Criteria) this;
        }

        public Criteria andPasswdWrongCountIn(List<Integer> values) {
            addCriterion("passwd_wrong_count in", values, "passwdWrongCount");
            return (Criteria) this;
        }

        public Criteria andPasswdWrongCountNotIn(List<Integer> values) {
            addCriterion("passwd_wrong_count not in", values, "passwdWrongCount");
            return (Criteria) this;
        }

        public Criteria andPasswdWrongCountBetween(Integer value1, Integer value2) {
            addCriterion("passwd_wrong_count between", value1, value2, "passwdWrongCount");
            return (Criteria) this;
        }

        public Criteria andPasswdWrongCountNotBetween(Integer value1, Integer value2) {
            addCriterion("passwd_wrong_count not between", value1, value2, "passwdWrongCount");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(Date value) {
            addCriterion("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(Date value) {
            addCriterion("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(Date value) {
            addCriterion("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(Date value) {
            addCriterion("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(Date value) {
            addCriterion("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(Date value) {
            addCriterion("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<Date> values) {
            addCriterion("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<Date> values) {
            addCriterion("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(Date value1, Date value2) {
            addCriterion("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(Date value1, Date value2) {
            addCriterion("birth_date not between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andDutyIsNull() {
            addCriterion("duty is null");
            return (Criteria) this;
        }

        public Criteria andDutyIsNotNull() {
            addCriterion("duty is not null");
            return (Criteria) this;
        }

        public Criteria andDutyEqualTo(String value) {
            addCriterion("duty =", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotEqualTo(String value) {
            addCriterion("duty <>", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThan(String value) {
            addCriterion("duty >", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThanOrEqualTo(String value) {
            addCriterion("duty >=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThan(String value) {
            addCriterion("duty <", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThanOrEqualTo(String value) {
            addCriterion("duty <=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLike(String value) {
            addCriterion("duty like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotLike(String value) {
            addCriterion("duty not like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyIn(List<String> values) {
            addCriterion("duty in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotIn(List<String> values) {
            addCriterion("duty not in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyBetween(String value1, String value2) {
            addCriterion("duty between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotBetween(String value1, String value2) {
            addCriterion("duty not between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLevIsNull() {
            addCriterion("duty_lev is null");
            return (Criteria) this;
        }

        public Criteria andDutyLevIsNotNull() {
            addCriterion("duty_lev is not null");
            return (Criteria) this;
        }

        public Criteria andDutyLevEqualTo(String value) {
            addCriterion("duty_lev =", value, "dutyLev");
            return (Criteria) this;
        }

        public Criteria andDutyLevNotEqualTo(String value) {
            addCriterion("duty_lev <>", value, "dutyLev");
            return (Criteria) this;
        }

        public Criteria andDutyLevGreaterThan(String value) {
            addCriterion("duty_lev >", value, "dutyLev");
            return (Criteria) this;
        }

        public Criteria andDutyLevGreaterThanOrEqualTo(String value) {
            addCriterion("duty_lev >=", value, "dutyLev");
            return (Criteria) this;
        }

        public Criteria andDutyLevLessThan(String value) {
            addCriterion("duty_lev <", value, "dutyLev");
            return (Criteria) this;
        }

        public Criteria andDutyLevLessThanOrEqualTo(String value) {
            addCriterion("duty_lev <=", value, "dutyLev");
            return (Criteria) this;
        }

        public Criteria andDutyLevLike(String value) {
            addCriterion("duty_lev like", value, "dutyLev");
            return (Criteria) this;
        }

        public Criteria andDutyLevNotLike(String value) {
            addCriterion("duty_lev not like", value, "dutyLev");
            return (Criteria) this;
        }

        public Criteria andDutyLevIn(List<String> values) {
            addCriterion("duty_lev in", values, "dutyLev");
            return (Criteria) this;
        }

        public Criteria andDutyLevNotIn(List<String> values) {
            addCriterion("duty_lev not in", values, "dutyLev");
            return (Criteria) this;
        }

        public Criteria andDutyLevBetween(String value1, String value2) {
            addCriterion("duty_lev between", value1, value2, "dutyLev");
            return (Criteria) this;
        }

        public Criteria andDutyLevNotBetween(String value1, String value2) {
            addCriterion("duty_lev not between", value1, value2, "dutyLev");
            return (Criteria) this;
        }

        public Criteria andPhonenumIsNull() {
            addCriterion("phonenum is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumIsNotNull() {
            addCriterion("phonenum is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumEqualTo(String value) {
            addCriterion("phonenum =", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotEqualTo(String value) {
            addCriterion("phonenum <>", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThan(String value) {
            addCriterion("phonenum >", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThanOrEqualTo(String value) {
            addCriterion("phonenum >=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThan(String value) {
            addCriterion("phonenum <", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThanOrEqualTo(String value) {
            addCriterion("phonenum <=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLike(String value) {
            addCriterion("phonenum like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotLike(String value) {
            addCriterion("phonenum not like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumIn(List<String> values) {
            addCriterion("phonenum in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotIn(List<String> values) {
            addCriterion("phonenum not in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumBetween(String value1, String value2) {
            addCriterion("phonenum between", value1, value2, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotBetween(String value1, String value2) {
            addCriterion("phonenum not between", value1, value2, "phonenum");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andPingyinIsNull() {
            addCriterion("pingyin is null");
            return (Criteria) this;
        }

        public Criteria andPingyinIsNotNull() {
            addCriterion("pingyin is not null");
            return (Criteria) this;
        }

        public Criteria andPingyinEqualTo(String value) {
            addCriterion("pingyin =", value, "pingyin");
            return (Criteria) this;
        }

        public Criteria andPingyinNotEqualTo(String value) {
            addCriterion("pingyin <>", value, "pingyin");
            return (Criteria) this;
        }

        public Criteria andPingyinGreaterThan(String value) {
            addCriterion("pingyin >", value, "pingyin");
            return (Criteria) this;
        }

        public Criteria andPingyinGreaterThanOrEqualTo(String value) {
            addCriterion("pingyin >=", value, "pingyin");
            return (Criteria) this;
        }

        public Criteria andPingyinLessThan(String value) {
            addCriterion("pingyin <", value, "pingyin");
            return (Criteria) this;
        }

        public Criteria andPingyinLessThanOrEqualTo(String value) {
            addCriterion("pingyin <=", value, "pingyin");
            return (Criteria) this;
        }

        public Criteria andPingyinLike(String value) {
            addCriterion("pingyin like", value, "pingyin");
            return (Criteria) this;
        }

        public Criteria andPingyinNotLike(String value) {
            addCriterion("pingyin not like", value, "pingyin");
            return (Criteria) this;
        }

        public Criteria andPingyinIn(List<String> values) {
            addCriterion("pingyin in", values, "pingyin");
            return (Criteria) this;
        }

        public Criteria andPingyinNotIn(List<String> values) {
            addCriterion("pingyin not in", values, "pingyin");
            return (Criteria) this;
        }

        public Criteria andPingyinBetween(String value1, String value2) {
            addCriterion("pingyin between", value1, value2, "pingyin");
            return (Criteria) this;
        }

        public Criteria andPingyinNotBetween(String value1, String value2) {
            addCriterion("pingyin not between", value1, value2, "pingyin");
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

        public Criteria andReserved6IsNull() {
            addCriterion("reserved6 is null");
            return (Criteria) this;
        }

        public Criteria andReserved6IsNotNull() {
            addCriterion("reserved6 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved6EqualTo(String value) {
            addCriterion("reserved6 =", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6NotEqualTo(String value) {
            addCriterion("reserved6 <>", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6GreaterThan(String value) {
            addCriterion("reserved6 >", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6GreaterThanOrEqualTo(String value) {
            addCriterion("reserved6 >=", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6LessThan(String value) {
            addCriterion("reserved6 <", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6LessThanOrEqualTo(String value) {
            addCriterion("reserved6 <=", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6Like(String value) {
            addCriterion("reserved6 like", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6NotLike(String value) {
            addCriterion("reserved6 not like", value, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6In(List<String> values) {
            addCriterion("reserved6 in", values, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6NotIn(List<String> values) {
            addCriterion("reserved6 not in", values, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6Between(String value1, String value2) {
            addCriterion("reserved6 between", value1, value2, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved6NotBetween(String value1, String value2) {
            addCriterion("reserved6 not between", value1, value2, "reserved6");
            return (Criteria) this;
        }

        public Criteria andReserved7IsNull() {
            addCriterion("reserved7 is null");
            return (Criteria) this;
        }

        public Criteria andReserved7IsNotNull() {
            addCriterion("reserved7 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved7EqualTo(String value) {
            addCriterion("reserved7 =", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7NotEqualTo(String value) {
            addCriterion("reserved7 <>", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7GreaterThan(String value) {
            addCriterion("reserved7 >", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7GreaterThanOrEqualTo(String value) {
            addCriterion("reserved7 >=", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7LessThan(String value) {
            addCriterion("reserved7 <", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7LessThanOrEqualTo(String value) {
            addCriterion("reserved7 <=", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7Like(String value) {
            addCriterion("reserved7 like", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7NotLike(String value) {
            addCriterion("reserved7 not like", value, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7In(List<String> values) {
            addCriterion("reserved7 in", values, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7NotIn(List<String> values) {
            addCriterion("reserved7 not in", values, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7Between(String value1, String value2) {
            addCriterion("reserved7 between", value1, value2, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved7NotBetween(String value1, String value2) {
            addCriterion("reserved7 not between", value1, value2, "reserved7");
            return (Criteria) this;
        }

        public Criteria andReserved8IsNull() {
            addCriterion("reserved8 is null");
            return (Criteria) this;
        }

        public Criteria andReserved8IsNotNull() {
            addCriterion("reserved8 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved8EqualTo(String value) {
            addCriterion("reserved8 =", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8NotEqualTo(String value) {
            addCriterion("reserved8 <>", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8GreaterThan(String value) {
            addCriterion("reserved8 >", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8GreaterThanOrEqualTo(String value) {
            addCriterion("reserved8 >=", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8LessThan(String value) {
            addCriterion("reserved8 <", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8LessThanOrEqualTo(String value) {
            addCriterion("reserved8 <=", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8Like(String value) {
            addCriterion("reserved8 like", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8NotLike(String value) {
            addCriterion("reserved8 not like", value, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8In(List<String> values) {
            addCriterion("reserved8 in", values, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8NotIn(List<String> values) {
            addCriterion("reserved8 not in", values, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8Between(String value1, String value2) {
            addCriterion("reserved8 between", value1, value2, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved8NotBetween(String value1, String value2) {
            addCriterion("reserved8 not between", value1, value2, "reserved8");
            return (Criteria) this;
        }

        public Criteria andReserved9IsNull() {
            addCriterion("reserved9 is null");
            return (Criteria) this;
        }

        public Criteria andReserved9IsNotNull() {
            addCriterion("reserved9 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved9EqualTo(String value) {
            addCriterion("reserved9 =", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9NotEqualTo(String value) {
            addCriterion("reserved9 <>", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9GreaterThan(String value) {
            addCriterion("reserved9 >", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9GreaterThanOrEqualTo(String value) {
            addCriterion("reserved9 >=", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9LessThan(String value) {
            addCriterion("reserved9 <", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9LessThanOrEqualTo(String value) {
            addCriterion("reserved9 <=", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9Like(String value) {
            addCriterion("reserved9 like", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9NotLike(String value) {
            addCriterion("reserved9 not like", value, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9In(List<String> values) {
            addCriterion("reserved9 in", values, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9NotIn(List<String> values) {
            addCriterion("reserved9 not in", values, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9Between(String value1, String value2) {
            addCriterion("reserved9 between", value1, value2, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved9NotBetween(String value1, String value2) {
            addCriterion("reserved9 not between", value1, value2, "reserved9");
            return (Criteria) this;
        }

        public Criteria andReserved10IsNull() {
            addCriterion("reserved10 is null");
            return (Criteria) this;
        }

        public Criteria andReserved10IsNotNull() {
            addCriterion("reserved10 is not null");
            return (Criteria) this;
        }

        public Criteria andReserved10EqualTo(String value) {
            addCriterion("reserved10 =", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10NotEqualTo(String value) {
            addCriterion("reserved10 <>", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10GreaterThan(String value) {
            addCriterion("reserved10 >", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10GreaterThanOrEqualTo(String value) {
            addCriterion("reserved10 >=", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10LessThan(String value) {
            addCriterion("reserved10 <", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10LessThanOrEqualTo(String value) {
            addCriterion("reserved10 <=", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10Like(String value) {
            addCriterion("reserved10 like", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10NotLike(String value) {
            addCriterion("reserved10 not like", value, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10In(List<String> values) {
            addCriterion("reserved10 in", values, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10NotIn(List<String> values) {
            addCriterion("reserved10 not in", values, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10Between(String value1, String value2) {
            addCriterion("reserved10 between", value1, value2, "reserved10");
            return (Criteria) this;
        }

        public Criteria andReserved10NotBetween(String value1, String value2) {
            addCriterion("reserved10 not between", value1, value2, "reserved10");
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