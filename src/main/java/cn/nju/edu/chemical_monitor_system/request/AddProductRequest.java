package cn.nju.edu.chemical_monitor_system.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class AddProductRequest {

    private int batchId;

    private Map<Integer, Double> casNumberMap;

    private int storeId;
}
