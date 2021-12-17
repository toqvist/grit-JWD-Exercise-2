package mvc.model;

import java.util.ArrayList;

//User "database"
public class UserDatabase {
	public ArrayList<User> userList; //Borde nog inte vara publik, utan ha getters/setters istället
	 
	public UserDatabase () {
		this.userList = new ArrayList<>();
		addUser("admin", "password", "admin");
		addUser("user1", "password", "user");
		//System.out.println("Constructor runs");
	}
	
	public boolean authenticate(String username, String password) {
		//System.out.println("booop");
		//System.out.println(this.userList);
		for (int i=0;i<this.userList.size();i++) {
			
			System.out.println(userList.get(i).getUsername());
			System.out.println(userList.get(i).getPassword());
			System.out.println(username + password);
			if(this.userList.get(i).getUsername().equals(username)
			&& this.userList.get(i).getPassword().equals(password)) {
					
					return true;
			}
		}
		return false;
	}

	public void addUser (String username, String password, String type) {
		if (userList.size()!= 0) {
			for (int i=0;i<userList.size();i++) {
				if(!userList.get(i).getUsername().equals(username)) {
					//Redundans, borde vara en metod
					User user= new User();
					user.setUsername(username);
					user.setPassword(password);
					user.setType(type);
					userList.add(user);
					return;
				}
			}
		} else {
			User user= new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setType(type);
			userList.add(user);
		}
	}
	
	public User getUser (String user) {
		for (int i=0;i<userList.size();i++) {
			if(userList.get(i).getUsername().equals(user)) {
				return userList.get(i);
			}
		}
		return null;
	}
}
