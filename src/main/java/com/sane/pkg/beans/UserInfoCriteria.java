package com.sane.pkg.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public UserInfoCriteria() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneIsNull() {
            addCriterion("email_phone is null");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneIsNotNull() {
            addCriterion("email_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneEqualTo(String value) {
            addCriterion("email_phone =", value, "emailPhone");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneNotEqualTo(String value) {
            addCriterion("email_phone <>", value, "emailPhone");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneGreaterThan(String value) {
            addCriterion("email_phone >", value, "emailPhone");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("email_phone >=", value, "emailPhone");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneLessThan(String value) {
            addCriterion("email_phone <", value, "emailPhone");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneLessThanOrEqualTo(String value) {
            addCriterion("email_phone <=", value, "emailPhone");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneLike(String value) {
            addCriterion("email_phone like", value, "emailPhone");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneNotLike(String value) {
            addCriterion("email_phone not like", value, "emailPhone");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneIn(List<String> values) {
            addCriterion("email_phone in", values, "emailPhone");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneNotIn(List<String> values) {
            addCriterion("email_phone not in", values, "emailPhone");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneBetween(String value1, String value2) {
            addCriterion("email_phone between", value1, value2, "emailPhone");
            return (Criteria) this;
        }

        public Criteria andEmailPhoneNotBetween(String value1, String value2) {
            addCriterion("email_phone not between", value1, value2, "emailPhone");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeIsNull() {
            addCriterion("verificationCode is null");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeIsNotNull() {
            addCriterion("verificationCode is not null");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeEqualTo(String value) {
            addCriterion("verificationCode =", value, "verificationcode");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeNotEqualTo(String value) {
            addCriterion("verificationCode <>", value, "verificationcode");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeGreaterThan(String value) {
            addCriterion("verificationCode >", value, "verificationcode");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeGreaterThanOrEqualTo(String value) {
            addCriterion("verificationCode >=", value, "verificationcode");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeLessThan(String value) {
            addCriterion("verificationCode <", value, "verificationcode");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeLessThanOrEqualTo(String value) {
            addCriterion("verificationCode <=", value, "verificationcode");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeLike(String value) {
            addCriterion("verificationCode like", value, "verificationcode");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeNotLike(String value) {
            addCriterion("verificationCode not like", value, "verificationcode");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeIn(List<String> values) {
            addCriterion("verificationCode in", values, "verificationcode");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeNotIn(List<String> values) {
            addCriterion("verificationCode not in", values, "verificationcode");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeBetween(String value1, String value2) {
            addCriterion("verificationCode between", value1, value2, "verificationcode");
            return (Criteria) this;
        }

        public Criteria andVerificationcodeNotBetween(String value1, String value2) {
            addCriterion("verificationCode not between", value1, value2, "verificationcode");
            return (Criteria) this;
        }

        public Criteria andStatuscodeIsNull() {
            addCriterion("statusCode is null");
            return (Criteria) this;
        }

        public Criteria andStatuscodeIsNotNull() {
            addCriterion("statusCode is not null");
            return (Criteria) this;
        }

        public Criteria andStatuscodeEqualTo(Integer value) {
            addCriterion("statusCode =", value, "statuscode");
            return (Criteria) this;
        }

        public Criteria andStatuscodeNotEqualTo(Integer value) {
            addCriterion("statusCode <>", value, "statuscode");
            return (Criteria) this;
        }

        public Criteria andStatuscodeGreaterThan(Integer value) {
            addCriterion("statusCode >", value, "statuscode");
            return (Criteria) this;
        }

        public Criteria andStatuscodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("statusCode >=", value, "statuscode");
            return (Criteria) this;
        }

        public Criteria andStatuscodeLessThan(Integer value) {
            addCriterion("statusCode <", value, "statuscode");
            return (Criteria) this;
        }

        public Criteria andStatuscodeLessThanOrEqualTo(Integer value) {
            addCriterion("statusCode <=", value, "statuscode");
            return (Criteria) this;
        }

        public Criteria andStatuscodeIn(List<Integer> values) {
            addCriterion("statusCode in", values, "statuscode");
            return (Criteria) this;
        }

        public Criteria andStatuscodeNotIn(List<Integer> values) {
            addCriterion("statusCode not in", values, "statuscode");
            return (Criteria) this;
        }

        public Criteria andStatuscodeBetween(Integer value1, Integer value2) {
            addCriterion("statusCode between", value1, value2, "statuscode");
            return (Criteria) this;
        }

        public Criteria andStatuscodeNotBetween(Integer value1, Integer value2) {
            addCriterion("statusCode not between", value1, value2, "statuscode");
            return (Criteria) this;
        }

        public Criteria andVerificationlimitdateIsNull() {
            addCriterion("verificationLimitDate is null");
            return (Criteria) this;
        }

        public Criteria andVerificationlimitdateIsNotNull() {
            addCriterion("verificationLimitDate is not null");
            return (Criteria) this;
        }

        public Criteria andVerificationlimitdateEqualTo(Date value) {
            addCriterion("verificationLimitDate =", value, "verificationlimitdate");
            return (Criteria) this;
        }

        public Criteria andVerificationlimitdateNotEqualTo(Date value) {
            addCriterion("verificationLimitDate <>", value, "verificationlimitdate");
            return (Criteria) this;
        }

        public Criteria andVerificationlimitdateGreaterThan(Date value) {
            addCriterion("verificationLimitDate >", value, "verificationlimitdate");
            return (Criteria) this;
        }

        public Criteria andVerificationlimitdateGreaterThanOrEqualTo(Date value) {
            addCriterion("verificationLimitDate >=", value, "verificationlimitdate");
            return (Criteria) this;
        }

        public Criteria andVerificationlimitdateLessThan(Date value) {
            addCriterion("verificationLimitDate <", value, "verificationlimitdate");
            return (Criteria) this;
        }

        public Criteria andVerificationlimitdateLessThanOrEqualTo(Date value) {
            addCriterion("verificationLimitDate <=", value, "verificationlimitdate");
            return (Criteria) this;
        }

        public Criteria andVerificationlimitdateIn(List<Date> values) {
            addCriterion("verificationLimitDate in", values, "verificationlimitdate");
            return (Criteria) this;
        }

        public Criteria andVerificationlimitdateNotIn(List<Date> values) {
            addCriterion("verificationLimitDate not in", values, "verificationlimitdate");
            return (Criteria) this;
        }

        public Criteria andVerificationlimitdateBetween(Date value1, Date value2) {
            addCriterion("verificationLimitDate between", value1, value2, "verificationlimitdate");
            return (Criteria) this;
        }

        public Criteria andVerificationlimitdateNotBetween(Date value1, Date value2) {
            addCriterion("verificationLimitDate not between", value1, value2, "verificationlimitdate");
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