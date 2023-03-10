package br.com.crudspring.model;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@SQLDelete(sql = "UPDATE Courses SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo' ")
public class Courses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("_id")
	private Long id;
	
	@NotBlank
	@NotNull
	@Size(min = 5, max=100)
	@Column(length = 100, nullable = false)
	private String name;
	
	@NotBlank
	@NotNull
	@Size(max=20)
	@Pattern(regexp = "back-end|front-end|fullstack")
	@Column(length = 20, nullable = false)
	private String category;
	
	@NotBlank
	@NotNull
	@Size(max=20)
	@Pattern(regexp = "Ativo|Inativo")
	@Column(length = 10, nullable = false)
	private String status = "Ativo";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
