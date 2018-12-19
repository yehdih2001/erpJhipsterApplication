package com.erp.application.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ProductReodringRules entity.
 */
public class ProductReodringRulesDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    private Integer minimumQuantity;

    private Integer maximumQuantity;

    private Integer quantityMultiple;

    private Integer leadTime;

    private Boolean active;

    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Integer minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public Integer getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(Integer maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public Integer getQuantityMultiple() {
        return quantityMultiple;
    }

    public void setQuantityMultiple(Integer quantityMultiple) {
        this.quantityMultiple = quantityMultiple;
    }

    public Integer getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

        ProductReodringRulesDTO productReodringRulesDTO = (ProductReodringRulesDTO) o;
        if (productReodringRulesDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productReodringRulesDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductReodringRulesDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", minimumQuantity=" + getMinimumQuantity() +
            ", maximumQuantity=" + getMaximumQuantity() +
            ", quantityMultiple=" + getQuantityMultiple() +
            ", leadTime=" + getLeadTime() +
            ", active='" + isActive() + "'" +
            ", product=" + getProductId() +
            "}";
    }
}
