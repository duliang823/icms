package cn.itcast.ssm.po;

public class GoodsCustom extends Goods{
	//添加商品的扩展信息
	private String name;

    private String phone;

    private String address;

    private String searchMessage;
    
    private String rankBygoodsPrice; //价格排序信息
    private String rankBygoodsCollectionnum; //收藏量排序信息
    private Integer goodsPageSize; //商品每页显示的数量
    private Integer goodsNowPage; //当前显示哪页
    private Integer goodsFirstMumInNowPage; //当前页面的首个商品编号

	public Integer getGoodsFirstMumInNowPage() {
		return goodsFirstMumInNowPage;
	}

	public void setGoodsFirstMumInNowPage(Integer goodsFirstMumInNowPage) {
		this.goodsFirstMumInNowPage = goodsFirstMumInNowPage;
	}

	public String getRankBygoodsPrice() {
		return rankBygoodsPrice;
	}

	public void setRankBygoodsPrice(String rankBygoodsPrice) {
		this.rankBygoodsPrice = rankBygoodsPrice;
	}

	public String getRankBygoodsCollectionnum() {
		return rankBygoodsCollectionnum;
	}

	public void setRankBygoodsCollectionnum(String rankBygoodsCollectionnum) {
		this.rankBygoodsCollectionnum = rankBygoodsCollectionnum;
	}

	public Integer getGoodsPageSize() {
		return goodsPageSize;
	}

	public void setGoodsPageSize(Integer goodsPageSize) {
		this.goodsPageSize = goodsPageSize;
	}

	public Integer getGoodsNowPage() {
		return goodsNowPage;
	}

	public void setGoodsNowPage(Integer goodsNowPage) {
		this.goodsNowPage = goodsNowPage;
	}

	public String getSearchMessage() {
		return searchMessage;
	}

	public void setSearchMessage(String searchMessage) {
		this.searchMessage = searchMessage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
}
