package nf.co.korshyadoo.test;

import java.util.List;

import nf.co.korshyadoo.CodeJam.io.Case;
import nf.co.korshyadoo.CodeJam.io.CaseLength;
import nf.co.korshyadoo.CodeJam.io.CaseRetriever;
import nf.co.korshyadoo.CodeJam.io.DefaultCaseRetriever;
import nf.co.korshyadoo.CodeJam.io.EmbeddedCaseLength;
import nf.co.korshyadoo.CodeJam.io.EmbeddedWithAdditionCaseLength;
import nf.co.korshyadoo.CodeJam.io.EmbeddedWithMultiplierCaseLength;
import nf.co.korshyadoo.CodeJam.io.StaticCaseLength;

import org.junit.Assert;
import org.junit.Test;

public class IoTest {

	@Test
	public void staticCaseLengthOneTest() {
		CaseLength length = new StaticCaseLength(1);
		CaseRetriever caseRetriever = new DefaultCaseRetriever("staticCaseLengthOneTestInput.in", length);
		List<Case> cases = caseRetriever.retrieveCases();
		
		Case case1 = cases.get(0);
		Assert.assertTrue(case1.get(0).equals("1 0 0"));
		case1 = cases.get(1);
		Assert.assertTrue(case1.get(0).equals("1 0 2"));
		case1 = cases.get(2);
		Assert.assertTrue(case1.get(0).equals("3 0 0"));
		case1 = cases.get(3);
		Assert.assertTrue(case1.get(0).equals("3 2 0"));
		case1 = cases.get(4);
		Assert.assertTrue(case1.get(0).equals("3 1 1"));
		case1 = cases.get(5);
		Assert.assertTrue(case1.get(0).equals("4 1 1"));
		case1 = cases.get(6);
		Assert.assertTrue(case1.get(0).equals("4 0 2"));
	}
	
	@Test
	public void staticCaseLengthTwoTest() {
		CaseLength length = new StaticCaseLength(2);
		CaseRetriever caseRetriever = new DefaultCaseRetriever("staticCaseLengthTwoTestInput.in", length);
		List<Case> cases = caseRetriever.retrieveCases();
		
		Case case1 = cases.get(0);
		Assert.assertTrue(case1.get(0).equals("2 2"));
		Assert.assertTrue(case1.get(1).equals("2 1"));
		case1 = cases.get(1);
		Assert.assertTrue(case1.get(0).equals("2 4"));
		Assert.assertTrue(case1.get(1).equals("2 1 1 6"));
		case1 = cases.get(2);
		Assert.assertTrue(case1.get(0).equals("10 4"));
		Assert.assertTrue(case1.get(1).equals("25 20 9 100"));
		case1 = cases.get(3);
		Assert.assertTrue(case1.get(0).equals("1 4"));
		Assert.assertTrue(case1.get(1).equals("1 1 1 1"));
	}
	
	@Test
	public void embeddedCaseLengthOneTest() {
		CaseLength embedded = new EmbeddedCaseLength(0, 0);
		CaseRetriever caseRetriever = new DefaultCaseRetriever("embeddedCaseLengthOneTestInput.in", embedded);
		List<Case> cases = caseRetriever.retrieveCases();
		
		Case case1 = cases.get(0);
		Assert.assertTrue(case1.get(0).equals("3 3 1"));
		Assert.assertTrue(case1.get(1).equals("###"));
		
		case1 = cases.get(1);
		Assert.assertTrue(case1.get(0).equals("3 3 2"));
		Assert.assertTrue(case1.get(1).equals("###"));
		
		case1 = cases.get(2);
		Assert.assertTrue(case1.get(0).equals("4 3 8"));
		Assert.assertTrue(case1.get(1).equals("###"));
		
		case1 = cases.get(3);
		Assert.assertTrue(case1.get(0).equals("7 7 4"));
		Assert.assertTrue(case1.get(1).equals("#######"));
		
		case1 = cases.get(4);
		Assert.assertTrue(case1.get(0).equals("5 6 3"));
		Assert.assertTrue(case1.get(1).equals("######"));
		
		case1 = cases.get(5);
		Assert.assertTrue(case1.get(0).equals("5 6 10"));
		Assert.assertTrue(case1.get(1).equals("######"));
	}
	
