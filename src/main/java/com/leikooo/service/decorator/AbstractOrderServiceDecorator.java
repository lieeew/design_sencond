package com.leikooo.service.decorator;

import com.leikooo.pojo.Order;
import com.leikooo.service.inner.OrderServiceInterface;

/**
 * @author <a href="https://github.com/lieeew">leikooo</a>
 * @data 2024/1/20
 * @description 装饰器模式
 */
public abstract class AbstractOrderServiceDecorator implements OrderServiceInterface {
    private OrderServiceInterface orderServiceInterface;

    public void setOrderServiceInterface(OrderServiceInterface orderServiceInterface) {
        this.orderServiceInterface = orderServiceInterface;
    }

    @Override
    public Order createOrder(String productId) {
        return this.orderServiceInterface.createOrder(productId);
    }

    @Override
    public Order payOrder(String orderId) {
        return this.orderServiceInterface.payOrder(orderId);
    }

    @Override
    public Order sendOrder(String orderId) {
        return this.orderServiceInterface.sendOrder(orderId);
    }

    @Override
    public Order receiveOrder(String orderId) {
        return this.orderServiceInterface.receiveOrder(orderId);
    }

    @Override
    public String getPayUrl(String orderId, Integer payType, Float price) {
        return this.orderServiceInterface.getPayUrl(orderId, payType, price);
    }

    @Override
    public void friendlyPay(String sourceCustomer, String orderId, String targetCustomer, String payResult, String role) {
        this.orderServiceInterface.friendlyPay(sourceCustomer, orderId, targetCustomer, payResult, role);
    }

    /**
     * 定义新的方法，根据 userId 和 productId 更新用户积分和发放红包
     *
     * @param productId
     * @param serviceLevel
     * @param price
     */
    public abstract void updateScoreAndSendRedPaper(String productId, int serviceLevel, float price);
}
