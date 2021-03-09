package com.rasmoo.cliente.escola.gradecurricular.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MateriaDto {

  private Long id;

  @NotBlank(message = "Informe a matéria.")
  private String nome;

  @Min(value = 34, message = "carga horária minima por matéria: 34 horas.")
  @Max(value = 120, message = "carga horária máxima por matéria: 120 horas.")
  private Integer horas;

  @NotBlank(message = "Informe o código da matéria.")
  private String codigo;

  @Min(value = 1, message = "Frequência minima por matéria permitida anualmente: 1.")
  @Max(value = 4, message = "Frequência máxima por matéria permitida anualmente: 4.")
  private Integer frequencia;
  
}
