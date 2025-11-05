package org.crue.hercules.sgi.sgo.repository;

import org.crue.hercules.sgi.sgo.model.Centro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CentroRepository extends JpaRepository<Centro, String>, JpaSpecificationExecutor<Centro> {

}
