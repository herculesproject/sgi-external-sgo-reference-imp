package org.crue.hercules.sgi.sgo.converter;

import org.crue.hercules.sgi.sgo.dto.DepartamentoOutput;
import org.crue.hercules.sgi.sgo.model.Departamento;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DepartamentoConverter {

  private final ModelMapper modelMapper;

  public DepartamentoOutput convert(Departamento entity) {
    if (entity == null) {
      return null;
    }

    return modelMapper.map(entity, DepartamentoOutput.class);
  }

  public Page<DepartamentoOutput> convert(Page<Departamento> page) {
    return page.map(this::convert);
  }

}
