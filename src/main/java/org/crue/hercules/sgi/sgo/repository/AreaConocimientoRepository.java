package org.crue.hercules.sgi.sgo.repository;

import org.crue.hercules.sgi.sgo.model.AreaConocimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AreaConocimientoRepository
    extends JpaRepository<AreaConocimiento, String>, JpaSpecificationExecutor<AreaConocimiento> {

}
