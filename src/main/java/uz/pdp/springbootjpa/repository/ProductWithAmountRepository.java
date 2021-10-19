package uz.pdp.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpa.entity.ProductWithAmount;

public interface ProductWithAmountRepository extends JpaRepository<ProductWithAmount,Integer> {
}
