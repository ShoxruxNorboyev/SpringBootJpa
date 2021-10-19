package uz.pdp.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpa.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse,Integer> {
}
