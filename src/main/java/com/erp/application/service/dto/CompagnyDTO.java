package com.erp.application.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;
import com.erp.application.domain.enumeration.Incoterm;

/**
 * A DTO for the Compagny entity.
 */
public class CompagnyDTO implements Serializable {

    private Long id;

    @NotNull
    private String compagnyName;

    private String website;

    @Lob
    private byte[] logo;
    private String logoContentType;

    private String street;

    private String street2;

    @NotNull
    private String city;

    private String state;

    @NotNull
    @Size(min = 5)
    private String zipCode;

    @NotNull
    @Size(min = 3)
    private String country;

    private String phone;

    private String email;

    private String vAT;

    private String compagnyRegistry;

    private String siret;

    private String currency;

    private Incoterm defaultIncoterm;

    private Boolean active;

    private Long erpId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompagnyName() {
        return compagnyName;
    }

    public void setCompagnyName(String compagnyName) {
        this.compagnyName = compagnyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getLogoContentType() {
        return logoContentType;
    }

    public void setLogoContentType(String logoContentType) {
        this.logoContentType = logoContentType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getvAT() {
        return vAT;
    }

    public void setvAT(String vAT) {
        this.vAT = vAT;
    }

    public String getCompagnyRegistry() {
        return compagnyRegistry;
    }

    public void setCompagnyRegistry(String compagnyRegistry) {
        this.compagnyRegistry = compagnyRegistry;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Incoterm getDefaultIncoterm() {
        return defaultIncoterm;
    }

    public void setDefaultIncoterm(Incoterm defaultIncoterm) {
        this.defaultIncoterm = defaultIncoterm;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getErpId() {
        return erpId;
    }

    public void setErpId(Long erpId) {
        this.erpId = erpId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CompagnyDTO compagnyDTO = (CompagnyDTO) o;
        if (compagnyDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), compagnyDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CompagnyDTO{" +
            "id=" + getId() +
            ", compagnyName='" + getCompagnyName() + "'" +
            ", website='" + getWebsite() + "'" +
            ", logo='" + getLogo() + "'" +
            ", street='" + getStreet() + "'" +
            ", street2='" + getStreet2() + "'" +
            ", city='" + getCity() + "'" +
            ", state='" + getState() + "'" +
            ", zipCode='" + getZipCode() + "'" +
            ", country='" + getCountry() + "'" +
            ", phone='" + getPhone() + "'" +
            ", email='" + getEmail() + "'" +
            ", vAT='" + getvAT() + "'" +
            ", compagnyRegistry='" + getCompagnyRegistry() + "'" +
            ", siret='" + getSiret() + "'" +
            ", currency='" + getCurrency() + "'" +
            ", defaultIncoterm='" + getDefaultIncoterm() + "'" +
            ", active='" + isActive() + "'" +
            ", erp=" + getErpId() +
            "}";
    }
}
