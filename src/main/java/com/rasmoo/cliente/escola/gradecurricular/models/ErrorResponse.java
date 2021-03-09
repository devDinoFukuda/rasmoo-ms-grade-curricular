package com.rasmoo.cliente.escola.gradecurricular.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponse {
  private String mensagem;
  private Integer httpStatus;
  private Long timeStamp;
  
}
