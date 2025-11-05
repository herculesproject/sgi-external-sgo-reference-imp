package org.crue.hercules.sgi.sgo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.crue.hercules.sgi.sgo.dto.PalabraClaveInput;
import org.crue.hercules.sgi.sgo.model.PalabraClave;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PalabraClaveConverter {

  private final ModelMapper modelMapper;

  public String convert(PalabraClave entity) {
    if (entity == null) {
      return null;
    }

    return entity.getPalabra();
  }

  public Page<String> convert(Page<PalabraClave> page) {
    return page.map(this::convert);
  }

  public PalabraClave convert(PalabraClaveInput input) {
    return modelMapper.map(input, PalabraClave.class);
  }

  public List<PalabraClave> convert(List<PalabraClaveInput> input) {
    return input.stream().map(this::convert).collect(Collectors.toList());
  }

}
