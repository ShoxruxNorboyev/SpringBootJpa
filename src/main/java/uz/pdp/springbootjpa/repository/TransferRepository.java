package uz.pdp.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootjpa.entity.Transfer;

public interface TransferRepository extends JpaRepository<Transfer,Integer> {
}
