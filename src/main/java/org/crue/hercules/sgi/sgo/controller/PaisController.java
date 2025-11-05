package org.crue.hercules.sgi.sgo.controller;

import org.crue.hercules.sgi.framework.web.bind.annotation.RequestPageable;
import org.crue.hercules.sgi.sgo.converter.PaisConverter;
import org.crue.hercules.sgi.sgo.dto.PaisOutput;
import org.crue.hercules.sgi.sgo.model.Pais;
import org.crue.hercules.sgi.sgo.service.PaisService;
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
 * PaisController
 */
@RestController
@RequestMapping(PaisController.REQUEST_MAPPING)
@RequiredArgsConstructor
@Slf4j
public class PaisController {

  public static final String PATH_DELIMITER = "/";
  public static final String REQUEST_MAPPING = PATH_DELIMITER + "paises";
  public static final String PATH_ID = PATH_DELIMITER + "{id}";

  private final PaisService service;
  private final PaisConverter converter;

  /**
   * Devuelve una lista paginada y filtrada de {@link Pais}.
   * 
   * @param query  filtro de búsqueda.
   * @param paging {@link Pageable}.
   * @return el listado de entidades {@link Pais} paginadas y filtradas.
   */
  @GetMapping()
  public ResponseEntity<Page<PaisOutput>> findAll(@RequestParam(name = "q", required = false) String query,
      @RequestPageable(sort = "s") Pageable paging) {
    log.debug("findAll({}, {}) - start", query, paging);
    Page<PaisOutput> page = converter.convert(service.findAll(query, paging));
    log.debug("findAll({}, {}) - end", query, paging);
    return page.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(page, HttpStatus.OK);
  }

  /**
   * Devuelve el {@link Pais} con el id indicado.
   * 
   * @param id Identificador de {@link Pais}.
   * @return {@link Pais} correspondiente al id
   */
  @GetMapping(PATH_ID)
  public PaisOutput findById(@PathVariable String id) {
    log.debug("findById({}) - start", id);
    PaisOutput returnValue = converter.convert(service.findById(id));
    log.debug("findById({}) - end", id);
    return returnValue;
  }

}
