package com.chamber.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cliffr
 * 
 * This class provides station search facility to return a station that matches a search string along with its next character.
 *
 */
public class StationSearcher {
	private List<String> stations = new ArrayList<String>();	
	public static final String STATION_NEXT_CHARACTER_SEPARATOR = "@"; // Station and its next character separated with this character
	
	/**
	 * This constructor can be created with a dependent 'stations provider'
	 * For simplicity, I am supplying an array of string.
	 * Whatever the 'stations provider' implementation is, the stations get sorted first in order to minimise the number of iterations.
	 * 
	 * @param arrStations
	 */
	public StationSearcher(String[] arrStations) {
		Arrays.sort(arrStations);
		stations = Arrays.asList(arrStations);
	}

	/**
	 * Given a search text, this method will return all stations that start with the search text 
	 * along with the next character of the matched station separated with a '@' symbol.
	 * This search algorithm is case insensitive.
	 * 
	 * @param searchText
	 * @return NULL. Else, a collection of stations along with its next character separated with a '@' symbol. 
	 */
	public List<String> getMatchingStationsWithNextCharacter(String searchText) {
		List<String> matchedStations = new ArrayList<String>();
		if(!validateAndContinue(stations, searchText))
			return matchedStations;
		try {
			Pattern pattern = Pattern.compile(searchText, Pattern.CASE_INSENSITIVE);
			Matcher matcher = null;
			boolean startedToMatch = false;
			for(String station:stations){
				matcher = pattern.matcher(station);
				if(matcher.find()){
					startedToMatch = true;
					matchedStations.add(station + STATION_NEXT_CHARACTER_SEPARATOR + getNextCharacterForMatchedStation(station, searchText));
				} else{
					if(startedToMatch) // limiting the search. 
						break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matchedStations;
	}
	/**
	 * Given a matched station and a search text, this method returns the next character for the matched station
	 * 
	 * @param matchedStation
	 * @param searchText
	 * @return
	 */
	public static String getNextCharacterForMatchedStation(String matchedStation, String searchText){
		if(matchedStation.equalsIgnoreCase(searchText))
			return " ";
		return matchedStation.substring(searchText.length(), searchText.length()+1);
	}
	/**
	 * @param stations
	 * @param searchText
	 * @return true if the validation is success
	 */
	private boolean validateAndContinue(List<String> stations, String searchText){
		if(stations.isEmpty() || searchText == null)
			return false;
		return true;
	}

}
