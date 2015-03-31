/**
 * 
 */
package vote;

import org.junit.Test;

/**
 * @author Aleh
 *
 */
public class RegexpTest {

	/**
	 * 
	 */
	public RegexpTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void replase() {
		org.junit.Assert
				.assertTrue("http://cs622416.vk.me/v622416287/2f2b4/CyptGJo-Fhw.jpg"
						.replaceAll("[//:-]", "")
						.equals("httpcs622416.vk.mev6224162872f2b4CyptGJoFhw.jpg"));
	}
}
