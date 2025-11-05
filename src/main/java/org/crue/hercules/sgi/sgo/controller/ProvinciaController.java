package org.crue.hercules.sgi.sgo.controller;

import org.crue.hercules.sgi.framework.web.bind.annotation.RequestPageable;
import org.crue.hercules.sgi.sgo.converter.ProvinciaConverter;
import org.crue.hercules.sgi.sgo.dto.ProvinciaOutput;
import org.crue.hercules.sgi.sgo.model.Provincia;
import org.crue.hercules.sgi.sgo.service.ProvinciaService;
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
 * ProvinciaController
 */
@RestController
@RequestMapping(ProvinciaController.REQUEST_MAPPING)
@RequiredArgsConstructor
@Slf4j
public class ProvinciaController {

  public static final String PATH_DELIMITER = "/";
  public static final String REQUEST_MAPPING = PATH_DELIMITER + "provincias";
  public static final String PATH_ID = PATH_DELIMITER + "{id}";

  private final ProvinciaService service;
  private final ProvinciaConverter converter;

  /**
   * Devuelve una lista paginada y filtrada de {@link Provincia}.
   * 
   * @param query  filtro de búsqueda.
   * @param paging {@link Pageable}.
   * @return el listado de entidades {@link Provincia} paginadas y filtradas.
   */
  @GetMapping()
  public ResponseEntity<Page<ProvinciaOutput>> findAll(@RequestParam(name = "q", required = false) String query,
      @RequestPageable(sort = "s") Pageable paging) {
    log.debug("findAll({}, {}) - start", query, paging);
    Page<ProvinciaOutput> page = converter.convert(service.findAll(query, paging));
    log.debug("findAll({}, {}) - end", query, paging);
    return page.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(page, HttpStatus.OK);
  }

  /**
   * Devuelve la {@link Provincia} con el id indicado.
   * 
   * @param id Identificador de {@link Provincia}.
   * @return {@link Provincia} correspondiente al id
   */
  @GetMapping(PATH_ID)
  public ProvinciaOutput findById(@PathVariable String id) {
    log.debug("findById({}) - start", id);
    ProvinciaOutput returnValue = converter.convert(service.findById(id));
    log.debug("findById({}) - end", id);
    return returnValue;
  }

}
