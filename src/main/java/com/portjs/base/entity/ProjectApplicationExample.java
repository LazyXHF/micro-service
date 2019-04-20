package com.portjs.base.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProjectApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectApplicationExample() {
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

        public Criteria andInvestmentIdIsNull() {
            addCriterion("investment_id is null");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdIsNotNull() {
            addCriterion("investment_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdEqualTo(String value) {
            addCriterion("investment_id =", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdNotEqualTo(String value) {
            addCriterion("investment_id <>", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdGreaterThan(String value) {
            addCriterion("investment_id >", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("investment_id >=", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdLessThan(String value) {
            addCriterion("investment_id <", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdLessThanOrEqualTo(String value) {
            addCriterion("investment_id <=", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdLike(String value) {
            addCriterion("investment_id like", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdNotLike(String value) {
            addCriterion("investment_id not like", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdIn(List<String> values) {
            addCriterion("investment_id in", values, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdNotIn(List<String> values) {
            addCriterion("investment_id not in", values, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdBetween(String value1, String value2) {
            addCriterion("investment_id between", value1, value2, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdNotBetween(String value1, String value2) {
            addCriterion("investment_id not between", value1, value2, "investmentId");
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

        public Criteria andProjectCodeIsNull() {
            addCriterion("project_code is null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIsNotNull() {
            addCriterion("project_code is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCodeEqualTo(String value) {
            addCriterion("project_code =", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotEqualTo(String value) {
            addCriterion("project_code <>", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThan(String value) {
            addCriterion("project_code >", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("project_code >=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThan(String value) {
            addCriterion("project_code <", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLessThanOrEqualTo(String value) {
            addCriterion("project_code <=", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeLike(String value) {
            addCriterion("project_code like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotLike(String value) {
            addCriterion("project_code not like", value, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeIn(List<String> values) {
            addCriterion("project_code in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotIn(List<String> values) {
            addCriterion("project_code not in", values, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeBetween(String value1, String value2) {
            addCriterion("project_code between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectCodeNotBetween(String value1, String value2) {
            addCriterion("project_code not between", value1, value2, "projectCode");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(String value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(String value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(String value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(String value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(String value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLike(String value) {
            addCriterion("project_type like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotLike(String value) {
            addCriterion("project_type not like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<String> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<String> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(String value1, String value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(String value1, String value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andInvestorIsNull() {
            addCriterion("investor is null");
            return (Criteria) this;
        }

        public Criteria andInvestorIsNotNull() {
            addCriterion("investor is not null");
            return (Criteria) this;
        }

        public Criteria andInvestorEqualTo(String value) {
            addCriterion("investor =", value, "investor");
            return (Criteria) this;
        }

        public Criteria andInvestorNotEqualTo(String value) {
            addCriterion("investor <>", value, "investor");
            return (Criteria) this;
        }

        public Criteria andInvestorGreaterThan(String value) {
            addCriterion("investor >", value, "investor");
            return (Criteria) this;
        }

        public Criteria andInvestorGreaterThanOrEqualTo(String value) {
            addCriterion("investor >=", value, "investor");
            return (Criteria) this;
        }

        public Criteria andInvestorLessThan(String value) {
            addCriterion("investor <", value, "investor");
            return (Criteria) this;
        }

        public Criteria andInvestorLessThanOrEqualTo(String value) {
            addCriterion("investor <=", value, "investor");
            return (Criteria) this;
        }

        public Criteria andInvestorLike(String value) {
            addCriterion("investor like", value, "investor");
            return (Criteria) this;
        }

        public Criteria andInvestorNotLike(String value) {
            addCriterion("investor not like", value, "investor");
            return (Criteria) this;
        }

        public Criteria andInvestorIn(List<String> values) {
            addCriterion("investor in", values, "investor");
            return (Criteria) this;
        }

        public Criteria andInvestorNotIn(List<String> values) {
            addCriterion("investor not in", values, "investor");
            return (Criteria) this;
        }

        public Criteria andInvestorBetween(String value1, String value2) {
            addCriterion("investor between", value1, value2, "investor");
            return (Criteria) this;
        }

        public Criteria andInvestorNotBetween(String value1, String value2) {
            addCriterion("investor not between", value1, value2, "investor");
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

        public Criteria andConstructionModeIsNull() {
            addCriterion("construction_mode is null");
            return (Criteria) this;
        }

        public Criteria andConstructionModeIsNotNull() {
            addCriterion("construction_mode is not null");
            return (Criteria) this;
        }

        public Criteria andConstructionModeEqualTo(String value) {
            addCriterion("construction_mode =", value, "constructionMode");
            return (Criteria) this;
        }

        public Criteria andConstructionModeNotEqualTo(String value) {
            addCriterion("construction_mode <>", value, "constructionMode");
            return (Criteria) this;
        }

        public Criteria andConstructionModeGreaterThan(String value) {
            addCriterion("construction_mode >", value, "constructionMode");
            return (Criteria) this;
        }

        public Criteria andConstructionModeGreaterThanOrEqualTo(String value) {
            addCriterion("construction_mode >=", value, "constructionMode");
            return (Criteria) this;
        }

        public Criteria andConstructionModeLessThan(String value) {
            addCriterion("construction_mode <", value, "constructionMode");
            return (Criteria) this;
        }

        public Criteria andConstructionModeLessThanOrEqualTo(String value) {
            addCriterion("construction_mode <=", value, "constructionMode");
            return (Criteria) this;
        }

        public Criteria andConstructionModeLike(String value) {
            addCriterion("construction_mode like", value, "constructionMode");
            return (Criteria) this;
        }

        public Criteria andConstructionModeNotLike(String value) {
            addCriterion("construction_mode not like", value, "constructionMode");
            return (Criteria) this;
        }

        public Criteria andConstructionModeIn(List<String> values) {
            addCriterion("construction_mode in", values, "constructionMode");
            return (Criteria) this;
        }

        public Criteria andConstructionModeNotIn(List<String> values) {
            addCriterion("construction_mode not in", values, "constructionMode");
            return (Criteria) this;
        }

        public Criteria andConstructionModeBetween(String value1, String value2) {
            addCriterion("construction_mode between", value1, value2, "constructionMode");
            return (Criteria) this;
        }

        public Criteria andConstructionModeNotBetween(String value1, String value2) {
            addCriterion("construction_mode not between", value1, value2, "constructionMode");
            return (Criteria) this;
        }

        public Criteria andLevalIsNull() {
            addCriterion("leval is null");
            return (Criteria) this;
        }

        public Criteria andLevalIsNotNull() {
            addCriterion("leval is not null");
            return (Criteria) this;
        }

        public Criteria andLevalEqualTo(String value) {
            addCriterion("leval =", value, "leval");
            return (Criteria) this;
        }

        public Criteria andLevalNotEqualTo(String value) {
            addCriterion("leval <>", value, "leval");
            return (Criteria) this;
        }

        public Criteria andLevalGreaterThan(String value) {
            addCriterion("leval >", value, "leval");
            return (Criteria) this;
        }

        public Criteria andLevalGreaterThanOrEqualTo(String value) {
            addCriterion("leval >=", value, "leval");
            return (Criteria) this;
        }

        public Criteria andLevalLessThan(String value) {
            addCriterion("leval <", value, "leval");
            return (Criteria) this;
        }

        public Criteria andLevalLessThanOrEqualTo(String value) {
            addCriterion("leval <=", value, "leval");
            return (Criteria) this;
        }

        public Criteria andLevalLike(String value) {
            addCriterion("leval like", value, "leval");
            return (Criteria) this;
        }

        public Criteria andLevalNotLike(String value) {
            addCriterion("leval not like", value, "leval");
            return (Criteria) this;
        }

        public Criteria andLevalIn(List<String> values) {
            addCriterion("leval in", values, "leval");
            return (Criteria) this;
        }

        public Criteria andLevalNotIn(List<String> values) {
            addCriterion("leval not in", values, "leval");
            return (Criteria) this;
        }

        public Criteria andLevalBetween(String value1, String value2) {
            addCriterion("leval between", value1, value2, "leval");
            return (Criteria) this;
        }

        public Criteria andLevalNotBetween(String value1, String value2) {
            addCriterion("leval not between", value1, value2, "leval");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountIsNull() {
            addCriterion("investment_amount is null");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountIsNotNull() {
            addCriterion("investment_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountEqualTo(BigDecimal value) {
            addCriterion("investment_amount =", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountNotEqualTo(BigDecimal value) {
            addCriterion("investment_amount <>", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountGreaterThan(BigDecimal value) {
            addCriterion("investment_amount >", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("investment_amount >=", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountLessThan(BigDecimal value) {
            addCriterion("investment_amount <", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("investment_amount <=", value, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountIn(List<BigDecimal> values) {
            addCriterion("investment_amount in", values, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountNotIn(List<BigDecimal> values) {
            addCriterion("investment_amount not in", values, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("investment_amount between", value1, value2, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andInvestmentAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("investment_amount not between", value1, value2, "investmentAmount");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeIsNull() {
            addCriterion("declare_type is null");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeIsNotNull() {
            addCriterion("declare_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeEqualTo(String value) {
            addCriterion("declare_type =", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeNotEqualTo(String value) {
            addCriterion("declare_type <>", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeGreaterThan(String value) {
            addCriterion("declare_type >", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeGreaterThanOrEqualTo(String value) {
            addCriterion("declare_type >=", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeLessThan(String value) {
            addCriterion("declare_type <", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeLessThanOrEqualTo(String value) {
            addCriterion("declare_type <=", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeLike(String value) {
            addCriterion("declare_type like", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeNotLike(String value) {
            addCriterion("declare_type not like", value, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeIn(List<String> values) {
            addCriterion("declare_type in", values, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeNotIn(List<String> values) {
            addCriterion("declare_type not in", values, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeBetween(String value1, String value2) {
            addCriterion("declare_type between", value1, value2, "declareType");
            return (Criteria) this;
        }

        public Criteria andDeclareTypeNotBetween(String value1, String value2) {
            addCriterion("declare_type not between", value1, value2, "declareType");
            return (Criteria) this;
        }

        public Criteria andRange1IsNull() {
            addCriterion("range1 is null");
            return (Criteria) this;
        }

        public Criteria andRange1IsNotNull() {
            addCriterion("range1 is not null");
            return (Criteria) this;
        }

        public Criteria andRange1EqualTo(String value) {
            addCriterion("range1 =", value, "range1");
            return (Criteria) this;
        }

        public Criteria andRange1NotEqualTo(String value) {
            addCriterion("range1 <>", value, "range1");
            return (Criteria) this;
        }

        public Criteria andRange1GreaterThan(String value) {
            addCriterion("range1 >", value, "range1");
            return (Criteria) this;
        }

        public Criteria andRange1GreaterThanOrEqualTo(String value) {
            addCriterion("range1 >=", value, "range1");
            return (Criteria) this;
        }

        public Criteria andRange1LessThan(String value) {
            addCriterion("range1 <", value, "range1");
            return (Criteria) this;
        }

        public Criteria andRange1LessThanOrEqualTo(String value) {
            addCriterion("range1 <=", value, "range1");
            return (Criteria) this;
        }

        public Criteria andRange1Like(String value) {
            addCriterion("range1 like", value, "range1");
            return (Criteria) this;
        }

        public Criteria andRange1NotLike(String value) {
            addCriterion("range1 not like", value, "range1");
            return (Criteria) this;
        }

        public Criteria andRange1In(List<String> values) {
            addCriterion("range1 in", values, "range1");
            return (Criteria) this;
        }

        public Criteria andRange1NotIn(List<String> values) {
            addCriterion("range1 not in", values, "range1");
            return (Criteria) this;
        }

        public Criteria andRange1Between(String value1, String value2) {
            addCriterion("range1 between", value1, value2, "range1");
            return (Criteria) this;
        }

        public Criteria andRange1NotBetween(String value1, String value2) {
            addCriterion("range1 not between", value1, value2, "range1");
            return (Criteria) this;
        }

        public Criteria andApplicationAmountIsNull() {
            addCriterion("application_amount is null");
            return (Criteria) this;
        }

        public Criteria andApplicationAmountIsNotNull() {
            addCriterion("application_amount is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationAmountEqualTo(BigDecimal value) {
            addCriterion("application_amount =", value, "applicationAmount");
            return (Criteria) this;
        }

        public Criteria andApplicationAmountNotEqualTo(BigDecimal value) {
            addCriterion("application_amount <>", value, "applicationAmount");
            return (Criteria) this;
        }

        public Criteria andApplicationAmountGreaterThan(BigDecimal value) {
            addCriterion("application_amount >", value, "applicationAmount");
            return (Criteria) this;
        }

        public Criteria andApplicationAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("application_amount >=", value, "applicationAmount");
            return (Criteria) this;
        }

        public Criteria andApplicationAmountLessThan(BigDecimal value) {
            addCriterion("application_amount <", value, "applicationAmount");
            return (Criteria) this;
        }

        public Criteria andApplicationAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("application_amount <=", value, "applicationAmount");
            return (Criteria) this;
        }

        public Criteria andApplicationAmountIn(List<BigDecimal> values) {
            addCriterion("application_amount in", values, "applicationAmount");
            return (Criteria) this;
        }

        public Criteria andApplicationAmountNotIn(List<BigDecimal> values) {
            addCriterion("application_amount not in", values, "applicationAmount");
            return (Criteria) this;
        }

        public Criteria andApplicationAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("application_amount between", value1, value2, "applicationAmount");
            return (Criteria) this;
        }

        public Criteria andApplicationAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("application_amount not between", value1, value2, "applicationAmount");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptIsNull() {
            addCriterion("operating_dept is null");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptIsNotNull() {
            addCriterion("operating_dept is not null");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptEqualTo(String value) {
            addCriterion("operating_dept =", value, "operatingDept");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptNotEqualTo(String value) {
            addCriterion("operating_dept <>", value, "operatingDept");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptGreaterThan(String value) {
            addCriterion("operating_dept >", value, "operatingDept");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptGreaterThanOrEqualTo(String value) {
            addCriterion("operating_dept >=", value, "operatingDept");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptLessThan(String value) {
            addCriterion("operating_dept <", value, "operatingDept");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptLessThanOrEqualTo(String value) {
            addCriterion("operating_dept <=", value, "operatingDept");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptLike(String value) {
            addCriterion("operating_dept like", value, "operatingDept");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptNotLike(String value) {
            addCriterion("operating_dept not like", value, "operatingDept");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptIn(List<String> values) {
            addCriterion("operating_dept in", values, "operatingDept");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptNotIn(List<String> values) {
            addCriterion("operating_dept not in", values, "operatingDept");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptBetween(String value1, String value2) {
            addCriterion("operating_dept between", value1, value2, "operatingDept");
            return (Criteria) this;
        }

        public Criteria andOperatingDeptNotBetween(String value1, String value2) {
            addCriterion("operating_dept not between", value1, value2, "operatingDept");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerIsNull() {
            addCriterion("business_owner is null");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerIsNotNull() {
            addCriterion("business_owner is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerEqualTo(String value) {
            addCriterion("business_owner =", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerNotEqualTo(String value) {
            addCriterion("business_owner <>", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerGreaterThan(String value) {
            addCriterion("business_owner >", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("business_owner >=", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerLessThan(String value) {
            addCriterion("business_owner <", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerLessThanOrEqualTo(String value) {
            addCriterion("business_owner <=", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerLike(String value) {
            addCriterion("business_owner like", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerNotLike(String value) {
            addCriterion("business_owner not like", value, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerIn(List<String> values) {
            addCriterion("business_owner in", values, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerNotIn(List<String> values) {
            addCriterion("business_owner not in", values, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerBetween(String value1, String value2) {
            addCriterion("business_owner between", value1, value2, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessOwnerNotBetween(String value1, String value2) {
            addCriterion("business_owner not between", value1, value2, "businessOwner");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneIsNull() {
            addCriterion("business_phone is null");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneIsNotNull() {
            addCriterion("business_phone is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneEqualTo(String value) {
            addCriterion("business_phone =", value, "businessPhone");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneNotEqualTo(String value) {
            addCriterion("business_phone <>", value, "businessPhone");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneGreaterThan(String value) {
            addCriterion("business_phone >", value, "businessPhone");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("business_phone >=", value, "businessPhone");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneLessThan(String value) {
            addCriterion("business_phone <", value, "businessPhone");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneLessThanOrEqualTo(String value) {
            addCriterion("business_phone <=", value, "businessPhone");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneLike(String value) {
            addCriterion("business_phone like", value, "businessPhone");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneNotLike(String value) {
            addCriterion("business_phone not like", value, "businessPhone");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneIn(List<String> values) {
            addCriterion("business_phone in", values, "businessPhone");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneNotIn(List<String> values) {
            addCriterion("business_phone not in", values, "businessPhone");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneBetween(String value1, String value2) {
            addCriterion("business_phone between", value1, value2, "businessPhone");
            return (Criteria) this;
        }

        public Criteria andBusinessPhoneNotBetween(String value1, String value2) {
            addCriterion("business_phone not between", value1, value2, "businessPhone");
            return (Criteria) this;
        }

        public Criteria andContractorIsNull() {
            addCriterion("contractor is null");
            return (Criteria) this;
        }

        public Criteria andContractorIsNotNull() {
            addCriterion("contractor is not null");
            return (Criteria) this;
        }

        public Criteria andContractorEqualTo(String value) {
            addCriterion("contractor =", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotEqualTo(String value) {
            addCriterion("contractor <>", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorGreaterThan(String value) {
            addCriterion("contractor >", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorGreaterThanOrEqualTo(String value) {
            addCriterion("contractor >=", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorLessThan(String value) {
            addCriterion("contractor <", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorLessThanOrEqualTo(String value) {
            addCriterion("contractor <=", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorLike(String value) {
            addCriterion("contractor like", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotLike(String value) {
            addCriterion("contractor not like", value, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorIn(List<String> values) {
            addCriterion("contractor in", values, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotIn(List<String> values) {
            addCriterion("contractor not in", values, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorBetween(String value1, String value2) {
            addCriterion("contractor between", value1, value2, "contractor");
            return (Criteria) this;
        }

        public Criteria andContractorNotBetween(String value1, String value2) {
            addCriterion("contractor not between", value1, value2, "contractor");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIsNull() {
            addCriterion("project_manager is null");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIsNotNull() {
            addCriterion("project_manager is not null");
            return (Criteria) this;
        }

        public Criteria andProjectManagerEqualTo(String value) {
            addCriterion("project_manager =", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotEqualTo(String value) {
            addCriterion("project_manager <>", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerGreaterThan(String value) {
            addCriterion("project_manager >", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerGreaterThanOrEqualTo(String value) {
            addCriterion("project_manager >=", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerLessThan(String value) {
            addCriterion("project_manager <", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerLessThanOrEqualTo(String value) {
            addCriterion("project_manager <=", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerLike(String value) {
            addCriterion("project_manager like", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotLike(String value) {
            addCriterion("project_manager not like", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIn(List<String> values) {
            addCriterion("project_manager in", values, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotIn(List<String> values) {
            addCriterion("project_manager not in", values, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerBetween(String value1, String value2) {
            addCriterion("project_manager between", value1, value2, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotBetween(String value1, String value2) {
            addCriterion("project_manager not between", value1, value2, "projectManager");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneIsNull() {
            addCriterion("manager_phone is null");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneIsNotNull() {
            addCriterion("manager_phone is not null");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneEqualTo(String value) {
            addCriterion("manager_phone =", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneNotEqualTo(String value) {
            addCriterion("manager_phone <>", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneGreaterThan(String value) {
            addCriterion("manager_phone >", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("manager_phone >=", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneLessThan(String value) {
            addCriterion("manager_phone <", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneLessThanOrEqualTo(String value) {
            addCriterion("manager_phone <=", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneLike(String value) {
            addCriterion("manager_phone like", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneNotLike(String value) {
            addCriterion("manager_phone not like", value, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneIn(List<String> values) {
            addCriterion("manager_phone in", values, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneNotIn(List<String> values) {
            addCriterion("manager_phone not in", values, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneBetween(String value1, String value2) {
            addCriterion("manager_phone between", value1, value2, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andManagerPhoneNotBetween(String value1, String value2) {
            addCriterion("manager_phone not between", value1, value2, "managerPhone");
            return (Criteria) this;
        }

        public Criteria andProjectDescIsNull() {
            addCriterion("project_desc is null");
            return (Criteria) this;
        }

        public Criteria andProjectDescIsNotNull() {
            addCriterion("project_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProjectDescEqualTo(String value) {
            addCriterion("project_desc =", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescNotEqualTo(String value) {
            addCriterion("project_desc <>", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescGreaterThan(String value) {
            addCriterion("project_desc >", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescGreaterThanOrEqualTo(String value) {
            addCriterion("project_desc >=", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescLessThan(String value) {
            addCriterion("project_desc <", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescLessThanOrEqualTo(String value) {
            addCriterion("project_desc <=", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescLike(String value) {
            addCriterion("project_desc like", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescNotLike(String value) {
            addCriterion("project_desc not like", value, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescIn(List<String> values) {
            addCriterion("project_desc in", values, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescNotIn(List<String> values) {
            addCriterion("project_desc not in", values, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescBetween(String value1, String value2) {
            addCriterion("project_desc between", value1, value2, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andProjectDescNotBetween(String value1, String value2) {
            addCriterion("project_desc not between", value1, value2, "projectDesc");
            return (Criteria) this;
        }

        public Criteria andKickoffDateIsNull() {
            addCriterion("kickoff_date is null");
            return (Criteria) this;
        }

        public Criteria andKickoffDateIsNotNull() {
            addCriterion("kickoff_date is not null");
            return (Criteria) this;
        }

        public Criteria andKickoffDateEqualTo(Date value) {
            addCriterionForJDBCDate("kickoff_date =", value, "kickoffDate");
            return (Criteria) this;
        }

        public Criteria andKickoffDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("kickoff_date <>", value, "kickoffDate");
            return (Criteria) this;
        }

        public Criteria andKickoffDateGreaterThan(Date value) {
            addCriterionForJDBCDate("kickoff_date >", value, "kickoffDate");
            return (Criteria) this;
        }

        public Criteria andKickoffDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("kickoff_date >=", value, "kickoffDate");
            return (Criteria) this;
        }

        public Criteria andKickoffDateLessThan(Date value) {
            addCriterionForJDBCDate("kickoff_date <", value, "kickoffDate");
            return (Criteria) this;
        }

        public Criteria andKickoffDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("kickoff_date <=", value, "kickoffDate");
            return (Criteria) this;
        }

        public Criteria andKickoffDateIn(List<Date> values) {
            addCriterionForJDBCDate("kickoff_date in", values, "kickoffDate");
            return (Criteria) this;
        }

        public Criteria andKickoffDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("kickoff_date not in", values, "kickoffDate");
            return (Criteria) this;
        }

        public Criteria andKickoffDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("kickoff_date between", value1, value2, "kickoffDate");
            return (Criteria) this;
        }

        public Criteria andKickoffDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("kickoff_date not between", value1, value2, "kickoffDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateIsNull() {
            addCriterion("completion_date is null");
            return (Criteria) this;
        }

        public Criteria andCompletionDateIsNotNull() {
            addCriterion("completion_date is not null");
            return (Criteria) this;
        }

        public Criteria andCompletionDateEqualTo(Date value) {
            addCriterionForJDBCDate("completion_date =", value, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("completion_date <>", value, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateGreaterThan(Date value) {
            addCriterionForJDBCDate("completion_date >", value, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("completion_date >=", value, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateLessThan(Date value) {
            addCriterionForJDBCDate("completion_date <", value, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("completion_date <=", value, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateIn(List<Date> values) {
            addCriterionForJDBCDate("completion_date in", values, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("completion_date not in", values, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("completion_date between", value1, value2, "completionDate");
            return (Criteria) this;
        }

        public Criteria andCompletionDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("completion_date not between", value1, value2, "completionDate");
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

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(String value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(String value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(String value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(String value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(String value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(String value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLike(String value) {
            addCriterion("enable like", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotLike(String value) {
            addCriterion("enable not like", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<String> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<String> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(String value1, String value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(String value1, String value2) {
            addCriterion("enable not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNull() {
            addCriterion("file_url is null");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNotNull() {
            addCriterion("file_url is not null");
            return (Criteria) this;
        }

        public Criteria andFileUrlEqualTo(String value) {
            addCriterion("file_url =", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotEqualTo(String value) {
            addCriterion("file_url <>", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThan(String value) {
            addCriterion("file_url >", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("file_url >=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThan(String value) {
            addCriterion("file_url <", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThanOrEqualTo(String value) {
            addCriterion("file_url <=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLike(String value) {
            addCriterion("file_url like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotLike(String value) {
            addCriterion("file_url not like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlIn(List<String> values) {
            addCriterion("file_url in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotIn(List<String> values) {
            addCriterion("file_url not in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlBetween(String value1, String value2) {
            addCriterion("file_url between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotBetween(String value1, String value2) {
            addCriterion("file_url not between", value1, value2, "fileUrl");
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

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(String value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(String value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(String value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(String value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLike(String value) {
            addCriterion("is_delete like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(String value) {
            addCriterion("is_delete not like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<String> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<String> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(String value1, String value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(String value1, String value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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