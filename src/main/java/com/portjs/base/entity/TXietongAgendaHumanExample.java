package com.portjs.base.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TXietongAgendaHumanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TXietongAgendaHumanExample() {
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

        public Criteria andParticipantIdIsNull() {
            addCriterion("participant_id is null");
            return (Criteria) this;
        }

        public Criteria andParticipantIdIsNotNull() {
            addCriterion("participant_id is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantIdEqualTo(String value) {
            addCriterion("participant_id =", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdNotEqualTo(String value) {
            addCriterion("participant_id <>", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdGreaterThan(String value) {
            addCriterion("participant_id >", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdGreaterThanOrEqualTo(String value) {
            addCriterion("participant_id >=", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdLessThan(String value) {
            addCriterion("participant_id <", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdLessThanOrEqualTo(String value) {
            addCriterion("participant_id <=", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdLike(String value) {
            addCriterion("participant_id like", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdNotLike(String value) {
            addCriterion("participant_id not like", value, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdIn(List<String> values) {
            addCriterion("participant_id in", values, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdNotIn(List<String> values) {
            addCriterion("participant_id not in", values, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdBetween(String value1, String value2) {
            addCriterion("participant_id between", value1, value2, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantIdNotBetween(String value1, String value2) {
            addCriterion("participant_id not between", value1, value2, "participantId");
            return (Criteria) this;
        }

        public Criteria andParticipantValueIsNull() {
            addCriterion("participant_value is null");
            return (Criteria) this;
        }

        public Criteria andParticipantValueIsNotNull() {
            addCriterion("participant_value is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantValueEqualTo(String value) {
            addCriterion("participant_value =", value, "participantValue");
            return (Criteria) this;
        }

        public Criteria andParticipantValueNotEqualTo(String value) {
            addCriterion("participant_value <>", value, "participantValue");
            return (Criteria) this;
        }

        public Criteria andParticipantValueGreaterThan(String value) {
            addCriterion("participant_value >", value, "participantValue");
            return (Criteria) this;
        }

        public Criteria andParticipantValueGreaterThanOrEqualTo(String value) {
            addCriterion("participant_value >=", value, "participantValue");
            return (Criteria) this;
        }

        public Criteria andParticipantValueLessThan(String value) {
            addCriterion("participant_value <", value, "participantValue");
            return (Criteria) this;
        }

        public Criteria andParticipantValueLessThanOrEqualTo(String value) {
            addCriterion("participant_value <=", value, "participantValue");
            return (Criteria) this;
        }

        public Criteria andParticipantValueLike(String value) {
            addCriterion("participant_value like", value, "participantValue");
            return (Criteria) this;
        }

        public Criteria andParticipantValueNotLike(String value) {
            addCriterion("participant_value not like", value, "participantValue");
            return (Criteria) this;
        }

        public Criteria andParticipantValueIn(List<String> values) {
            addCriterion("participant_value in", values, "participantValue");
            return (Criteria) this;
        }

        public Criteria andParticipantValueNotIn(List<String> values) {
            addCriterion("participant_value not in", values, "participantValue");
            return (Criteria) this;
        }

        public Criteria andParticipantValueBetween(String value1, String value2) {
            addCriterion("participant_value between", value1, value2, "participantValue");
            return (Criteria) this;
        }

        public Criteria andParticipantValueNotBetween(String value1, String value2) {
            addCriterion("participant_value not between", value1, value2, "participantValue");
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

        public Criteria andAgendaIdIsNull() {
            addCriterion("agenda_id is null");
            return (Criteria) this;
        }

        public Criteria andAgendaIdIsNotNull() {
            addCriterion("agenda_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgendaIdEqualTo(String value) {
            addCriterion("agenda_id =", value, "agendaId");
            return (Criteria) this;
        }

        public Criteria andAgendaIdNotEqualTo(String value) {
            addCriterion("agenda_id <>", value, "agendaId");
            return (Criteria) this;
        }

        public Criteria andAgendaIdGreaterThan(String value) {
            addCriterion("agenda_id >", value, "agendaId");
            return (Criteria) this;
        }

        public Criteria andAgendaIdGreaterThanOrEqualTo(String value) {
            addCriterion("agenda_id >=", value, "agendaId");
            return (Criteria) this;
        }

        public Criteria andAgendaIdLessThan(String value) {
            addCriterion("agenda_id <", value, "agendaId");
            return (Criteria) this;
        }

        public Criteria andAgendaIdLessThanOrEqualTo(String value) {
            addCriterion("agenda_id <=", value, "agendaId");
            return (Criteria) this;
        }

        public Criteria andAgendaIdLike(String value) {
            addCriterion("agenda_id like", value, "agendaId");
            return (Criteria) this;
        }

        public Criteria andAgendaIdNotLike(String value) {
            addCriterion("agenda_id not like", value, "agendaId");
            return (Criteria) this;
        }

        public Criteria andAgendaIdIn(List<String> values) {
            addCriterion("agenda_id in", values, "agendaId");
            return (Criteria) this;
        }

        public Criteria andAgendaIdNotIn(List<String> values) {
            addCriterion("agenda_id not in", values, "agendaId");
            return (Criteria) this;
        }

        public Criteria andAgendaIdBetween(String value1, String value2) {
            addCriterion("agenda_id between", value1, value2, "agendaId");
            return (Criteria) this;
        }

        public Criteria andAgendaIdNotBetween(String value1, String value2) {
            addCriterion("agenda_id not between", value1, value2, "agendaId");
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