package de.test;

import static de.schauderhaft.degraph.check.Check.classpath;
import static de.schauderhaft.degraph.check.JCheck.violationFree;
import static org.hamcrest.core.Is.is;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.scalatest.FunSuite;

@RunWith(BlockJUnit4ClassRunner.class)
public class Degraph extends FunSuite {
	private static final long serialVersionUID = 1L;

	@Test
	public void testTest()
	{
		Assert.assertThat(classpath()
		.printTo("target/test.graphml")
		.including("de.test.**")
		.withSlicing("adapter", "de.test.ccb.bat.reusable.adapter.(*).**")
		.withSlicing("usecases", "de.test.qa.proif.uc.(*).**")
		.allow("usecases","adapter")
		,is(violationFree())
		);
	}
}
