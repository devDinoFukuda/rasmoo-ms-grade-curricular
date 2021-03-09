package com.rasmoo.cliente.escola.gradecurricular.service;

import com.rasmoo.cliente.escola.gradecurricular.dto.MateriaDto;
import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;
import java.util.List;

public interface IMateriaService {

  //PUT
  public String atualizar(final MateriaDto materia);
  //DELETE
  public String excluir(final Long id);
  //GET List
  public List<MateriaDto> listar();
  //GET id
  public MateriaDto consultar(final Long id);
  //POST
  public String cadastrar(final MateriaDto materia);
  
}
