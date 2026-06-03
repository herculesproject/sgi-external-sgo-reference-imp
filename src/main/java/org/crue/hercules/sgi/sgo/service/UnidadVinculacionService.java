package org.crue.hercules.sgi.sgo.service;

import org.crue.hercules.sgi.framework.rsql.SgiRSQLJPASupport;
import org.crue.hercules.sgi.framework.web.method.annotation.RequestPageableArgumentResolver.UnpagedPageable;
import org.crue.hercules.sgi.sgo.exceptions.UnidadVinculacionNotFoundException;
import org.crue.hercules.sgi.sgo.model.UnidadVinculacion;
import org.crue.hercules.sgi.sgo.model.UnidadVinculacion_;
import org.crue.hercules.sgi.sgo.repository.UnidadVinculacionRepository;
import org.crue.hercules.sgi.sgo.util.SgiLogUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Service para la gestión de {@link UnidadVinculacion}.
 */
@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UnidadVinculacionService {

  private final UnidadVinculacionRepository repository;

  /**
   * Obtiene el {@link UnidadVinculacion} con el id indicado.
   *
   * @param id identificador de la {@link UnidadVinculacion} a recuperar.
   * @return el {@link UnidadVinculacion} encontrado.
   */
  public UnidadVinculacion findById(String id) {
    log.debug("findById(String id) - start");
    final UnidadVinculacion returnValue = repository.findById(id)
        .orElseThrow(() -> new UnidadVinculacionNotFoundException(id));
    log.debug("findById(String id) - end");
    return returnValue;
  }

  /**
   * Obtiene todos las {@link UnidadVinculacion} activas.
   *
   * @param query  filtro de búsqueda.
   * @param paging paginación.
   * @return página de {@link UnidadVinculacion} activos.
   */
  public Page<UnidadVinculacion> findAll(String query, Pageable paging) {
    log.debug("findAll - query: {}, paging: {}", query, SgiLogUtils.pageable(paging));

    if (paging == null || (paging.getSort().isUnsorted() && paging instanceof UnpagedPageable)) {
      paging = new UnpagedPageable(Sort.by(Sort.Direction.ASC, UnidadVinculacion_.NOMBRE));
    }

    Specification<UnidadVinculacion> specs = SgiRSQLJPASupport.toSpecification(query);

    Page<UnidadVinculacion> page = repository.findAll(specs, paging);
    log.debug("findAll - response: {}", SgiLogUtils.page(page));
    return page;
  }

}
