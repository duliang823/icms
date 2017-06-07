package cn.itcast.ssm.po;

public class Goodssort {
    private Integer id;

    private String sortname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname == null ? null : sortname.trim();
    }
}