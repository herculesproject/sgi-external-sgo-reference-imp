package org.crue.hercules.sgi.sgo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = Departamento.TABLE_NAME)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departamento extends BaseEntity {

  protected static final String TABLE_NAME = "departamento";

  private static final String ID_COLUMN_NAME = "id";
  private static final String NOMBRE_COLUMN_NAME = "nombre";

  /** Id */
  @Id
  @Column(name = ID_COLUMN_NAME)
  private String id;

  /** Nombre */
  @Column(name = NOMBRE_COLUMN_NAME)
  private String nombre;

}
