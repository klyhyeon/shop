package com.jpa.shop.logger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoggerServiceTest {
    
    @Autowired
    private LoggerService loggerService;
    
    @Test
    @DisplayName("로깅테스트")
    void 로깅테스트() {
        loggerService.doStuff("테스트중:INFO");
    }
            
}