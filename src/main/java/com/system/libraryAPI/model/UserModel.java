package com.system.libraryAPI.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private LibraryModel library;

    // todo refactor to audit
    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    // todo refactor to audit
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id")
    private UserModel createdBy;


    //CONSTRUCTORS
    // employee/manager
    public UserModel(String email, String passwordHash, LibraryModel library, LocalDate createdAt, UserRole role, UserModel createdBy) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.library = library;
        this.createdAt = createdAt;
        this.role = role;
        this.createdBy = createdBy;
    }

    // owner
    public UserModel(String email, String passwordHash, LocalDate createdAt, UserRole role) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.createdAt = createdAt;
        this.role = role;
    }

    public UserModel() {
    }


    //GETTERS
    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public LibraryModel getLibrary() {
        return library;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public UserRole getRole() {
        return role;
    }

    public UserModel getCreatedBy() {
        return createdBy;
    }


    //SETTERS
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setLibrary(LibraryModel library) {
        this.library = library;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setCreatedBy(UserModel createdBy) {
        this.createdBy = createdBy;
    }
}
