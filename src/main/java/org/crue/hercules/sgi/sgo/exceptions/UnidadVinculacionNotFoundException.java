package org.crue.hercules.sgi.sgo.exceptions;

import org.crue.hercules.sgi.sgo.model.UnidadVinculacion;

/**
 * UnidadVinculacionNotFoundException
 */
@SuppressWarnings("java:S110")
public class UnidadVinculacionNotFoundException extends SgoNotFoundException {

  private static final long serialVersionUID = 1L;

  public UnidadVinculacionNotFoundException(String id) {
    super(id, UnidadVinculacion.class);
  }

}
