package nf.co.korshyadoo.CodeJam.io;

/**
 * Represents a single case in the input file
 * @author korshyadoo
 *
 */
public interface Case {
	/**
	 * Get a specific line in the case. The first line is 0
	 * @param lineIndex The index of the requested line
	 * @return A {@code String} representing the requested line in the case
	 */
	String get(int lineIndex);
	
	/**
	 * The size of the {@code Case}. i.e. the number of lines in the {@code Case}. 
	 * @return The number of lines in the {@code Case}.
	 */
	int size();
}
