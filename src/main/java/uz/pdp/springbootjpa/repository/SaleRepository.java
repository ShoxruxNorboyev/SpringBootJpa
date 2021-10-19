package uz.pdp.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpa.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
