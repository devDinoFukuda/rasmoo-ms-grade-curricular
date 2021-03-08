package com.rasmoo.cliente.escola.gradecurricular.service;

import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;
import java.util.List;

public interface IMateriaService {

  //PUT
  public String atualizar(final MateriaEntity materia);
  //DELETE
  public String excluir(final Long id);
  //GET List
  public List<MateriaEntity> listar();
  //GET id
  public MateriaEntity consultar(final Long id);
  //POST
  public String cadastrar(final MateriaEntity materia);
  
}
