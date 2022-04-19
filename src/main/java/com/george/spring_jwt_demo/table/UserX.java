package com.george.spring_jwt_demo.table;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserX {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserX userX = (UserX) o;
        return id != null && Objects.equals(id, userX.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
