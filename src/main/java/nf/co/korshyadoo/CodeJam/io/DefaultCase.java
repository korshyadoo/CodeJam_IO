package nf.co.korshyadoo.CodeJam.io;

import java.util.ArrayList;
import java.util.List;

public class DefaultCase implements Case {
	private final List<String> lines;
	public DefaultCase(List<String> lines) {
		this.lines = lines;
	}

	@Override
	public String get(int lineIndex) {
		return lines.get(lineIndex);
	}

	@Override
	public int size() {
		return lines.size();
	}

	@Override
	public void add(Case addend) {
		List<String> newLines = addend.getLines();
		for(String newLine : newLines) {
			lines.add(newLine);
		}
		
	}

	@Override
	public List<String> getLines() {
		return new ArrayList<String>(lines);
	}

}
