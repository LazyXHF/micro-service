package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TXietongAgendaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    //分页组件 start
    /*protected int offset;
    protected int limit;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    } //分页组件结束 end*/

    public TXietongAgendaExample() {
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

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectIsNull() {
            addCriterion("meeting_subject is null");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectIsNotNull() {
            addCriterion("meeting_subject is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectEqualTo(String value) {
            addCriterion("meeting_subject =", value, "meetingSubject");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectNotEqualTo(String value) {
            addCriterion("meeting_subject <>", value, "meetingSubject");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectGreaterThan(String value) {
            addCriterion("meeting_subject >", value, "meetingSubject");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_subject >=", value, "meetingSubject");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectLessThan(String value) {
            addCriterion("meeting_subject <", value, "meetingSubject");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectLessThanOrEqualTo(String value) {
            addCriterion("meeting_subject <=", value, "meetingSubject");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectLike(String value) {
            addCriterion("meeting_subject like", value, "meetingSubject");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectNotLike(String value) {
            addCriterion("meeting_subject not like", value, "meetingSubject");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectIn(List<String> values) {
            addCriterion("meeting_subject in", values, "meetingSubject");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectNotIn(List<String> values) {
            addCriterion("meeting_subject not in", values, "meetingSubject");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectBetween(String value1, String value2) {
            addCriterion("meeting_subject between", value1, value2, "meetingSubject");
            return (Criteria) this;
        }

        public Criteria andMeetingSubjectNotBetween(String value1, String value2) {
            addCriterion("meeting_subject not between", value1, value2, "meetingSubject");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceIsNull() {
            addCriterion("meeting_place is null");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceIsNotNull() {
            addCriterion("meeting_place is not null");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceEqualTo(String value) {
            addCriterion("meeting_place =", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceNotEqualTo(String value) {
            addCriterion("meeting_place <>", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceGreaterThan(String value) {
            addCriterion("meeting_place >", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("meeting_place >=", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceLessThan(String value) {
            addCriterion("meeting_place <", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceLessThanOrEqualTo(String value) {
            addCriterion("meeting_place <=", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceLike(String value) {
            addCriterion("meeting_place like", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceNotLike(String value) {
            addCriterion("meeting_place not like", value, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceIn(List<String> values) {
            addCriterion("meeting_place in", values, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceNotIn(List<String> values) {
            addCriterion("meeting_place not in", values, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceBetween(String value1, String value2) {
            addCriterion("meeting_place between", value1, value2, "meetingPlace");
            return (Criteria) this;
        }

        public Criteria andMeetingPlaceNotBetween(String value1, String value2) {
            addCriterion("meeting_place not between", value1, value2, "meetingPlace");
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

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Integer value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Integer value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Integer value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Integer value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Integer> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Integer> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andAmPmIsNull() {
            addCriterion("am_pm is null");
            return (Criteria) this;
        }

        public Criteria andAmPmIsNotNull() {
            addCriterion("am_pm is not null");
            return (Criteria) this;
        }

        public Criteria andAmPmEqualTo(Integer value) {
            addCriterion("am_pm =", value, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmNotEqualTo(Integer value) {
            addCriterion("am_pm <>", value, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmGreaterThan(Integer value) {
            addCriterion("am_pm >", value, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmGreaterThanOrEqualTo(Integer value) {
            addCriterion("am_pm >=", value, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmLessThan(Integer value) {
            addCriterion("am_pm <", value, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmLessThanOrEqualTo(Integer value) {
            addCriterion("am_pm <=", value, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmIn(List<Integer> values) {
            addCriterion("am_pm in", values, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmNotIn(List<Integer> values) {
            addCriterion("am_pm not in", values, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmBetween(Integer value1, Integer value2) {
            addCriterion("am_pm between", value1, value2, "amPm");
            return (Criteria) this;
        }

        public Criteria andAmPmNotBetween(Integer value1, Integer value2) {
            addCriterion("am_pm not between", value1, value2, "amPm");
            return (Criteria) this;
        }

        public Criteria andIspublishIsNull() {
            addCriterion("ispublish is null");
            return (Criteria) this;
        }

        public Criteria andIspublishIsNotNull() {
            addCriterion("ispublish is not null");
            return (Criteria) this;
        }

        public Criteria andIspublishEqualTo(Integer value) {
            addCriterion("ispublish =", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishNotEqualTo(Integer value) {
            addCriterion("ispublish <>", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishGreaterThan(Integer value) {
            addCriterion("ispublish >", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishGreaterThanOrEqualTo(Integer value) {
            addCriterion("ispublish >=", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishLessThan(Integer value) {
            addCriterion("ispublish <", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishLessThanOrEqualTo(Integer value) {
            addCriterion("ispublish <=", value, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishIn(List<Integer> values) {
            addCriterion("ispublish in", values, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishNotIn(List<Integer> values) {
            addCriterion("ispublish not in", values, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishBetween(Integer value1, Integer value2) {
            addCriterion("ispublish between", value1, value2, "ispublish");
            return (Criteria) this;
        }

        public Criteria andIspublishNotBetween(Integer value1, Integer value2) {
            addCriterion("ispublish not between", value1, value2, "ispublish");
            return (Criteria) this;
        }

        public Criteria andCreateridIsNull() {
            addCriterion("createrid is null");
            return (Criteria) this;
        }

        public Criteria andCreateridIsNotNull() {
            addCriterion("createrid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateridEqualTo(String value) {
            addCriterion("createrid =", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridNotEqualTo(String value) {
            addCriterion("createrid <>", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridGreaterThan(String value) {
            addCriterion("createrid >", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridGreaterThanOrEqualTo(String value) {
            addCriterion("createrid >=", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridLessThan(String value) {
            addCriterion("createrid <", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridLessThanOrEqualTo(String value) {
            addCriterion("createrid <=", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridLike(String value) {
            addCriterion("createrid like", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridNotLike(String value) {
            addCriterion("createrid not like", value, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridIn(List<String> values) {
            addCriterion("createrid in", values, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridNotIn(List<String> values) {
            addCriterion("createrid not in", values, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridBetween(String value1, String value2) {
            addCriterion("createrid between", value1, value2, "createrid");
            return (Criteria) this;
        }

        public Criteria andCreateridNotBetween(String value1, String value2) {
            addCriterion("createrid not between", value1, value2, "createrid");
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