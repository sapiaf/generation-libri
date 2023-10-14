package org.generation.libri.generationlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Book {
    /*Aggiungere variabile per la casa editrice e l'anno di pubblicazione*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Inserisci un nome.")
    @Size(min = 1, max = 100)
    private String name;
    @NotBlank(message = "Inserisci un URL per la foto.")
    private String urlPhoto;
    @NotBlank
    @Size(min = 10, max = 2048, message = "Il testo della descrizione deve essere tra 10 e 2048 caratteri.")
    private String description;
    @NotBlank
    @Size(min = 1, max = 100, message = "Il testo della descrizione deve essere tra 10 e 100 caratteri.")
    private String publisher;
    @NotNull
    private int dateOfPublishing;
    @NotBlank
    private String authors;
    @NotBlank
    private String isbn;

    private int copies;
    private int soldCopies;
    @NotNull
    private BigDecimal price;
    private boolean deleteTrue = false;
    @ManyToMany
    private List<Category> categories;
    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private List<Purchase> purchasings;
    @OneToMany(mappedBy = "book")
    private List<BooksRestockinQuantity> booksRestockinQuantity;
    @OneToMany(mappedBy = "book")
    private List<Review> reviews;
    //constructor


    public Book(Integer id, String name, String urlPhoto, String description, String publisher, @NotNull int dateOfPublishing, String authors, String isbn, int copies, int soldCopies, @NotNull BigDecimal price, boolean deleteTrue, List<Category> categories, List<Purchase> purchasings, List<BooksRestockinQuantity> booksRestockinQuantity) {
        this.id = id;
        this.name = name;
        this.urlPhoto = urlPhoto;
        this.description = description;
        this.publisher = publisher;
        this.dateOfPublishing = dateOfPublishing;
        this.authors = authors;
        this.isbn = isbn;
        this.copies = copies;
        this.soldCopies = soldCopies;
        this.price = price;
        this.deleteTrue = deleteTrue;
        this.categories = categories;
        this.purchasings = purchasings;
        this.booksRestockinQuantity = booksRestockinQuantity;
    }

    //constructor default
    public Book() {
    }

    //getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getSoldCopies() {
        return soldCopies;
    }

    public void setSoldCopies(int soldCopies) {
        this.soldCopies = soldCopies;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getDateOfPublishing() {
        return dateOfPublishing;
    }

    public void setDateOfPublishing(int dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }

    public boolean isDeleteTrue() {
        return deleteTrue;
    }

    public void setDeleteTrue(boolean deleteTrue) {
        this.deleteTrue = deleteTrue;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Purchase> getPurchasings() {
        return purchasings;
    }

    public void setPurchasings(List<Purchase> purchasings) {
        this.purchasings = purchasings;
    }

    public List<BooksRestockinQuantity> getBooksRestockinQuantity() {
        return booksRestockinQuantity;
    }

    public void setBooksRestockinQuantity(List<BooksRestockinQuantity> booksRestockinQuantity) {
        this.booksRestockinQuantity = booksRestockinQuantity;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

