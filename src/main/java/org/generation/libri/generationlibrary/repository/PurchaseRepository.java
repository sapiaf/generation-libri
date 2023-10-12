package org.generation.libri.generationlibrary.repository;

import org.generation.libri.generationlibrary.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    @Query(value = "select p.* from purchase p join book b on p.book_id = b.id  where b.name like %:name%",
            nativeQuery = true)
    List<Purchase> searchListPurchase(String name);

    @Query(value = "select p.* from purchase p join book b on p.book_id = b.id where date_of_purchase between %:minDate% and %:maxDate%",
            nativeQuery = true)
    List<Purchase> searchListBetweenDates(LocalDate minDate, LocalDate maxDate);


}
