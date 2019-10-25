/**
 * This class contains the details of the users where a user can create a channel or can be a subscriber. If user 
 */

package MessageComponents;

public class User {

	String email, firstName, lastName;
	Boolean isOnline;
	List<Channel> userSubscribedChannels;
	List<Channel> userOwnedChannels;
	
	User(){
		
	}
	
	void setDetails(String e, String f, String l) {
		email = e;
		firstName = f;
		lastName = l;
		on = false;
	}
	
	//this is a client function. While user is on, this should always check with the server function if there is any update available to receive
	void onOff() {
		while(on) {
			
		}
	}
}
