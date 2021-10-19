package uz.pdp.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpa.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop,Integer> {
}
