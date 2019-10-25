package MessageComponents;

import java.util.ArrayList;
import java.util.List;

public class Channel {

	String channelName;
	User owner;
	List <String> posts;
	List<User> subscribers;
	
	Channel(){
		posts = new ArrayList<String>();
	}
	
}
