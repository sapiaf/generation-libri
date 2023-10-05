package org.generation.libri.generationlibrary.repository;

import org.generation.libri.generationlibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
