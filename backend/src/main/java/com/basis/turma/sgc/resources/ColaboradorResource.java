package com.basis.turma.sgc.resources;



import com.basis.turma.sgc.domain.Colaborador;
import com.basis.turma.sgc.service.ColaboradorService;
import com.basis.turma.sgc.service.dto.ColaboradorDTO;
import com.basis.turma.sgc.service.dto.ColaboradorListaDTO;
import com.basis.turma.sgc.service.dto.TurmaFormacaoDTO;
import com.basis.turma.sgc.service.mapper.ColaboradorMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/colaborador")
@AllArgsConstructor
public class ColaboradorResource {

    private ColaboradorService colaboradorService;
    private ColaboradorMapper colaboradorMapper;

    @GetMapping
    public ResponseEntity< List<ColaboradorDTO>> listar(){
        List<ColaboradorDTO> colaboradorDTO = colaboradorService.listar();
        return ResponseEntity.ok(colaboradorDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity< ColaboradorDTO> buscarPorId(@PathVariable Long id){
        ColaboradorDTO colaboradorDTO = colaboradorService.buscarPorId(id);
        return ResponseEntity.ok().body(colaboradorDTO);
    }

    @PostMapping
    public ResponseEntity<ColaboradorDTO> criar(@Valid @RequestBody ColaboradorDTO colaboradorDTO){
        ColaboradorDTO colaboradorCriar = colaboradorService.criar(colaboradorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorCriar);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ColaboradorDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ColaboradorDTO colaboradorDTO){
        ColaboradorDTO colaboradorAtualizar = colaboradorService.atualizar(id,colaboradorDTO);
        return ResponseEntity.ok().body(colaboradorAtualizar);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        colaboradorService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Colaborador deletado!");
    }



}





