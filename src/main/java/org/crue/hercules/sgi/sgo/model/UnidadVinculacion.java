package org.crue.hercules.sgi.sgo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

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
@Table(name = UnidadVinculacion.TABLE_NAME, uniqueConstraints = {
    @UniqueConstraint(columnNames = { "nombre", "predecesor_id" }, name = "UK_UNIDADVINCULACION_NOMBRE_PREDECESOR") })
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadVinculacion extends BaseEntity {

  protected static final String TABLE_NAME = "unidad_vinculacion";

  private static final String ID_COLUMN_NAME = "id";
  private static final String NOMBRE_COLUMN_NAME = "nombre";
  private static final String CODIGO_COLUMN_NAME = "codigo";
  private static final String ACTIVO_COLUMN_NAME = "activo";
  private static final String PREDECESOR_ID_COLUMN_NAME = "predecesor_id";

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = ID_COLUMN_NAME, nullable = false)
  @NotBlank
  private String id;

  @Column(name = NOMBRE_COLUMN_NAME)
  @NotBlank
  private String nombre;

  @Column(name = CODIGO_COLUMN_NAME)
  @NotBlank
  private String codigo;

  @Column(name = ACTIVO_COLUMN_NAME, nullable = false)
  private Boolean activo;

  @Column(name = PREDECESOR_ID_COLUMN_NAME, nullable = true)
  private String predecesorId;

  // Relations mapping, only for JPA metamodel generation
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = PREDECESOR_ID_COLUMN_NAME, nullable = true, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_UNIDADVINCULACION_PREDECESOR"))
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  @SuppressWarnings("java:S1170")
  private final UnidadVinculacion predecesor = null;

}
