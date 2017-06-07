package cn.itcast.ssm.po;

public class Goods {
    private Integer id;

    private String imageurl;

    private Float price;

    private Integer collectionnum;

    private String sort;

    private String storename;

    private String detail;

    public Integer getCollectionnum() {
		return collectionnum;
	}

	public void setCollectionnum(Integer collectionnum) {
		this.collectionnum = collectionnum;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}