package com.itheima.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 仓库表
 * @TableName store
 */
@Data
public class Store implements Serializable {
    /**
     * 
     */
    private Integer storeId;

    /**
     * 
     */
    private String storeName;

    /**
     * 
     */
    private String storeNum;

    /**
     * 
     */
    private String storeAddress;

    /**
     * 
     */
    private String concat;

    /**
     * 
     */
    private String phone;

    private static final long serialVersionUID = 1L;

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
        Store other = (Store) that;
        return (this.getStoreId() == null ? other.getStoreId() == null : this.getStoreId().equals(other.getStoreId()))
            && (this.getStoreName() == null ? other.getStoreName() == null : this.getStoreName().equals(other.getStoreName()))
            && (this.getStoreNum() == null ? other.getStoreNum() == null : this.getStoreNum().equals(other.getStoreNum()))
            && (this.getStoreAddress() == null ? other.getStoreAddress() == null : this.getStoreAddress().equals(other.getStoreAddress()))
            && (this.getConcat() == null ? other.getConcat() == null : this.getConcat().equals(other.getConcat()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStoreId() == null) ? 0 : getStoreId().hashCode());
        result = prime * result + ((getStoreName() == null) ? 0 : getStoreName().hashCode());
        result = prime * result + ((getStoreNum() == null) ? 0 : getStoreNum().hashCode());
        result = prime * result + ((getStoreAddress() == null) ? 0 : getStoreAddress().hashCode());
        result = prime * result + ((getConcat() == null) ? 0 : getConcat().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", storeId=").append(storeId);
        sb.append(", storeName=").append(storeName);
        sb.append(", storeNum=").append(storeNum);
        sb.append(", storeAddress=").append(storeAddress);
        sb.append(", concat=").append(concat);
        sb.append(", phone=").append(phone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}