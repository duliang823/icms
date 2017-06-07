package cn.itcast.ssm.po;

import java.util.List;

public class GoodsQueryVo {
	private Goods goods; //商品信息
	private GoodsCustom goodsCustom; //商品扩展信息
	private List<GoodsCustom> goodsCustomList; //商品扩展信息
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public GoodsCustom getGoodsCustom() {
		return goodsCustom;
	}
	public void setGoodsCustom(GoodsCustom goodsCustom) {
		this.goodsCustom = goodsCustom;
	}
	public List<GoodsCustom> getGoodsCustomList() {
		return goodsCustomList;
	}
	public void setGoodsCustomList(List<GoodsCustom> goodsCustomList) {
		this.goodsCustomList = goodsCustomList;
	}
	
}
