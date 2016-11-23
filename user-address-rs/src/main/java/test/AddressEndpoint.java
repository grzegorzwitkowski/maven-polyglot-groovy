package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/users")
public class AddressEndpoint {

    @Autowired
    private AddressRepository addressRepository;

    @GET
    @Path("/{userId}/address")
    @Produces("application/json")
    public Address getAddressByUserId(@PathParam("userId") String userId) throws AddressNotFoundException {

        Address address = addressRepository.findByUserId(userId);
        if (address == null) {
            throw new AddressNotFoundException(userId);
        }
        return address;
    }
}
