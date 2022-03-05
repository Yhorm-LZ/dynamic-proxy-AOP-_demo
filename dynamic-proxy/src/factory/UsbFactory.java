package factory;

import service.UsbSell;

public class UsbFactory implements UsbSell {
    @Override
    public float sell(int num) {
        System.out.println("目标方法中执行sell");
        return 85.0f*num;
    }
}
