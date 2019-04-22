package com.portjs.base.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TenderApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TenderApplicationExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("Id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("Id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRequestIdIsNull() {
            addCriterion("request_id is null");
            return (Criteria) this;
        }

        public Criteria andRequestIdIsNotNull() {
            addCriterion("request_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequestIdEqualTo(String value) {
            addCriterion("request_id =", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotEqualTo(String value) {
            addCriterion("request_id <>", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThan(String value) {
            addCriterion("request_id >", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdGreaterThanOrEqualTo(String value) {
            addCriterion("request_id >=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThan(String value) {
            addCriterion("request_id <", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdLessThanOrEqualTo(String value) {
            addCriterion("request_id <=", value, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdIn(List<String> values) {
            addCriterion("request_id in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotIn(List<String> values) {
            addCriterion("request_id not in", values, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdBetween(String value1, String value2) {
            addCriterion("request_id between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andRequestIdNotBetween(String value1, String value2) {
            addCriterion("request_id not between", value1, value2, "requestId");
            return (Criteria) this;
        }

        public Criteria andTenderNumIsNull() {
            addCriterion("tender_num is null");
            return (Criteria) this;
        }

        public Criteria andTenderNumIsNotNull() {
            addCriterion("tender_num is not null");
            return (Criteria) this;
        }

        public Criteria andTenderNumEqualTo(String value) {
            addCriterion("tender_num =", value, "tenderNum");
            return (Criteria) this;
        }

        public Criteria andTenderNumNotEqualTo(String value) {
            addCriterion("tender_num <>", value, "tenderNum");
            return (Criteria) this;
        }

        public Criteria andTenderNumGreaterThan(String value) {
            addCriterion("tender_num >", value, "tenderNum");
            return (Criteria) this;
        }

        public Criteria andTenderNumGreaterThanOrEqualTo(String value) {
            addCriterion("tender_num >=", value, "tenderNum");
            return (Criteria) this;
        }

        public Criteria andTenderNumLessThan(String value) {
            addCriterion("tender_num <", value, "tenderNum");
            return (Criteria) this;
        }

        public Criteria andTenderNumLessThanOrEqualTo(String value) {
            addCriterion("tender_num <=", value, "tenderNum");
            return (Criteria) this;
        }

        public Criteria andTenderNumLike(String value) {
            addCriterion("tender_num like", value, "tenderNum");
            return (Criteria) this;
        }

        public Criteria andTenderNumNotLike(String value) {
            addCriterion("tender_num not like", value, "tenderNum");
            return (Criteria) this;
        }

        public Criteria andTenderNumIn(List<String> values) {
            addCriterion("tender_num in", values, "tenderNum");
            return (Criteria) this;
        }

        public Criteria andTenderNumNotIn(List<String> values) {
            addCriterion("tender_num not in", values, "tenderNum");
            return (Criteria) this;
        }

        public Criteria andTenderNumBetween(String value1, String value2) {
            addCriterion("tender_num between", value1, value2, "tenderNum");
            return (Criteria) this;
        }

        public Criteria andTenderNumNotBetween(String value1, String value2) {
            addCriterion("tender_num not between", value1, value2, "tenderNum");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andOrganizationIsNull() {
            addCriterion("organization is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationIsNotNull() {
            addCriterion("organization is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationEqualTo(String value) {
            addCriterion("organization =", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotEqualTo(String value) {
            addCriterion("organization <>", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationGreaterThan(String value) {
            addCriterion("organization >", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationGreaterThanOrEqualTo(String value) {
            addCriterion("organization >=", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLessThan(String value) {
            addCriterion("organization <", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLessThanOrEqualTo(String value) {
            addCriterion("organization <=", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationLike(String value) {
            addCriterion("organization like", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotLike(String value) {
            addCriterion("organization not like", value, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationIn(List<String> values) {
            addCriterion("organization in", values, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotIn(List<String> values) {
            addCriterion("organization not in", values, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationBetween(String value1, String value2) {
            addCriterion("organization between", value1, value2, "organization");
            return (Criteria) this;
        }

        public Criteria andOrganizationNotBetween(String value1, String value2) {
            addCriterion("organization not between", value1, value2, "organization");
            return (Criteria) this;
        }

        public Criteria andDeptIsNull() {
            addCriterion("dept is null");
            return (Criteria) this;
        }

        public Criteria andDeptIsNotNull() {
            addCriterion("dept is not null");
            return (Criteria) this;
        }

        public Criteria andDeptEqualTo(String value) {
            addCriterion("dept =", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotEqualTo(String value) {
            addCriterion("dept <>", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptGreaterThan(String value) {
            addCriterion("dept >", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptGreaterThanOrEqualTo(String value) {
            addCriterion("dept >=", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLessThan(String value) {
            addCriterion("dept <", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLessThanOrEqualTo(String value) {
            addCriterion("dept <=", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptLike(String value) {
            addCriterion("dept like", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotLike(String value) {
            addCriterion("dept not like", value, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptIn(List<String> values) {
            addCriterion("dept in", values, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotIn(List<String> values) {
            addCriterion("dept not in", values, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptBetween(String value1, String value2) {
            addCriterion("dept between", value1, value2, "dept");
            return (Criteria) this;
        }

        public Criteria andDeptNotBetween(String value1, String value2) {
            addCriterion("dept not between", value1, value2, "dept");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNull() {
            addCriterion("open_date is null");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNotNull() {
            addCriterion("open_date is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDateEqualTo(Date value) {
            addCriterionForJDBCDate("open_date =", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("open_date <>", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThan(Date value) {
            addCriterionForJDBCDate("open_date >", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("open_date >=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThan(Date value) {
            addCriterionForJDBCDate("open_date <", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("open_date <=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateIn(List<Date> values) {
            addCriterionForJDBCDate("open_date in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("open_date not in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("open_date between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("open_date not between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTenderUrlIsNull() {
            addCriterion("tender_url is null");
            return (Criteria) this;
        }

        public Criteria andTenderUrlIsNotNull() {
            addCriterion("tender_url is not null");
            return (Criteria) this;
        }

        public Criteria andTenderUrlEqualTo(String value) {
            addCriterion("tender_url =", value, "tenderUrl");
            return (Criteria) this;
        }

        public Criteria andTenderUrlNotEqualTo(String value) {
            addCriterion("tender_url <>", value, "tenderUrl");
            return (Criteria) this;
        }

        public Criteria andTenderUrlGreaterThan(String value) {
            addCriterion("tender_url >", value, "tenderUrl");
            return (Criteria) this;
        }

        public Criteria andTenderUrlGreaterThanOrEqualTo(String value) {
            addCriterion("tender_url >=", value, "tenderUrl");
            return (Criteria) this;
        }

        public Criteria andTenderUrlLessThan(String value) {
            addCriterion("tender_url <", value, "tenderUrl");
            return (Criteria) this;
        }

        public Criteria andTenderUrlLessThanOrEqualTo(String value) {
            addCriterion("tender_url <=", value, "tenderUrl");
            return (Criteria) this;
        }

        public Criteria andTenderUrlLike(String value) {
            addCriterion("tender_url like", value, "tenderUrl");
            return (Criteria) this;
        }

        public Criteria andTenderUrlNotLike(String value) {
            addCriterion("tender_url not like", value, "tenderUrl");
            return (Criteria) this;
        }

        public Criteria andTenderUrlIn(List<String> values) {
            addCriterion("tender_url in", values, "tenderUrl");
            return (Criteria) this;
        }

        public Criteria andTenderUrlNotIn(List<String> values) {
            addCriterion("tender_url not in", values, "tenderUrl");
            return (Criteria) this;
        }

        public Criteria andTenderUrlBetween(String value1, String value2) {
            addCriterion("tender_url between", value1, value2, "tenderUrl");
            return (Criteria) this;
        }

        public Criteria andTenderUrlNotBetween(String value1, String value2) {
            addCriterion("tender_url not between", value1, value2, "tenderUrl");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andBidDateIsNull() {
            addCriterion("bid_date is null");
            return (Criteria) this;
        }

        public Criteria andBidDateIsNotNull() {
            addCriterion("bid_date is not null");
            return (Criteria) this;
        }

        public Criteria andBidDateEqualTo(Date value) {
            addCriterionForJDBCDate("bid_date =", value, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("bid_date <>", value, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateGreaterThan(Date value) {
            addCriterionForJDBCDate("bid_date >", value, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bid_date >=", value, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateLessThan(Date value) {
            addCriterionForJDBCDate("bid_date <", value, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bid_date <=", value, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateIn(List<Date> values) {
            addCriterionForJDBCDate("bid_date in", values, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("bid_date not in", values, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bid_date between", value1, value2, "bidDate");
            return (Criteria) this;
        }

        public Criteria andBidDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bid_date not between", value1, value2, "bidDate");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andBidUrlIsNull() {
            addCriterion("bid_url is null");
            return (Criteria) this;
        }

        public Criteria andBidUrlIsNotNull() {
            addCriterion("bid_url is not null");
            return (Criteria) this;
        }

        public Criteria andBidUrlEqualTo(String value) {
            addCriterion("bid_url =", value, "bidUrl");
            return (Criteria) this;
        }

        public Criteria andBidUrlNotEqualTo(String value) {
            addCriterion("bid_url <>", value, "bidUrl");
            return (Criteria) this;
        }

        public Criteria andBidUrlGreaterThan(String value) {
            addCriterion("bid_url >", value, "bidUrl");
            return (Criteria) this;
        }

        public Criteria andBidUrlGreaterThanOrEqualTo(String value) {
            addCriterion("bid_url >=", value, "bidUrl");
            return (Criteria) this;
        }

        public Criteria andBidUrlLessThan(String value) {
            addCriterion("bid_url <", value, "bidUrl");
            return (Criteria) this;
        }

        public Criteria andBidUrlLessThanOrEqualTo(String value) {
            addCriterion("bid_url <=", value, "bidUrl");
            return (Criteria) this;
        }

        public Criteria andBidUrlLike(String value) {
            addCriterion("bid_url like", value, "bidUrl");
            return (Criteria) this;
        }

        public Criteria andBidUrlNotLike(String value) {
            addCriterion("bid_url not like", value, "bidUrl");
            return (Criteria) this;
        }

        public Criteria andBidUrlIn(List<String> values) {
            addCriterion("bid_url in", values, "bidUrl");
            return (Criteria) this;
        }

        public Criteria andBidUrlNotIn(List<String> values) {
            addCriterion("bid_url not in", values, "bidUrl");
            return (Criteria) this;
        }

        public Criteria andBidUrlBetween(String value1, String value2) {
            addCriterion("bid_url between", value1, value2, "bidUrl");
            return (Criteria) this;
        }

        public Criteria andBidUrlNotBetween(String value1, String value2) {
            addCriterion("bid_url not between", value1, value2, "bidUrl");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("delete_time is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("delete_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("delete_time =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("delete_time <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("delete_time >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delete_time >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("delete_time <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("delete_time <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterion("delete_time in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterion("delete_time not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("delete_time between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("delete_time not between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andReviewIsNull() {
            addCriterion("review is null");
            return (Criteria) this;
        }

        public Criteria andReviewIsNotNull() {
            addCriterion("review is not null");
            return (Criteria) this;
        }

        public Criteria andReviewEqualTo(String value) {
            addCriterion("review =", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewNotEqualTo(String value) {
            addCriterion("review <>", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewGreaterThan(String value) {
            addCriterion("review >", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewGreaterThanOrEqualTo(String value) {
            addCriterion("review >=", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewLessThan(String value) {
            addCriterion("review <", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewLessThanOrEqualTo(String value) {
            addCriterion("review <=", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewLike(String value) {
            addCriterion("review like", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewNotLike(String value) {
            addCriterion("review not like", value, "review");
            return (Criteria) this;
        }

        public Criteria andReviewIn(List<String> values) {
            addCriterion("review in", values, "review");
            return (Criteria) this;
        }

        public Criteria andReviewNotIn(List<String> values) {
            addCriterion("review not in", values, "review");
            return (Criteria) this;
        }

        public Criteria andReviewBetween(String value1, String value2) {
            addCriterion("review between", value1, value2, "review");
            return (Criteria) this;
        }

        public Criteria andReviewNotBetween(String value1, String value2) {
            addCriterion("review not between", value1, value2, "review");
            return (Criteria) this;
        }

        public Criteria andBackUp1IsNull() {
            addCriterion("back_up1 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp1IsNotNull() {
            addCriterion("back_up1 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp1EqualTo(String value) {
            addCriterion("back_up1 =", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1NotEqualTo(String value) {
            addCriterion("back_up1 <>", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1GreaterThan(String value) {
            addCriterion("back_up1 >", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1GreaterThanOrEqualTo(String value) {
            addCriterion("back_up1 >=", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1LessThan(String value) {
            addCriterion("back_up1 <", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1LessThanOrEqualTo(String value) {
            addCriterion("back_up1 <=", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1Like(String value) {
            addCriterion("back_up1 like", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1NotLike(String value) {
            addCriterion("back_up1 not like", value, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1In(List<String> values) {
            addCriterion("back_up1 in", values, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1NotIn(List<String> values) {
            addCriterion("back_up1 not in", values, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1Between(String value1, String value2) {
            addCriterion("back_up1 between", value1, value2, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp1NotBetween(String value1, String value2) {
            addCriterion("back_up1 not between", value1, value2, "backUp1");
            return (Criteria) this;
        }

        public Criteria andBackUp2IsNull() {
            addCriterion("back_up2 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp2IsNotNull() {
            addCriterion("back_up2 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp2EqualTo(String value) {
            addCriterion("back_up2 =", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2NotEqualTo(String value) {
            addCriterion("back_up2 <>", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2GreaterThan(String value) {
            addCriterion("back_up2 >", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2GreaterThanOrEqualTo(String value) {
            addCriterion("back_up2 >=", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2LessThan(String value) {
            addCriterion("back_up2 <", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2LessThanOrEqualTo(String value) {
            addCriterion("back_up2 <=", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2Like(String value) {
            addCriterion("back_up2 like", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2NotLike(String value) {
            addCriterion("back_up2 not like", value, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2In(List<String> values) {
            addCriterion("back_up2 in", values, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2NotIn(List<String> values) {
            addCriterion("back_up2 not in", values, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2Between(String value1, String value2) {
            addCriterion("back_up2 between", value1, value2, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp2NotBetween(String value1, String value2) {
            addCriterion("back_up2 not between", value1, value2, "backUp2");
            return (Criteria) this;
        }

        public Criteria andBackUp3IsNull() {
            addCriterion("back_up3 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp3IsNotNull() {
            addCriterion("back_up3 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp3EqualTo(String value) {
            addCriterion("back_up3 =", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3NotEqualTo(String value) {
            addCriterion("back_up3 <>", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3GreaterThan(String value) {
            addCriterion("back_up3 >", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3GreaterThanOrEqualTo(String value) {
            addCriterion("back_up3 >=", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3LessThan(String value) {
            addCriterion("back_up3 <", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3LessThanOrEqualTo(String value) {
            addCriterion("back_up3 <=", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3Like(String value) {
            addCriterion("back_up3 like", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3NotLike(String value) {
            addCriterion("back_up3 not like", value, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3In(List<String> values) {
            addCriterion("back_up3 in", values, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3NotIn(List<String> values) {
            addCriterion("back_up3 not in", values, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3Between(String value1, String value2) {
            addCriterion("back_up3 between", value1, value2, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp3NotBetween(String value1, String value2) {
            addCriterion("back_up3 not between", value1, value2, "backUp3");
            return (Criteria) this;
        }

        public Criteria andBackUp4IsNull() {
            addCriterion("back_up4 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp4IsNotNull() {
            addCriterion("back_up4 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp4EqualTo(String value) {
            addCriterion("back_up4 =", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4NotEqualTo(String value) {
            addCriterion("back_up4 <>", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4GreaterThan(String value) {
            addCriterion("back_up4 >", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4GreaterThanOrEqualTo(String value) {
            addCriterion("back_up4 >=", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4LessThan(String value) {
            addCriterion("back_up4 <", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4LessThanOrEqualTo(String value) {
            addCriterion("back_up4 <=", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4Like(String value) {
            addCriterion("back_up4 like", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4NotLike(String value) {
            addCriterion("back_up4 not like", value, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4In(List<String> values) {
            addCriterion("back_up4 in", values, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4NotIn(List<String> values) {
            addCriterion("back_up4 not in", values, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4Between(String value1, String value2) {
            addCriterion("back_up4 between", value1, value2, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp4NotBetween(String value1, String value2) {
            addCriterion("back_up4 not between", value1, value2, "backUp4");
            return (Criteria) this;
        }

        public Criteria andBackUp5IsNull() {
            addCriterion("back_up5 is null");
            return (Criteria) this;
        }

        public Criteria andBackUp5IsNotNull() {
            addCriterion("back_up5 is not null");
            return (Criteria) this;
        }

        public Criteria andBackUp5EqualTo(String value) {
            addCriterion("back_up5 =", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5NotEqualTo(String value) {
            addCriterion("back_up5 <>", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5GreaterThan(String value) {
            addCriterion("back_up5 >", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5GreaterThanOrEqualTo(String value) {
            addCriterion("back_up5 >=", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5LessThan(String value) {
            addCriterion("back_up5 <", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5LessThanOrEqualTo(String value) {
            addCriterion("back_up5 <=", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5Like(String value) {
            addCriterion("back_up5 like", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5NotLike(String value) {
            addCriterion("back_up5 not like", value, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5In(List<String> values) {
            addCriterion("back_up5 in", values, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5NotIn(List<String> values) {
            addCriterion("back_up5 not in", values, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5Between(String value1, String value2) {
            addCriterion("back_up5 between", value1, value2, "backUp5");
            return (Criteria) this;
        }

        public Criteria andBackUp5NotBetween(String value1, String value2) {
            addCriterion("back_up5 not between", value1, value2, "backUp5");
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