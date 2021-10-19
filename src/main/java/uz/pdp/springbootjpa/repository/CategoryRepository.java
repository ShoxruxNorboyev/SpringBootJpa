package uz.pdp.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpa.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
