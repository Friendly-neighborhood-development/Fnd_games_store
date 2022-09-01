package com.fnd.games_store.users.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "users")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserAccount {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy ="uuid2")
    @Column(name = "user_id")
    private String id;

    private String username;

    private String password;

    private String email;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
//    private List<UserRole> role;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserAccount userAccount = (UserAccount) o;
        return id != null && Objects.equals(id, userAccount.id);
    }

}
