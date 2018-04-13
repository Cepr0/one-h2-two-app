package io.github.cepr0.commonpart;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Sergei Poznanski, 2018-02-02
 */
@Data
@NoArgsConstructor
@Entity
public class Model {
	@Id @GeneratedValue private Integer id;
	private String name;
	
	public Model(String name) {
		this.name = name;
	}
}
