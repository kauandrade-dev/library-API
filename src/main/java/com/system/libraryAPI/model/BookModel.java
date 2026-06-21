package com.system.libraryAPI.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "books")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String barcode;

    @Column(unique = true)
    private String bookCode;

    @Column(nullable = false)
    private String title;

    private String author;

    private String publisher;

    @Column(nullable = false)
    private boolean available;

    @Enumerated(EnumType.STRING)
    private BookCategory category;

    @Enumerated(EnumType.STRING)
    private BookLanguage language;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private LibraryModel library;

    @OneToMany(mappedBy = "book")
    private final List<ItemRentModel> itemRentList = new ArrayList<>();

    // todo to audit
    private LocalDate createdAt;


    //CONSTRUCTORS
    public BookModel(String barcode, String bookCode, String title, String author, String publisher, boolean available, BookCategory category, BookLanguage language, LibraryModel library, LocalDate createdAt) {
        this.barcode = barcode;
        this.bookCode = bookCode;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.available = available;
        this.category = category;
        this.language = language;
        this.library = library;
        this.createdAt = createdAt;
    }

    public BookModel() {
    }


    //GETTERS
    public UUID getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getBookCode() {
        return bookCode;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public boolean isAvailable() {
        return available;
    }

    public BookCategory getCategory() {
        return category;
    }

    public BookLanguage getLanguage() {
        return language;
    }

    public LibraryModel getLibrary() {
        return library;
    }

    public List<ItemRentModel> getItemRentList() {
        return itemRentList;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }


    //SETTERS
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public void setLanguage(BookLanguage language) {
        this.language = language;
    }

    public void setLibrary(LibraryModel library) {
        this.library = library;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }


    //LIST METHODS
    public void addItemRent(ItemRentModel itemRent) {
        this.itemRentList.add(itemRent);
        itemRent.setBook(this);
    }

    public void removeItemRent(ItemRentModel itemRent) {
        this.itemRentList.remove(itemRent);
        itemRent.setBook(null);
    }
}
