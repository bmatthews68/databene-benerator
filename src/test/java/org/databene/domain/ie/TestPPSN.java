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
import org.databene.commons.Validator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit/integration test of the PPSN generator {@link PPSNGenerator} and validator {@link PPSNValidator}.
 * 
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @version $Revision$
 */
public class TestPPSN {

    /**
     * The PPSN generator that will be used for the tests.
     */
    private Generator<String> generator;

    /**
     * The PPSN validator that will be used for the tests.
     */
    private Validator<String> validator;

    /**
     * The default constructor.
     */
    public TestPPSN() {
    }

    /**
     * Create the a PPSN generator and validator as test fixtures.
     */
    @Before
    public void setUp() {
        this.generator = new PPSNGenerator();
        this.validator = new PPSNValidator();
    }

    /**
     * Test that the generator generates 1000 valid PPSNs within 100ms.
     */
    @Test(timeout = 100)
    public void testGenerator() {
        for (int i = 0; i < 1000; ++i) {
            final String ppsn = this.generator.generate();
            Assert.assertTrue(this.validator.valid(ppsn));
        }
    }
}
