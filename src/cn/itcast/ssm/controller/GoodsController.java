package cn.itcast.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.ssm.po.GoodsCustom;
import cn.itcast.ssm.po.GoodsQueryVo;
import cn.itcast.ssm.po.Goodscollect;
import cn.itcast.ssm.po.GoodscollectQueryVo;
import cn.itcast.ssm.po.UserInfoCustom;
import cn.itcast.ssm.po.UserInfoQueryVo;
import cn.itcast.ssm.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 
	 * <p>Title: findAllGoodsList</p>
	 * <p>Description: 查询所有商品信息</p>
	 * @param @return
	 * @param @throws Exception   
	 * @return List<GoodsCustom>  
	 * @throws
	 * @date 2017-5-9下午3:51:17
	 */
	@RequestMapping("/findAllGoodsList")
	public @ResponseBody List<GoodsCustom> findAllGoodsList()throws Exception{
		List<GoodsCustom> allGoodsList = goodsService.findAllGoodsList();
		return allGoodsList;
	}
	
	/**
	 * 
	 * <p>Title: findGoodsById</p>
	 * <p>Description: 根据商品id查询商品信息</p>
	 * @param @param goodsCustom
	 * @param @return
	 * @param @throws Exception   
	 * @return GoodsCustom  
	 * @throws?
	 * @date 2017-5-9下午4:46:52
	 */
	@RequestMapping("/findGoodsById")
	public @ResponseBody GoodsCustom findGoodsById(GoodsCustom goodsCustom)throws Exception{
		GoodsQueryVo goodsQueryVo = new GoodsQueryVo();
		goodsQueryVo.setGoodsCustom(goodsCustom);
		GoodsCustom presentGoods = goodsService.findGoodsById(goodsQueryVo);
		return presentGoods;
	}
	
	/**
	 * 
	 * <p>Title: findGoodscollectListByUserid</p>
	 * <p>Description: 根据用户id查询用户的商品收藏情况</p>
	 * @param @param userInfoCustom
	 * @param @return
	 * @param @throws Exception   
	 * @return List<Goodscollect>  
	 * @throws
	 * @date 2017-5-10下午12:38:43
	 */
	@RequestMapping("/findGoodscollectListByUserid")
	public @ResponseBody List<Goodscollect> findGoodscollectListByUserid(UserInfoCustom userInfoCustom)throws Exception{
		UserInfoQueryVo userInfoQueryVo = new UserInfoQueryVo();
		userInfoQueryVo.setUserInfoCustom(userInfoCustom);
		
		List<Goodscollect> goodscollectList = goodsService.findGoodscollectListByUserid(userInfoQueryVo);
		return goodscollectList;
	}
	
	/**
	 * 
	 * <p>Title: collectGoods</p>
	 * <p>Description: 根据goodscollectState状态选择删除或者保存userid和goodsid</p>
	 * @param @param goodscollectState
	 * @param @param userid
	 * @param @param goodsid
	 * @param @throws Exception   
	 * @return void  
	 * @throws
	 * @date 2017-5-10下午1:48:30
	 */
	@RequestMapping("/collectGoods")
	public  @ResponseBody Goodscollect collectGoods(Integer goodscollectState, Integer userid, Integer goodsid) throws Exception{
		Integer collectionnumAdd = 0;
		
		Goodscollect goodscollect = new Goodscollect();
		goodscollect.setUserid(userid);
		goodscollect.setGoodsid(goodsid);
		
		GoodscollectQueryVo goodscollectQueryVo = new GoodscollectQueryVo();
		
		
		if(goodscollectState == 0){ //DELETE删除，把该商品从收藏栏中去除
			collectionnumAdd = 0;
			goodscollect.setCollectionnumAdd(collectionnumAdd);
			
			goodscollectQueryVo.setGoodscollect(goodscollect);
			goodsService.deleteGoodscollectByuseridAndgoodsid(goodscollectQueryVo);
			goodsService.updateGoodsCollectionnum(goodscollectQueryVo);
		}else if(goodscollectState == 1){  //INSERT保存，收藏该商品
			collectionnumAdd = 1;
			goodscollect.setCollectionnumAdd(collectionnumAdd);
			
			goodscollectQueryVo.setGoodscollect(goodscollect);
			goodsService.saveGoodscollect(goodscollectQueryVo);
			goodsService.updateGoodsCollectionnum(goodscollectQueryVo);
		}
		return null;
	}
	
	
	/**
	 * 
	 * <p>Title: findGoodscollectListBySearch</p>
	 * <p>Description: 根据商品搜索信息模糊查询商品列表</p>
	 * @param @param searchMessage
	 * @param @return
	 * @param @throws Exception   
	 * @return List<GoodsCustom>  
	 * @throws
	 * @date 2017-5-10下午2:41:24
	 */
	@RequestMapping("/findGoodscollectListBySearch")
	public @ResponseBody List<GoodsCustom> findGoodscollectListBySearch(String searchMessage)throws Exception{
		GoodsCustom goodsCustom = new GoodsCustom();
		goodsCustom.setSearchMessage(searchMessage);
		
		GoodsQueryVo goodsQueryVo = new GoodsQueryVo();
		goodsQueryVo.setGoodsCustom(goodsCustom);
		
		List<GoodsCustom> searchGoodsList = goodsService.findGoodscollectListBySearch(goodsQueryVo);
		return searchGoodsList;
	}
	
	/**
	 * 
	 * <p>Title: findGoodscollectListBySearchRank</p>
	 * <p>Description: 根据商品价格排序</p>
	 * @param @param searchMessage
	 * @param @param rankASC
	 * @param @return
	 * @param @throws Exception   
	 * @return List<GoodsCustom>  
	 * @throws
	 * @date 2017-5-10下午4:59:32
	 */
	@RequestMapping("/findGoodscollectListBySearchRank")
	public @ResponseBody List<GoodsCustom> findGoodscollectListBySearchRank(String searchMessage, String rankASC)throws Exception{
		GoodsCustom goodsCustom = new GoodsCustom();
		goodsCustom.setSearchMessage(searchMessage);
		
		GoodsQueryVo goodsQueryVo = new GoodsQueryVo();
		goodsQueryVo.setGoodsCustom(goodsCustom);
		List<GoodsCustom> searchGoodsList = null;
		if(rankASC.equals("ASC")){
			searchGoodsList = goodsService.findGoodscollectListBySearchDesc(goodsQueryVo);
		}else if(rankASC.equals("DESC")){
			searchGoodsList = goodsService.findGoodscollectListBySearchAsc(goodsQueryVo);
		}
		return searchGoodsList;
	}
	
	/**
	 * 
	 * <p>Title: findGoodscollectListByCollectionnumRank</p>
	 * <p>Description: 根据商品搜索信息模糊查询商品列表并按收藏量降序排序</p>
	 * @param @param searchMessage
	 * @param @return
	 * @param @throws Exception   
	 * @return List<GoodsCustom>  
	 * @throws
	 * @date 2017-5-10下午5:00:53
	 */
	@RequestMapping("/findGoodscollectListByCollectionnumRank")
	public @ResponseBody List<GoodsCustom> findGoodscollectListByCollectionnumRank(String searchMessage)throws Exception{
		GoodsCustom goodsCustom = new GoodsCustom();
		goodsCustom.setSearchMessage(searchMessage);
		GoodsQueryVo goodsQueryVo = new GoodsQueryVo();
		goodsQueryVo.setGoodsCustom(goodsCustom);
		List<GoodsCustom> searchGoodsList = goodsService.findGoodscollectListByCollectionnumDesc(goodsQueryVo);
		
		return searchGoodsList;
	}
	
	/**
	 * 
	 * <p>Title: searchGoodsByMessage</p>
	 * <p>Description: 根据查询信息进行分页处理商品数据</p>
	 * @param @throws Exception   
	 * @return void  
	 * @throws
	 * @date 2017-5-16下午2:25:18
	 */
	@RequestMapping("/searchGoodsByMessage")
	public @ResponseBody List searchGoodsByMessage(
			HttpServletResponse response,
			String searchGoodsMessage, 
			String rankBygoodsPrice, 
			String rankBygoodsCollectionnum, 
			Integer goodsPageSize,
			Integer goodsNowPage)throws Exception{
		
//		System.out.println(searchGoodsMessage+" "+rankBygoodsPrice+" "+rankBygoodsCollectionnum+" "+goodsPageSize+" "+goodsNowPage);
		if((searchGoodsMessage == null) || (searchGoodsMessage.equals(""))){  //查询条件为空
//			System.out.println("查询条件为空");
			return null;
		}else{ //查询条件不为空
			GoodsCustom goodsCustom = new GoodsCustom();
			goodsCustom.setSearchMessage(searchGoodsMessage);
			goodsCustom.setRankBygoodsPrice(rankBygoodsPrice);
			goodsCustom.setRankBygoodsCollectionnum(rankBygoodsCollectionnum);
			goodsCustom.setGoodsPageSize(goodsPageSize);
			goodsCustom.setGoodsNowPage(goodsNowPage);
			goodsCustom.setGoodsFirstMumInNowPage((goodsNowPage-1)*goodsPageSize);//传入当前页面的首个商品编号
			GoodsQueryVo goodsQueryVo = new GoodsQueryVo();
			goodsQueryVo.setGoodsCustom(goodsCustom);
			
			//查询出总的页数
			int goodsTotalPage = (goodsService.selectGoodsCountBySM(goodsQueryVo)-1)/goodsPageSize+1;
//			System.out.println("goodsTotalPage="+goodsTotalPage);
			
			//获取当前页的商品:
			List<GoodsCustom> nowPagegoodsCustomList = goodsService.selectGoodsListBySM(goodsQueryVo);
			
			List GoodsListAndTotalPage = new ArrayList();
			GoodsListAndTotalPage.add(goodsTotalPage);
			GoodsListAndTotalPage.add(nowPagegoodsCustomList);
			return GoodsListAndTotalPage;
		}
	}
	
	
}
