package test;

public class AddressNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public AddressNotFoundException(String userId) {
        super("Address for user id: " + userId + " was not found");
    }
}
