package com.fnd.games_store.login.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authorities")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Authority implements GrantedAuthority {

    @NotNull
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy ="uuid2")
    private String id;

    private String authority;

    @ManyToMany(mappedBy = "authorities")
    private List<Account> account;

}
