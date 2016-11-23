package test;

public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String id) {
        super("User with id: " + id + " was not found");
    }
}
