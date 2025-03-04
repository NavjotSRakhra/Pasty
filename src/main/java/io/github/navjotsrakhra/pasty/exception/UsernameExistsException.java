package io.github.navjotsrakhra.pasty.exception;

public class UsernameExistsException extends Exception{
    UsernameExistsException(){
        super("Username already exists");
    }
    public UsernameExistsException(String username){
        super("Username already exists: " + username);
    }
}
