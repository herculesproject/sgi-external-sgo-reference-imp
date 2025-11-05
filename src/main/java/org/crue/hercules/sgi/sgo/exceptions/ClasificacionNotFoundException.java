package org.crue.hercules.sgi.sgo.exceptions;

import org.crue.hercules.sgi.sgo.model.Clasificacion;

/**
 * ClasificacionNotFoundException
 */
public class ClasificacionNotFoundException extends SgoNotFoundException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public ClasificacionNotFoundException(String id) {
    super(id, Clasificacion.class);
  }

}
