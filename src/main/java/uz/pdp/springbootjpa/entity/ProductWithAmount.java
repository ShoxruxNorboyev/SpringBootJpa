package uz.pdp.springbootjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.springbootjpa.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductWithAmount extends AbsEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(nullable = false)
    private Integer amount;

    private Double soldPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private Transfer transfer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sale sale;

    @ManyToOne(fetch = FetchType.LAZY)
    private Reject reject;

    @ManyToOne(fetch = FetchType.LAZY)
    private Defect defect;

    public ProductWithAmount(Product product, Integer amount, Transfer transfer) {
        this.product = product;
        this.amount = amount;
        this.transfer = transfer;
    }

    public ProductWithAmount(Product product, Integer amount, Sale sale) {
        this.product = product;
        this.amount = amount;
        this.sale = sale;
    }

    public ProductWithAmount(Product product, Integer amount, Reject reject) {
        this.product = product;
        this.amount = amount;
        this.reject = reject;
    }

    public ProductWithAmount(Product product, Integer amount, Defect defect) {
        this.product = product;
        this.amount = amount;
        this.defect = defect;
    }
}
