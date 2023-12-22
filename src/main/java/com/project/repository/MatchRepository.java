package com.project.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long>{
	
	List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2,Pageable pageable);

	@Query("SELECT m from Match m where(m.team1=:teamName or m.team2=:teamName) and m.date between :startDate and :endDate order by m.date desc")
	List<Match> getMatchesByTeamBetweenDates(
		@Param("teamName") String teamName,@Param("startDate") LocalDate dateStart,@Param("endDate") LocalDate dateEnd);

	// List<Match> getByTeam1AndDateBetweenOrTeam2AndDateBetweenOrderByDateDesc(String teamName1,LocalDate date1, LocalDate date2, String teamName2,LocalDate date3, LocalDate date4);
	//absolutely working


	default List<Match> findLatestmatchesByTeam(String teamName, int count){
		return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
	}

}
