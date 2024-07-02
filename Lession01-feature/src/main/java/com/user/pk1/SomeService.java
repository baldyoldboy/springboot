package com.user.pk1;

/**
 * @ClassName SomeService
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public class SomeService {

    public boolean isAdult(Object obj){
        if (obj instanceof PeoPle peoPle){
            return peoPle.age()>= 18;
        }
        return false;
    }
}
