package org.crue.hercules.sgi.sgo.controller;

import org.crue.hercules.sgi.framework.web.bind.annotation.RequestPageable;
import org.crue.hercules.sgi.sgo.converter.CentroConverter;
import org.crue.hercules.sgi.sgo.dto.CentroOutput;
import org.crue.hercules.sgi.sgo.model.Centro;
import org.crue.hercules.sgi.sgo.service.CentroService;
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
 * CentroController
 */
@RestController
@RequestMapping(CentroController.REQUEST_MAPPING)
@RequiredArgsConstructor
@Slf4j
public class CentroController {

  public static final String PATH_DELIMITER = "/";
  public static final String REQUEST_MAPPING = PATH_DELIMITER + "centros";
  public static final String PATH_ID = PATH_DELIMITER + "{id}";

  private final CentroService service;
  private final CentroConverter converter;

  /**
   * Devuelve una lista paginada y filtrada de {@link Centro}.
   * 
   * @param query  filtro de búsqueda.
   * @param paging {@link Pageable}.
   * @return el listado de entidades {@link Centro} paginadas y
   *         filtradas.
   */
  @GetMapping()
  public ResponseEntity<Page<CentroOutput>> findAll(@RequestParam(name = "q", required = false) String query,
      @RequestPageable(sort = "s") Pageable paging) {
    log.debug("findAll({}, {}) - start", query, paging);
    Page<CentroOutput> page = converter.convert(service.findAll(query, paging));
    log.debug("findAll({}, {}) - end", query, paging);
    return page.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(page, HttpStatus.OK);
  }

  /**
   * Devuelve el {@link Centro} con el id indicado.
   * 
   * @param id Identificador del {@link Centro}.
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
