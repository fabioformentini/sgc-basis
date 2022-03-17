package com.basis.turma.sgc.resources;


import com.basis.turma.sgc.repository.SenioridadeRepository;
import com.basis.turma.sgc.service.SenioridadeService;
import com.basis.turma.sgc.service.dto.SenioridadeDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/senioridade")
@RequiredArgsConstructor
public class SenioridadeResource {

    private final SenioridadeService service;

    @GetMapping
    public ResponseEntity<List<SenioridadeDTO>> listar(){
        List<SenioridadeDTO> senioridadeDTO = service.listar();
        return ResponseEntity.ok(senioridadeDTO);
    }

}
