package com.system.libraryAPI.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "libraries")
public class LibraryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String name;

    private String contact;

    @OneToMany(mappedBy = "library")
    private final List<UserModel> employees = new ArrayList<>();

    // todo refactor to audit
    @OneToOne
    @JoinColumn(name = "owner_id")
    private UserModel owner;

    @OneToMany(mappedBy = "library")
    private final List<BookModel> bookList = new ArrayList<>();

    @OneToMany(mappedBy = "library")
    private final List<RentModel> rentList = new ArrayList<>();

    @OneToMany(mappedBy = "library")
    private final List<ItemRentModel> itemRentList = new ArrayList<>();


    //CONSTRUCTORS
    public LibraryModel(String cnpj, String name, String contact, UserModel owner) {
        this.cnpj = cnpj;
        this.name = name;
        this.contact = contact;
        this.owner = owner;
    }

    public LibraryModel() {
    }


    //GETTERS
    public UUID getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public List<UserModel> getEmployees() {
        return employees;
    }

    public UserModel getOwner() {
        return owner;
    }

    public List<BookModel> getBookList() {
        return bookList;
    }

    public List<RentModel> getRentList() {
        return rentList;
    }

    public List<ItemRentModel> getItemRentList() {
        return itemRentList;
    }


    //SETTERS
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    //LIST METHODS
    public void addEmployee(UserModel user) {
        this.employees.add(user);
        user.setLibrary(this);
    }

    public void removeEmployee(UserModel user) {
        this.employees.remove(user);
        user.setLibrary(null);
    }

    public void addBook(BookModel book) {
        this.bookList.add(book);
        book.setLibrary(this);
    }

    public void removeBook(BookModel book) {
        this.bookList.remove(book);
        book.setLibrary(null);
    }

    public void addRent(RentModel rent) {
        this.rentList.add(rent);
        rent.setLibrary(this);
    }

    public void removeRent(RentModel rent) {
        this.rentList.remove(rent);
        rent.setLibrary(null);
    }

    public void addItemRent(ItemRentModel itemRent) {
        this.itemRentList.add(itemRent);
        itemRent.setLibrary(this);
    }

    public void removeItemRent(ItemRentModel itemRent) {
        this.itemRentList.remove(itemRent);
        itemRent.setLibrary(null);
    }
}
