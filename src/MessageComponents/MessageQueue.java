package MessageComponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageQueue {
	List <User> registeredUsers; // keep record of all users
	List <Channel> registeredChannels; // keep record of all channels made by the users
	HashMap<Channel,ArrayList<User>> channelSubsList=new HashMap<Channel,ArrayList<User>>(); //this will save channel and it's list of subscribers
	
	MessageQueue(){
		user = new ArrayList<User>();
		channel = new ArrayList<Channel>();
	}
	
	/**
	 * This function will return true if values are successfully entered and return false if the email is already registered
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	Boolean registerNewUser(String email, String firstName, String lastName) {
		Boolean flag = true;
		for(User u : user) {
			if(u.email == email) {
				flag = false; // Operation unsuccessful. it is a duplicate, email is already registered
			}
		}
		if(flag == true) {
			User temp = new User();
			temp.email = email;
			temp.firstName = firstName;
			temp.lastName = lastName;
		}
		return flag;
	}
	
	/**
	 * This function needs to call the server after user login
	 * Here client function should be implemented in a while loop, and listing for server to return posts
	 * @param email
	 */
	Boolean login(String email) {
		Boolean flag = false;
		for(User u : user) {
			if(u.email == email) {
				u.on = true;
				flag = true; // user email exist and user has successfully logged in
			}
		}
		return flag;
	}
	
	Boolean logout(String email) {
		Boolean flag = false;
		for(User u : user) {
			if(u.email == email) {
				u.on = false;
				flag = true; // user email exist and user has successfully logged in
			}
		}
		return flag;
	}
	
	void openNewChannel(String email, String ownerName, String chName) {
		Channel ch = new Channel();
		ch.owner = ownerName;
		ch.email= email;
		ch.channelName = chName;
		channel.add(ch);
	}
	
	/**
	 *  Main function should show user list of channel and owner name and let user choose which channel to subscribe.
	 * After choosing channel name, it should be saved in map.
	 * Parameter email will help to choose user from the user list.
	 * @param ch
	 * @param email 
	 */
	Boolean newSubscriber(Channel ch, String email) {
		
		Boolean flag = false;
		User us = new User();
		ArrayList<User> temp = new ArrayList<User>();
		for(User u : user) {
			if(u.email == email) {
				us = u;
				break;
			}
		}
		if(channelSubsList.get(ch) != null) { // if the map already contains the channel and user list
			temp = channelSubsList.get(ch); 
			if(!temp.contains(us)) { //if user has not previously subscribe this channel
				temp.add(us);
				channelSubsList.put(ch, temp);
				flag = true; // successfully subscribed the channel
			}
			else
				flag=false; //user has already subscribed the channel
		}
		else { // map does not have channel listed
			temp.add(us);
			channelSubsList.put(ch, temp);
			flag = true; // successfully subscribed the channel
		}
		 return flag;
	}
	
	void listen() {
		
	}
	
	
	void ChannelUpdate() {
		//This should call the channel class
	}

}
