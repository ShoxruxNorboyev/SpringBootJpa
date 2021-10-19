package uz.pdp.springbootjpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.springbootjpa.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "select((select coalesce(sum(amount), 0)from product_with_amount pwa join product p2 on p2.id = pwa.product_id and p2.id=:pId join transfer t on t.id = pwa.transfer_id join warehouse w on w.id = t.to_warehouse_id and w.shop_id = (select id from shop where id = :shId))+(select coalesce(sum(amount), 0)from product_with_amount pwa join product p2 on p2.id = pwa.product_id and p2.id=:pId join reject r on r.id = pwa.reject_id join shop s on s.id = r.shop_id and s.id=:shId)-(select coalesce(sum(amount), 0)from product_with_amount pwa join product p2 on p2.id = pwa.product_id and p2.id=:pId join transfer t on t.id = pwa.transfer_id join warehouse w on w.id = t.from_warehouse_id and w.shop_id = (select id from shop where id = :shId))-(select coalesce(sum(amount), 0)from product_with_amount pwa join product p2 on p2.id = pwa.product_id and p2.id=:pId join defect d on d.id = pwa.defect_id join warehouse w2 on w2.id = d.warehouse_id and w2.shop_id = (select id from shop where id = :shId))-(select coalesce(sum(amount), 0)from product_with_amount pwa join product p2 on p2.id = pwa.product_id and p2.id=:pId join sale s2 on s2.id = pwa.sale_id join shop s3 on s3.id = s2.shop_id and s3.id=:shId)) as pCount from product p where p.id = :pId",nativeQuery = true)
    Integer productCountByIdAndShopId(@Param("pId")Integer pId,@Param("shId")Integer shId);


    List<Product> findAllByNameStartsWithIgnoringCase(String name);

    List<Product> findAllByNameStartsWith(String name);

    Page<Product> findAllByName(String name, Pageable pageable);
}
