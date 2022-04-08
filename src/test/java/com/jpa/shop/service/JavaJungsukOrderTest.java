package com.jpa.shop.service;

import com.jpa.shop.domain.BasketballChild;
import com.jpa.shop.domain.ClothesChild;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaJungsukOrderTest {


    @Test
    @DisplayName("자바의 정석 다형성 Product 테스트")
    void productOrderTest() {
        OrderService os = new OrderService();
        ClothesChild cc = ClothesChild.getInstance();
        os.order(cc, 1);
        ClothesChild cc2 = ClothesChild.getInstance();
        assertThat(os.order(cc2, 4)).isTrue();
    }

    @Test
    @DisplayName("자바의 정석 인터페이스 다형성 테스트")
    void productOrderInterfaceTest() {
        BasketballChild bc = new BasketballChild();
        OrderService os = new OrderService();
        os.order(bc, 1);
    }
}
