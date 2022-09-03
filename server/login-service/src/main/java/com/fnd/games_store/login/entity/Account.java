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
@ToString
public class Account {

    @NotNull
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy ="uuid2")
    @Column(name = "account_id")
    private String id;

    private String username;

    private String password;

    @Column(name = "authority_id")
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "authority_id")
    private List<Authority> authorities;


    public Account(String username, String password, List<Authority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }
}
