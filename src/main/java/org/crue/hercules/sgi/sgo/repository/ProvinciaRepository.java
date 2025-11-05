package org.crue.hercules.sgi.sgo.repository;

import org.crue.hercules.sgi.sgo.model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProvinciaRepository extends JpaRepository<Provincia, String>, JpaSpecificationExecutor<Provincia> {

}
