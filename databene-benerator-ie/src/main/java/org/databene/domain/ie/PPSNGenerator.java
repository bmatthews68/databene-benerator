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

import org.databene.benerator.util.RandomUtil;
import org.databene.benerator.util.ThreadSafeGenerator;

/**
 * Generate valid Personal Public Service Numbers (PPSNs).
 * 
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @since 1.0.0
 */
public final class PPSNGenerator extends ThreadSafeGenerator<String> {

	/**
	 * The 23 check digits.
	 */
	private final static char[] CHECK_DIGITS = { 'W', 'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V' };

	/**
	 * The length of a PPSN.
	 */
	private final static int PPSN_LENTGTH = 8;

	/**
	 * The default constructor.
	 */
	public PPSNGenerator() {
	}

	/**
	 * Generate a valid Personal Public Service Number as a string of 7 random
	 * digits plus a check digit.
	 * 
	 * @return The generated Personal Public Service Number.
	 */
	public String generate() {
		final StringBuilder builder = new StringBuilder(
				PPSNGenerator.PPSN_LENTGTH);
		int checksum = 0;
		for (int multiplier = PPSNGenerator.PPSN_LENTGTH; multiplier > 1; --multiplier) {
			final char digit = RandomUtil.randomDigit(0);
			checksum += multiplier * (digit - '0');
			builder.append(digit);
		}
		builder.append(PPSNGenerator.CHECK_DIGITS[checksum
				% PPSNGenerator.CHECK_DIGITS.length]);
		return builder.toString();
	}

	/**
	 * Return the type created by this generator.
	 * 
	 * @return Always returns {@link String#class}.
	 */
	public Class<String> getGeneratedType() {
		return String.class;
	}
}
