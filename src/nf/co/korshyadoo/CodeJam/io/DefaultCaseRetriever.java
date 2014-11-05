package nf.co.korshyadoo.CodeJam.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * This class reads the input file and separates it into {@code Case}s based on case length 
 * information retrieved from the {@code CaseLength} object passed to the constructor.
 * 
 * This class also contains helper methods for separating a single line of space separated values 
 * into their individual tokens.
 * @author korshyadoo
 *
 */
public class DefaultCaseRetriever implements CaseRetriever {
	private final CaseLength[] caseLength;
	private List<String> lines = new ArrayList<>();
	private final String inputFileLocation;
	
	/**
	 * In order for the {@code CaseRetriever} to know how to split up the input lines into {@code Case}s, 
	 * it must know how to locate the information about where the {@code Case} lengths are stored. 
	 * {@code CaseLength} objects are passed to the constructor to provide this information. 
	 * 
	 * If the cases all have the same, known length, one {@code StaticCaseLength} should be passed to
	 * this constructor.
	 * 
	 * If the cases have variable length, indicated by a single integer found within the case, then an 
	 * {@code EmbeddedCaseLength} should be passed to this constructor.
	 * 
	 * If the cases have variable length, indicated by more than one integer found with the case, then 
	 * more than one {@code EmbeddedCaseLength} should be passed to this constructor.
	 * 
	 * If the cases have variable length, indicated by an integer found within the case multiplied 
	 * by a constant, then an {@code EmbeddedWithMultiplierCaseLength} should be passed to this constructor.
	 * 
	 * If the cases have variable length, indicated by an integer found within the case plus an 
	 * additional number of lines, then an {@code EmbeddedWithAdditionCaseLength} should be passed to this constructor.
	 * 
	 * @param caseLength The {@code CaseLength} objects used to determine the length of the cases
	 */
	public DefaultCaseRetriever(String inputFileLocation, CaseLength... caseLength) {
		this.inputFileLocation = inputFileLocation;
		this.caseLength = caseLength;
		lines = new CodeJamFileIO().retrieveLines();
	}

	@Override
	public List<Case> retrieveCases() {
		List<Case> results = new ArrayList<>();
		int currentLine = 1;					//Starts at 1 because line 0 is always the number of cases
		
		//For each case in the input file
		do {
			int currentLength = 0;		
			Set<Integer> lengthSet = new HashSet<>();
			for(CaseLength cl : caseLength) {
				if(cl.isStatic()) {
					currentLength += cl.getStaticLength();
				} else {
					lengthSet.add(cl.getLocationLine());
					String line = lines.get(cl.getLocationLine() + currentLine);
					List<String> tokens = separateLineIntoStrings(line);
					currentLength += (Integer.parseInt(tokens.get(cl.getLocationIndex()))) * cl.getMultiplier() + cl.getAdditionalLines();
				}
			}
			currentLength += lengthSet.size();		//To account for the lines that store lengths
			
			//We now have the length of the current case, so import it into a Case object
			List<String> caseLines = new ArrayList<>();
			for(int x = 0; x < currentLength; x++) {
				caseLines.add(lines.get(currentLine));
				currentLine++;
			}
			Case _case = new DefaultCase(caseLines);
			results.add(_case);
		} while(currentLine < lines.size());
		
		return results;
	}
	
	/**
	 * Used to extract space separated {@code String}s from the input file. A {@code String} representing a line from the input file containing space separated data
	 * is passed into the method, and a {@code List<String>} of the tokens is returned.
	 * @param line A {@code String} of space separated {@code String}s
	 * @return A {@code List<String>} of the segmented space separated data passed into the method
	 */
	public static List<String> separateLineIntoStrings(String line) {
		List<String> result = new ArrayList<>();
		Scanner scanner = new Scanner(line);
		while(scanner.hasNext()) {
			result.add(scanner.next("\\S+"));
		}
		scanner.close();
		return result;
	}
	
	/**
	 * Used to extract space separated {@code Integer}s from the input file. A {@code String} representing a line from the input file containing space separated data
	 * is passed into the method, and a {@code List<Integer>} of the segments is returned.
	 * @param line A {@code String} of space separated {@code Integer}s
	 * @return A {@code List<Integer>} of the segmented space separated data passed into the method
	 */
	public static List<Integer> separateLineIntoIntegers(String line) {
		List<Integer> result = new ArrayList<>();
		Scanner scanner = new Scanner(line);
		while(scanner.hasNext()) {
			result.add((int)scanner.nextInt());
		}
		scanner.close();
		return result;
	}
	
	private class CodeJamFileIO {
		CodeJamFileIO() {
		}

		/**
		 * Reads the input file named in the properties file and returns a {@code List<String>} 
		 * containing the contents of the file, one line per index.  
		 * @return A {@code List<String>} containing the lines retrieved from the input file
		 */
		public List<String> retrieveLines() {
			List<String> lines = new ArrayList<>();
			Path file = Paths.get(inputFileLocation);
			try (InputStream in = Files.newInputStream(file); BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					lines.add(line);
				}
			} catch (IOException x) {
				System.err.println(x);
			}
			return lines;
		}
	}

}
