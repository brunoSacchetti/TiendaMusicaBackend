package com.example.BackendTp7Lc4React.services;

import com.example.BackendTp7Lc4React.entities.Instrumento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstrumentoService {
    //Metodo para listar todos los registros
    public List<Instrumento> findAll() throws Exception;

    //Metodo para buscar un registro por id que le pasemos
    public Instrumento findById(Long id) throws Exception;

    //Metodo para crear un instrumento
    public Instrumento create(Instrumento instrumento) throws Exception;

    //metodo para actualizar un instrumento
    public Instrumento update(Long id, Instrumento instrumento) throws Exception;

    //metodo para eliminar un instrumento
    public String delete(Long id) throws Exception;

    //metodod para filtrar por categoria
    public List<Instrumento> findByCategoria(Long categoriaId);

}
