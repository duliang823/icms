package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.UserInfoMapperCustom;
import cn.itcast.ssm.po.UserInfoCustom;
import cn.itcast.ssm.po.UserInfoQueryVo;
import cn.itcast.ssm.service.UserInfoService;

/**
 * 
 * <p>Title: UserInfoServiceImpl</p>
 * <p>@Description: 用户信息查询</p>
 * @author 杜亮
 * @date 2017-4-27上午10:17:24
 */
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoMapperCustom userInfoMapperCustom;
	
	public List<UserInfoCustom> findUserInfoList(UserInfoQueryVo userInfoQueryVo)
			throws Exception {
		return userInfoMapperCustom.findUserInfoList(userInfoQueryVo);
	}

	public List<UserInfoCustom> findUserInfoByloginid(
			UserInfoQueryVo userInfoQueryVo) throws Exception {
		return userInfoMapperCustom.findUserInfoByloginid(userInfoQueryVo);
	}

	public void saveUserInfo(UserInfoQueryVo userInfoQueryVo) throws Exception {
		userInfoMapperCustom.saveUserInfo(userInfoQueryVo);
	}

	public void updateUserInfo(UserInfoQueryVo userInfoQueryVo)
			throws Exception {
		userInfoMapperCustom.updateUserInfo(userInfoQueryVo);
	}

	public List<UserInfoCustom> findUserInfosList() throws Exception {
		return userInfoMapperCustom.findUserInfosList();
	}

	public void updateUserInfoList(UserInfoQueryVo userInfoQueryVo)
			throws Exception {
		userInfoMapperCustom.updateUserInfoList(userInfoQueryVo);
	}

	public void deleteUserInfosById(UserInfoQueryVo userInfoQueryVo)
			throws Exception {
		userInfoMapperCustom.deleteUserInfosById(userInfoQueryVo);
	}

}
