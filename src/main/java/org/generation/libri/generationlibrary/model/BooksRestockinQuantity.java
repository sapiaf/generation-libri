package org.generation.libri.generationlibrary.model;

import jakarta.persistence.*;

@Entity
public class BooksRestockinQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int quantityOfBookStock;

    @ManyToOne
    private Book book;
    @ManyToOne
    private Restocking restock;

    //constructor
    public BooksRestockinQuantity(Integer id, int quantityOfBookStock, Book book, Restocking restock) {
        this.id = id;
        this.quantityOfBookStock = quantityOfBookStock;
        this.book = book;
        this.restock = restock;
    }

    //constructor default
    public BooksRestockinQuantity() {
    }

    //getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantityOfBookStock() {
        return quantityOfBookStock;
    }

    public void setQuantityOfBookStock(int quantityOfBookStock) {
        this.quantityOfBookStock = quantityOfBookStock;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Restocking getRestock() {
        return restock;
    }

    public void setRestock(Restocking restock) {
        this.restock = restock;
    }
}

