package fr.fms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor //@ToString
public class Article implements Serializable {
	private static final long serialVersionUID=1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=5,max=50)
	private String description;
	
	@DecimalMin("50")
	private double price;
	
	@ManyToOne
	private Category category;

	
	public Article(@Size(min = 5, max = 50) String description, @DecimalMin("50") double price, Category category) {
		super();
		this.description = description;
		this.price = price;
		this.category = category;
	}


	@Override
	public String toString() {
		return "Article [id=" + id + ", description=" + description + ", price=" + price + "]";
	}
	
	

}
