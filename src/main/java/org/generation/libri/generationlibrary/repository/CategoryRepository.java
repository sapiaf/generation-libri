package org.generation.libri.generationlibrary.repository;

import org.generation.libri.generationlibrary.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
