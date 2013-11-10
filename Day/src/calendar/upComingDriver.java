package calendar;
import java.util.Hashtable;

import javax.naming.*;
import javax.naming.ldap.InitialLdapContext;
public class upComingDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		// Create the object to be bound
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=jnditutorial");
		Context ctx = new InitialContext(env);
		upComing calandar = new upComing();
		ctx.bind("file", calandar);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
