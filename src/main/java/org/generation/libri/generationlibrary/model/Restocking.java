package org.generation.libri.generationlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Restocking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime dateOfStock;
    @NotNull
    private BigDecimal bulkPrice;
    @NotBlank
    private String supplierName;
    @NotNull
    @Min(1)
    private int suppliedCopies;

    @ManyToMany(mappedBy = "restockingList")
    private List<Book> booksListRestock;

    //constructor
    public Restocking(int id, LocalDateTime dateOfStock, BigDecimal bulkPrice, String supplierName, int suppliedCopies, List<Book> booksListRestock) {
        this.id = id;
        this.dateOfStock = dateOfStock;
        this.bulkPrice = bulkPrice;
        this.supplierName = supplierName;
        this.suppliedCopies = suppliedCopies;
        this.booksListRestock = booksListRestock;
    }

    //Constructor default
    public Restocking() {
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateOfStock() {
        return dateOfStock;
    }

    public void setDateOfStock(LocalDateTime dateOfStock) {
        this.dateOfStock = dateOfStock;
    }

    public BigDecimal getBulkPrice() {
        return bulkPrice;
    }

    public void setBulkPrice(BigDecimal bulkPrice) {
        this.bulkPrice = bulkPrice;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public int getSuppliedCopies() {
        return suppliedCopies;
    }

    public void setSuppliedCopies(int suppliedCopies) {
        this.suppliedCopies = suppliedCopies;
    }

    public List<Book> getBooksListRestock() {
        return booksListRestock;
    }

    public void setBooksListRestock(List<Book> booksListRestock) {
        this.booksListRestock = booksListRestock;
    }

}
