package com.user.pk3;

/**
 * @ClassName SomeService
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public sealed interface SomeService permits SomeServiceImpl {
    void printf();
}
