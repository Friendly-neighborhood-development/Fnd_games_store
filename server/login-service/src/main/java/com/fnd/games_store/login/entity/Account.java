package com.fnd.games_store.login.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@Setter
@Getter
public class Account {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy ="uuid2")
    @Column(name = "account_id")
    private String id;

    private String username;

    private String password;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "accounts_authorities",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name ="authority_id"))
    private List<Authority> authorities;

    private String email;
    private Boolean isAccountNonExpired;

    private Boolean isAccountNonLocked;

    private Boolean isCredentialsNonExpired;

    private Boolean isAccountEnabled;

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
//                ", authorities=" + authorities +
                ", email='" + email + '\'' +
                ", accountNonExpired=" + isAccountNonExpired +
                ", accountNonLocked=" + isAccountNonLocked +
                ", credentialsNonExpired=" + isCredentialsNonExpired +
                ", enabled=" + isAccountEnabled +
                '}';
    }
}
