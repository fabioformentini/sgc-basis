package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Senioridade;
import com.basis.turma.sgc.service.dto.SenioridadeDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-17T08:33:49-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_312 (Private Build)"
)
@Component
public class SenioridadeMapperImpl implements SenioridadeMapper {

    @Override
    public SenioridadeDTO toDTO(Senioridade entity) {
        if ( entity == null ) {
            return null;
        }

        SenioridadeDTO senioridadeDTO = new SenioridadeDTO();

        senioridadeDTO.setId( entity.getId() );
        senioridadeDTO.setDescricao( entity.getDescricao() );

        return senioridadeDTO;
    }

    @Override
    public Senioridade toEntity(SenioridadeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Senioridade senioridade = new Senioridade();

        senioridade.setId( dto.getId() );
        senioridade.setDescricao( dto.getDescricao() );

        return senioridade;
    }

    @Override
    public List<SenioridadeDTO> toDTO(List<Senioridade> entity) {
        if ( entity == null ) {
            return null;
        }

        List<SenioridadeDTO> list = new ArrayList<SenioridadeDTO>( entity.size() );
        for ( Senioridade senioridade : entity ) {
            list.add( toDTO( senioridade ) );
        }

        return list;
    }

    @Override
    public List<Senioridade> toEntity(List<SenioridadeDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Senioridade> list = new ArrayList<Senioridade>( dto.size() );
        for ( SenioridadeDTO senioridadeDTO : dto ) {
            list.add( toEntity( senioridadeDTO ) );
        }

        return list;
    }
}
