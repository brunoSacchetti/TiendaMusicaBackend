package com.example.BackendTp7Lc4React.services;

import com.example.BackendTp7Lc4React.entities.CategoriaInstrumento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaInstrumentoService {
    //Metodo para listar todos los registros
    public List<CategoriaInstrumento> findAll() throws Exception;

    //Metodo para buscar un registro por id que le pasemos
    public CategoriaInstrumento findById(Long id) throws Exception;

    //Metodo para crear un CategoriaInstrumento
    public CategoriaInstrumento create(CategoriaInstrumento categoriaInstrumento) throws Exception;

    //metodo para actualizar un CategoriaInstrumento
    public CategoriaInstrumento update(Long id, CategoriaInstrumento categoriaInstrumento) throws Exception;

    //metodo para eliminar un CategoriaInstrumento
    public String delete(Long id) throws Exception;
}
