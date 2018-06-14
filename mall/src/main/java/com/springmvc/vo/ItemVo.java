package com.springmvc.vo;

public class ItemVo {
    private Integer id;

    private String itemName;

    private Float price;

    private String typeName;

    private Integer itemNumber;

    public ItemVo() {
    }

    public ItemVo(Integer id, String itemName, Float price, String typeName, Integer itemNumber) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.typeName = typeName;
        this.itemNumber = itemNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }
}
