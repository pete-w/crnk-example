package io.crnk.example.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiResource;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents a person involed with a movie through roles.
 */
@JsonApiResource(type = "person")
@Entity
public class PersonEntity {

    @Id
    private UUID id;

    @JsonProperty
    private String name;

    private int year;

    @OneToMany(mappedBy = "movie")
    private List<RoleEntity> roles = new ArrayList<>();

    @Version
    private Integer version;

    public PersonEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
