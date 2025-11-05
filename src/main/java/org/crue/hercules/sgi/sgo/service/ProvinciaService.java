package org.crue.hercules.sgi.sgo.service;

import org.crue.hercules.sgi.framework.rsql.SgiRSQLJPASupport;
import org.crue.hercules.sgi.framework.web.method.annotation.RequestPageableArgumentResolver.UnpagedPageable;
import org.crue.hercules.sgi.sgo.exceptions.ProvinciaNotFoundException;
import org.crue.hercules.sgi.sgo.model.Provincia;
import org.crue.hercules.sgi.sgo.model.Provincia_;
import org.crue.hercules.sgi.sgo.repository.ProvinciaRepository;
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
public class ProvinciaService {

  private final ProvinciaRepository repository;

  public ProvinciaService(ProvinciaRepository provinciaRepository) {
    this.repository = provinciaRepository;
  }

  /**
   * Obtiene una entidad {@link Provincia} por id.
   * 
   * @param id identificador de la entidad {@link Provincia}.
   * @return la entidad {@link Provincia}.
   */
  public Provincia findById(String id) {
    log.debug("findById(String id) - start");
    final Provincia returnValue = repository.findById(id).orElseThrow(() -> new ProvinciaNotFoundException(id));
    log.debug("findById(String id) - end");
    return returnValue;
  }

  /**
   * Obtiene todas las entidades {@link Provincia} paginadas y filtradas.
   *
   * @param query  información del filtro.
   * @param paging información de paginación. Si no se pasa informacion de
   *               paginación se devuelven todas las entidades
   *               {@link Provincia} ordenadas alfabeticamente por nombre.
   * @return el listado de entidades {@link Provincia} paginadas y filtradas.
   */
  public Page<Provincia> findAll(String query, Pageable paging) {
    log.debug("findAll(String query, Pageable paging) - start");

    if (paging == null || (paging.getSort().isUnsorted() && paging instanceof UnpagedPageable)) {
      paging = new UnpagedPageable(Sort.by(Sort.Direction.ASC, Provincia_.NOMBRE));
    }

    Specification<Provincia> specs = SgiRSQLJPASupport.toSpecification(query);

    Page<Provincia> returnValue = repository.findAll(specs, paging);
    log.debug("findAll(String query, Pageable paging) - end");
    return returnValue;
  }

}
