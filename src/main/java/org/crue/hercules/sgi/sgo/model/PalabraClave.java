package org.crue.hercules.sgi.sgo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = PalabraClave.TABLE_NAME)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PalabraClave extends BaseEntity {

  protected static final String TABLE_NAME = "palabra_clave";
  private static final String PALABRA_COLUMN_NAME = "palabra";

  public static final int PALABRA_CLAVE_MAX_LENGTH = 250;

  /**
   * Serial version
   */
  private static final long serialVersionUID = 1L;

  /** Palabra clave */
  @Id
  @Column(name = PALABRA_COLUMN_NAME, length = PALABRA_CLAVE_MAX_LENGTH, nullable = false)
  @NotBlank
  private String palabra;

  /**
   * Interfaz para marcar validaciones en la creación de la entidad.
   */
  public interface OnCrear {
  }

}
