package com.fnd.games_store.games.dto.developer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fnd.games_store.games.entity.Game;
import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

public class DeveloperResponseDTO {


    private String id;


    private String name;


}
