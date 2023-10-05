package org.generation.libri.generationlibrary.repository;

import org.generation.libri.generationlibrary.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
