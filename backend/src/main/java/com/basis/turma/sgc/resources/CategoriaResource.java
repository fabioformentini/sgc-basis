package com.basis.turma.sgc.resources;

import com.basis.turma.sgc.service.dto.CategoriaDTO;
import com.basis.turma.sgc.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/categoria"})
@AllArgsConstructor
public class CategoriaResource {

    private final CategoriaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listar(){
        List<CategoriaDTO> categoriaDTO = service.listar();
        return ResponseEntity.ok(categoriaDTO);
    }

}

