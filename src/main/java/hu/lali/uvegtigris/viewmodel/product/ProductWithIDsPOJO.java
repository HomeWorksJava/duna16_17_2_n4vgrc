package hu.lali.uvegtigris.viewmodel.product;

public class ProductWithIDsPOJO {
    protected Integer shopid;
    protected String name,description;
    protected Integer net_price,gross_price,cnt;

    public ProductWithIDsPOJO() {
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNet_price() {
        return net_price;
    }

    public void setNet_price(Integer net_price) {
        this.net_price = net_price;
    }

    public Integer getGross_price() {
        return gross_price;
    }

    public void setGross_price(Integer gross_price) {
        this.gross_price = gross_price;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }
}