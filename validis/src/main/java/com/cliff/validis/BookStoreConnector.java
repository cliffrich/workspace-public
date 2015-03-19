package com.cliff.validis;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cliffr
 * 
 * A connector class that connects to a database, access the encrypted book text and returns the 
 * text un-encrypted so that this connector can be integrated to the website by the web team in 
 * order to display ebooks online
 * 
 */
public class BookStoreConnector {
	private static final String BOOK_QUERY = "select data from b0dy";
	private static final String RULE_QUERY = "select start, length, rotate from crypt";
	private static final String CONNECTION_URL = "jdbc:sqlite:C:\\Users\\xxx\\Downloads\\puzzle.db3";
	private List<EncryptionRule> encryptionRules =  loadEncryptionRules();
	
	/**
	 * This method connects to the database, access the encrypted book text and returns the 
	 * text de-crypted.
	 * 
	 * @return
	 */
	private String getBookText(){
		StringBuffer unencryptedBookText = new StringBuffer();
		try {
			Connection connection = DriverManager.getConnection(CONNECTION_URL);
			if(connection == null)
				return "";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(BOOK_QUERY);
			while ( rs.next() ) {
				String encryptedText = rs.getString("data");
				unencryptedBookText.append(unencryptBookText(encryptedText));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
		return unencryptedBookText.toString();
	}
	/**
	 * This method iterates through the rules and applies rules to the 
	 * given input string repeatedly until all rules are applied
	 * 
	 * @param encryptedBookText - The encrypted text that needs un-encrypted
	 * @return - The un-encrypted text
	 */
	private String unencryptBookText(String encryptedBookText){
		String ruleAppliedBookText = encryptedBookText;
		for(EncryptionRule rule:encryptionRules){
			ruleAppliedBookText = applyRule(ruleAppliedBookText, rule);
		}
		return ruleAppliedBookText;
	}
	/**
	 * This method applies the encryption rule to the input string.
	 * 
	 * @param unencryptedText - This string is expected to be of the same length as defined in the rule
	 * @param rule
	 * @return the un-encrypted text
	 */
	private String applyRule(String unencryptedText, EncryptionRule rule){
		//TODO:
		return "";
	}
	private List<EncryptionRule> loadEncryptionRules(){
		List<EncryptionRule> encryptionRules = new ArrayList<EncryptionRule>();
		try {
			Connection connection = DriverManager.getConnection(CONNECTION_URL);
			if(connection == null)
				return null;
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(RULE_QUERY);
			while ( rs.next() ) {
				String encryptedText = rs.getString("data");
				encryptionRules.add(new EncryptionRule(rs.getInt("start"), rs.getInt("length"), rs.getInt("rotate")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Collections.sort(encryptionRules); // Sort the collection to help us when applying the rules
		return encryptionRules;
	}
	
	public static void main(String[] args) {
		BookStoreConnector bookStoreConnector = new BookStoreConnector();
		System.out.println(bookStoreConnector.getBookText());
	}
	/**
	 * Encapsulates the encryption rules.
	 * Implements comparable so that we can have a sorted collection of rules
	 *
	 */
	class EncryptionRule implements Comparable<EncryptionRule>{
		private int start;
		private int length;
		private int rotate;
		
		public EncryptionRule(int start, int length, int rotate) {
			this.start = start;
			this.length = length;
			this.rotate = rotate;
		}
		
		public int getStart() {
			return start;
		}

		public int getLength() {
			return length;
		}

		public int getRotate() {
			return rotate;
		}

		public int compareTo(EncryptionRule o) {
			int otherStart = o.getStart();
			return this.getStart() - otherStart;
		}

	}
}
