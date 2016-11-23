package test;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.common.collect.ImmutableMap;

@Repository
public class AddressRepository {

    private Map<String, Address> addresses = ImmutableMap.of("1", new Address("1", "Wroclaw", "Klecinska"), "2",
            new Address("2", "Warszawa", "Armii Krajowej"));

    public Address findByUserId(String userId) {

        return addresses.get(userId);
    }
}
