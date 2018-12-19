package com.erp.application.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ProductCount entity.
 */
public class ProductCountDTO implements Serializable {

    private Long id;

    private Integer onHand;

    private Integer purchased;

    private Integer forecasted;

    private Integer sold;

    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOnHand() {
        return onHand;
    }

    public void setOnHand(Integer onHand) {
        this.onHand = onHand;
    }

    public Integer getPurchased() {
        return purchased;
    }

    public void setPurchased(Integer purchased) {
        this.purchased = purchased;
    }

    public Integer getForecasted() {
        return forecasted;
    }

    public void setForecasted(Integer forecasted) {
        this.forecasted = forecasted;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productInventoryViewId) {
        this.productId = productInventoryViewId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductCountDTO productCountDTO = (ProductCountDTO) o;
        if (productCountDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productCountDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductCountDTO{" +
            "id=" + getId() +
            ", onHand=" + getOnHand() +
            ", purchased=" + getPurchased() +
            ", forecasted=" + getForecasted() +
            ", sold=" + getSold() +
            ", product=" + getProductId() +
            "}";
    }
}
