package handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SellHandler implements InvocationHandler {
    private Object target=null;
    //构造函数传入对象
    public SellHandler(Object target){
        this.target=target;
    }
    //实现接口方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行目标方法
        Object res=method.invoke(target,args);
        //目标增强
        System.out.println("发出优惠券");
        if(res!=null) {
            float price=(float)res;
            res = price + 25;
        }
        return res;
    }
}
