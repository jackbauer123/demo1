package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * A repository to manage {@link Person} instances.
 *
 * @author Greg Turnquist
 * @author Oliver Gierke
 */
public interface PersonRepository extends JpaRepository<Person, Long> {}