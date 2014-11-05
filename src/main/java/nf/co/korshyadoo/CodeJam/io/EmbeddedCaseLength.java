package nf.co.korshyadoo.CodeJam.io;

public class EmbeddedCaseLength implements CaseLength {
	private final int line;
	private final int index;
	
	/**
	 * Creates an EmbeddedCaseLength object from the passed line number and index. 
	 * 
	 * For example, if a cases have a variable number of lines, and the first number on the first line of each case give the number of lines that follow in the case, 
	 * then {@code line} would be 0 and {@code index} would be 0.
	 * 
	 * To demonstrate:
	 * 4 3 8
	 * ###
	 * #X#
	 * #.#
	 * ###
	 * 
	 * The first digit of the first line of each case tells how many lines follow. In this case, 4 more lines are in the case. The constructor would be:
	 * {@code new EmbeddedCaseLength(0, 0);}
	 * @param line The line number (starting at 0), relative to the start of the case, that contains the number of lines in the case
	 * @param index The index (starting at 0) on the line that contains the number of lines in the case
	 */
	public EmbeddedCaseLength(int line, int index) {
		this.line = line;
		this.index = index;
	}

	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public int getStaticLength() throws IllegalStateException {
		throw new IllegalStateException("This method cannot be called on a CaseLength of variable length");
	}

	@Override
	public int getLocationLine() throws IllegalStateException {
		return line;
	}

	@Override
	public int getLocationIndex() throws IllegalStateException {
		return index;
	}

	@Override
	public int getMultiplier() {
		return 1;
	}

	@Override
	public int getAdditionalLines() {
		return 0;
	}

}
