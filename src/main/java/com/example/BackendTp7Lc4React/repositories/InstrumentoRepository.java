package com.example.BackendTp7Lc4React.repositories;

import com.example.BackendTp7Lc4React.entities.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento,Long> {

    // Spring Data JPA interpreta el nombre del método que defines en tu repositorio y automáticamente genera la consulta SQL o JPQL correspondiente.

    // findBy: Este prefijo en Spring Data JPA indica que es una consulta de búsqueda. Spring Data construye una consulta que buscará entidades cuyas propiedades coincidan con los valores de los parámetros proporcionados.
    // CategoriaId: Spring Data interpreta que deseas filtrar los resultados por la propiedad categoriaId de la entidad Instrumento.
    // Supone que tu entidad Instrumento tiene una asociación o un campo llamado categoria que es un objeto, y que este objeto tiene un campo llamado id.
    // Si la estructura de tu entidad no coincide con estos supuestos (por ejemplo, si el campo se llama diferente o la estructura de la entidad es diferente), necesitarás ajustar el nombre del método o usar una anotación
    // @Query para definir explícitamente la consulta.

    //Metodo personalizado para devolver instrumentos que pertenecen a una categoria en especifico
    List<Instrumento> findByCategoriaId(Long categoriaId);
}
