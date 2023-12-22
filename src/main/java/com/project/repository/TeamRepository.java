package com.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long>{

	Team findByTeamName(String teamName);
}
