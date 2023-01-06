package io.github.marabezzi.crudbackend.model;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "course")
@SQLDelete(sql = "UPDATE Course SET status = 'Inativo' WHERE id = ?") //Para soft delete
@Where(clause = "status = 'Ativo'") // mostra apenas com a coluna Ativo
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("_id")
	private Long id;
	
	@NotBlank
	@NotNull
	@Length(min = 5, max = 100)
	@Column(name = "name", length= 100, nullable = false)
	private String name;
	
	
	@NotNull
	@Length(max = 10)
	@Pattern(regexp = "Back-end|Front-end")
	@Column(name = "category", length = 10, nullable = false)
	private String category;
	
	//Remoção Lógica (Soft Delete)
	@NotNull
	@Length(max = 10)
	@Pattern(regexp = "Ativo|Inativo")
	@Column(name = "status", length = 10, nullable = false)
	private String status = "Ativo";
	
}
