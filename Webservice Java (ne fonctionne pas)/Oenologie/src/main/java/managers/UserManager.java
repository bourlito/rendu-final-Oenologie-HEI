package managers;

import impl.UserDaoImpl;

public class UserManager {
    public boolean confirmPassword(String username, String password) throws Exception{
        if (username == null || username.equals("")){
            throw new IllegalArgumentException("Username must be filled!");
        }
        if (password == null || password.equals("")){
            throw new IllegalArgumentException("Password must be filled!");
        }
        String storedPassword = new UserDaoImpl().getStoredPassword(username);
        if (storedPassword == null){
            throw new IllegalArgumentException("Uknown username!");
        }
        return new UserDaoImpl().getStoredPassword(username).equals(password);
    }
}
