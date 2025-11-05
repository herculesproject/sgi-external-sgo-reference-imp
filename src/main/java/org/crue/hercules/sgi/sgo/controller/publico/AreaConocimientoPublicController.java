package org.crue.hercules.sgi.sgo.controller.publico;

import org.crue.hercules.sgi.sgo.converter.AreaConocimientoConverter;
import org.crue.hercules.sgi.sgo.dto.AreaConocimientoOutput;
import org.crue.hercules.sgi.sgo.model.AreaConocimiento;
import org.crue.hercules.sgi.sgo.service.AreaConocimientoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * AreaConocimientoPublicController
 */
@RestController
@RequestMapping(AreaConocimientoPublicController.REQUEST_MAPPING)
@RequiredArgsConstructor
@Slf4j
public class AreaConocimientoPublicController {

  public static final String PATH_DELIMITER = "/";
  public static final String PATH_PUBLIC = PATH_DELIMITER + "public";
  public static final String REQUEST_MAPPING = PATH_PUBLIC + PATH_DELIMITER + "areas-conocimiento";
  public static final String PATH_ID = PATH_DELIMITER + "{id}";

  private final AreaConocimientoService service;
  private final AreaConocimientoConverter converter;

  /**
   * Devuelve el {@link AreaConocimiento} con el id indicado.
   * 
   * @param id Identificador de {@link AreaConocimiento}.
   * @return {@link AreaConocimiento} correspondiente al id
   */
  @GetMapping(PATH_ID)
  public AreaConocimientoOutput findById(@PathVariable String id) {
    log.debug("findById({}) - start", id);
    AreaConocimientoOutput returnValue = converter.convert(service.findById(id));
    log.debug("findById({}) - end", id);
    return returnValue;
  }

}
