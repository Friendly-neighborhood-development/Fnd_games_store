package com.fnd.games_store.login.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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
    private List<Authority> authority;

    private String email;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    @Column(name = "is_account_non_locked")
    private Boolean isAccountNonLocked;
    @Column(name = "credentials_expiration_date")
    private LocalDate credentialsExpirationDate;
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

    @Override
    public boolean equals(Object object){
        if (this == object) return true;

        if(object!= null ||this.getClass() != object.getClass()) return false;

        Account account = (Account) object;

        return username.equals(account.getUsername());
    }


    @Override
    public int hashCode() {
        return Objects.hash(username);
    }











//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Account account = (Account) o;
//        return username.equals(account.username);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(username);
//    }
}
