package com.projetosAcademicos.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "projeto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "area")
	private String area;
	
	@Column(name = "resumo")
	private String resumo;
	
	@Column(name = "palavraChave1")
	private String palavraChave1;
	
	@Column(name = "palavraChave2")
	private String palavraChave2;
	
	@Column(name = "palavraChave3")
	private String palavraChave3;
	
	@Column(name = "urlDocumento")
	private String url;
	
	@OneToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fk_professor_id", foreignKey = @ForeignKey(name = "fk_professor"), referencedColumnName = "id")
	private Professor professorResponsavel;
	
	@OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "projeto_alunos", 
    			joinColumns={@JoinColumn(name="fK_projeto_id", foreignKey = @ForeignKey(name = "fk_projeto"), referencedColumnName = "id")},
    			inverseJoinColumns={@JoinColumn(name="fk_aluno_id", foreignKey = @ForeignKey(name = "fk_aluno"), referencedColumnName = "id")}    				)
	private List<Aluno> alunos;

}
