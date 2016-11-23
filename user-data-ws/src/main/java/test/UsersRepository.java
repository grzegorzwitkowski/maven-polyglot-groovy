package test;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UsersRepository {

    private Map<String, User> users = ImmutableMap.of(
            "1", new User("1", "Jan", "Kowalski", 25),
            "2", new User("2", "Anna", "Nowak", 30)
    );

    public User findById(String id) {

        return users.get(id);
    }
}
