import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
		String site = "Local";
		String sender = "sender";
		String recipient = "recipient";
		String box = "Inbox";
		String title = "title";
		u.addLocalAccount(recipient);
		u.addRemoteAccount(sender);
		Email testEmail = new Email(title, "message", sender, recipient);
		u.localSite.get(0).addEmail(testEmail, 0);
		
// Test 16 Email objects with 16 permutations of parameters (value/null)
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
		if (test1111 != null)
			assertTrue(test1111.getTitle().equals(title));		
	}

	@Test
	public void testGetLocalSiteNames() {
		
	}

	@Test
	public void testGetRemoteSiteName() {
//		fail("Not yet implemented");
	}

	@Test
	public void testTrashLocalEmail() {
//		fail("Not yet implemented");
	}

	@Test
	public void testTrashRemoteEmail() {
//		fail("Not yet implemented");
	}

}
