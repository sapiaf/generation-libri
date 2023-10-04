package org.generation.libri.generationlibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    //constructor
    public Restocking(int id, LocalDateTime dateOfStock, BigDecimal bulkPrice, String supplierName, int suppliedCopies) {
        this.id = id;
        this.dateOfStock = dateOfStock;
        this.bulkPrice = bulkPrice;
        this.supplierName = supplierName;
        this.suppliedCopies = suppliedCopies;
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
}
