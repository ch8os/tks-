package com.tks.db.common.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TScanRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TScanRecordExample() {
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

        public Criteria andDocIdIsNull() {
            addCriterion("DOC_ID is null");
            return (Criteria) this;
        }

        public Criteria andDocIdIsNotNull() {
            addCriterion("DOC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDocIdEqualTo(String value) {
            addCriterion("DOC_ID =", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotEqualTo(String value) {
            addCriterion("DOC_ID <>", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThan(String value) {
            addCriterion("DOC_ID >", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdGreaterThanOrEqualTo(String value) {
            addCriterion("DOC_ID >=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThan(String value) {
            addCriterion("DOC_ID <", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLessThanOrEqualTo(String value) {
            addCriterion("DOC_ID <=", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdLike(String value) {
            addCriterion("DOC_ID like", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotLike(String value) {
            addCriterion("DOC_ID not like", value, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdIn(List<String> values) {
            addCriterion("DOC_ID in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotIn(List<String> values) {
            addCriterion("DOC_ID not in", values, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdBetween(String value1, String value2) {
            addCriterion("DOC_ID between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andDocIdNotBetween(String value1, String value2) {
            addCriterion("DOC_ID not between", value1, value2, "docId");
            return (Criteria) this;
        }

        public Criteria andPatOpenidIsNull() {
            addCriterion("PAT_OPENID is null");
            return (Criteria) this;
        }

        public Criteria andPatOpenidIsNotNull() {
            addCriterion("PAT_OPENID is not null");
            return (Criteria) this;
        }

        public Criteria andPatOpenidEqualTo(String value) {
            addCriterion("PAT_OPENID =", value, "patOpenid");
            return (Criteria) this;
        }

        public Criteria andPatOpenidNotEqualTo(String value) {
            addCriterion("PAT_OPENID <>", value, "patOpenid");
            return (Criteria) this;
        }

        public Criteria andPatOpenidGreaterThan(String value) {
            addCriterion("PAT_OPENID >", value, "patOpenid");
            return (Criteria) this;
        }

        public Criteria andPatOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("PAT_OPENID >=", value, "patOpenid");
            return (Criteria) this;
        }

        public Criteria andPatOpenidLessThan(String value) {
            addCriterion("PAT_OPENID <", value, "patOpenid");
            return (Criteria) this;
        }

        public Criteria andPatOpenidLessThanOrEqualTo(String value) {
            addCriterion("PAT_OPENID <=", value, "patOpenid");
            return (Criteria) this;
        }

        public Criteria andPatOpenidLike(String value) {
            addCriterion("PAT_OPENID like", value, "patOpenid");
            return (Criteria) this;
        }

        public Criteria andPatOpenidNotLike(String value) {
            addCriterion("PAT_OPENID not like", value, "patOpenid");
            return (Criteria) this;
        }

        public Criteria andPatOpenidIn(List<String> values) {
            addCriterion("PAT_OPENID in", values, "patOpenid");
            return (Criteria) this;
        }

        public Criteria andPatOpenidNotIn(List<String> values) {
            addCriterion("PAT_OPENID not in", values, "patOpenid");
            return (Criteria) this;
        }

        public Criteria andPatOpenidBetween(String value1, String value2) {
            addCriterion("PAT_OPENID between", value1, value2, "patOpenid");
            return (Criteria) this;
        }

        public Criteria andPatOpenidNotBetween(String value1, String value2) {
            addCriterion("PAT_OPENID not between", value1, value2, "patOpenid");
            return (Criteria) this;
        }

        public Criteria andAdviceIdIsNull() {
            addCriterion("ADVICE_ID is null");
            return (Criteria) this;
        }

        public Criteria andAdviceIdIsNotNull() {
            addCriterion("ADVICE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceIdEqualTo(String value) {
            addCriterion("ADVICE_ID =", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdNotEqualTo(String value) {
            addCriterion("ADVICE_ID <>", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdGreaterThan(String value) {
            addCriterion("ADVICE_ID >", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("ADVICE_ID >=", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdLessThan(String value) {
            addCriterion("ADVICE_ID <", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdLessThanOrEqualTo(String value) {
            addCriterion("ADVICE_ID <=", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdLike(String value) {
            addCriterion("ADVICE_ID like", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdNotLike(String value) {
            addCriterion("ADVICE_ID not like", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdIn(List<String> values) {
            addCriterion("ADVICE_ID in", values, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdNotIn(List<String> values) {
            addCriterion("ADVICE_ID not in", values, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdBetween(String value1, String value2) {
            addCriterion("ADVICE_ID between", value1, value2, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdNotBetween(String value1, String value2) {
            addCriterion("ADVICE_ID not between", value1, value2, "adviceId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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