package nf.co.korshyadoo.CodeJam.io;

import java.util.List;

/**
 * This class is used to retrieve the {@code Case}s from the input file and return them in a java.util.List.
 * @author korshyadoo
 *
 */
public interface CaseRetriever {
	/**
	 * Takes the lines from the input file and separates them into individual {@code Case}s.
	 * @return A {@code List<Case>} containing the separated cases from the input file
	 */
	public List<Case> retrieveCases();
}
