package com.system.libraryAPI.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "costumers")
public class CostumerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String document;

    @OneToMany(mappedBy = "costumer")
    private final List<RentModel> rentList = new ArrayList<>();

    // todo refactor to audit
    @Column(nullable = false)
    private LocalDate createdAt;


    //CONSTRUCTORS
    public CostumerModel(String name, String document, LocalDate createdAt) {
        this.name = name;
        this.document = document;
        this.createdAt = createdAt;
    }

    public CostumerModel() {
    }


    //GETTERS
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public List<RentModel> getRentList() {
        return rentList;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }


    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }


    //LIST METHODS
    public void addRent(RentModel rent) {
        this.rentList.add(rent);
        rent.setCostumer(this);
    }

    public void removeRent(RentModel rent) {
        this.rentList.remove(rent);
        rent.setCostumer(null);
    }
}
