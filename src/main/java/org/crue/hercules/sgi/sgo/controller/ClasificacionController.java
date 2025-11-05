package org.crue.hercules.sgi.sgo.controller;

import org.crue.hercules.sgi.framework.web.bind.annotation.RequestPageable;
import org.crue.hercules.sgi.sgo.converter.ClasificacionConverter;
import org.crue.hercules.sgi.sgo.dto.ClasificacionOutput;
import org.crue.hercules.sgi.sgo.model.Clasificacion;
import org.crue.hercules.sgi.sgo.service.ClasificacionService;
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
 * ClasificacionController
 */
@RestController
@RequestMapping(ClasificacionController.REQUEST_MAPPING)
@RequiredArgsConstructor
@Slf4j
public class ClasificacionController {

  public static final String PATH_DELIMITER = "/";
  public static final String REQUEST_MAPPING = PATH_DELIMITER + "clasificaciones";
  public static final String PATH_ID = PATH_DELIMITER + "{id}";

  private final ClasificacionService service;
  private final ClasificacionConverter converter;

  /**
   * Devuelve una lista paginada y filtrada de {@link Clasificacion}.
   * 
   * @param query  filtro de búsqueda.
   * @param paging {@link Pageable}.
   * @return el listado de entidades {@link Clasificacion} paginadas y filtradas.
   */
  @GetMapping()
  public ResponseEntity<Page<ClasificacionOutput>> findAll(@RequestParam(name = "q", required = false) String query,
      @RequestPageable(sort = "s") Pageable paging) {
    log.debug("findAll({}, {}) - start", query, paging);
    Page<ClasificacionOutput> page = converter.convert(service.findAll(query, paging));
    log.debug("findAll({}, {}) - end", query, paging);
    return page.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(page, HttpStatus.OK);
  }

  /**
   * Devuelve la {@link Clasificacion} con el id indicado.
   * 
   * @param id Identificador de {@link Clasificacion}.
   * @return {@link Clasificacion} correspondiente al id
   */
  @GetMapping(PATH_ID)
  public ClasificacionOutput findById(@PathVariable String id) {
    log.debug("findById({}) - start", id);
    ClasificacionOutput returnValue = converter.convert(service.findById(id));
    log.debug("findById({}) - end", id);
    return returnValue;
  }

}
