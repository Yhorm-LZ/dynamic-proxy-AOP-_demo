import factory.UsbFactory;
import handler.SellHandler;
import service.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class mainSell {
    public static void main(String[] args) {
        //创建对象
        UsbSell fac=new UsbFactory();
        //创建InvocationHandler对象
        InvocationHandler handler=new SellHandler(fac);
        //创建动态代理对象，并强制转换为接口类型
        UsbSell proxy=(UsbSell)Proxy.newProxyInstance(fac.getClass().getClassLoader(),
                fac.getClass().getInterfaces(),
                handler);
        //通过代理执行方法
        float price=proxy.sell(1);
        System.out.println("通过动态代理对象，调用方法，价格为："+price);
    }
}
