package uz.pdp.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpa.entity.Defect;

public interface DefectRepository extends JpaRepository<Defect,Integer> {
}
