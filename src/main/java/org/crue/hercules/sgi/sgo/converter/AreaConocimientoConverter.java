package org.crue.hercules.sgi.sgo.converter;

import org.crue.hercules.sgi.sgo.dto.AreaConocimientoOutput;
import org.crue.hercules.sgi.sgo.model.AreaConocimiento;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AreaConocimientoConverter {

  private final ModelMapper modelMapper;

  public AreaConocimientoOutput convert(AreaConocimiento entity) {
    if (entity == null) {
      return null;
    }

    return modelMapper.map(entity, AreaConocimientoOutput.class);
  }

  public Page<AreaConocimientoOutput> convert(Page<AreaConocimiento> page) {
    return page.map(this::convert);
  }

}
