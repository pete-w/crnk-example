package io.crnk.example.service.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.crnk.core.resource.annotations.JsonApiEmbeddable;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiRelationId;

/**
 * Identifier for nested Secret resource.
 */
@JsonApiEmbeddable
@JsonSerialize(using = ToStringSerializer.class)
public class SecretId {

    /**
     * Id of the secret.
     */
    @JsonApiId
    private String id;

    /**
     * Id of the parent login resource.
     */
    @JsonApiRelationId
    private String loginId;

    public SecretId() {
    }


    public SecretId(String idString) {
        String[] elements = idString.split("\\-");
        loginId = elements[0];
        id = elements[1];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof SecretId && object.toString().equals(toString());
    }

    @Override
    public String toString() {
        return loginId + "-" + id;
    }
}
