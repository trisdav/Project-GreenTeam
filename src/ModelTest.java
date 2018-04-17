import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import org.junit.Test;

/**
 * JUnit test class for the Model
 * @author Lydia McGovern
 *
 */
public class ModelTest {
	Model system = new Model();

	@Test
	public void testAddUser() {
		assertTrue(system.addUser("John"));
		assertFalse(system.addUser(null));
		assertFalse(system.addUser("John"));
	}

	@Test
	public void testDeleteUser() {
		system.addUser("Paul");
		assertTrue(system.deleteUser("Paul"));
		assertFalse(system.deleteUser(null));
	}

	@Test
	public void testAddAccount() {
		system.addUser("Ringo Starr");
// Test for 8 permutations of the parameters (value/null)
		assertFalse(system.addAccount(null, null, null));
		assertFalse(system.addAccount(null, null, "ringo.starr@gmail.com"));
		assertFalse(system.addAccount(null, "Remote", null));
		assertFalse(system.addAccount(null, "Remote", "ringo.starr.@gmail.com"));
		assertFalse(system.addAccount("Ringo Starr", null, null));
		assertFalse(system.addAccount("Ringo Starr", null, "ringo.starr.@gmail.com"));
		assertFalse(system.addAccount("Ringo Starr", "Remote", null));
		assertTrue(system.addAccount("Ringo Starr", "Remote", "ringo.starr@gmail.com"));
// Try to add an account that already exists
		assertFalse(system.addAccount("Ringo Starr", "Remote", "ringo.starr@gmail.com"));
	}

	@Test
	public void testDeleteAccount() {
		system.addUser("George");
		system.addAccount("George", "Local", "george@georgemail.com");
// Test 8 permutations of the parameters (value/null)
		assertFalse(system.deleteAccount(null, null, null));
		assertFalse(system.deleteAccount(null, null, "george@georgemail.com"));
		assertFalse(system.deleteAccount(null, "Local", null));
		assertFalse(system.deleteAccount(null, "Local", "george@georgemail.com"));
		assertFalse(system.deleteAccount("George", null, null));
		assertFalse(system.deleteAccount("George", null, "george@georgemail.com"));
		assertFalse(system.deleteAccount("George", "Local", null));
		assertTrue(system.deleteAccount("George", "Local", "george@georgemail.com"));
		assertFalse(system.deleteAccount("George", "Local", "george@georgemail.com"));
	}

	@Test
	public void testSendEmail() {
// Create the objects for testing
		system.addUser("George");
		system.addAccount("George", "Local", "george@gmail.com");
// Test for 16 permutations of the parameters (value/null)
		assertNull(system.sendEmail(null, null, null, null));
		assertNull(system.sendEmail(null, null, null, "george@gmail.com"));
		assertNull(system.sendEmail(null, null, "harrison@gmail.com", null));
		assertNull(system.sendEmail(null, null, "harrison@gmail.com", "george@gmail.com"));
		assertNull(system.sendEmail(null, "foo", null, null));
		assertNull(system.sendEmail(null, "foo", null, "george@gmail.com"));
		assertNull(system.sendEmail(null, "foo", "harrison@gmail.com", null));
// An email does not have to have a title; it is replaced with the timestamp
		assertNotNull(system.sendEmail(null, "foo", "harrison@gmail.com", "george@gmail.com"));
		assertNull(system.sendEmail("title", null, null, null));
		assertNull(system.sendEmail("title", null, null, "george@gmail.com"));
		assertNull(system.sendEmail("title", null, "harrison@gmail.com", null));
		assertNull(system.sendEmail("title", null, "harrison@gmail.com", "george@gmail.com"));
		assertNull(system.sendEmail("title", "foo", null, null));
		assertNull(system.sendEmail("title", "foo", null, "george@gmail.com"));
		assertNull(system.sendEmail("title", "foo", "harrison@gmail.com", null));
		assertNotNull(system.sendEmail("title", "foo", "harrison@gmail.com", "george@gmail.com"));
	}

