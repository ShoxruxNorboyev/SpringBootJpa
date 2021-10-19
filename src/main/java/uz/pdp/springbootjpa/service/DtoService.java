package uz.pdp.springbootjpa.service;

import uz.pdp.springbootjpa.entity.Product;
import uz.pdp.springbootjpa.payload.ProductDto;

public class DtoService {

    public static ProductDto getProductDto(Product product){
        return new ProductDto(product.getId(), product.getName());
    }
}
