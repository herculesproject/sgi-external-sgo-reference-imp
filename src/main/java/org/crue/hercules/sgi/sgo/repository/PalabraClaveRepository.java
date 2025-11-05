package org.crue.hercules.sgi.sgo.repository;

import org.crue.hercules.sgi.sgo.model.PalabraClave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PalabraClaveRepository
    extends JpaRepository<PalabraClave, String>, JpaSpecificationExecutor<PalabraClave> {

}
