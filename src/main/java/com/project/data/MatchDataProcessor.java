package com.project.data;

import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
// import org.springframework.context.annotation.Bean;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.JsonMappingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match>{
	
	private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);
	
//	public static List<String> convertStringToList(String inputString) {
//        List<String> resultList = new ArrayList<>();
//
//        // Remove square brackets and single quotes from the input string
//        String cleanString = inputString.replaceAll("\\[|\\]|'", "");
//
//        // Split the cleaned string into an array of strings
//        String[] stringArray = cleanString.split(", ");
//
//        // Add each element from the array to the result list
//        for (String element : stringArray) {
//            resultList.add(element);
//        }
//
//        return resultList;
//        
//	}
	
	  
//	  public static String[] convertStringToArray(String inputString ) {
//		  
//		  String stringWithoutBrackets = inputString.substring(1, inputString.length() - 1).replace("'", "");
//
//	      // Split the string into an array of strings using ', ' as the delimiter
//	      String[] stringArray = stringWithoutBrackets.split(", ");
//
//	      // Print the elements of the array
////	      for (String element : stringArray) {
////	          System.out.println(element);
////	      }
//	      return stringArray;
//	  }
	  
//	  public static String[] convertStringToArray(String jsonString ) throws JsonMappingException, JsonProcessingException {
//		  
//		// Remove single quotes around the string elements to make it valid JSON
//	        jsonString = jsonString.replace("'", "\"");
//
//	        // Use Jackson to parse the JSON array
//	        ObjectMapper objectMapper = new ObjectMapper();
//	        String[] stringArray = objectMapper.readValue(jsonString, String[].class);
//	        
//	        return stringArray;
//	  }

	@Override
	public Match process(final MatchInput matchInput) {
		
		Match match = new Match();
		  
		  match.setId(Long.parseLong(matchInput.getID()));
		  match.setCity(matchInput.getCity());
		  match.setDate(LocalDate.parse(matchInput.getDate()));
		  match.setSeason(matchInput.getSeason());
		  match.setMatchNumber(matchInput.getMatchNumber());
		  
		  // Set Team 1 and Team 2 depending on the innings order
		  String firstInningsTeam;
		  String secondInningsTeam;
		  
		  if ("bat".equals(matchInput.getTossDecision())) {
	          firstInningsTeam = matchInput.getTossWinner();
	          secondInningsTeam = matchInput.getTossWinner().equals(matchInput.getTeam1()) 
	              ? matchInput.getTeam2() : matchInput.getTeam1();

	      } else {
	          secondInningsTeam = matchInput.getTossWinner();
	          firstInningsTeam = matchInput.getTossWinner().equals(matchInput.getTeam1()) 
	              ? matchInput.getTeam2() : matchInput.getTeam1();
	      }
		  match.setTeam1(firstInningsTeam);
		  match.setTeam2(secondInningsTeam);
		  match.setVenue(matchInput.getVenue());
		  match.setPlayerOfMatch(matchInput.getPlayer_of_Match());
		  match.setTossWinner(matchInput.getTossWinner());
		  match.setTossDecision(matchInput.getTossDecision());
		  match.setWinningTeam(matchInput.getWinningTeam());
		  match.setResult(matchInput.getWonBy());
		  match.setMargin(matchInput.getMargin());
		  match.setUmpire1(matchInput.getUmpire1());
		  match.setUmpire2(matchInput.getUmpire2());
		  match.setSuperOver(matchInput.getSuperOver());
		  match.setTeam1Players(matchInput.getTeam1Players());
		  match.setTeam2Players(matchInput.getTeam2Players());
		  	  
		  
		  
		  
		  log.info("Converting (" + matchInput + ") into (" + match + ")");
		  
		  
		  return match;
		
	}

}
