package uz.pdp.springbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springbootjpa.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/productCountByProductIdAndShopId/{productId}/{shopId}")
    public HttpEntity<?> productCountByProductIdAndShopId(@PathVariable Integer productId,
                                      @PathVariable Integer shopId){
        return ResponseEntity.ok(dashboardService.productCountByProductIdAndShopId(productId,shopId));
    }
}
