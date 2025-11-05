package org.crue.hercules.sgi.sgo.repository;

import org.crue.hercules.sgi.sgo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaisRepository extends JpaRepository<Pais, String>, JpaSpecificationExecutor<Pais> {

}
