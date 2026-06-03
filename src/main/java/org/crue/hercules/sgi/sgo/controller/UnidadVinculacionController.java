package org.crue.hercules.sgi.sgo.controller;

import org.crue.hercules.sgi.framework.web.bind.annotation.RequestPageable;
import org.crue.hercules.sgi.sgo.converter.UnidadVinculacionConverter;
import org.crue.hercules.sgi.sgo.dto.UnidadVinculacionOutput;
import org.crue.hercules.sgi.sgo.model.UnidadVinculacion;
import org.crue.hercules.sgi.sgo.service.UnidadVinculacionService;
import org.crue.hercules.sgi.sgo.util.SgiLogUtils;
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
 * UnidadVinculacionController
 */
@RestController
@RequestMapping(UnidadVinculacionController.REQUEST_MAPPING)
@RequiredArgsConstructor
@Slf4j
public class UnidadVinculacionController {

  public static final String PATH_DELIMITER = "/";
  public static final String REQUEST_MAPPING = PATH_DELIMITER + "unidades-vinculacion";
  public static final String PATH_ID = PATH_DELIMITER + "{id}";

  private final UnidadVinculacionService service;
  private final UnidadVinculacionConverter converter;

  /**
   * Devuelve una lista paginada y filtrada de {@link UnidadVinculacion}.
   *
   * @param query  filtro de búsqueda.
   * @param paging {@link Pageable}.
   * @return el listado de entidades {@link UnidadVinculacion} paginadas y
   *         filtradas.
   */
  @GetMapping()
  public ResponseEntity<Page<UnidadVinculacionOutput>> findAll(
      @RequestParam(name = "q", required = false) String query,
      @RequestPageable(sort = "s") Pageable paging) {
    log.debug("findAll - query: {}, paging: {}", query, SgiLogUtils.pageable(paging));
    Page<UnidadVinculacionOutput> page = converter.convert(service.findAll(query, paging));
    log.debug("findAll - response: {}", SgiLogUtils.page(page));
    return page.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(page, HttpStatus.OK);
  }

  /**
   * Devuelve la {@link UnidadVinculacion} con el id indicado.
   *
   * @param id Identificador de {@link UnidadVinculacion}.
   * @return {@link UnidadVinculacion} correspondiente al id
   */
  @GetMapping(PATH_ID)
  public UnidadVinculacionOutput findById(@PathVariable String id) {
    log.debug("findById - id: {}", id);
    return converter.convert(service.findById(id));
  }

}
