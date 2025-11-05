package org.crue.hercules.sgi.sgo.service;

import org.crue.hercules.sgi.framework.rsql.SgiRSQLJPASupport;
import org.crue.hercules.sgi.framework.web.method.annotation.RequestPageableArgumentResolver.UnpagedPageable;
import org.crue.hercules.sgi.sgo.exceptions.AreaConocimientoNotFoundException;
import org.crue.hercules.sgi.sgo.model.AreaConocimiento;
import org.crue.hercules.sgi.sgo.model.AreaConocimiento_;
import org.crue.hercules.sgi.sgo.repository.AreaConocimientoRepository;
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
public class AreaConocimientoService {

  private final AreaConocimientoRepository repository;

  public AreaConocimientoService(AreaConocimientoRepository areaConocimientoRepository) {
    this.repository = areaConocimientoRepository;
  }

  /**
   * Obtiene una entidad {@link AreaConocimiento} por id.
   * 
   * @param id identificador de la entidad {@link AreaConocimiento}.
   * @return la entidad {@link AreaConocimiento}.
   */
  public AreaConocimiento findById(String id) {
    log.debug("findById(String id) - start");
    final AreaConocimiento returnValue = repository.findById(id)
        .orElseThrow(() -> new AreaConocimientoNotFoundException(id));
    log.debug("findById(String id) - end");
    return returnValue;
  }

  /**
   * Obtiene todas las entidades {@link AreaConocimiento} paginadas y filtradas.
   *
   * @param query  información del filtro.
   * @param paging información de paginación. Si no se pasa informacion de
   *               paginación se devuelven todas las entidades
   *               {@link AreaConocimiento} ordenadas alfabeticamente por nombre.
   * @return el listado de entidades {@link AreaConocimiento} paginadas y
   *         filtradas.
   */
  public Page<AreaConocimiento> findAll(String query, Pageable paging) {
    log.debug("findAll(String query, Pageable paging) - start");

    if (paging == null || (paging.getSort().isUnsorted() && paging instanceof UnpagedPageable)) {
      paging = new UnpagedPageable(Sort.by(Sort.Direction.ASC, AreaConocimiento_.NOMBRE));
    }

    Specification<AreaConocimiento> specs = SgiRSQLJPASupport.toSpecification(query);

    Page<AreaConocimiento> returnValue = repository.findAll(specs, paging);
    log.debug("findAll(String query, Pageable paging) - end");
    return returnValue;
  }

}
