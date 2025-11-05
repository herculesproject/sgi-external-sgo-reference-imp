package org.crue.hercules.sgi.sgo.converter;

import org.crue.hercules.sgi.sgo.dto.ClasificacionOutput;
import org.crue.hercules.sgi.sgo.model.Clasificacion;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClasificacionConverter {

  private final ModelMapper modelMapper;

  public ClasificacionOutput convert(Clasificacion entity) {
    if (entity == null) {
      return null;
    }

    return modelMapper.map(entity, ClasificacionOutput.class);
  }

  public Page<ClasificacionOutput> convert(Page<Clasificacion> page) {
    return page.map(this::convert);
  }

}
