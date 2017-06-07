package cn.itcast.ssm.po;

import java.util.List;

public class UserInfoQueryVo {
	private UserInfo userInfo; //用户信息
	private UserInfoCustom userInfoCustom;  //用户信息扩展属性
	private List<UserInfoCustom> userInfoCustomList;  //多个用户信息
	
	public List<UserInfoCustom> getUserInfoCustomList() {
		return userInfoCustomList;
	}
	public void setUserInfoCustomList(List<UserInfoCustom> userInfoCustomList) {
		this.userInfoCustomList = userInfoCustomList;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public UserInfoCustom getUserInfoCustom() {
		return userInfoCustom;
	}
	public void setUserInfoCustom(UserInfoCustom userInfoCustom) {
		this.userInfoCustom = userInfoCustom;
	}
	
}
