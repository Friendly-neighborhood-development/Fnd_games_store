package com.fnd.games_store.login.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;


import javax.persistence.*;

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
    @Column(name = "authority_id")
    private String id;

    private String authority;



}
