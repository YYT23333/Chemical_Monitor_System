package cn.nju.edu.chemical_monitor_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "InOutBatch", schema = "mydb")
public class InOutBatchEntity {
    private int inOutId;
    private int productId;
    private int storeId;
    private int batchId;
    private Integer inOrOut;
    private Double number;
    private String status;

    @Id
    @Column(name = "InOut_id")
    public int getInOutId() {
        return inOutId;
    }

    public void setInOutId(int inOutId) {
        this.inOutId = inOutId;
    }

    @Basic
    @Column(name = "Product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "Store_id")
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "Batch_id")
    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    @Basic
    @Column(name = "InOrOut")
    public Integer getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(Integer inOrOut) {
        this.inOrOut = inOrOut;
    }

    @Basic
    @Column(name = "Number")
    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    @Basic
    @Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InOutBatchEntity that = (InOutBatchEntity) o;

        if (inOutId != that.inOutId) return false;
        if (productId != that.productId) return false;
        if (storeId != that.storeId) return false;
        if (batchId != that.batchId) return false;
        if (inOrOut != null ? !inOrOut.equals(that.inOrOut) : that.inOrOut != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = inOutId;
        result = 31 * result + productId;
        result = 31 * result + storeId;
        result = 31 * result + batchId;
        result = 31 * result + (inOrOut != null ? inOrOut.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}