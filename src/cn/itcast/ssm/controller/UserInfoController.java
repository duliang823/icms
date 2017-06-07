package cn.itcast.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.po.UserInfoCustom;
import cn.itcast.ssm.po.UserInfoQueryVo;
import cn.itcast.ssm.service.UserInfoService;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 
	 * <p>Title: queryUserInfo</p>
	 * <p>Description: 查询用户列表</p>
	 * @param @param userInfoCustom
	 * @param @return
	 * @param @throws Exception   
	 * @return UserInfoCustom  
	 * @throws
	 * @date 2017-4-27下午1:24:33
	 */
	@RequestMapping("/queryUserInfo")
	public @ResponseBody UserInfoCustom queryUserInfo(UserInfoCustom userInfoCustom) throws Exception{
		UserInfoQueryVo userInfoQueryVo = new UserInfoQueryVo();
		userInfoQueryVo.setUserInfoCustom(userInfoCustom);
		
		List<UserInfoCustom> userInfoList = userInfoService.findUserInfoList(userInfoQueryVo);
		if(userInfoList.size() != 0){
			return userInfoList.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 
	 * <p>Title: registerUser</p>
	 * <p>Description: 注册用户</p>
	 * @param @param response
	 * @param @param userInfoCustom
	 * @param @throws Exception   
	 * @return void  
	 * @throws
	 * @date 2017-4-27下午1:28:30
	 */
	@RequestMapping("/registerUser")
	public void registerUser(HttpServletResponse response,UserInfoCustom userInfoCustom)throws Exception{
		UserInfoQueryVo userInfoQueryVo = new UserInfoQueryVo();
		userInfoQueryVo.setUserInfoCustom(userInfoCustom);
		List<UserInfoCustom> userInfoList = userInfoService.findUserInfoByloginid(userInfoQueryVo);
		
		if(userInfoList.size() != 0){//如果存在该用户
			response.getWriter().write("exist");
		}else{//如果不存在该用户,则进行注册，保存该用户信息
			userInfoService.saveUserInfo(userInfoQueryVo);
			response.getWriter().write("inexistence");
		}
		
	}
	
	/**
	 * 
	 * <p>Title: queryUserInfoByloginid</p>
	 * <p>Description: 根据登录账号查询用户信息</p>
	 * @param @param response
	 * @param @param userInfoCustom
	 * @param @return
	 * @param @throws Exception   
	 * @return UserInfoCustom  
	 * @throws
	 * @date 2017-4-27下午2:34:51
	 */
	@RequestMapping("/queryUserInfoByloginid")
	public @ResponseBody UserInfoCustom queryUserInfoByloginid(HttpServletResponse response,UserInfoCustom userInfoCustom)throws Exception{
		UserInfoQueryVo userInfoQueryVo = new UserInfoQueryVo();
		userInfoQueryVo.setUserInfoCustom(userInfoCustom);
		List<UserInfoCustom> userInfoList = userInfoService.findUserInfoByloginid(userInfoQueryVo);
		
		if(userInfoList.size() != 0){
			return userInfoList.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 
	 * <p>Title: updateUserInfoByloginid</p>
	 * <p>Description: 根据登录账号更新用户信息</p>
	 * @param @param userInfoCustom
	 * @param @return
	 * @param @throws Exception   
	 * @return UserInfoCustom  
	 * @throws
	 * @date 2017-5-4上午11:21:17
	 */
	@RequestMapping("/updateUserInfoByloginid")
	public @ResponseBody UserInfoCustom updateUserInfoByloginid(@RequestBody UserInfoCustom userInfoCustom)throws Exception{
		UserInfoQueryVo userInfoQueryVo = new UserInfoQueryVo();
		userInfoQueryVo.setUserInfoCustom(userInfoCustom);
		
		//更新用户信息：
		userInfoService.updateUserInfo(userInfoQueryVo);
		
		//根据该用户账号查询更新后的用户信息
		List<UserInfoCustom> userInfoList = userInfoService.findUserInfoByloginid(userInfoQueryVo);
		if(userInfoList.size() != 0){
			return userInfoList.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 
	 * <p>Title: findUserInfosList</p>
	 * <p>Description: 查询所有用户列表</p>
	 * @param @return
	 * @param @throws Exception   
	 * @return List<UserInfoCustom>  
	 * @throws
	 * @date 2017-5-4下午2:49:00
	 */
	@RequestMapping("/findUserInfosList")
	public @ResponseBody List<UserInfoCustom> findUserInfosList()throws Exception{
		List<UserInfoCustom> userInfosList = userInfoService.findUserInfosList();
		return userInfosList;
	}
	
	/**
	 * 
	 * <p>Title: updateUserInfoList</p>
	 * <p>Description: 更新多条用户信息</p>
	 * @param @param list
	 * @param @throws Exception   
	 * @return List<UserInfoCustom> 
	 * @throws
	 * @date 2017-5-5下午4:59:22
	 */
	@RequestMapping("/updateUserInfoList")
	public @ResponseBody List<UserInfoCustom> updateUserInfoList(@RequestBody List<UserInfoCustom> userInfoCustomList)throws Exception{
		UserInfoQueryVo userInfoQueryVo = new UserInfoQueryVo();
		userInfoQueryVo.setUserInfoCustomList(userInfoCustomList);
		
		//更新用户信息：
		userInfoService.updateUserInfoList(userInfoQueryVo);
		
		return null;
	}
	
	
	/**
	 * 
	 * <p>Title: deleteUserInfosById</p>
	 * <p>Description: 根据用户id删除多条用户信息</p>
	 * @param @param userInfoCustomList
	 * @param @return
	 * @param @throws Exception   
	 * @return List<UserInfoCustom>  
	 * @throws
	 * @date 2017-5-8下午1:08:47
	 */
	@RequestMapping("/deleteUserInfosById")
	public @ResponseBody List<UserInfoCustom> deleteUserInfosById(@RequestBody List<UserInfoCustom> userInfoCustomList)throws Exception{
		UserInfoQueryVo userInfoQueryVo = new UserInfoQueryVo();
		userInfoQueryVo.setUserInfoCustomList(userInfoCustomList);
		
		//根据用户id删除多条用户信息：
		userInfoService.deleteUserInfosById(userInfoQueryVo);
		
		return null;
	}
	
}
