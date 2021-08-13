package com.jpa.shop.controller;

import com.jpa.shop.service.EtherinumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EtheriumController {

    private EtherinumService etherinumService;

    private final String apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbklkeCI6NDQzNTcsImdyb3VwSWR4IjozOTQ1NSwidXNlcklkeCI6MzY2MzcsInR5cGUiOiJhcGkiLCJzZXJ2aWNlSWR4IjoyLCJyZXNvdXJjZUlkeCI6NDkyMCwiaWF0IjoxNjI4NDc0MzEyfQ.yb5Uqe8ph9mMvFverfBDqwR0CUqhK2YYExm2S3HUbq8";

    @Autowired
    public EtheriumController(EtherinumService etherinumService) {
        this.etherinumService = etherinumService;
    }

    //==트랜잭션 조회==
    @RequestMapping(value = "/get/transactions", method = RequestMethod.GET)
    public ResponseEntity getTransactions() {
        return ResponseEntity.ok().header(apiKey).body("");
    }
}
