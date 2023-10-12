package org.generation.libri.generationlibrary.repository;

import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    @Query("SELECT p.book, SUM(p.purchaseQuantity) as totalSold FROM Purchase p WHERE p.dateOfPurchase BETWEEN :startDate AND :endDate GROUP BY p.book ORDER BY totalSold DESC")
    List<Book> findTopSellingBooksInDateRange(LocalDateTime startDate, LocalDateTime endDate);
}
