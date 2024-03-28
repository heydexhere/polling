package com.polling.ipl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "poll")
public class Poll {

    @Id
    String team;
    private String[] votes;

}
