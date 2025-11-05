package org.crue.hercules.sgi.sgo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.crue.hercules.sgi.sgo.model.PalabraClave;

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
public class PalabraClaveInput implements Serializable {

  @NotNull
  @Size(max = PalabraClave.PALABRA_CLAVE_MAX_LENGTH)
  private String palabra;

}
