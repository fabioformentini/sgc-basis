package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Colaborador;
import com.basis.turma.sgc.domain.Senioridade;
import com.basis.turma.sgc.service.dto.ColaboradorListaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T07:28:04-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_312 (Private Build)"
)
@Component
public class ColaboradorListaMapperImpl implements ColaboradorListaMapper {

    @Override
    public List<ColaboradorListaDTO> toDTO(List<Colaborador> entity) {
        if ( entity == null ) {
            return null;
        }

        List<ColaboradorListaDTO> list = new ArrayList<ColaboradorListaDTO>( entity.size() );
        for ( Colaborador colaborador : entity ) {
            list.add( toDTO( colaborador ) );
        }

        return list;
    }

    @Override
    public List<Colaborador> toEntity(List<ColaboradorListaDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Colaborador> list = new ArrayList<Colaborador>( dto.size() );
        for ( ColaboradorListaDTO colaboradorListaDTO : dto ) {
            list.add( toEntity( colaboradorListaDTO ) );
        }

        return list;
    }

    @Override
    public ColaboradorListaDTO toDTO(Colaborador colaborador) {
        if ( colaborador == null ) {
            return null;
        }

        ColaboradorListaDTO colaboradorListaDTO = new ColaboradorListaDTO();

        colaboradorListaDTO.setDescricaoSenioridade( colaboradorSenioridadeDescricao( colaborador ) );
        colaboradorListaDTO.setIdSenioridade( colaboradorSenioridadeId( colaborador ) );
        colaboradorListaDTO.setId( colaborador.getId() );
        colaboradorListaDTO.setNome( colaborador.getNome() );
        colaboradorListaDTO.setSobrenome( colaborador.getSobrenome() );
        colaboradorListaDTO.setEmail( colaborador.getEmail() );
        colaboradorListaDTO.setDataNascimento( colaborador.getDataNascimento() );
        colaboradorListaDTO.setDataAdmissao( colaborador.getDataAdmissao() );

        return colaboradorListaDTO;
    }

    @Override
    public Colaborador toEntity(ColaboradorListaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Colaborador colaborador = new Colaborador();

        colaborador.setSenioridade( colaboradorListaDTOToSenioridade( dto ) );
        colaborador.setId( dto.getId() );
        colaborador.setNome( dto.getNome() );
        colaborador.setSobrenome( dto.getSobrenome() );
        colaborador.setEmail( dto.getEmail() );
        colaborador.setDataNascimento( dto.getDataNascimento() );
        colaborador.setDataAdmissao( dto.getDataAdmissao() );

        return colaborador;
    }

    private String colaboradorSenioridadeDescricao(Colaborador colaborador) {
        if ( colaborador == null ) {
            return null;
        }
        Senioridade senioridade = colaborador.getSenioridade();
        if ( senioridade == null ) {
            return null;
        }
        String descricao = senioridade.getDescricao();
        if ( descricao == null ) {
            return null;
        }
        return descricao;
    }

    private Long colaboradorSenioridadeId(Colaborador colaborador) {
        if ( colaborador == null ) {
            return null;
        }
        Senioridade senioridade = colaborador.getSenioridade();
        if ( senioridade == null ) {
            return null;
        }
        Long id = senioridade.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Senioridade colaboradorListaDTOToSenioridade(ColaboradorListaDTO colaboradorListaDTO) {
        if ( colaboradorListaDTO == null ) {
            return null;
        }

        Senioridade senioridade = new Senioridade();

        senioridade.setId( colaboradorListaDTO.getIdSenioridade() );

        return senioridade;
    }
}
