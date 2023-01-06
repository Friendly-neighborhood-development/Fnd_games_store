package com.fnd.games_store.login.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "authorities")
@NoArgsConstructor
@Setter
@Getter
public class Authority implements GrantedAuthority{

    @NotNull
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy ="uuid2")
    @Column(name = "authority_id")
    private String id;

    private String authority;


    @ManyToMany
    @JsonIgnore
    private List<Account> account;


    public Authority(String id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id='" + id + '\'' +
                ", authority='" + authority + '\'' +
//                ", accounts=" + accounts +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority1 = (Authority) o;
        return Objects.equals(id, authority1.id) && Objects.equals(authority, authority1.authority) && Objects.equals(account, authority1.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authority, account);
    }
}
