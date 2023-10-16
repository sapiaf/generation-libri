package org.generation.libri.generationlibrary.repository;

import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    @Query(value = "select p.* from purchase p join book b on p.book_id = b.id  where b.name like %:name%",
            nativeQuery = true)
    List<Purchase> searchListPurchase(String name);

    @Query(value = "select p.* from purchase p join book b on p.book_id = b.id where date_of_purchase >= :minDate and date_of_purchase < :maxDate",
            nativeQuery = true)
    List<Purchase> searchListBetweenDates(LocalDate minDate, LocalDate maxDate);

    @Query("SELECT p.book, SUM(p.purchaseQuantity) as totalSold FROM Purchase p WHERE p.dateOfPurchase BETWEEN :startDate AND :endDate GROUP BY p.book ORDER BY totalSold DESC")
    List<Book> findTopSellingBooksInDateRange(LocalDateTime startDate, LocalDateTime endDate);

}

