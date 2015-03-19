package com.chamber.search;

import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author cliffr
 * 
 * Test cases to test StationSearcher class
 */
public class TestStationSearcher extends TestCase {
	
	public TestStationSearcher(String name) {
		super(name);
	}
	
	/**
	 * Test if the next character of a given matched station is as expected
	 */
	@Test
	public void testForNextCharacter(){
		String nextCharacter = StationSearcher.getNextCharacterForMatchedStation("LIVERPOOL LIME STREET", "LIVERPOOL");
		assertEquals("Next character: ", " ", nextCharacter);
		nextCharacter = StationSearcher.getNextCharacterForMatchedStation("DARTMOUTH", "DART");
		assertEquals("Next character: ", "M", nextCharacter);
	}
	
	/**
	 * Test for case insensitive match
	 */
	@Test
	public void testForCaseInsensitiveMatch(){
		StationSearcher stationSearcher = new StationSearcher(new String[]{"LIVERPOOL"});
		List<String> matchedStations = stationSearcher.getMatchingStationsWithNextCharacter("liverpool");
		checkForValues(matchedStations.get(0), "LIVERPOOL", " ");
	}

	/**
	 * Test the total number of matching stations returned and their values
	 */
	@Test
	public void testForMatchingStationWithNextCharacter(){
		StationSearcher stationSearcher = new StationSearcher(new String[]{"DARTMOUTH","BRACKNELL","AYLESBURY", "DARTFORD", "TOWER HILL", "BUCKINGHAM", "DERBY"});
		List<String> matchedStations = stationSearcher.getMatchingStationsWithNextCharacter("DART");
		assertEquals("Total number of matches: ", 2, matchedStations.size());
		checkForValues(matchedStations.get(0), "DARTFORD", "F");
		checkForValues(matchedStations.get(1), "DARTMOUTH", "M");
	}
	
	/**
	 * Test for non-matching search text
	 */
	@Test
	public void testForNoMatchingStation(){
		StationSearcher stationSearcher = new StationSearcher(new String[]{"EUSTON", "LONDON BRIDGE", "VICTORIA"});
		List<String> matchedStations = stationSearcher.getMatchingStationsWithNextCharacter("KINGS CROSS");
		assertEquals("Total number of matches: ", 0, matchedStations.size());
	}
	/**
	 * Test for non-matching search text
	 */
	@Test
	public void testForEmptyStationList(){
		StationSearcher stationSearcher = new StationSearcher(new String[]{});
		List<String> matchedStations = stationSearcher.getMatchingStationsWithNextCharacter("KINGS CROSS");
		assertEquals("Total number of matches: ", 0, matchedStations.size());
	}
	/**
	 * Test for null search text
	 */
	@Test
	public void testWithNullSearchText(){
		StationSearcher stationSearcher = new StationSearcher(new String[]{"KINGS CROSS"});
		List<String> matchedStations = stationSearcher.getMatchingStationsWithNextCharacter(null);
		assertEquals("Total number of matches: ", 0, matchedStations.size());
	}

	private void checkForValues(String matchedStation, String expectedMatch, String nextCharacter){
		String[] arrStation = matchedStation.split(StationSearcher.STATION_NEXT_CHARACTER_SEPARATOR);
		assertEquals("Matched station: ", expectedMatch, arrStation[0]);
		assertEquals("Next character: ", nextCharacter, arrStation[1]);
	}

}
