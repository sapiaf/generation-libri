package org.generation.libri.generationlibrary.repository;

import org.generation.libri.generationlibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByNameContainingIgnoreCase(String query);
    List<Book> findByCategories_Id(Integer categoryId);
    List<Book> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);


}
