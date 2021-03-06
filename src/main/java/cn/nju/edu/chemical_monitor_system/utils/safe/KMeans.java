package cn.nju.edu.chemical_monitor_system.utils.safe;


import cn.nju.edu.chemical_monitor_system.constant.ConstantVariables;

class KMeans {
    private Distance distance;
    private int iterationNum;

    KMeans(Distance distance, int iterationNum) {
        this.distance = distance;
        this.iterationNum = iterationNum;
    }

    //将未分配的节点加入簇（策略为选择最近的簇）
    private void allocateProductsToCluster(ProductList products, ClusterList clusterList) {
        for (Product product : products) {
            if (!product.isAllocated()) {
                Cluster nearest = clusterList.findNearestCluster(distance, product);
                nearest.add(product);
                product.setAllocated(true);
            }
        }
    }

    //通过最远的节点创建新的簇
    private Cluster createFurthestCluster(ProductList products, ClusterList clusterList) {
        Product furthestProduct = clusterList.findFurthestProduct(distance, products);
        return new Cluster(furthestProduct);
    }

    private Cluster selectProductAsClusterRandomly(ProductList products) {
        int index = (int) ((Math.random() * products.size()));
        return new Cluster(products.get(index));
    }

    ClusterList runKMeans(ProductList products) {
        ClusterList clusters = new ClusterList();
        products.clearAllocated();

        //初始化一个簇，再根据最远原则选择更多的簇直到满足k个
        clusters.add(selectProductAsClusterRandomly(products));
        while (clusters.size() < ConstantVariables.clusterNum) {
            clusters.add(createFurthestCluster(products, clusters));
        }

        for (int i = 0; i < iterationNum; i++) {
            allocateProductsToCluster(products, clusters);
            clusters.updateCenter();//每次需要重新计算簇的中心
            if (i < iterationNum - 1) {
                clusters.clear();
            }//清空簇中的数据准备进行下一轮节点分配
        }
        return clusters;
    }

}
