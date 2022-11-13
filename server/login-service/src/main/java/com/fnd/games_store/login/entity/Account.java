package com.fnd.games_store.login.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "accounts_authorities",
              joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "account_id"),
              inverseJoinColumns = @JoinColumn(name = "authority_id",  referencedColumnName = "authority_id"))
    private List<Authority> authorities;

    private String authorityName;



    public Account(String username, String password, List<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
//                ", authorities=" + authorities +
                '}';
    }
}
