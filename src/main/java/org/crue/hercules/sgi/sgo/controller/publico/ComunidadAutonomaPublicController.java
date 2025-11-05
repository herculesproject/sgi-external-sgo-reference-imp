package org.crue.hercules.sgi.sgo.controller.publico;

import org.crue.hercules.sgi.framework.web.bind.annotation.RequestPageable;
import org.crue.hercules.sgi.sgo.converter.ComunidadAutonomaConverter;
import org.crue.hercules.sgi.sgo.dto.ComunidadAutonomaOutput;
import org.crue.hercules.sgi.sgo.model.ComunidadAutonoma;
import org.crue.hercules.sgi.sgo.service.ComunidadAutonomaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ComunidadAutonomaPublicController
 */
@RestController
@RequestMapping(ComunidadAutonomaPublicController.REQUEST_MAPPING)
@RequiredArgsConstructor
@Slf4j
public class ComunidadAutonomaPublicController {

  public static final String PATH_DELIMITER = "/";
  public static final String PATH_PUBLIC = PATH_DELIMITER + "public";
  public static final String REQUEST_MAPPING = PATH_PUBLIC + PATH_DELIMITER + "comunidades-autonomas";
  public static final String PATH_ID = PATH_DELIMITER + "{id}";

  private final ComunidadAutonomaService service;
  private final ComunidadAutonomaConverter converter;

  /**
   * Devuelve el {@link ComunidadAutonoma} con el id indicado.
   * 
   * @param id Identificador de {@link ComunidadAutonoma}.
   * @return {@link ComunidadAutonoma} correspondiente al id
   */
  @GetMapping(PATH_ID)
  public ComunidadAutonomaOutput findById(@PathVariable String id) {
    log.debug("findById({}) - start", id);
    ComunidadAutonomaOutput returnValue = converter.convert(service.findById(id));
    log.debug("findById({}) - end", id);
    return returnValue;
  }

  /**
   * Devuelve una lista paginada y filtrada de {@link ComunidadAutonoma}.
   * 
   * @param query  filtro de búsqueda.
   * @param paging {@link Pageable}.
   * @return el listado de entidades {@link ComunidadAutonoma} paginadas y
   *         filtradas.
   */
  @GetMapping()
  public ResponseEntity<Page<ComunidadAutonomaOutput>> findAll(@RequestParam(name = "q", required = false) String query,
      @RequestPageable(sort = "s") Pageable paging) {
    log.debug("findAll({}, {}) - start", query, paging);
    Page<ComunidadAutonomaOutput> page = converter.convert(service.findAll(query, paging));
    log.debug("findAll({}, {}) - end", query, paging);
    return page.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(page, HttpStatus.OK);
  }

}
