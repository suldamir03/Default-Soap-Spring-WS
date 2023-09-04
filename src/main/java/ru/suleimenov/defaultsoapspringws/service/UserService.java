package ru.suleimenov.defaultsoapspringws.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import generated.User;
import ru.suleimenov.defaultsoapspringws.entity.UserEntity;
import ru.suleimenov.defaultsoapspringws.factory.UserFactory;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository repository;
    UserFactory factory;

    public User getUserByName(String name) {
        Optional<UserEntity> entity = repository.findByName(name);
        return entity.map(factory::makeXml).orElse(null);
    }
}