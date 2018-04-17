import static org.junit.Assert.*;
import org.junit.Test;

public class EmailUserTest {
	private EmailUser u = new EmailUser("testUser");

	@Test
	public void testDeleteLocalAccount() {
		u.addLocalAccount("address 1");
		int size = u.localSite.size();
		u.deleteLocalAccount(null);
		assertEquals(u.localSite.size(), size);
		u.deleteLocalAccount("address 1");
		assertEquals(u.localSite.size(), (size - 1));
	}

	@Test
	public void testDeleteRemoteAccount() {
		u.addRemoteAccount("address 2");
		int size = u.remoteSite.size();
		u.deleteRemoteAccount(null);
		assertEquals(u.remoteSite.size(), size);
		u.deleteRemoteAccount("address 2");
		assertEquals(u.remoteSite.size(), (size - 1));
	}

	@Test
	public void testRetrieveEmail() {
// variable names
		String site = "Local";
		String sender = "sender";
		String recipient = "recipient";
		String box = "Inbox";
		String title = "title";
// Create the objects for testing
		u.addLocalAccount(recipient);
		Email testEmail = new Email(title, "message", sender, recipient);
		title = testEmail.getTitleWithTimestamp();	// Recall that the email system creates unique emails by title and timestamp
		System.out.println(u.localSite.get(0).getAddress());
		u.localSite.get(0).addEmail(testEmail, 0);
		
// Test 16 Email objects with 16 total permutations of parameters (value/null)
		assertNull(u.retrieveEmail(null, null, null, null));
		assertNull(u.retrieveEmail(null, null, null, title));
		assertNull(u.retrieveEmail(null, null, box, null));
		assertNull(u.retrieveEmail(null, null, box, title));
		assertNull(u.retrieveEmail(null, recipient, null, null));
		assertNull(u.retrieveEmail(null, recipient, null, title));
		assertNull(u.retrieveEmail(null, recipient, box, null));
		assertNull(u.retrieveEmail(null, recipient, box, title));
		assertNull(u.retrieveEmail(site, null, null, null));
		assertNull(u.retrieveEmail(site, null, null, title));
		assertNull(u.retrieveEmail(site, null, box, null));
		assertNull(u.retrieveEmail(site, null, box, title));
		assertNull(u.retrieveEmail(site, recipient, null, null));
		assertNull(u.retrieveEmail(site, recipient, null, title));
		assertNull(u.retrieveEmail(site, recipient, box, null));
// The only nonnull email object
		Email test1111 = u.retrieveEmail(site, recipient, box, title);
			assertTrue(test1111.getTitleWithTimestamp().equals(title));		
	}

	@Test
	public void testGetLocalSiteNames() {
		u.localSite.add(new Account("test1@gmail.com"));
		u.localSite.add(new Account("test2@yahoo.com"));
		assertEquals(u.localSite.size(), u.getLocalSiteNames().size());
		assertTrue(u.localSite.get(0).getAddress().equals(u.getLocalSiteNames().get(0)));
		assertTrue(u.localSite.get(1).getAddress().equals(u.getLocalSiteNames().get(1)));
	}

	@Test
	public void testGetRemoteSiteName() {
		u.remoteSite.add(new Account("test1@gmail.com"));
		u.remoteSite.add(new Account("test2@yahoo.com"));
		assertEquals(u.remoteSite.size(), u.getRemoteSiteNames().size());
		assertTrue(u.remoteSite.get(0).getAddress().equals(u.getRemoteSiteNames().get(0)));
		assertTrue(u.remoteSite.get(1).getAddress().equals(u.getRemoteSiteNames().get(1)));
	}

	@Test
	public void testTrashLocalEmail() {
// Create the objects for testing
		u.localSite.add(new Account("testTrash@local.com"));
		Email e = new Email("title", "message", "sender", "recipient");
		String titleWithStamp = e.getTitleWithTimestamp();
		u.localSite.get(0).addEmail(e, 0);
// Test 8 total permutations
		assertFalse(u.trashLocalEmail(null, null, null));
		assertFalse(u.trashLocalEmail(null, null, "title"));
		assertFalse(u.trashLocalEmail(null, "Inbox", null));
		assertFalse(u.trashLocalEmail(null, "Inbox", "title"));
		assertFalse(u.trashLocalEmail("testTrash@local.com", null, null));
		assertFalse(u.trashLocalEmail("testTrash@local.com", null, "title"));
		assertFalse(u.trashLocalEmail("testTrash@local.com", "Inbox", null));
// The only valid trash call
		assertTrue(u.trashLocalEmail("testTrash@local.com", "Inbox", titleWithStamp));
	}

	@Test
	public void testTrashRemoteEmail() {
// Create the objects for testing
		u.remoteSite.add(new Account("testTrash@remote.com"));
		Email e = new Email("title", "message", "sender", "recipient");
		String titleWithStamp = e.getTitleWithTimestamp();
		u.remoteSite.get(0).addEmail(e, 0);
// Test 8 total permutations
		assertFalse(u.trashRemoteEmail(null, null, null));
		assertFalse(u.trashRemoteEmail(null, null, "title"));
		assertFalse(u.trashRemoteEmail(null, "Inbox", null));
		assertFalse(u.trashRemoteEmail(null, "Inbox", "title"));
		assertFalse(u.trashRemoteEmail("testTrash@remote.com", null, null));
		assertFalse(u.trashRemoteEmail("testTrash@remote.com", null, "title"));
		assertFalse(u.trashRemoteEmail("testTrash@remote.com", "Inbox", null));
// The only valid trash call
		assertTrue(u.trashRemoteEmail("testTrash@remote.com", "Inbox", titleWithStamp));
	}

}
