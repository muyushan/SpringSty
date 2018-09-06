package com.sane.pkg.beans;

import java.util.ArrayList;
import java.util.List;

public class SeedTableCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public SeedTableCriteria() {
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

        public Criteria andSeedMoudleIsNull() {
            addCriterion("SeedMoudle is null");
            return (Criteria) this;
        }

        public Criteria andSeedMoudleIsNotNull() {
            addCriterion("SeedMoudle is not null");
            return (Criteria) this;
        }

        public Criteria andSeedMoudleEqualTo(String value) {
            addCriterion("SeedMoudle =", value, "seedMoudle");
            return (Criteria) this;
        }

        public Criteria andSeedMoudleNotEqualTo(String value) {
            addCriterion("SeedMoudle <>", value, "seedMoudle");
            return (Criteria) this;
        }

        public Criteria andSeedMoudleGreaterThan(String value) {
            addCriterion("SeedMoudle >", value, "seedMoudle");
            return (Criteria) this;
        }

        public Criteria andSeedMoudleGreaterThanOrEqualTo(String value) {
            addCriterion("SeedMoudle >=", value, "seedMoudle");
            return (Criteria) this;
        }

        public Criteria andSeedMoudleLessThan(String value) {
            addCriterion("SeedMoudle <", value, "seedMoudle");
            return (Criteria) this;
        }

        public Criteria andSeedMoudleLessThanOrEqualTo(String value) {
            addCriterion("SeedMoudle <=", value, "seedMoudle");
            return (Criteria) this;
        }

        public Criteria andSeedMoudleLike(String value) {
            addCriterion("SeedMoudle like", value, "seedMoudle");
            return (Criteria) this;
        }

        public Criteria andSeedMoudleNotLike(String value) {
            addCriterion("SeedMoudle not like", value, "seedMoudle");
            return (Criteria) this;
        }

        public Criteria andSeedMoudleIn(List<String> values) {
            addCriterion("SeedMoudle in", values, "seedMoudle");
            return (Criteria) this;
        }

        public Criteria andSeedMoudleNotIn(List<String> values) {
            addCriterion("SeedMoudle not in", values, "seedMoudle");
            return (Criteria) this;
        }

        public Criteria andSeedMoudleBetween(String value1, String value2) {
            addCriterion("SeedMoudle between", value1, value2, "seedMoudle");
            return (Criteria) this;
        }

        public Criteria andSeedMoudleNotBetween(String value1, String value2) {
            addCriterion("SeedMoudle not between", value1, value2, "seedMoudle");
            return (Criteria) this;
        }

        public Criteria andSeedValueIsNull() {
            addCriterion("SeedValue is null");
            return (Criteria) this;
        }

        public Criteria andSeedValueIsNotNull() {
            addCriterion("SeedValue is not null");
            return (Criteria) this;
        }

        public Criteria andSeedValueEqualTo(Long value) {
            addCriterion("SeedValue =", value, "seedValue");
            return (Criteria) this;
        }

        public Criteria andSeedValueNotEqualTo(Long value) {
            addCriterion("SeedValue <>", value, "seedValue");
            return (Criteria) this;
        }

        public Criteria andSeedValueGreaterThan(Long value) {
            addCriterion("SeedValue >", value, "seedValue");
            return (Criteria) this;
        }

        public Criteria andSeedValueGreaterThanOrEqualTo(Long value) {
            addCriterion("SeedValue >=", value, "seedValue");
            return (Criteria) this;
        }

        public Criteria andSeedValueLessThan(Long value) {
            addCriterion("SeedValue <", value, "seedValue");
            return (Criteria) this;
        }

        public Criteria andSeedValueLessThanOrEqualTo(Long value) {
            addCriterion("SeedValue <=", value, "seedValue");
            return (Criteria) this;
        }

        public Criteria andSeedValueIn(List<Long> values) {
            addCriterion("SeedValue in", values, "seedValue");
            return (Criteria) this;
        }

        public Criteria andSeedValueNotIn(List<Long> values) {
            addCriterion("SeedValue not in", values, "seedValue");
            return (Criteria) this;
        }

        public Criteria andSeedValueBetween(Long value1, Long value2) {
            addCriterion("SeedValue between", value1, value2, "seedValue");
            return (Criteria) this;
        }

        public Criteria andSeedValueNotBetween(Long value1, Long value2) {
            addCriterion("SeedValue not between", value1, value2, "seedValue");
            return (Criteria) this;
        }

        public Criteria andSeedLetterIsNull() {
            addCriterion("SeedLetter is null");
            return (Criteria) this;
        }

        public Criteria andSeedLetterIsNotNull() {
            addCriterion("SeedLetter is not null");
            return (Criteria) this;
        }

        public Criteria andSeedLetterEqualTo(String value) {
            addCriterion("SeedLetter =", value, "seedLetter");
            return (Criteria) this;
        }

        public Criteria andSeedLetterNotEqualTo(String value) {
            addCriterion("SeedLetter <>", value, "seedLetter");
            return (Criteria) this;
        }

        public Criteria andSeedLetterGreaterThan(String value) {
            addCriterion("SeedLetter >", value, "seedLetter");
            return (Criteria) this;
        }

        public Criteria andSeedLetterGreaterThanOrEqualTo(String value) {
            addCriterion("SeedLetter >=", value, "seedLetter");
            return (Criteria) this;
        }

        public Criteria andSeedLetterLessThan(String value) {
            addCriterion("SeedLetter <", value, "seedLetter");
            return (Criteria) this;
        }

        public Criteria andSeedLetterLessThanOrEqualTo(String value) {
            addCriterion("SeedLetter <=", value, "seedLetter");
            return (Criteria) this;
        }

        public Criteria andSeedLetterLike(String value) {
            addCriterion("SeedLetter like", value, "seedLetter");
            return (Criteria) this;
        }

        public Criteria andSeedLetterNotLike(String value) {
            addCriterion("SeedLetter not like", value, "seedLetter");
            return (Criteria) this;
        }

        public Criteria andSeedLetterIn(List<String> values) {
            addCriterion("SeedLetter in", values, "seedLetter");
            return (Criteria) this;
        }

        public Criteria andSeedLetterNotIn(List<String> values) {
            addCriterion("SeedLetter not in", values, "seedLetter");
            return (Criteria) this;
        }

        public Criteria andSeedLetterBetween(String value1, String value2) {
            addCriterion("SeedLetter between", value1, value2, "seedLetter");
            return (Criteria) this;
        }

        public Criteria andSeedLetterNotBetween(String value1, String value2) {
            addCriterion("SeedLetter not between", value1, value2, "seedLetter");
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