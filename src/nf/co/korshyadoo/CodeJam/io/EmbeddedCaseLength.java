package nf.co.korshyadoo.CodeJam.io;

public class EmbeddedCaseLength implements CaseLength {
	private final int line;
	private final int index;
	
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
