package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Colaborador;
import com.basis.turma.sgc.domain.Senioridade;
import com.basis.turma.sgc.service.dto.ColaboradorDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T07:28:04-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_312 (Private Build)"
)
@Component
public class ColaboradorMapperImpl implements ColaboradorMapper {

    @Autowired
    private CompetenciaNivelMapper competenciaNivelMapper;

    @Override
    public List<ColaboradorDTO> toDTO(List<Colaborador> entity) {
        if ( entity == null ) {
            return null;
        }

        List<ColaboradorDTO> list = new ArrayList<ColaboradorDTO>( entity.size() );
        for ( Colaborador colaborador : entity ) {
            list.add( toDTO( colaborador ) );
        }

        return list;
    }

    @Override
    public List<Colaborador> toEntity(List<ColaboradorDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Colaborador> list = new ArrayList<Colaborador>( dto.size() );
        for ( ColaboradorDTO colaboradorDTO : dto ) {
            list.add( toEntity( colaboradorDTO ) );
        }

        return list;
    }

    @Override
    public ColaboradorDTO toDTO(Colaborador colaborador) {
        if ( colaborador == null ) {
            return null;
        }

        ColaboradorDTO colaboradorDTO = new ColaboradorDTO();

        colaboradorDTO.setDescricaoSenioridade( colaboradorSenioridadeDescricao( colaborador ) );
        colaboradorDTO.setIdSenioridade( colaboradorSenioridadeId( colaborador ) );
        colaboradorDTO.setId( colaborador.getId() );
        colaboradorDTO.setNome( colaborador.getNome() );
        colaboradorDTO.setSobrenome( colaborador.getSobrenome() );
        colaboradorDTO.setCpf( colaborador.getCpf() );
        colaboradorDTO.setEmail( colaborador.getEmail() );
        colaboradorDTO.setFoto( colaborador.getFoto() );
        colaboradorDTO.setDataNascimento( colaborador.getDataNascimento() );
        colaboradorDTO.setDataAdmissao( colaborador.getDataAdmissao() );
        colaboradorDTO.setCompetenciasList( competenciaNivelMapper.toDTO( colaborador.getCompetenciasList() ) );

        return colaboradorDTO;
    }

    @Override
    public Colaborador toEntity(ColaboradorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Colaborador colaborador = new Colaborador();

        colaborador.setSenioridade( colaboradorDTOToSenioridade( dto ) );
        colaborador.setId( dto.getId() );
        colaborador.setNome( dto.getNome() );
        colaborador.setSobrenome( dto.getSobrenome() );
        colaborador.setCpf( dto.getCpf() );
        colaborador.setEmail( dto.getEmail() );
        colaborador.setFoto( dto.getFoto() );
        colaborador.setDataNascimento( dto.getDataNascimento() );
        colaborador.setDataAdmissao( dto.getDataAdmissao() );
        colaborador.setCompetenciasList( competenciaNivelMapper.toEntity( dto.getCompetenciasList() ) );

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

    protected Senioridade colaboradorDTOToSenioridade(ColaboradorDTO colaboradorDTO) {
        if ( colaboradorDTO == null ) {
            return null;
        }

        Senioridade senioridade = new Senioridade();

        senioridade.setId( colaboradorDTO.getIdSenioridade() );

        return senioridade;
    }
}
