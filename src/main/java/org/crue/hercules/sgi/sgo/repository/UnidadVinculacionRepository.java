package org.crue.hercules.sgi.sgo.repository;

import org.crue.hercules.sgi.sgo.model.UnidadVinculacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UnidadVinculacionRepository
    extends JpaRepository<UnidadVinculacion, String>, JpaSpecificationExecutor<UnidadVinculacion> {

}
