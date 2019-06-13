package com.roncoo.eshop.inventory.request;

import com.roncoo.eshop.inventory.model.ProductInventory;
import com.roncoo.eshop.inventory.service.ProductInventoryService;

/**
 * @ClassName ProductInventoryDBUpdateRequest
 * @Description 比如说一个商品发送了交易，那么就要修改这个商品对应的库存；
 * 此时就会发送请求过来，要求修改库存，那么这个可能就是数据更新曲奇；
 * <p>
 * 1.删除缓存；
 * 2.更新数据库；
 * @Author wuwenxiang
 * @Date 2019-06-13 22:17
 * @Version 1.0
 **/
public class ProductInventoryDBUpdateRequest implements Request {

    //商品库存
    private ProductInventory productInventory;
    //商品库存service
    private ProductInventoryService productInventoryService;

    public ProductInventoryDBUpdateRequest(ProductInventory productInventory, ProductInventoryService productInventoryService) {
        this.productInventory = productInventory;
        this.productInventoryService = productInventoryService;
    }

    @Override
    public void process() {
        //1.删除redis缓存；
        productInventoryService.removeProductInventoryCache(productInventory);
        //2.更新数据库中的库存；
        productInventoryService.updateProductInventory(productInventory);
    }
}
