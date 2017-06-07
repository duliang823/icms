package cn.itcast.ssm.po;

import java.util.Date;

public class UserInfo {
    private Integer id;

    private String username;

    private String loginid;

    private String password;

    private Date birthday;

    private Integer blocknum;

    private Integer unitnum;

    private Integer housenum;
    
    private Integer administrator;
    
    private String email;
    
    private String phonenumber;
    
    private String sex;
    
    private Integer age;

    public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Integer getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Integer administrator) {
		this.administrator = administrator;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid == null ? null : loginid.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getBlocknum() {
        return blocknum;
    }

    public void setBlocknum(Integer blocknum) {
        this.blocknum = blocknum;
    }

    public Integer getUnitnum() {
        return unitnum;
    }

    public void setUnitnum(Integer unitnum) {
        this.unitnum = unitnum;
    }

    public Integer getHousenum() {
        return housenum;
    }

    public void setHousenum(Integer housenum) {
        this.housenum = housenum;
    }
}