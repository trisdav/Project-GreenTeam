import java.util.*;
/**
 * An email user with two sites, each with zero to many accounts
 * @author Lydia McGovern
 *
 */
public class EmailUser {	
	private String name;
	protected ArrayList<Account> localSite;
	protected ArrayList<Account> remoteSite;
	
/**
 * Construct an email user
 * @param name the user's name
 */
	EmailUser(String name) {
		this.name = name;
		localSite = new ArrayList<Account>();
		remoteSite = new ArrayList<Account>();
	}

/**
 * Add an account to the local site
 * @param address the email address of the new account
 */
	public void addLocalAccount(String address) {
		localSite.add(new Account(address));
	}
	
/**
 * Add an account to the remote site
 * @param address the email address of the new account
 */
	public void addRemoteAccount (String address) {
		remoteSite.add(new Account(address));
	}
	
/**
 * Delete an account from the local site
 * @param address the address of the account to be deleted
 */
	public void deleteLocalAccount(String address) {
		for (Account a : localSite) {
			if (a.getAddress().equals(address))
				localSite.remove(a);
		}
	}
	
/**
 * Delete an account from the remote site	
 * @param address the address of the account to be deleted
 */
	public void deleteRemoteAccount(String address) {
		for (Account a : remoteSite) {
			if (a.getAddress().equals(address))
				remoteSite.remove(a);
		}
	}
	
	public Email retrieveEmail(String site, String account, String box, String title) {
		if (site.equals("local")) {
			for (Account a : localSite) {
				if (a.getAddress().equals(account))
					return a.retrieveEmail(box, title);
			}
		} else if (site.equals("remote")) {
			for (Account a : remoteSite) {
				if (a.getAddress().equals(account))
					return a.retrieveEmail(box, title);
			}
		}
		return null;
	}
	
/**
 * Return the user's name
 * @return the user's name
 */
	public String getName() {
		return name;
	}
	
/**
 * Return a list of all the addresses stored in the local site
 * @return a list of all addresses in the local site
 */
	public ArrayList<String> getLocalSiteNames() {
		ArrayList<String> s = new ArrayList<String>();
		for (Account a : localSite)
			s.add(a.getAddress());
		return s;
	}
	
/**
 * Return a list of all addresses stored in the remote site
 * @return a list of all addresses in the remote site
 */
	public ArrayList<String> getRemoteSiteName() {
		ArrayList<String> s = new ArrayList<String>();
		for (Account a : remoteSite)
			s.add(a.getAddress());
		return s;
	}
}
