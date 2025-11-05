package org.crue.hercules.sgi.sgo.controller;

import org.crue.hercules.sgi.framework.web.bind.annotation.RequestPageable;
import org.crue.hercules.sgi.sgo.converter.AreaConocimientoConverter;
import org.crue.hercules.sgi.sgo.dto.AreaConocimientoOutput;
import org.crue.hercules.sgi.sgo.model.AreaConocimiento;
import org.crue.hercules.sgi.sgo.service.AreaConocimientoService;
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
 * AreaConocimientoController
 */
@RestController
@RequestMapping(AreaConocimientoController.REQUEST_MAPPING)
@RequiredArgsConstructor
@Slf4j
public class AreaConocimientoController {

  public static final String PATH_DELIMITER = "/";
  public static final String REQUEST_MAPPING = PATH_DELIMITER + "areas-conocimiento";
  public static final String PATH_ID = PATH_DELIMITER + "{id}";

  private final AreaConocimientoService service;
  private final AreaConocimientoConverter converter;

  /**
   * Devuelve una lista paginada y filtrada de {@link AreaConocimiento}.
   * 
   * @param query  filtro de búsqueda.
   * @param paging {@link Pageable}.
   * @return el listado de entidades {@link AreaConocimiento} paginadas y
   *         filtradas.
   */
  @GetMapping()
  public ResponseEntity<Page<AreaConocimientoOutput>> findAll(@RequestParam(name = "q", required = false) String query,
      @RequestPageable(sort = "s") Pageable paging) {
    log.debug("findAll({}, {}) - start", query, paging);
    Page<AreaConocimientoOutput> page = converter.convert(service.findAll(query, paging));
    log.debug("findAll({}, {}) - end", query, paging);
    return page.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(page, HttpStatus.OK);
  }

  /**
   * Devuelve el {@link AreaConocimiento} con el id indicado.
   * 
   * @param id Identificador del {@link AreaConocimiento}.
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
