package com.system.libraryAPI.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "items_rent")
public class ItemRentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookModel book;

    @ManyToOne
    @JoinColumn(name = "rent_id")
    private RentModel rent;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private LibraryModel library;

    @Column(nullable = false)
    private LocalDate expirationDate;

    private LocalDate retunedDate;

    private boolean returned;

    @ManyToOne
    @JoinColumn(name = "received_by_id")
    private UserModel receivedBy;


    //CONSTRUCTORS
    public ItemRentModel(BookModel book, RentModel rent, LibraryModel library, LocalDate expirationDate) {
        this.book = book;
        this.rent = rent;
        this.library = library;
        this.expirationDate = expirationDate;
        this.returned = false;
    }

    public ItemRentModel() {
    }


    //GETTERS
    public UUID getId() {
        return id;
    }

    public BookModel getBook() {
        return book;
    }

    public RentModel getRent() {
        return rent;
    }

    public LibraryModel getLibrary() {
        return library;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public LocalDate getRetunedDate() {
        return retunedDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public UserModel getReceivedBy() {
        return receivedBy;
    }


    //SETTERS
    public void setBook(BookModel book) {
        this.book = book;
    }

    public void setRent(RentModel rent) {
        this.rent = rent;
    }

    public void setLibrary(LibraryModel library) {
        this.library = library;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setRetunedDate(LocalDate retunedDate) {
        this.retunedDate = retunedDate;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public void setReceivedBy(UserModel receivedBy) {
        this.receivedBy = receivedBy;
    }
}
