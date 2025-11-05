package org.crue.hercules.sgi.sgo.service;

import org.crue.hercules.sgi.sgo.exceptions.DepartamentoNotFoundException;
import org.crue.hercules.sgi.sgo.model.Departamento;
import org.crue.hercules.sgi.sgo.model.Departamento_;
import org.crue.hercules.sgi.sgo.repository.DepartamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(readOnly = true)
public class DepartamentoService {

  private final DepartamentoRepository repository;

  public DepartamentoService(DepartamentoRepository departamentoRepository) {
    this.repository = departamentoRepository;
  }

  /**
   * Obtiene una entidad {@link Departamento} por id.
   * 
   * @param id identificador de la entidad {@link Departamento}.
   * @return la entidad {@link Departamento}.
   */
  public Departamento findById(String id) {
    log.debug("findById(String id) - start");
    final Departamento returnValue = repository.findById(id)
        .orElseThrow(() -> new DepartamentoNotFoundException(id));
    log.debug("findById(String id) - end");
    return returnValue;
  }

  /**
   * Obtiene todas las entidades {@link Departamento} ordenadas alfabeticamente
   * por nombre.
   *
   * @return el listado de entidades {@link Departamento}.
   */
  public Page<Departamento> findAll() {
    log.debug("findAll() - start");
    Page<Departamento> returnValue = new PageImpl<>(
        repository.findAll(Sort.by(Sort.Direction.ASC, Departamento_.NOMBRE)));
    log.debug("findAll() - end");
    return returnValue;
  }

}
