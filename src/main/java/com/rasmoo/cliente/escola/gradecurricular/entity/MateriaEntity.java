package com.rasmoo.cliente.escola.gradecurricular.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import java.io.Serializable;

import javax.persistence.*;

//Uma entidade do JPA
@Entity
//modificar o nome da tabela em nosso db
@Table( name = "table_materia")
@Data
@NoArgsConstructor
//Utilizar o Lombok p/ criaćão de Getters e Setters
public class MateriaEntity implements Serializable {


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Column(name = "nome")
    private String nome;

    @Column(name = "hrs")
    private Integer horas;

    @Column(name = "cod")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String codigo;

    @Column(name = "freq")
    private Integer frequencia;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }


}
