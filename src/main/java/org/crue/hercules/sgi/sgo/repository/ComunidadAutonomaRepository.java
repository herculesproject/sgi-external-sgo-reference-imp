package org.crue.hercules.sgi.sgo.repository;

import org.crue.hercules.sgi.sgo.model.ComunidadAutonoma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ComunidadAutonomaRepository
    extends JpaRepository<ComunidadAutonoma, String>, JpaSpecificationExecutor<ComunidadAutonoma> {

}
