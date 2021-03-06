package com.github.SakuraMatrix.BareMarket.lookup.controller;

import com.github.SakuraMatrix.BareMarket.lookup.domain.StockInfo;
import com.github.SakuraMatrix.BareMarket.lookup.service.StockLookupService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/search")
public class StockLookupController {
    private StockLookupService stockLookupService;

    public StockLookupController(StockLookupService stockLookupService) {
        this.stockLookupService = stockLookupService;
    }

    @GetMapping("/{symbol}")
    public Mono<StockInfo> search(@PathVariable String symbol) {
        return stockLookupService.search(symbol);
    }
}
