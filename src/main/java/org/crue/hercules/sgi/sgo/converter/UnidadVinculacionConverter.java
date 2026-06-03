package org.crue.hercules.sgi.sgo.converter;

import org.crue.hercules.sgi.sgo.dto.UnidadVinculacionOutput;
import org.crue.hercules.sgi.sgo.model.UnidadVinculacion;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UnidadVinculacionConverter {

  private final ModelMapper modelMapper;

  public UnidadVinculacionOutput convert(UnidadVinculacion entity) {
    if (entity == null) {
      return null;
    }

    return modelMapper.map(entity, UnidadVinculacionOutput.class);
  }

  public Page<UnidadVinculacionOutput> convert(Page<UnidadVinculacion> page) {
    return page.map(this::convert);
  }

}
