package ru.suleimenov.defaultsoapspringws.factory;

import generated.User;
import org.springframework.stereotype.Component;
import ru.suleimenov.defaultsoapspringws.db.entity.UserEntity;

@Component
public class UserFactory {

    public User makeXml(UserEntity entity){
        return User.builder()
                .empId(entity.getEmpId())
                .name(entity.getName())
                .salary(entity.getSalary())
                .build();
    }
}
