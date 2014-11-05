package nf.co.korshyadoo.CodeJam.io;

public class EmbeddedWithMultiplierCaseLength implements CaseLength {
	private final int line;
	private final int index;
	private final int multiplier;
	
	public EmbeddedWithMultiplierCaseLength(int line, int index, int multiplier) {
		this.line = line;
		this.index = index;
		this.multiplier = multiplier;
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
		return multiplier;
	}

	@Override
	public int getAdditionalLines() {
		return 0;
	}

}
