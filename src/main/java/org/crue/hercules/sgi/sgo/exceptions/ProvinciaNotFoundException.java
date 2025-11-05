package org.crue.hercules.sgi.sgo.exceptions;

import org.crue.hercules.sgi.sgo.model.Provincia;

/**
 * ProvinciaNotFoundException
 */
public class ProvinciaNotFoundException extends SgoNotFoundException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public ProvinciaNotFoundException(String id) {
    super(id, Provincia.class);
  }

}
