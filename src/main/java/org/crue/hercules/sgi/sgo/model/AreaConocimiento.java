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
@Table(name = AreaConocimiento.TABLE_NAME)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AreaConocimiento extends BaseEntity {

  protected static final String TABLE_NAME = "area_conocimiento";

  private static final String ID_COLUMN_NAME = "id";
  private static final String NOMBRE_COLUMN_NAME = "nombre";
  private static final String CLASIFICACION_PADRE_ID_COLUMN_NAME = "padre_id";

  /** Id */
  @Id
  @Column(name = ID_COLUMN_NAME)
  private String id;

  /** Nombre */
  @Column(name = NOMBRE_COLUMN_NAME)
  private String nombre;

  /** Area conocimiento padre Id */
  @Column(name = CLASIFICACION_PADRE_ID_COLUMN_NAME)
  private String padreId;

  // Relations mapping, only for JPA metamodel generation
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = CLASIFICACION_PADRE_ID_COLUMN_NAME, insertable = false, updatable = false)
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private final AreaConocimiento padre = null;

}
