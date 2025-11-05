package org.crue.hercules.sgi.sgo.exceptions;

import org.crue.hercules.sgi.sgo.model.Centro;

/**
 * CentroNotFoundException
 */
public class CentroNotFoundException extends SgoNotFoundException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public CentroNotFoundException(String id) {
    super(id, Centro.class);
  }

}
