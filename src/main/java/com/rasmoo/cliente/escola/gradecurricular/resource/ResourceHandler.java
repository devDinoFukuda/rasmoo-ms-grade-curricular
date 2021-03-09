package com.rasmoo.cliente.escola.gradecurricular.resource;

import com.rasmoo.cliente.escola.gradecurricular.exceptions.MateriaException;
import com.rasmoo.cliente.escola.gradecurricular.models.ErrorResponse;
import com.rasmoo.cliente.escola.gradecurricular.models.ErrorResponse.ErrorResponseBuilder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice: centralizando nossas Exceptions como
//a ExceptionHandler
@ControllerAdvice
public class ResourceHandler {

  @ExceptionHandler(MateriaException.class)
  public ResponseEntity<ErrorResponse> handleMateriaException(MateriaException mException) {
    ErrorResponseBuilder erro = ErrorResponse.builder();
    erro.httpStatus(mException.getHttpStatus().value());
    erro.mensagem(mException.getMessage());
    erro.timeStamp(System.currentTimeMillis());

    return ResponseEntity.status(mException.getHttpStatus()).body(erro.build());
  }
  
}
