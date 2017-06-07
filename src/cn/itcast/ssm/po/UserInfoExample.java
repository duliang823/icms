package cn.itcast.ssm.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andLoginidIsNull() {
            addCriterion("loginid is null");
            return (Criteria) this;
        }

        public Criteria andLoginidIsNotNull() {
            addCriterion("loginid is not null");
            return (Criteria) this;
        }

        public Criteria andLoginidEqualTo(String value) {
            addCriterion("loginid =", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidNotEqualTo(String value) {
            addCriterion("loginid <>", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidGreaterThan(String value) {
            addCriterion("loginid >", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidGreaterThanOrEqualTo(String value) {
            addCriterion("loginid >=", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidLessThan(String value) {
            addCriterion("loginid <", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidLessThanOrEqualTo(String value) {
            addCriterion("loginid <=", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidLike(String value) {
            addCriterion("loginid like", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidNotLike(String value) {
            addCriterion("loginid not like", value, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidIn(List<String> values) {
            addCriterion("loginid in", values, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidNotIn(List<String> values) {
            addCriterion("loginid not in", values, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidBetween(String value1, String value2) {
            addCriterion("loginid between", value1, value2, "loginid");
            return (Criteria) this;
        }

        public Criteria andLoginidNotBetween(String value1, String value2) {
            addCriterion("loginid not between", value1, value2, "loginid");
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

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBlocknumIsNull() {
            addCriterion("blocknum is null");
            return (Criteria) this;
        }

        public Criteria andBlocknumIsNotNull() {
            addCriterion("blocknum is not null");
            return (Criteria) this;
        }

        public Criteria andBlocknumEqualTo(Integer value) {
            addCriterion("blocknum =", value, "blocknum");
            return (Criteria) this;
        }

        public Criteria andBlocknumNotEqualTo(Integer value) {
            addCriterion("blocknum <>", value, "blocknum");
            return (Criteria) this;
        }

        public Criteria andBlocknumGreaterThan(Integer value) {
            addCriterion("blocknum >", value, "blocknum");
            return (Criteria) this;
        }

        public Criteria andBlocknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("blocknum >=", value, "blocknum");
            return (Criteria) this;
        }

        public Criteria andBlocknumLessThan(Integer value) {
            addCriterion("blocknum <", value, "blocknum");
            return (Criteria) this;
        }

        public Criteria andBlocknumLessThanOrEqualTo(Integer value) {
            addCriterion("blocknum <=", value, "blocknum");
            return (Criteria) this;
        }

        public Criteria andBlocknumIn(List<Integer> values) {
            addCriterion("blocknum in", values, "blocknum");
            return (Criteria) this;
        }

        public Criteria andBlocknumNotIn(List<Integer> values) {
            addCriterion("blocknum not in", values, "blocknum");
            return (Criteria) this;
        }

        public Criteria andBlocknumBetween(Integer value1, Integer value2) {
            addCriterion("blocknum between", value1, value2, "blocknum");
            return (Criteria) this;
        }

        public Criteria andBlocknumNotBetween(Integer value1, Integer value2) {
            addCriterion("blocknum not between", value1, value2, "blocknum");
            return (Criteria) this;
        }

        public Criteria andUnitnumIsNull() {
            addCriterion("unitnum is null");
            return (Criteria) this;
        }

        public Criteria andUnitnumIsNotNull() {
            addCriterion("unitnum is not null");
            return (Criteria) this;
        }

        public Criteria andUnitnumEqualTo(Integer value) {
            addCriterion("unitnum =", value, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumNotEqualTo(Integer value) {
            addCriterion("unitnum <>", value, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumGreaterThan(Integer value) {
            addCriterion("unitnum >", value, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("unitnum >=", value, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumLessThan(Integer value) {
            addCriterion("unitnum <", value, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumLessThanOrEqualTo(Integer value) {
            addCriterion("unitnum <=", value, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumIn(List<Integer> values) {
            addCriterion("unitnum in", values, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumNotIn(List<Integer> values) {
            addCriterion("unitnum not in", values, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumBetween(Integer value1, Integer value2) {
            addCriterion("unitnum between", value1, value2, "unitnum");
            return (Criteria) this;
        }

        public Criteria andUnitnumNotBetween(Integer value1, Integer value2) {
            addCriterion("unitnum not between", value1, value2, "unitnum");
            return (Criteria) this;
        }

        public Criteria andHousenumIsNull() {
            addCriterion("housenum is null");
            return (Criteria) this;
        }

        public Criteria andHousenumIsNotNull() {
            addCriterion("housenum is not null");
            return (Criteria) this;
        }

        public Criteria andHousenumEqualTo(Integer value) {
            addCriterion("housenum =", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumNotEqualTo(Integer value) {
            addCriterion("housenum <>", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumGreaterThan(Integer value) {
            addCriterion("housenum >", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("housenum >=", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumLessThan(Integer value) {
            addCriterion("housenum <", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumLessThanOrEqualTo(Integer value) {
            addCriterion("housenum <=", value, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumIn(List<Integer> values) {
            addCriterion("housenum in", values, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumNotIn(List<Integer> values) {
            addCriterion("housenum not in", values, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumBetween(Integer value1, Integer value2) {
            addCriterion("housenum between", value1, value2, "housenum");
            return (Criteria) this;
        }

        public Criteria andHousenumNotBetween(Integer value1, Integer value2) {
            addCriterion("housenum not between", value1, value2, "housenum");
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