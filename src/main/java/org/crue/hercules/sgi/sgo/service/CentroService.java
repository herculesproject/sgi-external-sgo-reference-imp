package org.crue.hercules.sgi.sgo.service;

import org.crue.hercules.sgi.framework.rsql.SgiRSQLJPASupport;
import org.crue.hercules.sgi.framework.web.method.annotation.RequestPageableArgumentResolver.UnpagedPageable;
import org.crue.hercules.sgi.sgo.exceptions.CentroNotFoundException;
import org.crue.hercules.sgi.sgo.model.Centro;
import org.crue.hercules.sgi.sgo.model.Centro_;
import org.crue.hercules.sgi.sgo.repository.CentroRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CentroService {

  private final CentroRepository repository;

  /**
   * Obtiene una entidad {@link Centro} por id.
   * 
   * @param id identificador de la entidad {@link Centro}.
   * @return la entidad {@link Centro}.
   */
  public Centro findById(String id) {
    log.debug("findById(Long id) - start");
    final Centro returnValue = repository.findById(id).orElseThrow(() -> new CentroNotFoundException(id));
    log.debug("findById(Long id) - end");
    return returnValue;
  }

  /**
   * Obtiene todas las entidades {@link Centro} paginadas y filtradas.
   *
   * @param query  información del filtro.
   * @param paging información de paginación. Si no se pasa informacion de
   *               paginación se devuelven todas las entidades
   *               {@link Centro} ordenadas alfabeticamente por nombre.
   * @return el listado de entidades {@link Centro} paginadas y
   *         filtradas.
   */
  public Page<Centro> findAll(String query, Pageable paging) {
    log.debug("findAll(String query, Pageable paging) - start");

    if (paging == null || (paging.getSort().isUnsorted() && paging instanceof UnpagedPageable)) {
      paging = new UnpagedPageable(Sort.by(Sort.Direction.ASC, Centro_.NOMBRE));
    }

    Specification<Centro> specs = SgiRSQLJPASupport.toSpecification(query);

    Page<Centro> returnValue = repository.findAll(specs, paging);
    log.debug("findAll(String query, Pageable paging) - end");
    return returnValue;
  }

}
