package nf.co.korshyadoo.CodeJam.io;

import java.util.List;

public class ProgramLauncher {
	private static final String INPUT_FILE_LOCATION = "resources/Falling Diamonds input.txt";
	private static final String OUTPUT_FILE_LOCATION = "resources/output.out";
	private static StringBuilder output = new StringBuilder();

	public static void main(String[] args) {
		//STEP ONE
		//Create a CaseLength. If it is static, use a StaticCaseLength and pass the case length
		CaseLength length = new StaticCaseLength(1);
		
		//Otherwise, use one of the embedded case length types
		CaseLength embedded = new EmbeddedCaseLength(0, 0);
		CaseLength embedded2 = new EmbeddedCaseLength(1, 0);
		CaseLength multiplierCaseLength = new EmbeddedWithMultiplierCaseLength(0, 1, 2);
		CaseLength addition = new EmbeddedWithAdditionCaseLength(0, 1, 1);
		
		//STEP TWO
		//Pass the CaseLengths to a CaseRetriever along with the location of the input file
		CaseRetriever caseRetriever1 = new DefaultCaseRetriever(INPUT_FILE_LOCATION, length);
		CaseRetriever caseRetriever2 = new DefaultCaseRetriever(INPUT_FILE_LOCATION, embedded);
		CaseRetriever caseRetriever3 = new DefaultCaseRetriever(INPUT_FILE_LOCATION, multiplierCaseLength);
		CaseRetriever caseRetriever4 = new DefaultCaseRetriever(INPUT_FILE_LOCATION, addition);
		CaseRetriever caseRetriever5 = new DefaultCaseRetriever(INPUT_FILE_LOCATION, embedded, embedded2);
		
		//STEP THREE
		//Retrieve the cases from the CaseRetriever
		List<Case> cases = caseRetriever1.retrieveCases();
		for(Case c : cases) {
			printCase(c);
		}
		
		
		OutputWriter.write(OUTPUT_FILE_LOCATION, output.toString());
		System.out.println("done");
	}
	
	private static void printCase(Case c) {
		for(int y = 0; y < c.size(); y++) {
			System.out.println(c.get(y));
		}
		System.out.println("*************");
		
	}
}
