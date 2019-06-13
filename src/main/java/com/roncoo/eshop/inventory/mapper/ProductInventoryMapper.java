package com.roncoo.eshop.inventory.mapper;

import com.roncoo.eshop.inventory.model.ProductInventory;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName ProductInventoryMapper
 * @Description 商品库存mapper
 * @Author wuwenxiang
 * @Date 2019-06-13 22:24
 * @Version 1.0
 **/
public interface ProductInventoryMapper {
    /**
     * 更新库存数量；
     */
    void updateInventoryCnt(ProductInventory productInventory);

    /**
     * 根据商品id从数据库中查询库存信息；
     *
     * @param productId
     * @return
     */
    ProductInventory findProductInventory(@Param("productId") Integer productId);
}
