package com.user.exceptionhandler.vo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * @ClassName OrderVo
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@Data
public class OrderVO {
    @NotBlank(message = "订单名称不能为空")
    private String name;
    @NotNull(message = "商品必须有数量")
    @Range(min = 1,max = 100,message = "一个商品的数量在{min}-{max}")
    private Integer amount;
    @NotNull(message = "用户不能为空")
    @Min(value = 1,message = "Id从1开始")
    private Integer userId;

}
