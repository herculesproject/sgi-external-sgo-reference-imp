package org.crue.hercules.sgi.sgo.exceptions;

import org.crue.hercules.sgi.sgo.model.Departamento;

/**
 * DepartamentoNotFoundException
 */
public class DepartamentoNotFoundException extends SgoNotFoundException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public DepartamentoNotFoundException(String id) {
    super(id, Departamento.class);
  }

}
