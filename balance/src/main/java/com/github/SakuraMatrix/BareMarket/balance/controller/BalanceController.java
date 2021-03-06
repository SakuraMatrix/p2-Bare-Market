package com.github.SakuraMatrix.BareMarket.balance.controller;

import com.github.SakuraMatrix.BareMarket.balance.domain.Balance;
import com.github.SakuraMatrix.BareMarket.balance.service.BalanceService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/balances")
public class BalanceController {

    private BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping()
    public Mono<Balance> getBalance() {
        return balanceService.get();
    }

    @PutMapping()
    public Mono<Balance> setBalance(@RequestBody Balance balance) throws Exception {
        return balanceService.set(balance);
    }
}
