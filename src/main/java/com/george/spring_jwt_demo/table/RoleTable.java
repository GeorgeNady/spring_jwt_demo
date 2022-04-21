package com.george.spring_jwt_demo.table;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RoleTable {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;

}
