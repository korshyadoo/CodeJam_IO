package nf.co.korshyadoo.CodeJam.io;

public interface CaseLength {
	/**
	 * Informs whether or not the length of the cases are static
	 * @return {@code true} if the cases have a static length; otherwise, {@code false}
	 */
	boolean isStatic();
	
	/**
	 * If the cases have a static length, this returns the length, in lines, of the cases
	 * @return The length of the cases in lines
	 * @throws IllegalStateException If the cases do not have a static length, calling this method throws an exception
	 */
	int getStaticLength() throws IllegalStateException;
	
	/**
	 * If the cases have a variable length, this method informs which line the length of the case can be found on (starting at 0).
	 * @return The line containing the length of the case (0 based)
	 * @throws IllegalStateException If the cases have a static length, this method throws an exception
	 */
	int getLocationLine() throws IllegalStateException;
	
	/**
	 * If the cases have a variable length, this method informs which index the length of the case can be found in (starting at 0).
	 * e.g. If the length of the case can be found at index 2 on line 1, this method returns 2 and getLocationLine() 
	 * will return 1.
	 * @return The index where the case length can be found
	 * @throws IllegalStateException If the cases have a static length, this method throws an exception
	 */
	int getLocationIndex() throws IllegalStateException;
	
	/**
	 * The multiplier to multiply the case length by to retrieve the total case length.
	 *  
	 * Some cases embed a variable case length that is to be multiplied by a specific integer 
	 * to obtain the total number of lines to follow the line containing the case length.
	 * @return The multiplier for the case length
	 */
	int getMultiplier();
	
	/**
	 * The number of additional lines following the number of lines indicated by the case length and multiplier.
	 * 
	 * Some cases specify a variable case length that indicates the number of lines to follow, but 
	 * also have a static number of additional lines. 
	 * @return The number of additional lines in the case
	 */
	int getAdditionalLines();
}
