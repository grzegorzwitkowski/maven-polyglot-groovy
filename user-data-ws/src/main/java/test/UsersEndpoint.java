package test;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService
public class UsersEndpoint extends SpringBeanAutowiringSupport {

    @Autowired
    private UsersRepository usersRepository;

    public
    @WebResult(name = "user")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    User getUser(@WebParam(name = "id") String id) throws UserNotFoundException {

        User user = usersRepository.findById(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return user;
    }
}
