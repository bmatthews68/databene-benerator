/*
 * (c) Copyright 2011 by Brian Matthews. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, is permitted under the terms of the
 * GNU General Public License.
 *
 * For redistributing this software or a derivative work under a license other
 * than the GPL-compatible Free Software License as defined by the Free
 * Software Foundation or approved by OSI, you must first obtain a commercial
 * license to this software product from Brian Matthews.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * WITHOUT A WARRANTY OF ANY KIND. ALL EXPRESS OR IMPLIED CONDITIONS,
 * REPRESENTATIONS AND WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE
 * HEREBY EXCLUDED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package org.databene.domain.ie;

import org.databene.commons.Validator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test the PPSN validator {@link PPSNValidator}.
 * 
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @version $Revision$
 */
public class TestPPSNValidator {

	/**
	 * The PPSN validator that will be used for the tests.
	 */
	private Validator<String> validator;

	/**
	 * The default constructor.
	 */
	public TestPPSNValidator() {
	}

	/**
	 * Create the a PPSN validator as a test fixture.
	 */
	@Before
	public void setUp() {
		this.validator = new PPSNValidator();
	}

	/**
	 * Verify that <code>null</code> fails validation.
	 */
	@Test
	public void testNull() {
		Assert.assertFalse(this.validator.valid(null));
	}

	/**
	 * Verify that empty strings fail validation.
	 */
	@Test
	public void testEmpty() {
		Assert.assertFalse(this.validator.valid(""));
	}

	/**
	 * Verify that valid PPSNs pass validation.
	 */
	@Test
	public void testValid() {
		Assert.assertTrue(this.validator.valid("7333346H"));
		Assert.assertTrue(this.validator.valid("7333346HW"));
	}

	/**
	 * Verify that PPSNs with incorrect check codes will fail validation.
	 */
	@Test
	public void testIncorrectChecksum() {
		Assert.assertFalse(this.validator.valid("7333346J"));
		Assert.assertFalse(this.validator.valid("7333346HJ"));
	}

	/**
	 * Verify that PPSNs with non-numeric codes will fail validation.
	 */
	@Test
	public void testInvalidDigits() {
		Assert.assertFalse(this.validator.valid("Z333346H"));
        Assert.assertFalse(this.validator.valid("Z333346HW"));
		Assert.assertFalse(this.validator.valid("7Z33346H"));
        Assert.assertFalse(this.validator.valid("7Z33346HW"));
		Assert.assertFalse(this.validator.valid("73Z3346H"));
        Assert.assertFalse(this.validator.valid("73Z3346HW"));
		Assert.assertFalse(this.validator.valid("733Z346H"));
        Assert.assertFalse(this.validator.valid("733Z346HW"));
        Assert.assertFalse(this.validator.valid("7333Z46H"));
		Assert.assertFalse(this.validator.valid("7333Z46HW"));
		Assert.assertFalse(this.validator.valid("73333Z6H"));
        Assert.assertFalse(this.validator.valid("73333Z6HW"));
		Assert.assertFalse(this.validator.valid("733334ZH"));
        Assert.assertFalse(this.validator.valid("733334ZHW"));
	}

	/**
	 * Verify that PPNs that are too short will fail validation.
	 */
	@Test
	public void testTooShort() {
		Assert.assertFalse(this.validator.valid("333346H"));
	}

	/**
	 * Verify that PPSNs tat are too long will fail validation.
	 */
	@Test
	public void testTooLong() {
		Assert.assertFalse(this.validator.valid("777333346H"));
	}
}
