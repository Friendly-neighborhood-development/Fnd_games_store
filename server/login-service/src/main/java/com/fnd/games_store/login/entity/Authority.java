package com.fnd.games_store.login.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authorities")
@NoArgsConstructor
@Data
public class Authority {

    @NotNull
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy ="uuid2")
    @Column(name = "authority_id")
    private String id;

    private String authority;


    @ManyToMany(mappedBy = "authorities")
    @JsonIgnore
    private List<Account> accounts;

}
