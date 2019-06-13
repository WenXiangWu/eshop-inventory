package com.roncoo.eshop.inventory.request;

import com.roncoo.eshop.inventory.model.ProductInventory;
import com.roncoo.eshop.inventory.service.ProductInventoryService;

/**
 * @ClassName ProductInventoryCacheReloadRequest
 * @Description 重新加载商品库存的缓存；
 * @Author wuwenxiang
 * @Date 2019-06-13 22:48
 * @Version 1.0
 **/
public class ProductInventoryCacheReloadRequest implements Request {

    //商品id
    private Integer productId;
    //商品库存service
    private ProductInventoryService productInventoryService;

    public ProductInventoryCacheReloadRequest(Integer productId, ProductInventoryService productInventoryService) {
        this.productId = productId;
        this.productInventoryService = productInventoryService;
    }

    @Override
    public void process() {
        //1.从数据库中查询最新的数据：
        ProductInventory productInventory = productInventoryService.findProductInventory(productId);
        //2.将数据放入缓存；
        productInventoryService.setProductInventoryCache(productInventory);
    }
}
