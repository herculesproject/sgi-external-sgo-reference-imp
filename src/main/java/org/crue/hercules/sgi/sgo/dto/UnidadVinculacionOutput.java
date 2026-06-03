package org.crue.hercules.sgi.sgo.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadVinculacionOutput implements Serializable {
  private String id;
  private String codigo;
  private String nombre;
  private Boolean activo;
  private String predecesorId;
}
