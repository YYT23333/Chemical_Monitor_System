package cn.nju.edu.chemical_monitor_system.vo;

import cn.nju.edu.chemical_monitor_system.entity.InOutBatchEntity;
import lombok.Data;

@Data
public class InOutBatchVO {

    private int inOutId;
    private int productId;
    private int storeId;
    private int batchId;
    private Integer inOrOut;
    private Double number;
    private int code;

    public InOutBatchVO(InOutBatchEntity io) {
        if (io == null) {
            this.code = 0;
            return;
        }

        this.inOrOut = io.getInOrOut();
        this.productId = io.getProductId();
        this.storeId = io.getStoreId();
        this.batchId = io.getBatchId();
        this.inOrOut = io.getInOrOut();
        this.number = io.getNumber();
        this.code = 1;
    }

    public InOutBatchVO() {
        this.code = 0;
    }
}