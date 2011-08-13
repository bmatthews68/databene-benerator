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

import org.databene.benerator.Generator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test the PPSN generator {@link PPSNGenerator}.
 * 
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @version $Revision$
 */
public class TestPPSNGenerator {

	/**
	 * The PPSN generator that will be used for the tests.
	 */
	private Generator<String> generator;

	/**
	 * The default constructor.
	 */
	public TestPPSNGenerator() {
	}

	/**
	 * Create the a PPSN generator as a test fixture.
	 */
	@Before
	public void setUp() {
		this.generator = new PPSNGenerator();
	}

	/**
	 * Verify the {@link PPSNGenerator#getGeneratedType()} method.
	 */
	@Test
	public void testGetGeneratedType() {
		final Class<String> generatedType = this.generator.getGeneratedType();
		Assert.assertNotNull(generatedType);
		Assert.assertSame(String.class, generatedType);
	}

	/**
	 * Verify the {@link PPSNGenerator#generate()} method.
	 */
	@Test
	public void testGenerate() {
		final String ppsn = this.generator.generate();
		Assert.assertNotNull(ppsn);
		Assert.assertEquals(8, ppsn.length());
	}
}
