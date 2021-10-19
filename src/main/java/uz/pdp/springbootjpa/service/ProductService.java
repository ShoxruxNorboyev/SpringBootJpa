package uz.pdp.springbootjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import uz.pdp.springbootjpa.entity.Product;
import uz.pdp.springbootjpa.payload.ApiResponse;
import uz.pdp.springbootjpa.repository.ProductRepository;
import uz.pdp.springbootjpa.utills.CommonUtills;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;


    public List<Product> searchByName(String search) {
        return productRepository.findAllByNameStartsWithIgnoringCase(search);
    }

    public ApiResponse allByPageable(Integer page, Integer size) {
        Page<Product> productPage = productRepository.findAll(CommonUtills.simplePageable(page, size));
        return new ApiResponse("Ok",true,productPage.getContent().stream().map(product->DtoService.getProductDto(product)).collect(Collectors.toList()),productPage.getTotalElements());
    }
}
