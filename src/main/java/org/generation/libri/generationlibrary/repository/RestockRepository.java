package org.generation.libri.generationlibrary.repository;

import org.generation.libri.generationlibrary.model.Restocking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestockRepository extends JpaRepository<Restocking, Integer> {


}
