package com.erp.application.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;
import com.erp.application.domain.enumeration.ProductType;

/**
 * A DTO for the Product entity.
 */
public class ProductDTO implements Serializable {

    private Long id;

    private String name;

    private Boolean canBeSold;

    private Boolean canBePurchased;

    private ProductType productType;

    private String productCategory;

    private String internalReference;

    private Double salesPrice;

    private Double cost;

    @Lob
    private byte[] barCode;
    private String barCodeContentType;

    @Lob
    private String internalNotes;

    private Boolean active;

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

    public Boolean isCanBeSold() {
        return canBeSold;
    }

    public void setCanBeSold(Boolean canBeSold) {
        this.canBeSold = canBeSold;
    }

    public Boolean isCanBePurchased() {
        return canBePurchased;
    }

    public void setCanBePurchased(Boolean canBePurchased) {
        this.canBePurchased = canBePurchased;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getInternalReference() {
        return internalReference;
    }

    public void setInternalReference(String internalReference) {
        this.internalReference = internalReference;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public byte[] getBarCode() {
        return barCode;
    }

    public void setBarCode(byte[] barCode) {
        this.barCode = barCode;
    }

    public String getBarCodeContentType() {
        return barCodeContentType;
    }

    public void setBarCodeContentType(String barCodeContentType) {
        this.barCodeContentType = barCodeContentType;
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    public void setInternalNotes(String internalNotes) {
        this.internalNotes = internalNotes;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductDTO productDTO = (ProductDTO) o;
        if (productDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", canBeSold='" + isCanBeSold() + "'" +
            ", canBePurchased='" + isCanBePurchased() + "'" +
            ", productType='" + getProductType() + "'" +
            ", productCategory='" + getProductCategory() + "'" +
            ", internalReference='" + getInternalReference() + "'" +
            ", salesPrice=" + getSalesPrice() +
            ", cost=" + getCost() +
            ", barCode='" + getBarCode() + "'" +
            ", internalNotes='" + getInternalNotes() + "'" +
            ", active='" + isActive() + "'" +
            "}";
    }
}
