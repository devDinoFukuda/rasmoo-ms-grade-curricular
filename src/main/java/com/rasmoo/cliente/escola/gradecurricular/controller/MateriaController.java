package com.rasmoo.cliente.escola.gradecurricular.controller;

import java.util.List;
import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;
import com.rasmoo.cliente.escola.gradecurricular.repositories.IMateriaRepository;
import com.rasmoo.cliente.escola.gradecurricular.service.IMateriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materia")
public class  MateriaController {
/*
    @Autowired
    private IMateriaRepository materiaRepository;
*/
    @Autowired
    private IMateriaService materiaService;

    @GetMapping
    public ResponseEntity<List<MateriaEntity>> listarMaterias() {
        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaEntity> consultaMateria(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.consultar(id));
    }

    //fazer o delete, parecido com GetMapping acima e e PUT parecido ao Post abaixo

    @PostMapping
    public ResponseEntity<String> cadastrarMateria(@RequestBody MateriaEntity materia) {
    
        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.cadastrar(materia));
    
    }

    @PutMapping

    public ResponseEntity<String> atualizarMateria(@RequestBody MateriaEntity materia) {
        
            return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.atualizar(materia));
        
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirMateria(@PathVariable Long id) {
        
        return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.excluir(id));
        
    }

}
