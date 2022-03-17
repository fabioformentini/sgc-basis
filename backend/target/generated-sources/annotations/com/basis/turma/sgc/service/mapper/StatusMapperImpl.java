package com.basis.turma.sgc.service.mapper;

import com.basis.turma.sgc.domain.Status;
import com.basis.turma.sgc.service.dto.StatusDTO;
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
public class StatusMapperImpl implements StatusMapper {

    @Override
    public StatusDTO toDTO(Status entity) {
        if ( entity == null ) {
            return null;
        }

        StatusDTO statusDTO = new StatusDTO();

        statusDTO.setId( entity.getId() );
        statusDTO.setDescricao( entity.getDescricao() );

        return statusDTO;
    }

    @Override
    public Status toEntity(StatusDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Status status = new Status();

        status.setId( dto.getId() );
        status.setDescricao( dto.getDescricao() );

        return status;
    }

    @Override
    public List<StatusDTO> toDTO(List<Status> entity) {
        if ( entity == null ) {
            return null;
        }

        List<StatusDTO> list = new ArrayList<StatusDTO>( entity.size() );
        for ( Status status : entity ) {
            list.add( toDTO( status ) );
        }

        return list;
    }

    @Override
    public List<Status> toEntity(List<StatusDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Status> list = new ArrayList<Status>( dto.size() );
        for ( StatusDTO statusDTO : dto ) {
            list.add( toEntity( statusDTO ) );
        }

        return list;
    }
}
