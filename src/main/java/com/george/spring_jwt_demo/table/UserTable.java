package com.george.spring_jwt_demo.table;

import lombok.*;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserTable {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    @ManyToMany(fetch = EAGER)
    private Collection<RoleTable> roleTables = new ArrayList<>();

}
