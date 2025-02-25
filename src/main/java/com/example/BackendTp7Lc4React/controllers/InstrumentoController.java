package com.example.BackendTp7Lc4React.controllers;

import com.example.BackendTp7Lc4React.entities.Instrumento;
import com.example.BackendTp7Lc4React.services.InstrumentoServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/instrumentos")
public class InstrumentoController {

    @Autowired
    private InstrumentoServiceImplementation instrumentoService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllInstruments(){
        try{

            return ResponseEntity.status(HttpStatus.OK).body(instrumentoService.findAll());

        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getInstrumentById(@PathVariable Long id) {
        try{

            return ResponseEntity.status(HttpStatus.OK).body(instrumentoService.findById(id));

        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }

    }

    @PostMapping("/create")
    public ResponseEntity<?> createInstrument(@RequestBody Instrumento instrumento) {
        try {
            return ResponseEntity.ok(instrumentoService.create(instrumento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating the instrument");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateInstrument(@PathVariable Long id, @RequestBody Instrumento instrumento) {
        try {
            instrumento.setId(id);
            return ResponseEntity.ok(instrumentoService.update(id, instrumento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instrument not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInstrument(@PathVariable Long id) {
        try {
            instrumentoService.delete(id);
            return ResponseEntity.ok().body("Instrument deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instrument not found");
        }
    }

    //Retornamos una lista de ? (instrumentos)
    @GetMapping("/all/filter")
    public ResponseEntity<?> filterInstrument(@RequestParam Long categoriaId){
        try {
            if (categoriaId != null) {
                return ResponseEntity.status(HttpStatus.OK).body(instrumentoService.findByCategoria(categoriaId));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(instrumentoService.findAll());
            }
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instrument not found");
        }
    }
}


