package org.crue.hercules.sgi.sgo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = Clasificacion.TABLE_NAME, uniqueConstraints = {
    @UniqueConstraint(columnNames = { "nombre", "padre_id" }, name = "UK_CLASIFICACION_NOMBRE_PADRE") })
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clasificacion extends BaseEntity {

  protected static final String TABLE_NAME = "clasificacion";

  private static final String ID_COLUMN_NAME = "id";
  private static final String NOMBRE_COLUMN_NAME = "nombre";
  private static final String CODIGO_COLUMN_NAME = "codigo";
  private static final String TIPO_COLUMN_NAME = "tipo";
  private static final String CLASIFICACION_PADRE_ID_COLUMN_NAME = "padre_id";

  public static final int TIPO_MAX_LENGTH = 50;

  /** Tipos de colectivo */
  public enum Tipo {
    /** Sectores industriales */
    SECTORES_INDUSTRIALES,
    /** ANEP */
    ANEP;
  }

  /**
   * Serial version
   */
  private static final long serialVersionUID = 1L;

  /** Id */
  @Id
  @Column(name = ID_COLUMN_NAME, nullable = false)
  @NotBlank
  private String id;

  /** Nombre */
  @Column(name = NOMBRE_COLUMN_NAME)
  @NotBlank
  private String nombre;

  /** Codigo */
  @Column(name = CODIGO_COLUMN_NAME)
  @NotBlank
  private String codigo;

  /** Tipo */
  @Column(name = TIPO_COLUMN_NAME, length = TIPO_MAX_LENGTH, nullable = true)
  @Enumerated(EnumType.STRING)
  private Tipo tipoClasificacion;

  /** Clasificacion padre Id */
  @Column(name = CLASIFICACION_PADRE_ID_COLUMN_NAME, nullable = true)
  private String padreId;

  // Relations mapping, only for JPA metamodel generation
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = CLASIFICACION_PADRE_ID_COLUMN_NAME, nullable = true, insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_CLASIFICACION_PADRE"))
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  private final Clasificacion padre = null;

}