	@Test
	public void testTrashEmail() {
// Create the objects for testing
		system.addUser("George");
		system.addAccount("George", "Local", "george@gmail.com");
		Timestamp t = system.sendEmail("title", "message", "harrison@gmail.com", "george@gmail.com");
		String titleWithTimestamp = "title " + t;		
// Test 32 permutations of the parameters (value/null)		
		assertFalse(system.trashEmail(null, null, null, null, null));
		assertFalse(system.trashEmail(null, null, null, null, titleWithTimestamp));
		assertFalse(system.trashEmail(null, null, null, "Inbox", null));
		assertFalse(system.trashEmail(null, null, null, "Inbox", titleWithTimestamp));		
		assertFalse(system.trashEmail(null, null, "george@gmail.com", null, null));
		assertFalse(system.trashEmail(null, null, "george@gmail.com", null, titleWithTimestamp));
		assertFalse(system.trashEmail(null, null, "george@gmail.com", "Inbox", null));
		assertFalse(system.trashEmail(null, null, "george@gmail.com", "Inbox", titleWithTimestamp));			
		assertFalse(system.trashEmail(null, "Local", null, null, null));
		assertFalse(system.trashEmail(null, "Local", null, null, titleWithTimestamp));
		assertFalse(system.trashEmail(null, "Local", null, "Inbox", null));
		assertFalse(system.trashEmail(null, "Local", null, "Inbox", titleWithTimestamp));		
		assertFalse(system.trashEmail(null, "Local", "george@gmail.com", null, null));
		assertFalse(system.trashEmail(null, "Local", "george@gmail.com", null, titleWithTimestamp));
		assertFalse(system.trashEmail(null, "Local", "george@gmail.com", "Inbox", null));
		assertFalse(system.trashEmail(null, "Local", "george@gmail.com", "Inbox", titleWithTimestamp));		
		assertFalse(system.trashEmail("George", null, null, null, null));
		assertFalse(system.trashEmail("George", null, null, null, titleWithTimestamp));
		assertFalse(system.trashEmail("George", null, null, "Inbox", null));
		assertFalse(system.trashEmail("George", null, null, "Inbox", titleWithTimestamp));		
		assertFalse(system.trashEmail("George", null, "george@gmail.com", null, null));
		assertFalse(system.trashEmail("George", null, "george@gmail.com", null, titleWithTimestamp));
		assertFalse(system.trashEmail("George", null, "george@gmail.com", "Inbox", null));
		assertFalse(system.trashEmail("George", null, "george@gmail.com", "Inbox", titleWithTimestamp));			
		assertFalse(system.trashEmail("George", "Local", null, null, null));
		assertFalse(system.trashEmail("George", "Local", null, null, titleWithTimestamp));
		assertFalse(system.trashEmail("George", "Local", null, "Inbox", null));
		assertFalse(system.trashEmail("George", "Local", null, "Inbox", titleWithTimestamp));		
		assertFalse(system.trashEmail("George", "Local", "george@gmail.com", null, null));
		assertFalse(system.trashEmail("George", "Local", "george@gmail.com", null, titleWithTimestamp));
		assertFalse(system.trashEmail("George", "Local", "george@gmail.com", "Inbox", null));
// The only test case that returns true
		assertTrue(system.trashEmail("George", "Local", "george@gmail.com", "Inbox", titleWithTimestamp));
	}

	@Test
	public void testRetrieveEmail() {
// Create the objects for testing
		system.addUser("George");
		system.addAccount("George", "Local", "george@gmail.com");
		Timestamp t = system.sendEmail("title", "message", "harrison@gmail.com", "george@gmail.com");
		String titleWithTimestamp = "title " + t;		
// Test 32 permutations of the parameters (value/null)	
		assertNull(system.retrieveEmail(null, null, null, null, null));
		assertNull(system.retrieveEmail(null, null, null, null, titleWithTimestamp));
		assertNull(system.retrieveEmail(null, null, null, "Inbox", null));
		assertNull(system.retrieveEmail(null, null, null, "Inbox", titleWithTimestamp));		
		assertNull(system.retrieveEmail(null, null, "george@gmail.com", null, null));
		assertNull(system.retrieveEmail(null, null, "george@gmail.com", null, titleWithTimestamp));
		assertNull(system.retrieveEmail(null, null, "george@gmail.com", "Inbox", null));
		assertNull(system.retrieveEmail(null, null, "george@gmail.com", "Inbox", titleWithTimestamp));			
		assertNull(system.retrieveEmail(null, "Local", null, null, null));
		assertNull(system.retrieveEmail(null, "Local", null, null, titleWithTimestamp));
		assertNull(system.retrieveEmail(null, "Local", null, "Inbox", null));
		assertNull(system.retrieveEmail(null, "Local", null, "Inbox", titleWithTimestamp));		
		assertNull(system.retrieveEmail(null, "Local", "george@gmail.com", null, null));
		assertNull(system.retrieveEmail(null, "Local", "george@gmail.com", null, titleWithTimestamp));
		assertNull(system.retrieveEmail(null, "Local", "george@gmail.com", "Inbox", null));
		assertNull(system.retrieveEmail(null, "Local", "george@gmail.com", "Inbox", titleWithTimestamp));		
		assertNull(system.retrieveEmail("George", null, null, null, null));
		assertNull(system.retrieveEmail("George", null, null, null, titleWithTimestamp));
		assertNull(system.retrieveEmail("George", null, null, "Inbox", null));
		assertNull(system.retrieveEmail("George", null, null, "Inbox", titleWithTimestamp));		
		assertNull(system.retrieveEmail("George", null, "george@gmail.com", null, null));
		assertNull(system.retrieveEmail("George", null, "george@gmail.com", null, titleWithTimestamp));
		assertNull(system.retrieveEmail("George", null, "george@gmail.com", "Inbox", null));
		assertNull(system.retrieveEmail("George", null, "george@gmail.com", "Inbox", titleWithTimestamp));			
		assertNull(system.retrieveEmail("George", "Local", null, null, null));
		assertNull(system.retrieveEmail("George", "Local", null, null, titleWithTimestamp));
		assertNull(system.retrieveEmail("George", "Local", null, "Inbox", null));
		assertNull(system.retrieveEmail("George", "Local", null, "Inbox", titleWithTimestamp));		
		assertNull(system.retrieveEmail("George", "Local", "george@gmail.com", null, null));
		assertNull(system.retrieveEmail("George", "Local", "george@gmail.com", null, titleWithTimestamp));
		assertNull(system.retrieveEmail("George", "Local", "george@gmail.com", "Inbox", null));				
// The only test case that returns not null
		assertNotNull(system.retrieveEmail("George", "Local", "george@gmail.com", "Inbox", titleWithTimestamp));
	}

}
