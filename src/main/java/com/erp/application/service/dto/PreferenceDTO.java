package com.erp.application.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;
import com.erp.application.domain.enumeration.NotificationManagement;

/**
 * A DTO for the Preference entity.
 */
public class PreferenceDTO implements Serializable {

    private Long id;

    @NotNull
    private String language;

    private NotificationManagement notification;

    private String alias;

    @Lob
    private String signature;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public NotificationManagement getNotification() {
        return notification;
    }

    public void setNotification(NotificationManagement notification) {
        this.notification = notification;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PreferenceDTO preferenceDTO = (PreferenceDTO) o;
        if (preferenceDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), preferenceDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PreferenceDTO{" +
            "id=" + getId() +
            ", language='" + getLanguage() + "'" +
            ", notification='" + getNotification() + "'" +
            ", alias='" + getAlias() + "'" +
            ", signature='" + getSignature() + "'" +
            "}";
    }
}
