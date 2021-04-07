package service;

import DataAccess.UserDB;
import Models.Users;
import java.util.List;

public class UserService {

    private UserDB userDB;

    public UserService() {
        userDB = new UserDB();
    }

    public Users getUser(String username) throws Exception {
        return userDB.getUser(username);
    }

    public List<Users> getAll() throws Exception {
        return userDB.getAll();
    }

    public int update(String username, String password,String email, String firstname, String lastname) throws Exception {
        Users user = getUser(username);
        user.setPassword(password);
        
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        return userDB.update(user);
    }

    public int delete(String username) throws Exception {
        Users deletedUser = userDB.getUser(username);
        // do not allow the admin to be deleted
        if (deletedUser.getUsername().equals("admin")) {
            return 0;
        }
        return userDB.delete(deletedUser);
    }

    public int insert(String username, String password, String email, String firstName, String lastName, boolean active, boolean isAdmin) throws Exception {
        Users user = new Users(username, password, email, firstName, lastName, active, isAdmin );
        
        return userDB.insert(user);
    }
}