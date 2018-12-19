package com.erp.application.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the ProductInventoryView entity.
 */
public class ProductInventoryViewDTO implements Serializable {

    private Long id;

    private Double weightInKg;

    private Double volumeInMetercube;

    @Lob
    private String descriptionForDeliveryOrders;

    @Lob
    private String descriptionForReceipts;

    private Integer customerLeadTime;

    private Long productId;

    private Long responsibleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(Double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public Double getVolumeInMetercube() {
        return volumeInMetercube;
    }

    public void setVolumeInMetercube(Double volumeInMetercube) {
        this.volumeInMetercube = volumeInMetercube;
    }

    public String getDescriptionForDeliveryOrders() {
        return descriptionForDeliveryOrders;
    }

    public void setDescriptionForDeliveryOrders(String descriptionForDeliveryOrders) {
        this.descriptionForDeliveryOrders = descriptionForDeliveryOrders;
    }

    public String getDescriptionForReceipts() {
        return descriptionForReceipts;
    }

    public void setDescriptionForReceipts(String descriptionForReceipts) {
        this.descriptionForReceipts = descriptionForReceipts;
    }

    public Integer getCustomerLeadTime() {
        return customerLeadTime;
    }

    public void setCustomerLeadTime(Integer customerLeadTime) {
        this.customerLeadTime = customerLeadTime;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getResponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(Long appUserId) {
        this.responsibleId = appUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductInventoryViewDTO productInventoryViewDTO = (ProductInventoryViewDTO) o;
        if (productInventoryViewDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productInventoryViewDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductInventoryViewDTO{" +
            "id=" + getId() +
            ", weightInKg=" + getWeightInKg() +
            ", volumeInMetercube=" + getVolumeInMetercube() +
            ", descriptionForDeliveryOrders='" + getDescriptionForDeliveryOrders() + "'" +
            ", descriptionForReceipts='" + getDescriptionForReceipts() + "'" +
            ", customerLeadTime=" + getCustomerLeadTime() +
            ", product=" + getProductId() +
            ", responsible=" + getResponsibleId() +
            "}";
    }
}
