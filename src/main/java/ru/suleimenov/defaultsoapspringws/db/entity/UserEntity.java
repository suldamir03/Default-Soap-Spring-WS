package ru.suleimenov.defaultsoapspringws.db.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int empId;
    @Column(nullable = false)
    String name;
    double salary;
}
