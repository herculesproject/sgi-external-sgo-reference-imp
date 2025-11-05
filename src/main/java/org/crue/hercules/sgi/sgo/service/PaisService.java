package org.crue.hercules.sgi.sgo.service;

import org.crue.hercules.sgi.framework.rsql.SgiRSQLJPASupport;
import org.crue.hercules.sgi.framework.web.method.annotation.RequestPageableArgumentResolver.UnpagedPageable;
import org.crue.hercules.sgi.sgo.exceptions.PaisNotFoundException;
import org.crue.hercules.sgi.sgo.model.Pais;
import org.crue.hercules.sgi.sgo.model.Pais_;
import org.crue.hercules.sgi.sgo.repository.PaisRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(readOnly = true)
public class PaisService {

  private final PaisRepository repository;

  public PaisService(PaisRepository paisRepository) {
    this.repository = paisRepository;
  }

  /**
   * Obtiene una entidad {@link Pais} por id.
   * 
   * @param id identificador de la entidad {@link Pais}.
   * @return la entidad {@link Pais}.
   */
  public Pais findById(String id) {
    log.debug("findById(String id) - start");
    final Pais returnValue = repository.findById(id).orElseThrow(() -> new PaisNotFoundException(id));
    log.debug("findById(String id) - end");
    return returnValue;
  }

  /**
   * Obtiene todas las entidades {@link Pais} paginadas y filtradas.
   *
   * @param query  información del filtro.
   * @param paging información de paginación. Si no se pasa informacion de
   *               paginación se devuelven todas las entidades
   *               {@link Pais} ordenadas alfabeticamente por nombre.
   * @return el listado de entidades {@link Pais} paginadas y filtradas.
   */
  public Page<Pais> findAll(String query, Pageable paging) {
    log.debug("findAll(String query, Pageable paging) - start");

    if (paging == null || (paging.getSort().isUnsorted() && paging instanceof UnpagedPageable)) {
      paging = new UnpagedPageable(Sort.by(Sort.Direction.ASC, Pais_.NOMBRE));
    }

    Specification<Pais> specs = SgiRSQLJPASupport.toSpecification(query);

    Page<Pais> returnValue = repository.findAll(specs, paging);
    log.debug("findAll(String query, Pageable paging) - end");
    return returnValue;
  }

}
