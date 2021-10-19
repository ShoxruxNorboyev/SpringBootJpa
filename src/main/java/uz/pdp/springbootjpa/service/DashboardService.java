package uz.pdp.springbootjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootjpa.repository.ProductRepository;

@Service
public class DashboardService {

    @Autowired
    ProductRepository productRepository;

    public Integer productCountByProductIdAndShopId(Integer productId, Integer shopId) {
        return productRepository.productCountByIdAndShopId(productId,shopId);
    }
}
