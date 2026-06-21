package com.system.libraryAPI.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "rents")
public class RentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // todo refactor to audit
    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(nullable = false)
    private boolean closed;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private CostumerModel costumer;

    @ManyToOne
    @JoinColumn(name = "closed_By_id")
    private UserModel closedBy;

    // todo refactor to audit
    @ManyToOne
    @JoinColumn(name = "created_By_id")
    private UserModel createdBy;

    @OneToMany(mappedBy = "rent")
    private final List<ItemRentModel> itemList = new ArrayList<>();

    private String observation;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private LibraryModel library;


    //CONSTRUCTORS
    public RentModel(LocalDate createdAt, LocalDate expirationDate, CostumerModel costumer, UserModel closedBy, UserModel createdBy, String observation, LibraryModel library) {
        this.createdAt = createdAt;
        this.expirationDate = expirationDate;
        this.closed = false;
        this.costumer = costumer;
        this.closedBy = closedBy;
        this.createdBy = createdBy;
        this.observation = observation;
        this.library = library;
    }

    public RentModel() {
    }


    //GETTERS
    public UUID getId() {
        return id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public boolean isClosed() {
        return closed;
    }

    public CostumerModel getCostumer() {
        return costumer;
    }

    public UserModel getClosedBy() {
        return closedBy;
    }

    public UserModel getCreatedBy() {
        return createdBy;
    }

    public List<ItemRentModel> getItemList() {
        return itemList;
    }

    public String getObservation() {
        return observation;
    }

    public LibraryModel getLibrary() {
        return library;
    }


    //SETTERS
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public void setCostumer(CostumerModel costumer) {
        this.costumer = costumer;
    }

    public void setClosedBy(UserModel closedBy) {
        this.closedBy = closedBy;
    }

    public void setCreatedBy(UserModel createdBy) {
        this.createdBy = createdBy;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public void setLibrary(LibraryModel library) {
        this.library = library;
    }


    //LIST METHODS
    public void addItem(ItemRentModel item) {
        this.itemList.add(item);
        item.setRent(this);
    }

    public void removeItem(ItemRentModel item) {
        this.itemList.remove(item);
        item.setRent(null);
    }
}
