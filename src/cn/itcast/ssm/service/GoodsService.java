package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.GoodsCustom;
import cn.itcast.ssm.po.GoodsQueryVo;
import cn.itcast.ssm.po.Goodscollect;
import cn.itcast.ssm.po.GoodscollectQueryVo;
import cn.itcast.ssm.po.UserInfoCustom;
import cn.itcast.ssm.po.UserInfoQueryVo;


public interface GoodsService {
	
	//查询所有商品信息
	public List<GoodsCustom> findAllGoodsList() throws Exception;

	//根据商品id查询商品信息
	public GoodsCustom findGoodsById(GoodsQueryVo goodsQueryVo) throws Exception;
	
	//根据用户id查询用户的商品收藏情况
	public List<Goodscollect> findGoodscollectListByUserid(UserInfoQueryVo userInfoQueryVo) throws Exception;
	
	//保存数据到Goodscollect
	public void saveGoodscollect(GoodscollectQueryVo goodscollectQueryVo) throws Exception;
	
	//根据用户id和商品id删除Goodscollect中的数据
	public void deleteGoodscollectByuseridAndgoodsid(GoodscollectQueryVo goodscollectQueryVo) throws Exception;

	//根据商品搜索信息模糊查询商品列表
	public List<GoodsCustom> findGoodscollectListBySearch(GoodsQueryVo goodsQueryVo) throws Exception;

	//根据商品搜索信息模糊查询商品列表并按商品价格升序排序
	public List<GoodsCustom> findGoodscollectListBySearchAsc(GoodsQueryVo goodsQueryVo) throws Exception;
	
	//根据商品搜索信息模糊查询商品列表并按商品价格降序排序
	public List<GoodsCustom> findGoodscollectListBySearchDesc(GoodsQueryVo goodsQueryVo) throws Exception;

	//根据商品搜索信息模糊查询商品列表并按收藏量降序排序
	public List<GoodsCustom> findGoodscollectListByCollectionnumDesc(GoodsQueryVo goodsQueryVo) throws Exception;
	
	//根据用户是否收藏该商品，对该商品的收藏量进行增减
	public void updateGoodsCollectionnum(GoodscollectQueryVo goodscollectQueryVo) throws Exception;

	//根据商品搜索信息模糊查询商品的数量
	public Integer selectGoodsCountBySM(GoodsQueryVo goodsQueryVo) throws Exception;

	//根据查询信息分页情况返回商品信息
	public List<GoodsCustom> selectGoodsListBySM(GoodsQueryVo goodsQueryVo) throws Exception;
}
