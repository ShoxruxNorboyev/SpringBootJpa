package uz.pdp.springbootjpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import uz.pdp.springbootjpa.entity.Brand;
import uz.pdp.springbootjpa.projections.CustomBrand;

@RepositoryRestResource(path = "brand",collectionResourceRel = "objs",excerptProjection = CustomBrand.class)
public interface BrandRepository extends JpaRepository<Brand,Integer> {

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    public Page findByNameStartsWith(@Param("name") String name, Pageable p);

}
