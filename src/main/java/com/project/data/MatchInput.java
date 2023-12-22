package com.project.data;

// import java.util.List;

public class MatchInput {
	
	private String ID;
	private String City; 
	private String Date;
	private String Season;
	private String MatchNumber;
	private String Team1;
	private String Team2;
	private String Venue;
	private String Player_of_Match;
	private String TossWinner;
	private String TossDecision;
	private String WinningTeam;
	private String WonBy;
	private String Margin;
	private String method;
	private String Umpire1;
	private String Umpire2;
	private String SuperOver;
	private String Team1Players;
	private String Team2Players;
	
	public static String arrayToString(String[] stringArray) {
		StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < stringArray.length; i++) {
            result.append("'").append(stringArray[i]).append("'");
            if (i < stringArray.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");

        // Print the resulting string
        //System.out.println(result.toString());
        return result.toString();
	}
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getSeason() {
		return Season;
	}
	public void setSeason(String season) {
		Season = season;
	}
	public String getMatchNumber() {
		return MatchNumber;
	}
	public void setMatchNumber(String matchNumber) {
		MatchNumber = matchNumber;
	}
	public String getTeam1() {
		return Team1;
	}
	public void setTeam1(String team1) {
		Team1 = team1;
	}
	public String getTeam2() {
		return Team2;
	}
	public void setTeam2(String team2) {
		Team2 = team2;
	}
	public String getVenue() {
		return Venue;
	}
	public void setVenue(String venue) {
		Venue = venue;
	}
	public String getPlayer_of_Match() {
		return Player_of_Match;
	}
	public void setPlayer_of_Match(String player_of_Match) {
		Player_of_Match = player_of_Match;
	}
	public String getTossWinner() {
		return TossWinner;
	}
	public void setTossWinner(String tossWinner) {
		TossWinner = tossWinner;
	}
	public String getTossDecision() {
		return TossDecision;
	}
	public void setTossDecision(String tossDecision) {
		TossDecision = tossDecision;
	}
	public String getWinningTeam() {
		return WinningTeam;
	}
	public void setWinningTeam(String winningTeam) {
		WinningTeam = winningTeam;
	}
	public String getWonBy() {
		return WonBy;
	}
	public void setWonBy(String wonBy) {
		WonBy = wonBy;
	}
	public String getMargin() {
		return Margin;
	}
	public void setMargin(String margin) {
		Margin = margin;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUmpire1() {
		return Umpire1;
	}
	public void setUmpire1(String umpire1) {
		Umpire1 = umpire1;
	}
	public String getUmpire2() {
		return Umpire2;
	}
	public void setUmpire2(String umpire2) {
		Umpire2 = umpire2;
	}
	public String getSuperOver() {
		return SuperOver;
	}
	public void setSuperOver(String superOver) {
		SuperOver = superOver;
	}


	public String getTeam1Players() {
		return Team1Players;
	}


	public void setTeam1Players(String team1Players) {
		Team1Players = team1Players;
	}


	public String getTeam2Players() {
		return Team2Players;
	}


	public void setTeam2Players(String team2Players) {
		Team2Players = team2Players;
	}


	@Override
	public String toString() {
		return "MatchInput [ID=" + ID + ", City=" + City + ", Date=" + Date + ", Season=" + Season + ", MatchNumber="
				+ MatchNumber + ", Team1=" + Team1 + ", Team2=" + Team2 + ", Venue=" + Venue + ", Player_of_Match="
				+ Player_of_Match + ", TossWinner=" + TossWinner + ", TossDecision=" + TossDecision + ", WinningTeam="
				+ WinningTeam + ", WonBy=" + WonBy + ", Margin=" + Margin + ", method=" + method + ", Umpire1="
				+ Umpire1 + ", Umpire2=" + Umpire2 + ", SuperOver=" + SuperOver + ", Team1Players=" + Team1Players
				+ ", Team2Players=" + Team2Players + "]";
	}
	


	
	
	
	
	

}
