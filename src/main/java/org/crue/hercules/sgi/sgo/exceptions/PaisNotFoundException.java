package org.crue.hercules.sgi.sgo.exceptions;

import org.crue.hercules.sgi.sgo.model.Pais;

/**
 * PaisNotFoundException
 */
public class PaisNotFoundException extends SgoNotFoundException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public PaisNotFoundException(String id) {
    super(id, Pais.class);
  }

}
