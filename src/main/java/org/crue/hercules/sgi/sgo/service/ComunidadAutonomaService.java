package org.crue.hercules.sgi.sgo.service;

import org.crue.hercules.sgi.framework.rsql.SgiRSQLJPASupport;
import org.crue.hercules.sgi.framework.web.method.annotation.RequestPageableArgumentResolver.UnpagedPageable;
import org.crue.hercules.sgi.sgo.exceptions.ComunidadAutonomaNotFoundException;
import org.crue.hercules.sgi.sgo.model.ComunidadAutonoma;
import org.crue.hercules.sgi.sgo.model.ComunidadAutonoma_;
import org.crue.hercules.sgi.sgo.repository.ComunidadAutonomaRepository;
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
public class ComunidadAutonomaService {

  private final ComunidadAutonomaRepository repository;

  public ComunidadAutonomaService(ComunidadAutonomaRepository comunidadAutonomaRepository) {
    this.repository = comunidadAutonomaRepository;
  }

  /**
   * Obtiene una entidad {@link ComunidadAutonoma} por id.
   * 
   * @param id identificador de la entidad {@link ComunidadAutonoma}.
   * @return la entidad {@link ComunidadAutonoma}.
   */
  public ComunidadAutonoma findById(String id) {
    log.debug("findById(String id) - start");
    final ComunidadAutonoma returnValue = repository.findById(id)
        .orElseThrow(() -> new ComunidadAutonomaNotFoundException(id));
    log.debug("findById(String id) - end");
    return returnValue;
  }

  /**
   * Obtiene todas las entidades {@link ComunidadAutonoma} paginadas y filtradas.
   *
   * @param query  información del filtro.
   * @param paging información de paginación. Si no se pasa informacion de
   *               paginación se devuelven todas las entidades
   *               {@link ComunidadAutonoma} ordenadas alfabeticamente por nombre.
   * @return el listado de entidades {@link ComunidadAutonoma} paginadas y
   *         filtradas.
   */
  public Page<ComunidadAutonoma> findAll(String query, Pageable paging) {
    log.debug("findAll(String query, Pageable paging) - start");

    if (paging == null || (paging.getSort().isUnsorted() && paging instanceof UnpagedPageable)) {
      paging = new UnpagedPageable(Sort.by(Sort.Direction.ASC, ComunidadAutonoma_.NOMBRE));
    }

    Specification<ComunidadAutonoma> specs = SgiRSQLJPASupport.toSpecification(query);

    Page<ComunidadAutonoma> returnValue = repository.findAll(specs, paging);
    log.debug("findAll(String query, Pageable paging) - end");
    return returnValue;
  }

}
