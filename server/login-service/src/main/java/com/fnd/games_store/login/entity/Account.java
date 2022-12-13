package com.fnd.games_store.login.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;
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
    @Column(name = "expiration_date")
    private OffsetDateTime expirationDate;
    @Column(name = "is_account_non_locked")
    private Boolean isAccountNonLocked;
    @Column(name = "credentials_expiration_date")
    private OffsetDateTime credentialsExpirationDate;
    @Column(name ="is_account_enabled")
    private Boolean isAccountEnabled;

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
//                ", authorities=" + authorities +
                ", email='" + email + '\'' +
                ", expirationDate=" + expirationDate +
                ", accountNonLocked=" + isAccountNonLocked +
                ", credentialsExpirationDate=" + credentialsExpirationDate +
                ", enabled=" + isAccountEnabled +
                '}';
    }
}
