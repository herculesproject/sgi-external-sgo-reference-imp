package org.crue.hercules.sgi.sgo.converter;

import org.crue.hercules.sgi.sgo.dto.PaisOutput;
import org.crue.hercules.sgi.sgo.model.Pais;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaisConverter {

  private final ModelMapper modelMapper;

  public PaisOutput convert(Pais entity) {
    if (entity == null) {
      return null;
    }

    return modelMapper.map(entity, PaisOutput.class);
  }

  public Page<PaisOutput> convert(Page<Pais> page) {
    return page.map(this::convert);
  }

}
