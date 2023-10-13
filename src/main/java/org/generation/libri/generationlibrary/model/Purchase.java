package org.generation.libri.generationlibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime dateOfPurchase;
    @NotNull
    @Min(1)
    private int purchaseQuantity;
    @NotBlank
    private String userName;
    @NotBlank
    private String userSurname;
    @NotBlank
    private String userEmail;
    @NotBlank
    private String userAddress;
    @NotBlank
    private String userCountry;
    @NotBlank
    private String userCity;
    @NotBlank
    @Size(min = 2, max = 2)
    private String userMunicipality;
    @NotBlank
    private String userZipCode;
    private int userPaymentMethod = 1;

    @ManyToOne
    private Book book;

    //constructor

    public Purchase(int id, LocalDateTime dateOfPurchase, @NotNull int purchaseQuantity, String userName, String userSurname, String userEmail, String userAddress, String userCountry, String userCity, String userMunicipality, String userZipCode, int userPaymentMethod, Book book) {
        this.id = id;
        this.dateOfPurchase = dateOfPurchase;
        this.purchaseQuantity = purchaseQuantity;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userCountry = userCountry;
        this.userCity = userCity;
        this.userMunicipality = userMunicipality;
        this.userZipCode = userZipCode;
        this.userPaymentMethod = userPaymentMethod;
        this.book = book;
    }

    //constructor default
    public Purchase() {
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDateTime dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserMunicipality() {
        return userMunicipality;
    }

    public void setUserMunicipality(String userMunicipality) {
        this.userMunicipality = userMunicipality;
    }

    public String getUserZipCode() {
        return userZipCode;
    }

    public void setUserZipCode(String userZipCode) {
        this.userZipCode = userZipCode;
    }

    public int getUserPaymentMethod() {
        return userPaymentMethod;
    }

    public void setUserPaymentMethod(int userPaymentMethod) {
        this.userPaymentMethod = userPaymentMethod;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = book.getPrice().multiply(BigDecimal.valueOf(purchaseQuantity));
        return totalPrice;
    }
}
