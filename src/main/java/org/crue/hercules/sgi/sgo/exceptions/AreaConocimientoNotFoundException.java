package org.crue.hercules.sgi.sgo.exceptions;

import org.crue.hercules.sgi.sgo.model.AreaConocimiento;

/**
 * AreaConocimientoNotFoundException
 */
public class AreaConocimientoNotFoundException extends SgoNotFoundException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public AreaConocimientoNotFoundException(String id) {
    super(id, AreaConocimiento.class);
  }

}
