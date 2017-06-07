package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.po.UserInfoCustom;
import cn.itcast.ssm.po.UserInfoQueryVo;

public interface UserInfoMapperCustom {
	//用户信息查询列表
	public List<UserInfoCustom> findUserInfoList(UserInfoQueryVo userInfoQueryVo) throws Exception;
	
	//根据登陆账号查询用户列表
	public List<UserInfoCustom> findUserInfoByloginid(UserInfoQueryVo userInfoQueryVo) throws Exception;
	
	//保存用户信息
	public void saveUserInfo(UserInfoQueryVo userInfoQueryVo) throws Exception;
	
	//更新用户信息
	public void updateUserInfo(UserInfoQueryVo userInfoQueryVo) throws Exception;
	
	//查询所有用户列表
	public List<UserInfoCustom> findUserInfosList() throws Exception;
	
	//更新多条用户信息
	public void updateUserInfoList(UserInfoQueryVo userInfoQueryVo) throws Exception;
	
	//根据用户id删除多条用户信息
	public void deleteUserInfosById(UserInfoQueryVo userInfoQueryVo) throws Exception;
	
}
