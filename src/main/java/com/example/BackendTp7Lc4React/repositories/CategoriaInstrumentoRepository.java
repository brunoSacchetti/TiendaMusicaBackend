package com.example.BackendTp7Lc4React.repositories;

import com.example.BackendTp7Lc4React.entities.CategoriaInstrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaInstrumentoRepository extends JpaRepository<CategoriaInstrumento,Long>{
}
