package uz.pdp.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpa.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
