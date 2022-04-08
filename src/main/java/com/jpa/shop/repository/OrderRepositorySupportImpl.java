//package com.jpa.shop.repository;
//
//import com.jpa.shop.domain.Order;
//import com.jpa.shop.domain.OrderSearch;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class OrderRepositorySupportImpl implements OrderRepositorySupport {
//
//    private final JPAQueryFactory jpaQueryFactory;
//
//    @Autowired
//    public OrderRepositorySupportImpl(JPAQueryFactory jpaQueryFactory) {
//        this.jpaQueryFactory = jpaQueryFactory;
//    }
//
////    @Override
////    public List<Order> findAll(OrderSearch orderSearch) {
////        return jpaQueryFactory.selectFrom(order)
////                        .where(order.member.name.eq(orderSearch.getMemberName())
////                                ,(order.status.eq(orderSearch.getOrderStatus())))
////                        .fetch();
////    }
//}
