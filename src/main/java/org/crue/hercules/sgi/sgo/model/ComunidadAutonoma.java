package org.crue.hercules.sgi.sgo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = ComunidadAutonoma.TABLE_NAME)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComunidadAutonoma extends BaseEntity {

  protected static final String TABLE_NAME = "comunidad_autonoma";

  private static final String ID_COLUMN_NAME = "id";
  private static final String NOMBRE_COLUMN_NAME = "nombre";
  private static final String PAIS_ID_COLUMN_NAME = "pais_id";

  /** Id */
  @Id
  @Column(name = ID_COLUMN_NAME)
  private String id;

  /** Nombre */
  @Column(name = NOMBRE_COLUMN_NAME)
  private String nombre;

  /** Pais Id */
  @Column(name = PAIS_ID_COLUMN_NAME)
  private String paisId;

  // Relations mapping, only for JPA metamodel generation
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = PAIS_ID_COLUMN_NAME, insertable = false, updatable = false)
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private final Pais pais = null;

}
