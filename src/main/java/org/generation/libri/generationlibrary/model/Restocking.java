package org.generation.libri.generationlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Restocking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime dateOfStock;
    @NotBlank
    @Size(min = 3, max = 100, message = "Inserisci il tuo nome..")
    private String dependentName;
    //@NotNull
    private BigDecimal bulkPrice;
    @NotBlank(message = "Inserisci il fornitore.")
    private String supplierName;
    //@NotNull
    //@Min(1)
    private int suppliedCopies;

    private String paymentMethod;

    @OneToMany(mappedBy = "restock")
    private List<BooksRestockinQuantity> booksRestockinQuantity;

    //constructor
    public Restocking(int id, LocalDateTime dateOfStock, String dependentName, BigDecimal bulkPrice, String supplierName, int suppliedCopies, String paymentMethod, List<Book> booksListRestock, List<BooksRestockinQuantity> booksRestockinQuantity) {
        this.id = id;
        this.dateOfStock = dateOfStock;
        this.dependentName = dependentName;
        this.bulkPrice = bulkPrice;
        this.supplierName = supplierName;
        this.suppliedCopies = suppliedCopies;
        this.paymentMethod = paymentMethod;
        this.booksRestockinQuantity = booksRestockinQuantity;
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

    public String getDependentName() {
        return dependentName;
    }

    public void setDependentName(String dependentName) {
        this.dependentName = dependentName;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<BooksRestockinQuantity> getBooksRestockinQuantity() {
        return booksRestockinQuantity;
    }

    public void setBooksRestockinQuantity(List<BooksRestockinQuantity> booksRestockinQuantity) {
        this.booksRestockinQuantity = booksRestockinQuantity;
    }

}
