package com.sane.pkg.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseListItemCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BaseListItemCriteria() {
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

        public Criteria andListIDIsNull() {
            addCriterion("ListID is null");
            return (Criteria) this;
        }

        public Criteria andListIDIsNotNull() {
            addCriterion("ListID is not null");
            return (Criteria) this;
        }

        public Criteria andListIDEqualTo(Integer value) {
            addCriterion("ListID =", value, "listID");
            return (Criteria) this;
        }

        public Criteria andListIDNotEqualTo(Integer value) {
            addCriterion("ListID <>", value, "listID");
            return (Criteria) this;
        }

        public Criteria andListIDGreaterThan(Integer value) {
            addCriterion("ListID >", value, "listID");
            return (Criteria) this;
        }

        public Criteria andListIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ListID >=", value, "listID");
            return (Criteria) this;
        }

        public Criteria andListIDLessThan(Integer value) {
            addCriterion("ListID <", value, "listID");
            return (Criteria) this;
        }

        public Criteria andListIDLessThanOrEqualTo(Integer value) {
            addCriterion("ListID <=", value, "listID");
            return (Criteria) this;
        }

        public Criteria andListIDIn(List<Integer> values) {
            addCriterion("ListID in", values, "listID");
            return (Criteria) this;
        }

        public Criteria andListIDNotIn(List<Integer> values) {
            addCriterion("ListID not in", values, "listID");
            return (Criteria) this;
        }

        public Criteria andListIDBetween(Integer value1, Integer value2) {
            addCriterion("ListID between", value1, value2, "listID");
            return (Criteria) this;
        }

        public Criteria andListIDNotBetween(Integer value1, Integer value2) {
            addCriterion("ListID not between", value1, value2, "listID");
            return (Criteria) this;
        }

        public Criteria andTypeIDIsNull() {
            addCriterion("TypeID is null");
            return (Criteria) this;
        }

        public Criteria andTypeIDIsNotNull() {
            addCriterion("TypeID is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIDEqualTo(Short value) {
            addCriterion("TypeID =", value, "typeID");
            return (Criteria) this;
        }

        public Criteria andTypeIDNotEqualTo(Short value) {
            addCriterion("TypeID <>", value, "typeID");
            return (Criteria) this;
        }

        public Criteria andTypeIDGreaterThan(Short value) {
            addCriterion("TypeID >", value, "typeID");
            return (Criteria) this;
        }

        public Criteria andTypeIDGreaterThanOrEqualTo(Short value) {
            addCriterion("TypeID >=", value, "typeID");
            return (Criteria) this;
        }

        public Criteria andTypeIDLessThan(Short value) {
            addCriterion("TypeID <", value, "typeID");
            return (Criteria) this;
        }

        public Criteria andTypeIDLessThanOrEqualTo(Short value) {
            addCriterion("TypeID <=", value, "typeID");
            return (Criteria) this;
        }

        public Criteria andTypeIDIn(List<Short> values) {
            addCriterion("TypeID in", values, "typeID");
            return (Criteria) this;
        }

        public Criteria andTypeIDNotIn(List<Short> values) {
            addCriterion("TypeID not in", values, "typeID");
            return (Criteria) this;
        }

        public Criteria andTypeIDBetween(Short value1, Short value2) {
            addCriterion("TypeID between", value1, value2, "typeID");
            return (Criteria) this;
        }

        public Criteria andTypeIDNotBetween(Short value1, Short value2) {
            addCriterion("TypeID not between", value1, value2, "typeID");
            return (Criteria) this;
        }

        public Criteria andListValueIsNull() {
            addCriterion("ListValue is null");
            return (Criteria) this;
        }

        public Criteria andListValueIsNotNull() {
            addCriterion("ListValue is not null");
            return (Criteria) this;
        }

        public Criteria andListValueEqualTo(String value) {
            addCriterion("ListValue =", value, "listValue");
            return (Criteria) this;
        }

        public Criteria andListValueNotEqualTo(String value) {
            addCriterion("ListValue <>", value, "listValue");
            return (Criteria) this;
        }

        public Criteria andListValueGreaterThan(String value) {
            addCriterion("ListValue >", value, "listValue");
            return (Criteria) this;
        }

        public Criteria andListValueGreaterThanOrEqualTo(String value) {
            addCriterion("ListValue >=", value, "listValue");
            return (Criteria) this;
        }

        public Criteria andListValueLessThan(String value) {
            addCriterion("ListValue <", value, "listValue");
            return (Criteria) this;
        }

        public Criteria andListValueLessThanOrEqualTo(String value) {
            addCriterion("ListValue <=", value, "listValue");
            return (Criteria) this;
        }

        public Criteria andListValueLike(String value) {
            addCriterion("ListValue like", value, "listValue");
            return (Criteria) this;
        }

        public Criteria andListValueNotLike(String value) {
            addCriterion("ListValue not like", value, "listValue");
            return (Criteria) this;
        }

        public Criteria andListValueIn(List<String> values) {
            addCriterion("ListValue in", values, "listValue");
            return (Criteria) this;
        }

        public Criteria andListValueNotIn(List<String> values) {
            addCriterion("ListValue not in", values, "listValue");
            return (Criteria) this;
        }

        public Criteria andListValueBetween(String value1, String value2) {
            addCriterion("ListValue between", value1, value2, "listValue");
            return (Criteria) this;
        }

        public Criteria andListValueNotBetween(String value1, String value2) {
            addCriterion("ListValue not between", value1, value2, "listValue");
            return (Criteria) this;
        }

        public Criteria andListNameIsNull() {
            addCriterion("ListName is null");
            return (Criteria) this;
        }

        public Criteria andListNameIsNotNull() {
            addCriterion("ListName is not null");
            return (Criteria) this;
        }

        public Criteria andListNameEqualTo(String value) {
            addCriterion("ListName =", value, "listName");
            return (Criteria) this;
        }

        public Criteria andListNameNotEqualTo(String value) {
            addCriterion("ListName <>", value, "listName");
            return (Criteria) this;
        }

        public Criteria andListNameGreaterThan(String value) {
            addCriterion("ListName >", value, "listName");
            return (Criteria) this;
        }

        public Criteria andListNameGreaterThanOrEqualTo(String value) {
            addCriterion("ListName >=", value, "listName");
            return (Criteria) this;
        }

        public Criteria andListNameLessThan(String value) {
            addCriterion("ListName <", value, "listName");
            return (Criteria) this;
        }

        public Criteria andListNameLessThanOrEqualTo(String value) {
            addCriterion("ListName <=", value, "listName");
            return (Criteria) this;
        }

        public Criteria andListNameLike(String value) {
            addCriterion("ListName like", value, "listName");
            return (Criteria) this;
        }

        public Criteria andListNameNotLike(String value) {
            addCriterion("ListName not like", value, "listName");
            return (Criteria) this;
        }

        public Criteria andListNameIn(List<String> values) {
            addCriterion("ListName in", values, "listName");
            return (Criteria) this;
        }

        public Criteria andListNameNotIn(List<String> values) {
            addCriterion("ListName not in", values, "listName");
            return (Criteria) this;
        }

        public Criteria andListNameBetween(String value1, String value2) {
            addCriterion("ListName between", value1, value2, "listName");
            return (Criteria) this;
        }

        public Criteria andListNameNotBetween(String value1, String value2) {
            addCriterion("ListName not between", value1, value2, "listName");
            return (Criteria) this;
        }

        public Criteria andListSortIsNull() {
            addCriterion("ListSort is null");
            return (Criteria) this;
        }

        public Criteria andListSortIsNotNull() {
            addCriterion("ListSort is not null");
            return (Criteria) this;
        }

        public Criteria andListSortEqualTo(Short value) {
            addCriterion("ListSort =", value, "listSort");
            return (Criteria) this;
        }

        public Criteria andListSortNotEqualTo(Short value) {
            addCriterion("ListSort <>", value, "listSort");
            return (Criteria) this;
        }

        public Criteria andListSortGreaterThan(Short value) {
            addCriterion("ListSort >", value, "listSort");
            return (Criteria) this;
        }

        public Criteria andListSortGreaterThanOrEqualTo(Short value) {
            addCriterion("ListSort >=", value, "listSort");
            return (Criteria) this;
        }

        public Criteria andListSortLessThan(Short value) {
            addCriterion("ListSort <", value, "listSort");
            return (Criteria) this;
        }

        public Criteria andListSortLessThanOrEqualTo(Short value) {
            addCriterion("ListSort <=", value, "listSort");
            return (Criteria) this;
        }

        public Criteria andListSortIn(List<Short> values) {
            addCriterion("ListSort in", values, "listSort");
            return (Criteria) this;
        }

        public Criteria andListSortNotIn(List<Short> values) {
            addCriterion("ListSort not in", values, "listSort");
            return (Criteria) this;
        }

        public Criteria andListSortBetween(Short value1, Short value2) {
            addCriterion("ListSort between", value1, value2, "listSort");
            return (Criteria) this;
        }

        public Criteria andListSortNotBetween(Short value1, Short value2) {
            addCriterion("ListSort not between", value1, value2, "listSort");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("Creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("Creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("Creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("Creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("Creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("Creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("Creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("Creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("Creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("Creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("Creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("Creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("Creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("Creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatDateIsNull() {
            addCriterion("CreatDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatDateIsNotNull() {
            addCriterion("CreatDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatDateEqualTo(Date value) {
            addCriterion("CreatDate =", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotEqualTo(Date value) {
            addCriterion("CreatDate <>", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateGreaterThan(Date value) {
            addCriterion("CreatDate >", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CreatDate >=", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateLessThan(Date value) {
            addCriterion("CreatDate <", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateLessThanOrEqualTo(Date value) {
            addCriterion("CreatDate <=", value, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateIn(List<Date> values) {
            addCriterion("CreatDate in", values, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotIn(List<Date> values) {
            addCriterion("CreatDate not in", values, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateBetween(Date value1, Date value2) {
            addCriterion("CreatDate between", value1, value2, "creatDate");
            return (Criteria) this;
        }

        public Criteria andCreatDateNotBetween(Date value1, Date value2) {
            addCriterion("CreatDate not between", value1, value2, "creatDate");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("Modifier is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("Modifier is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("Modifier =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("Modifier <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("Modifier >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("Modifier >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("Modifier <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("Modifier <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("Modifier like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("Modifier not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("Modifier in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("Modifier not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("Modifier between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("Modifier not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("ModifyDate is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("ModifyDate is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("ModifyDate =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("ModifyDate <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("ModifyDate >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ModifyDate >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("ModifyDate <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("ModifyDate <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("ModifyDate in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("ModifyDate not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("ModifyDate between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("ModifyDate not between", value1, value2, "modifyDate");
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