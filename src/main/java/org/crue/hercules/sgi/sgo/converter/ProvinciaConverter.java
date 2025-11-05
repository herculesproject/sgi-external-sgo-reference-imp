package org.crue.hercules.sgi.sgo.converter;

import org.crue.hercules.sgi.sgo.dto.ProvinciaOutput;
import org.crue.hercules.sgi.sgo.model.Provincia;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProvinciaConverter {

  private final ModelMapper modelMapper;

  public ProvinciaOutput convert(Provincia entity) {
    if (entity == null) {
      return null;
    }

    return modelMapper.map(entity, ProvinciaOutput.class);
  }

  public Page<ProvinciaOutput> convert(Page<Provincia> page) {
    return page.map(this::convert);
  }

}
