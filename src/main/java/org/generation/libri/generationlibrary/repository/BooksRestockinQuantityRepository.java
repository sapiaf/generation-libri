package org.generation.libri.generationlibrary.repository;

import org.generation.libri.generationlibrary.model.BooksRestockinQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRestockinQuantityRepository extends JpaRepository<BooksRestockinQuantity, Integer> {
}
