package com.project.model;

import java.time.LocalDate;
// import java.util.Arrays;
// import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Match {
	
	@Id
	private long id;
	private String city; 
	private LocalDate date;
	private String season;
	private String matchNumber;
	private String team1;
	private String team2;
	private String venue;
	private String playerOfMatch;
	private String tossWinner;
	private String tossDecision;
	private String winningTeam;
	private String result;
	private String margin;
	private String umpire1;
	private String umpire2;
	private String superOver;
	private String team1Players;
	private String team2Players;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getMatchNumber() {
		return matchNumber;
	}
	public void setMatchNumber(String matchNumber) {
		this.matchNumber = matchNumber;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getPlayerOfMatch() {
		return playerOfMatch;
	}
	public void setPlayerOfMatch(String playerOfMatch) {
		this.playerOfMatch = playerOfMatch;
	}
	public String getTossWinner() {
		return tossWinner;
	}
	public void setTossWinner(String tossWinner) {
		this.tossWinner = tossWinner;
	}
	public String getTossDecision() {
		return tossDecision;
	}
	public void setTossDecision(String tossDecision) {
		this.tossDecision = tossDecision;
	}
	public String getWinningTeam() {
		return winningTeam;
	}
	public void setWinningTeam(String winningTeam) {
		this.winningTeam = winningTeam;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMargin() {
		return margin;
	}
	public void setMargin(String margin) {
		this.margin = margin;
	}
	public String getUmpire1() {
		return umpire1;
	}
	public void setUmpire1(String umpire1) {
		this.umpire1 = umpire1;
	}
	public String getUmpire2() {
		return umpire2;
	}
	public void setUmpire2(String umpire2) {
		this.umpire2 = umpire2;
	}
	public String getSuperOver() {
		return superOver;
	}
	public void setSuperOver(String superOver) {
		this.superOver = superOver;
	}
	public String getTeam1Players() {
		return team1Players;
	}
	public void setTeam1Players(String team1Players) {
		this.team1Players = team1Players;
	}
	public String getTeam2Players() {
		return team2Players;
	}
	public void setTeam2Players(String team2Players) {
		this.team2Players = team2Players;
	}
	@Override
	public String toString() {
		return "Match [id=" + id + ", city=" + city + ", date=" + date + ", season=" + season + ", matchNumber="
				+ matchNumber + ", team1=" + team1 + ", team2=" + team2 + ", venue=" + venue + ", playerOfMatch="
				+ playerOfMatch + ", tossWinner=" + tossWinner + ", tossDecision=" + tossDecision + ", winningTeam="
				+ winningTeam + ", result=" + result + ", margin=" + margin + ", umpire1=" + umpire1 + ", umpire2="
				+ umpire2 + ", superOver=" + superOver + ", team1Players=" + team1Players + ", team2Players="
				+ team2Players + "]";
	}
	
	
	
	
	
	

}
