//package com.mmall.service.impl;
//
//import com.google.common.collect.Lists;
//import com.mmall.common.Const;
//import com.mmall.common.ServerResponse;
//import com.mmall.dao.CartMapper;
//import com.mmall.dao.OrderItemMapper;
//import com.mmall.dao.OrderMapper;
//import com.mmall.dao.ProductMapper;
//import com.mmall.pojo.Cart;
//import com.mmall.pojo.Order;
//import com.mmall.pojo.OrderItem;
//import com.mmall.pojo.Product;
//import com.mmall.service.IOrderService;
//import com.mmall.util.BigDecimalUtil;
//import org.apache.commons.collections.CollectionUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.List;
//
///**
// * @author yejunyu
// * @date 18-3-12.
// */
//@Service("iOrderService")
//public class OrderServiceImpl implements IOrderService {
//
//    @Autowired
//    private OrderMapper orderMapper;
//
//    @Autowired
//    private OrderItemMapper orderItemMapper;
//
//    @Autowired
//    private CartMapper cartMapper;
//
//    @Autowired
//    private ProductMapper productMapper;
//
//    @Override
//    public ServerResponse createOrder(Integer userId, Integer shippingId) {
//        // 从购物车中获取数据
//        List<Cart> cartList = cartMapper.selectCartByUserId(userId);
//        // 计算订单总价
//        ServerResponse serverResponse = this.getCartOrderItem(userId, cartList);
//        if (!serverResponse.isSuccess()) {
//            return ServerResponse.createByError();
//        }
//        List<OrderItem> orderItemList = (List<OrderItem>) serverResponse.getData();
//        BigDecimal payment = this.getOrderTotalPrice(orderItemList);
//        // 生成订单
//        Order order = this.assembleOrder(userId, shippingId, payment);
//
//        return null;
//    }
//
//    private long generateOrderNo() {
//        long currentTime = System.currentTimeMillis();
//        return currentTime % 10;
//    }
//
//    private Order assembleOrder(Integer userId, Integer shippingId, BigDecimal payment) {
//        Order order = new Order();
//        long orderNo = this.generateOrderNo();
//        order.setOrderNo(orderNo);
//        order.setStatus(Const.OrderStatusEnum.NO_PAY.getCode());
//        order.setPostage(0);
//        order.setPaymentType(Const.PaymentTypeEnum.ONLINE_PAY.getCode());
//        order.setPayment(payment);
//
//        order.setUserId(userId);
//        order.setShippingId(shippingId);
//        //发货时间等等
//        //付款时间等等
//        int rowCount = orderMapper.insert(order);
//        if (rowCount > 0) {
//            return order;
//        }
//        return null;
//    }
//
//    private BigDecimal getOrderTotalPrice(List<OrderItem> orderItemList) {
//        BigDecimal payment = new BigDecimal("0");
//        for (OrderItem orderItem : orderItemList) {
//            BigDecimalUtil.add(payment.doubleValue(), orderItem.getTotalPrice().doubleValue());
//        }
//        return payment;
//    }
//
//    private ServerResponse<List<OrderItem>> getCartOrderItem(Integer userId, List<Cart> cartList) {
//        List<OrderItem> orderItemList = Lists.newArrayList();
//        if (CollectionUtils.isEmpty(cartList)) {
//            return ServerResponse.createByErrorMessage("购物车为空");
//        }
//
//        //校验购物车的数据,包括产品的状态和数量
//        for (Cart cartItem : cartList) {
//            OrderItem orderItem = new OrderItem();
//            Product product = productMapper.selectByPrimaryKey(cartItem.getProductId());
//            if (Const.ProductStatusEnum.ON_SALE.getCode() != product.getStatus()) {
//                return ServerResponse.createByErrorMessage("产品" + product.getName() + "不是在线售卖状态");
//            }
//
//            //校验库存
//            if (cartItem.getQuantity() > product.getStock()) {
//                return ServerResponse.createByErrorMessage("产品" + product.getName() + "库存不足");
//            }
//
//            orderItem.setUserId(userId);
//            orderItem.setProductId(product.getId());
//            orderItem.setProductName(product.getName());
//            orderItem.setProductImage(product.getMainImage());
//            orderItem.setCurrentUnitPrice(product.getPrice());
//            orderItem.setQuantity(cartItem.getQuantity());
//            orderItem.setTotalPrice(BigDecimalUtil.mul(product.getPrice().doubleValue(), cartItem.getQuantity()));
//            orderItemList.add(orderItem);
//        }
//        return ServerResponse.createBySuccess(orderItemList);
//    }
//}
