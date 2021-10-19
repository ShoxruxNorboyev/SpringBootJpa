package uz.pdp.springbootjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.springbootjpa.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transfer extends AbsEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse fromWarehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    private Warehouse toWarehouse;

    private boolean approved;

    public Transfer(Warehouse toWarehouse, boolean approved) {
        this.toWarehouse = toWarehouse;
        this.approved = approved;
    }
}
