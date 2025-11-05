package org.crue.hercules.sgi.sgo.exceptions;

import org.crue.hercules.sgi.sgo.model.ComunidadAutonoma;

/**
 * ComunidadAutonomaNotFoundException
 */
public class ComunidadAutonomaNotFoundException extends SgoNotFoundException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public ComunidadAutonomaNotFoundException(String id) {
    super(id, ComunidadAutonoma.class);
  }

}
