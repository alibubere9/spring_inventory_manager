package com.rest.spring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MobilePhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @ManyToOne
    private Company company;

    @NotNull
    private String name;

    @NotNull
    private int internalStorage;

    @NotNull
    private int ram;

    @NotNull
    private int frontCamera;

    @NotNull
    private int rearCamera;

    @NotNull
    private Date createdOn;

    @NotNull
    private Date lastUpdated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MobilePhone)) return false;
        MobilePhone that = (MobilePhone) o;
        return id == that.id && internalStorage == that.internalStorage && ram == that.ram && frontCamera == that.frontCamera && rearCamera == that.rearCamera && Objects.equals(company, that.company) && Objects.equals(name, that.name) && Objects.equals(createdOn, that.createdOn) && Objects.equals(lastUpdated, that.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, name, internalStorage, ram, frontCamera, rearCamera, createdOn, lastUpdated);
    }
}
