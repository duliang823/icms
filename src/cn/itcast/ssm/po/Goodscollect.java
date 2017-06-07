package cn.itcast.ssm.po;

public class Goodscollect {
    private Integer id;
    private Integer userid;
    private Integer goodsid;
    private Integer collectionnumAdd;
    
	public Integer getCollectionnumAdd() {
		return collectionnumAdd;
	}
	public void setCollectionnumAdd(Integer collectionnumAdd) {
		this.collectionnumAdd = collectionnumAdd;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
    
}