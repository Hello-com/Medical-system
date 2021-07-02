package com.javaclimb.drug.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.javaclimb.drug.common.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName(value = "druginfo")  //对应那个表
public class Druginfo {

    //主键
    @TableField(value = "id")
    //@TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    //供应商名称
    private String name;
    //供应商描述
    private String supplie;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date producttime;
    //保质期（月）
    private String warrenty;
    //药品编号
    private String number;
    //价格
    private Float price;
    //库存
    private Integer stock;



    public String getProducttimeStr() {
        return DateUtil.dateConvert(producttime);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplie;
    }

    public void setSupplier(String supplier) {
        this.supplie = supplier;
    }

    public Date getProducttime(Date date) {
        return producttime;
    }

    public void setProducttime(Date producttime) {
        this.producttime = producttime;
    }

    public String getWarrenty() {
        return warrenty;
    }

    public void setWarrenty(String warrenty) {
        this.warrenty = warrenty;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
