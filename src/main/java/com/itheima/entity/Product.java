package com.itheima.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 商品表
 * @TableName product
 */
@Data
public class Product implements Serializable {
    /**
     * 
     */
    private Integer productId;

    /**
     * 
     */
    private Integer storeId;

    /**
     * 
     */
    private Integer brandId;

    /**
     * 
     */
    private String productName;

    /**
     * 
     */
    private String productNum;

    /**
     * 
     */
    private Integer productInvent;

    /**
     * 
     */
    private Integer typeId;

    /**
     * 
     */
    private Integer supplyId;

    /**
     * 
     */
    private Integer placeId;

    /**
     * 
     */
    private Integer unitId;

    /**
     * 
     */
    private String introduce;

    /**
     * 0 下架 1 上架
     */
    private String upDownState;

    /**
     * 
     */
    private BigDecimal inPrice;

    /**
     * 
     */
    private BigDecimal salePrice;

    /**
     * 
     */
    private BigDecimal memPrice;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer createBy;

    /**
     * 
     */
    private Integer updateBy;

    /**
     * 
     */
    private String imgs;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date productDate;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date suppDate;

    private static final long serialVersionUID = 1L;

    ///--------------------------------追加属性


    private String brandName ;
    private String supplyName ;
    private String placeName ;
    private String typeName ;
    private Integer isOverDate ;
    private String storeName ;
    private String unitName ;




    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Product other = (Product) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getStoreId() == null ? other.getStoreId() == null : this.getStoreId().equals(other.getStoreId()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getProductNum() == null ? other.getProductNum() == null : this.getProductNum().equals(other.getProductNum()))
            && (this.getProductInvent() == null ? other.getProductInvent() == null : this.getProductInvent().equals(other.getProductInvent()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getSupplyId() == null ? other.getSupplyId() == null : this.getSupplyId().equals(other.getSupplyId()))
            && (this.getPlaceId() == null ? other.getPlaceId() == null : this.getPlaceId().equals(other.getPlaceId()))
            && (this.getUnitId() == null ? other.getUnitId() == null : this.getUnitId().equals(other.getUnitId()))
            && (this.getIntroduce() == null ? other.getIntroduce() == null : this.getIntroduce().equals(other.getIntroduce()))
            && (this.getUpDownState() == null ? other.getUpDownState() == null : this.getUpDownState().equals(other.getUpDownState()))
            && (this.getInPrice() == null ? other.getInPrice() == null : this.getInPrice().equals(other.getInPrice()))
            && (this.getSalePrice() == null ? other.getSalePrice() == null : this.getSalePrice().equals(other.getSalePrice()))
            && (this.getMemPrice() == null ? other.getMemPrice() == null : this.getMemPrice().equals(other.getMemPrice()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getImgs() == null ? other.getImgs() == null : this.getImgs().equals(other.getImgs()))
            && (this.getProductDate() == null ? other.getProductDate() == null : this.getProductDate().equals(other.getProductDate()))
            && (this.getSuppDate() == null ? other.getSuppDate() == null : this.getSuppDate().equals(other.getSuppDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getStoreId() == null) ? 0 : getStoreId().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getProductNum() == null) ? 0 : getProductNum().hashCode());
        result = prime * result + ((getProductInvent() == null) ? 0 : getProductInvent().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getSupplyId() == null) ? 0 : getSupplyId().hashCode());
        result = prime * result + ((getPlaceId() == null) ? 0 : getPlaceId().hashCode());
        result = prime * result + ((getUnitId() == null) ? 0 : getUnitId().hashCode());
        result = prime * result + ((getIntroduce() == null) ? 0 : getIntroduce().hashCode());
        result = prime * result + ((getUpDownState() == null) ? 0 : getUpDownState().hashCode());
        result = prime * result + ((getInPrice() == null) ? 0 : getInPrice().hashCode());
        result = prime * result + ((getSalePrice() == null) ? 0 : getSalePrice().hashCode());
        result = prime * result + ((getMemPrice() == null) ? 0 : getMemPrice().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getImgs() == null) ? 0 : getImgs().hashCode());
        result = prime * result + ((getProductDate() == null) ? 0 : getProductDate().hashCode());
        result = prime * result + ((getSuppDate() == null) ? 0 : getSuppDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", storeId=").append(storeId);
        sb.append(", brandId=").append(brandId);
        sb.append(", productName=").append(productName);
        sb.append(", productNum=").append(productNum);
        sb.append(", productInvent=").append(productInvent);
        sb.append(", typeId=").append(typeId);
        sb.append(", supplyId=").append(supplyId);
        sb.append(", placeId=").append(placeId);
        sb.append(", unitId=").append(unitId);
        sb.append(", introduce=").append(introduce);
        sb.append(", upDownState=").append(upDownState);
        sb.append(", inPrice=").append(inPrice);
        sb.append(", salePrice=").append(salePrice);
        sb.append(", memPrice=").append(memPrice);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", imgs=").append(imgs);
        sb.append(", productDate=").append(productDate);
        sb.append(", suppDate=").append(suppDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}