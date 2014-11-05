package nf.co.korshyadoo.CodeJam.io;

public class StaticCaseLength implements CaseLength {
	private final int length;
	
	public StaticCaseLength(int length) {
		this.length = length;
	}

	@Override
	public boolean isStatic() {
		return true;
	}

	@Override
	public int getStaticLength() throws IllegalStateException {
		return length;
	}

	@Override
	public int getLocationLine() throws IllegalStateException {
		throw new IllegalStateException("This method cannot be called on a static case length");
	}

	@Override
	public int getLocationIndex() throws IllegalStateException {
		throw new IllegalStateException("This method cannot be called on a static case length");
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
