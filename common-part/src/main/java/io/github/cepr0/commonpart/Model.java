package io.github.cepr0.commonpart;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Sergei Poznanski, 2018-02-02
 */
@Data
@Entity
public class Model {
	@Id @GeneratedValue private Integer id;
	private String name;
}