	@Test
	public void embeddedWithAdditionOneTest() {
		CaseLength addition = new EmbeddedWithAdditionCaseLength(0, 1, 1);
		CaseRetriever caseRetriever = new DefaultCaseRetriever("embeddedWithAdditionOneTest.in", addition);
		List<Case> cases = caseRetriever.retrieveCases();
		
		Case case1 = cases.get(0);
		Assert.assertTrue(case1.get(0).equals("1000.000000 2 3"));
		Assert.assertTrue(case1.get(1).equals("0.000000 20.500000"));
		Assert.assertTrue(case1.get(2).equals("25.000000 1000.000000"));
		Assert.assertTrue(case1.get(3).equals("1.00 5.00 9.81"));
		
		case1 = cases.get(1);
		Assert.assertTrue(case1.get(0).equals("50.000000 2 2"));
		Assert.assertTrue(case1.get(1).equals("0.000000 0.000000"));
		Assert.assertTrue(case1.get(2).equals("100000.000000 100.000000"));
		Assert.assertTrue(case1.get(3).equals("1.00 1.01"));
		
		case1 = cases.get(2);
		Assert.assertTrue(case1.get(0).equals("10000.000000 3 1"));
		Assert.assertTrue(case1.get(1).equals("0.000000 0.000000"));
		Assert.assertTrue(case1.get(2).equals("10000.000000 0.100000"));
		Assert.assertTrue(case1.get(3).equals("10000.100000 100000.000000"));
		Assert.assertTrue(case1.get(4).equals("1.00"));
	}
	
	@Test
	public void emmbeddedWithMultiplierTest() {
		CaseLength multiplierCaseLength = new EmbeddedWithMultiplierCaseLength(0, 1, 2);
		CaseRetriever caseRetriever = new DefaultCaseRetriever("embeddedWithMultiplierTestInput.in", multiplierCaseLength);
		List<Case> cases = caseRetriever.retrieveCases();
		
		Case case1 = cases.get(0);
		Assert.assertTrue(case1.get(0).equals("200 1 2"));
		Assert.assertTrue(case1.get(1).equals("250 233"));
		Assert.assertTrue(case1.get(2).equals("180 100"));
		
		case1 = cases.get(1);
		Assert.assertTrue(case1.get(0).equals("100 3 3"));
		Assert.assertTrue(case1.get(1).equals("500 500 500"));
		Assert.assertTrue(case1.get(2).equals("500 500 600"));
		Assert.assertTrue(case1.get(3).equals("500 140 1000"));
		Assert.assertTrue(case1.get(4).equals("10 10 10"));
		Assert.assertTrue(case1.get(5).equals("10 10 490"));
		Assert.assertTrue(case1.get(6).equals("10 10 10"));
		
		case1 = cases.get(2);
		Assert.assertTrue(case1.get(0).equals("100 3 3"));
		Assert.assertTrue(case1.get(1).equals("500 100 500"));
		Assert.assertTrue(case1.get(2).equals("100 100 500"));
		Assert.assertTrue(case1.get(3).equals("500 500 500"));
		Assert.assertTrue(case1.get(4).equals("10 10 10"));
		Assert.assertTrue(case1.get(5).equals("10 10 10"));
		Assert.assertTrue(case1.get(6).equals("10 10 10"));
		
		case1 = cases.get(3);
		Assert.assertTrue(case1.get(0).equals("100 2 2"));
		Assert.assertTrue(case1.get(1).equals("1000 1000"));
		Assert.assertTrue(case1.get(2).equals("1000 1000"));
		Assert.assertTrue(case1.get(3).equals("100 900"));
		Assert.assertTrue(case1.get(4).equals("900 100"));
	}
}
