package com.project.controller;

import java.time.LocalDate;
import java.util.List;

// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Match;
import com.project.model.Team;
import com.project.repository.MatchRepository;
import com.project.repository.TeamRepository;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
public class TeamController {
	
	private TeamRepository teamRepository;
	
	private MatchRepository matchRepository;
	
	
	
	
	public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
		this.teamRepository = teamRepository;
		this.matchRepository = matchRepository;
	}


	@GetMapping("/team")
	public Iterable<Team> getAllTeams(){
		return teamRepository.findAll();
	}


	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		
		Team team = teamRepository.findByTeamName(teamName);
		
		team.setMatches(matchRepository.findLatestmatchesByTeam(teamName, 4));
		
		return team;
	}

	@GetMapping("/team/{teamName}/matches")
	public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
		LocalDate startDate = LocalDate.of(year, 1, 1);
		LocalDate endDate = LocalDate.of(year+1, 1, 1);

		return matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);
	}
	

}
