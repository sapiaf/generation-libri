package org.generation.libri.generationlibrary.repository;

import org.generation.libri.generationlibrary.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByBookId(Integer bookId);
}
