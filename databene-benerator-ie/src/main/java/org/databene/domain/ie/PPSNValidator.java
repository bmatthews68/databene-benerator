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

import javax.validation.ConstraintValidatorContext;

import org.databene.commons.validator.bean.AbstractConstraintValidator;
import org.databene.domain.person.TIN;

/**
 * Validates Personal Public Service Numbers (PPSNs).
 * 
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @version $Revision$
 */
public class PPSNValidator extends AbstractConstraintValidator<TIN, String> {
	/**
	 * The 23 check digits.
	 */
	private final static char[] CHECK_DIGITS = { 'W', 'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V' };

	/**
	 * The default constructor.
	 */
	public PPSNValidator() {
	}

	/**
	 * Validate the Personal Public Service Number.
	 * 
	 * @param ppsn
	 *            The Personal Public Service Number.
	 * @param context
	 *            The validation context.
	 * @return <ul>
	 *         <li><code>true</code> if the PPSN is not valid</li>
	 *         <li><code>false</code> if the PPSN is valid</li>
	 *         </ul>
	 */
	public boolean isValid(String ppsn, ConstraintValidatorContext context) {
		
		if (ppsn == null) {
			return false;
		}
		
		switch (ppsn.length()) {
		case 9:
			// If the PPSN is 9 characters in length the the last character
			// must be W
			return ppsn.charAt(8) == 'W'
					&& this.isValid(ppsn.substring(0, 8), context);
		case 8:
			// Most PPSNs will be 8 characters in length
			break;
		default:
			return false;
		}

		// Make sure the first 7 characters are digits and
		// calculate the checksum

		int checksum = 0;
		for (int i = 0; i < 7; ++i) {
			if (!Character.isDigit(ppsn.charAt(i))) {
				return false;
			}
			checksum += (8 - i) * (ppsn.charAt(i) - '0');
		}

		// Make sure the check digit is correct

		return PPSNValidator.CHECK_DIGITS[checksum
				% PPSNValidator.CHECK_DIGITS.length] == ppsn.charAt(7);
	}
}
