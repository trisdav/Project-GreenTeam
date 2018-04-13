/**
 * Test the EmailBox class
 * @author Lydia McGovern
 *
 */
public class EmailBoxTest {

	@Test
	public void testAddEmail() {
// Create a test email box and add an email object and a null object
		EmailBox testBox = new EmailBox();

		Email eTest = new Email("test title", "test message", "sender.test", "recipient.test");
		assertTrue(testBox.addEmail(eTest));
		assertTrue(testBox.addEmail(null));	
	}

	@Test
	public void testRemoveEmail() {
// Create a test email box, add an email, and remove the email and a null object
		EmailBox testBox = new EmailBox();		
		Email eNonNull = new Email("test title", "test message", "sender.test", "recipient.test");
		testBox.addEmail(eNonNull);
		assertTrue(testBox.removeEmail("test title " + eNonNull.getSentTime()));
		assertFalse(testBox.removeEmail(null));
	}

	@Test
	public void testRetrieveEmail() {
// Create a test email box, add an email, and retrieve the email and an email with a null title
		EmailBox testBox = new EmailBox();
		Email eNotNull = new Email("test title", "test message", "sender.test", "recipient.test");
		testBox.addEmail(eNotNull);
		assertNotNull(testBox.retrieveEmail("test title " + eNotNull.getSentTime()));
		assertNull(testBox.retrieveEmail(null));
	}

}
