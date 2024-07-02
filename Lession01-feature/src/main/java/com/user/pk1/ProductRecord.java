package com.user.pk1;

/**
 * @ClassName ProductRecord
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public record ProductRecord(String id,String name,Integer qty) implements PrintInterface{

    @Override
    public void printf() {
        String productDesc = String.join("-", id,name,qty.toString());
        System.out.println("商品信息 ="+productDesc);
    }
}
