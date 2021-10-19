package uz.pdp.springbootjpa.projections;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.springbootjpa.entity.Brand;

@Projection(types = Brand.class)
public interface CustomBrand {
    Integer getId();
    String getName();
}
