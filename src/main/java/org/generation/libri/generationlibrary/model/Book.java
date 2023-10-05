package org.generation.libri.generationlibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
public class Book {
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
    private int soldCopies;
    @NotNull
    private BigDecimal price;


    //contructor
    public Book(int id, String name, String urlPhoto, String description, int soldCopies, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.urlPhoto = urlPhoto;
        this.description = description;
        this.soldCopies = soldCopies;
        this.price = price;
    }

    //constructor default
    public Book() {
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
