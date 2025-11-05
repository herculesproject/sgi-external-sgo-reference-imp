package org.crue.hercules.sgi.sgo.controller.publico;

import org.crue.hercules.sgi.sgo.converter.CentroConverter;
import org.crue.hercules.sgi.sgo.dto.CentroOutput;
import org.crue.hercules.sgi.sgo.model.Centro;
import org.crue.hercules.sgi.sgo.service.CentroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * CentroPublicController
 */
@RestController
@RequestMapping(CentroPublicController.REQUEST_MAPPING)
@RequiredArgsConstructor
@Slf4j
public class CentroPublicController {

  public static final String PATH_DELIMITER = "/";
  public static final String PATH_PUBLIC = PATH_DELIMITER + "public";
  public static final String REQUEST_MAPPING = PATH_PUBLIC + PATH_DELIMITER + "centros";
  public static final String PATH_ID = PATH_DELIMITER + "{id}";

  private final CentroService service;
  private final CentroConverter converter;

  /**
   * Devuelve el {@link Centro} con el id indicado.
   * 
   * @param id Identificador de {@link Centro}.
   * @return {@link Centro} correspondiente al id
   */
  @GetMapping(PATH_ID)
  public CentroOutput findById(@PathVariable String id) {
    log.debug("findById({}) - start", id);
    CentroOutput returnValue = converter.convert(service.findById(id));
    log.debug("findById({}) - end", id);
    return returnValue;
  }

}
