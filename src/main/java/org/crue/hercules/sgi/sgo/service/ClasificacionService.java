package org.crue.hercules.sgi.sgo.service;

import org.crue.hercules.sgi.framework.rsql.SgiRSQLJPASupport;
import org.crue.hercules.sgi.framework.web.method.annotation.RequestPageableArgumentResolver.UnpagedPageable;
import org.crue.hercules.sgi.sgo.exceptions.ClasificacionNotFoundException;
import org.crue.hercules.sgi.sgo.model.Clasificacion;
import org.crue.hercules.sgi.sgo.model.Clasificacion_;
import org.crue.hercules.sgi.sgo.repository.ClasificacionRepository;
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
public class ClasificacionService {

  private final ClasificacionRepository repository;

  public ClasificacionService(ClasificacionRepository clasificacionRepository) {
    this.repository = clasificacionRepository;
  }

  /**
   * Obtiene una entidad {@link Clasificacion} por id.
   * 
   * @param id identificador de la entidad {@link Clasificacion}.
   * @return la entidad {@link Clasificacion}.
   */
  public Clasificacion findById(String id) {
    log.debug("findById(String id) - start");
    final Clasificacion returnValue = repository.findById(id).orElseThrow(() -> new ClasificacionNotFoundException(id));
    log.debug("findById(String id) - end");
    return returnValue;
  }

  /**
   * Obtiene todas las entidades {@link Clasificacion} paginadas y filtradas.
   *
   * @param query  información del filtro.
   * @param paging información de paginación. Si no se pasa informacion de
   *               paginación se devuelven todas las entidades
   *               {@link Clasificacion} ordenadas alfabeticamente por nombre.
   * @return el listado de entidades {@link Clasificacion} paginadas y filtradas.
   */
  public Page<Clasificacion> findAll(String query, Pageable paging) {
    log.debug("findAll(String query, Pageable paging) - start");

    if (paging == null || (paging.getSort().isUnsorted() && paging instanceof UnpagedPageable)) {
      paging = new UnpagedPageable(Sort.by(Sort.Direction.ASC, Clasificacion_.NOMBRE));
    }

    Specification<Clasificacion> specs = SgiRSQLJPASupport.toSpecification(query);

    Page<Clasificacion> returnValue = repository.findAll(specs, paging);
    log.debug("findAll(String query, Pageable paging) - end");
    return returnValue;
  }

}
