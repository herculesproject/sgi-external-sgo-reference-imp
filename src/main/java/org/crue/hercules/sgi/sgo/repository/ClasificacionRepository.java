package org.crue.hercules.sgi.sgo.repository;

import org.crue.hercules.sgi.sgo.model.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ClasificacionRepository
    extends JpaRepository<Clasificacion, String>, JpaSpecificationExecutor<Clasificacion> {

}
