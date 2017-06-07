package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.GoodsMapperCustom;
import cn.itcast.ssm.po.GoodsCustom;
import cn.itcast.ssm.po.GoodsQueryVo;
import cn.itcast.ssm.po.Goodscollect;
import cn.itcast.ssm.po.GoodscollectQueryVo;
import cn.itcast.ssm.po.UserInfoQueryVo;
import cn.itcast.ssm.service.GoodsService;

/**
 * 
 * <p>Title: UserInfoServiceImpl</p>
 * <p>@Description: 用户信息查询</p>
 * @author 杜亮
 * @date 2017-4-27上午10:17:24
 */
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsMapperCustom goodsMapperCustom;

	public List<GoodsCustom> findAllGoodsList() throws Exception {
		return goodsMapperCustom.findAllGoodsList();
	}

	public GoodsCustom findGoodsById(GoodsQueryVo goodsQueryVo)
			throws Exception {
		return goodsMapperCustom.findGoodsById(goodsQueryVo);
	}

	public List<Goodscollect> findGoodscollectListByUserid(
			UserInfoQueryVo userInfoQueryVo) throws Exception {
		return goodsMapperCustom.findGoodscollectListByUserid(userInfoQueryVo);
	}

	public void saveGoodscollect(GoodscollectQueryVo goodscollectQueryVo)
			throws Exception {
		goodsMapperCustom.saveGoodscollect(goodscollectQueryVo);
	}

	public void deleteGoodscollectByuseridAndgoodsid(
			GoodscollectQueryVo goodscollectQueryVo) throws Exception {
		goodsMapperCustom.deleteGoodscollectByuseridAndgoodsid(goodscollectQueryVo);
	}

	public List<GoodsCustom> findGoodscollectListBySearch(
			GoodsQueryVo goodsQueryVo) throws Exception {
		return goodsMapperCustom.findGoodscollectListBySearch(goodsQueryVo);
	}

	public List<GoodsCustom> findGoodscollectListBySearchAsc(
			GoodsQueryVo goodsQueryVo) throws Exception {
		return goodsMapperCustom.findGoodscollectListBySearchAsc(goodsQueryVo);
	}

	public List<GoodsCustom> findGoodscollectListBySearchDesc(
			GoodsQueryVo goodsQueryVo) throws Exception {
		return goodsMapperCustom.findGoodscollectListBySearchDesc(goodsQueryVo);
	}

	public List<GoodsCustom> findGoodscollectListByCollectionnumDesc(
			GoodsQueryVo goodsQueryVo) throws Exception {
		return goodsMapperCustom.findGoodscollectListByCollectionnumDesc(goodsQueryVo);
	}
	
	public void updateGoodsCollectionnum(GoodscollectQueryVo goodscollectQueryVo)
			throws Exception {
		goodsMapperCustom.updateGoodsCollectionnum(goodscollectQueryVo);
	}

	public Integer selectGoodsCountBySM(GoodsQueryVo goodsQueryVo)
			throws Exception {
		return goodsMapperCustom.selectGoodsCountBySM(goodsQueryVo);
	}

	public List<GoodsCustom> selectGoodsListBySM(GoodsQueryVo goodsQueryVo)
			throws Exception {
		return goodsMapperCustom.selectGoodsListBySM(goodsQueryVo);
	}


}
