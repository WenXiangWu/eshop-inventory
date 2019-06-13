package com.roncoo.eshop.inventory.model;

/**
 * @ClassName ProductInventory
 * @Description 库存数量Model
 * @Author wuwenxiang
 * @Date 2019-06-13 22:26
 * @Version 1.0
 **/
public class ProductInventory {
    /**
     * 商品Id
     */
    private Integer productId;
    /**
     * 库存数量；
     */
    private Long inventoryCnt;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getInventoryCnt() {
        return inventoryCnt;
    }

    public void setInventoryCnt(Long inventoryCnt) {
        this.inventoryCnt = inventoryCnt;
    }

    public ProductInventory(Integer productId, Long inventoryCnt) {
        this.productId = productId;
        this.inventoryCnt = inventoryCnt;
    }

    public ProductInventory() {
    }
}
