package com.rasmoo.cliente.escola.gradecurricular.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class MateriaException extends RuntimeException {

  /**
   *serial Generated
   */
  private static final long serialVersionUID = 1L;

  private final HttpStatus httpStatus;

  public MateriaException(final String mensagem, final HttpStatus httpStatus) {
    super(mensagem);
    this.httpStatus = httpStatus;
  }
  
}
