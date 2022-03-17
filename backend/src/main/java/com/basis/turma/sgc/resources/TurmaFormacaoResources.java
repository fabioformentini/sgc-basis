package com.basis.turma.sgc.resources;

import com.basis.turma.sgc.service.dto.TurmaFormacaoDTO;
import com.basis.turma.sgc.service.dto.TurmaFormacaoListaDTO;
import com.basis.turma.sgc.service.mapper.TurmaFormacaoMapper;
import com.basis.turma.sgc.service.TurmaFormacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/turmaformacao")
@AllArgsConstructor
public class TurmaFormacaoResources {

    private final TurmaFormacaoService turmaFormacaoService;

    @GetMapping
    public ResponseEntity<List<TurmaFormacaoListaDTO>> listar(){
        List<TurmaFormacaoListaDTO> turmaFormacaoListaDTO = turmaFormacaoService.listar();
        return ResponseEntity.ok(turmaFormacaoListaDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TurmaFormacaoListaDTO> buscarId(@PathVariable Long id){
        TurmaFormacaoListaDTO turmaFormacaoListaDTO = turmaFormacaoService.buscarId(id);
        return ResponseEntity.ok().body(turmaFormacaoListaDTO);
    }

    @PostMapping
    public ResponseEntity<TurmaFormacaoDTO> criar(@Valid @RequestBody TurmaFormacaoDTO turmaFormacaoDTO){
        TurmaFormacaoDTO turmaFormacaoCriar = turmaFormacaoService.criar(turmaFormacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaFormacaoCriar);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TurmaFormacaoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody TurmaFormacaoDTO turmaFormacaoDTO){
        TurmaFormacaoDTO turmaFormacaoAtualizar = turmaFormacaoService.atualizar(id,turmaFormacaoDTO);
        return ResponseEntity.ok().body(turmaFormacaoAtualizar);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        turmaFormacaoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Turma de formação deletada!");
    }

}
