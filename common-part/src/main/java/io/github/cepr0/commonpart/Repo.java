package io.github.cepr0.commonpart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Sergei Poznanski, 2018-02-02
 */
@RepositoryRestResource
public interface Repo extends JpaRepository<Model, Integer> {
}
