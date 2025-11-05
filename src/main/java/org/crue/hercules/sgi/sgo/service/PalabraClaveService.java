package org.crue.hercules.sgi.sgo.service;

import java.util.List;

import javax.validation.Valid;

import org.crue.hercules.sgi.framework.rsql.SgiRSQLJPASupport;
import org.crue.hercules.sgi.sgo.model.PalabraClave;
import org.crue.hercules.sgi.sgo.repository.PalabraClaveRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(readOnly = true)
@Validated
public class PalabraClaveService {

  private final PalabraClaveRepository repository;

  public PalabraClaveService(PalabraClaveRepository palabraClaveRepository) {
    this.repository = palabraClaveRepository;
  }

  /**
   * Guardar o actualiza un listado de {@link PalabraClave}.
   *
   * @param palabrasClave listado de {@link PalabraClave} a guardar.
   */
  @Transactional
  @Validated({ PalabraClave.OnCrear.class })
  public void create(@Valid List<PalabraClave> palabrasClave) {
    log.debug("create(PalabraClave palabraClave) - start");

    repository.saveAll(palabrasClave);

    log.debug("create(PalabraClave palabraClave) - end");
  }

  /**
   * Obtiene todas las entidades {@link PalabraClave} paginadas y filtradas.
   *
   * @param query  información del filtro.
   * @param paging información de paginación.
   * @return el listado de entidades {@link PalabraClave} paginadas y filtradas.
   */
  public Page<PalabraClave> findAll(String query, Pageable paging) {
    log.debug("findAll(String query, Pageable paging) - start");

    Specification<PalabraClave> specs = SgiRSQLJPASupport.toSpecification(query);

    Page<PalabraClave> returnValue = repository.findAll(specs, paging);
    log.debug("findAll(String query, Pageable paging) - end");
    return returnValue;
  }

}
