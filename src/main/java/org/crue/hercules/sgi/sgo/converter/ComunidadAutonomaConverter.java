package org.crue.hercules.sgi.sgo.converter;

import org.crue.hercules.sgi.sgo.dto.ComunidadAutonomaOutput;
import org.crue.hercules.sgi.sgo.model.ComunidadAutonoma;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ComunidadAutonomaConverter {

  private final ModelMapper modelMapper;

  public ComunidadAutonomaOutput convert(ComunidadAutonoma entity) {
    if (entity == null) {
      return null;
    }

    return modelMapper.map(entity, ComunidadAutonomaOutput.class);
  }

  public Page<ComunidadAutonomaOutput> convert(Page<ComunidadAutonoma> page) {
    return page.map(this::convert);
  }

}
