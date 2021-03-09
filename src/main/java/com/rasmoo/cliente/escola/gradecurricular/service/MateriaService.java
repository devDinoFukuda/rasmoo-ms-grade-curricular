package com.rasmoo.cliente.escola.gradecurricular.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.rasmoo.cliente.escola.gradecurricular.entity.MateriaEntity;
import com.rasmoo.cliente.escola.gradecurricular.exceptions.MateriaException;
import com.rasmoo.cliente.escola.gradecurricular.repositories.IMateriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MateriaService implements IMateriaService {
  
  @Autowired
  private IMateriaRepository materiaRepository;


  @Override
  public List<MateriaEntity> listar() {
    try {

      return this.materiaRepository.findAll();
      
    } catch (Exception e) {
      
      return new ArrayList<>();

    }
    
    
  }

  @Override
  public MateriaEntity consultar(Long id) {
    
    try {

      Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(id);
      if (materiaOptional.isPresent()) {
        return materiaOptional.get();

      } else {
        throw new MateriaException("Matéria não encontrada", 
        HttpStatus.NOT_FOUND);
      } 
      } catch (MateriaException mException) {
        throw mException;
      } catch (Exception e) {
        throw new MateriaException("Erro interno inesperado, contate o suporte", 
        HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
      
    
  @Override
  public String cadastrar(MateriaEntity materia) {
    try {
      this.materiaRepository.save(materia);
      return ("Matéria cadastrada com sucesso!");
    } catch (Exception e) {
      return ("Desculpe, não foi possivel criar matéria.");
    }
    
  }

  @Override
  public String atualizar(MateriaEntity materia) {
    try {
  
        //buscando materia para atualizar
      MateriaEntity materiaEntityAtualizada = this.consultar(materia.getId());

      //atualizar todos os valores:
      materiaEntityAtualizada.setNome(materia.getNome());
      materiaEntityAtualizada.setCodigo(materia.getCodigo());
      materiaEntityAtualizada.setFrequencia(materia.getFrequencia());
      materiaEntityAtualizada.setHoras(materia.getHoras());

      //salvando alterações
      this.materiaRepository.save(materiaEntityAtualizada);

      return ("Alterações efetuadas com sucesso");
 
  } catch (MateriaException mException) {
    throw mException;
  } catch (Exception eException) {
    throw eException;
  }
}

  @Override
  public String excluir(Long id) {
    try {
      this.consultar(id);
      this.materiaRepository.deleteById(id);
      return ("Matéria excluida com Sucesso!");
  } catch (MateriaException mException) {
    throw mException;
  } catch (Exception eException) {
    throw eException;
  }
}

 

  
  
}
