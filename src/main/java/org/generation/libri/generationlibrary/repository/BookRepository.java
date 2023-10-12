package org.generation.libri.generationlibrary.repository;

import org.generation.libri.generationlibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByNameContainingIgnoreCase(String query);

    List<Book> findByCategories_Id(Integer categoryId);

    List<Book> findByPriceBetweenAndDateOfPublishingBetween(BigDecimal minPrice, BigDecimal maxPrice, Integer minYear, Integer maxYear);

    List<Book> findByCategories_IdAndPriceBetweenAndDateOfPublishingBetween(Integer categoryId, BigDecimal minPrice, BigDecimal maxPrice, Integer minYear, Integer maxYear);

}
