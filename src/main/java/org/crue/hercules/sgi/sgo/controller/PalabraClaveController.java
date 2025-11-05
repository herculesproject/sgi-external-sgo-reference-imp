package org.crue.hercules.sgi.sgo.controller;

import java.util.List;

import javax.validation.Valid;

import org.crue.hercules.sgi.framework.web.bind.annotation.RequestPageable;
import org.crue.hercules.sgi.sgo.converter.PalabraClaveConverter;
import org.crue.hercules.sgi.sgo.dto.PalabraClaveInput;
import org.crue.hercules.sgi.sgo.model.PalabraClave;
import org.crue.hercules.sgi.sgo.service.PalabraClaveService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * PalabraClaveController
 */
@RestController
@RequestMapping(PalabraClaveController.REQUEST_MAPPING)
@RequiredArgsConstructor
@Slf4j
public class PalabraClaveController {

  public static final String PATH_DELIMITER = "/";
  public static final String REQUEST_MAPPING = PATH_DELIMITER + "palabras-clave";

  private final PalabraClaveService service;
  private final PalabraClaveConverter converter;

  /**
   * Crea las nuevas {@link PalabraClave}.
   * 
   * @param palabrasClave lista de {@link PalabraClave} que se quiere crear.
   * @return {@link HttpStatus#OK}
   */
  @PostMapping
  public ResponseEntity<Void> create(@Valid @RequestBody List<PalabraClaveInput> palabrasClave) {
    log.debug("create({}) - start", palabrasClave);
    service.create(converter.convert(palabrasClave));
    log.debug("create({}) - end", palabrasClave);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Devuelve una lista paginada y filtrada de {@link PalabraClave}.
   * 
   * @param query  filtro de búsqueda.
   * @param paging {@link Pageable}.
   * @return el listado de entidades {@link PalabraClave} paginadas y filtradas.
   */
  @GetMapping()
  public ResponseEntity<Page<String>> findAll(@RequestParam(name = "q", required = false) String query,
      @RequestPageable(sort = "s") Pageable paging) {
    log.debug("findAll({}, {}) - start", query, paging);
    Page<PalabraClave> page = service.findAll(query, paging);
    log.debug("findAll({}, {}) - end", query, paging);
    return page.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
        : new ResponseEntity<>(converter.convert(page), HttpStatus.OK);
  }

}
