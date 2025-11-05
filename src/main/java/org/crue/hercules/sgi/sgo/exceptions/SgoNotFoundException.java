package org.crue.hercules.sgi.sgo.exceptions;

import org.crue.hercules.sgi.framework.exception.NotFoundException;
import org.crue.hercules.sgi.framework.problem.message.ProblemMessage;
import org.crue.hercules.sgi.framework.spring.context.support.ApplicationContextSupport;

/**
 * SgoNotFoundException
 */
public class SgoNotFoundException extends NotFoundException {

  private static final String PROBLEM_MESSAGE_PARAMETER_ENTITY = "entity";
  private static final String MESSAGE_KEY_ID = "id";

  /**
   * Serial version
   */
  private static final long serialVersionUID = 1L;

  public SgoNotFoundException(String message) {
    super(message);
  }

  public SgoNotFoundException(Long id, Class<?> clazz) {
    super(ProblemMessage.builder().key(SgoNotFoundException.class)
        .parameter(PROBLEM_MESSAGE_PARAMETER_ENTITY, ApplicationContextSupport.getMessage(clazz))
        .parameter(MESSAGE_KEY_ID, id).build());
  }

  public SgoNotFoundException(String id, Class<?> clazz) {
    super(ProblemMessage.builder().key(SgoNotFoundException.class)
        .parameter(PROBLEM_MESSAGE_PARAMETER_ENTITY, ApplicationContextSupport.getMessage(clazz))
        .parameter(MESSAGE_KEY_ID, id).build());
  }

}
