package org.crue.hercules.sgi.sgo.repository;

import org.crue.hercules.sgi.sgo.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartamentoRepository
    extends JpaRepository<Departamento, String>, JpaSpecificationExecutor<Departamento> {

}
