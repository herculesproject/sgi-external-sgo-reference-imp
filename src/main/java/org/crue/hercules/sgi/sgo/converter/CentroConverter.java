package org.crue.hercules.sgi.sgo.converter;

import org.crue.hercules.sgi.sgo.dto.CentroOutput;
import org.crue.hercules.sgi.sgo.model.Centro;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CentroConverter {

  private final ModelMapper modelMapper;

  public CentroOutput convert(Centro entity) {
    if (entity == null) {
      return null;
    }

    return modelMapper.map(entity, CentroOutput.class);
  }

  public Page<CentroOutput> convert(Page<Centro> page) {
    return page.map(this::convert);
  }

}
