package org.crue.hercules.sgi.sgo.controller;

import org.crue.hercules.sgi.sgo.converter.DepartamentoConverter;
import org.crue.hercules.sgi.sgo.dto.DepartamentoOutput;
import org.crue.hercules.sgi.sgo.model.Departamento;
import org.crue.hercules.sgi.sgo.service.DepartamentoService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * DepartamentoController
 */
@RestController
@RequestMapping(DepartamentoController.REQUEST_MAPPING)
@RequiredArgsConstructor
@Slf4j
public class DepartamentoController {

  public static final String PATH_DELIMITER = "/";
  public static final String REQUEST_MAPPING = PATH_DELIMITER + "departamentos";
  public static final String PATH_ID = PATH_DELIMITER + "{id}";

  private final DepartamentoService service;
  private final DepartamentoConverter converter;

  /**
   * Devuelve la lista de {@link Departamento}.
   *
   * @return el listado de entidades {@link Departamento}.
   */
  @GetMapping()
  public ResponseEntity<Page<DepartamentoOutput>> findAll() {
    log.debug("findAll() - start");
    Page<DepartamentoOutput> page = converter.convert(service.findAll());
    log.debug("findAll() - end");
    return page.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(page, HttpStatus.OK);
  }

  /**
   * Devuelve el {@link Departamento} con el id indicado.
   * 
   * @param id Identificador de {@link Departamento}.
   * @return {@link Departamento} correspondiente al id
   */
  @GetMapping(PATH_ID)
  public DepartamentoOutput findById(@PathVariable String id) {
    log.debug("findById({}) - start", id);
    DepartamentoOutput returnValue = converter.convert(service.findById(id));
    log.debug("findById({}) - end", id);
    return returnValue;
  }

}
