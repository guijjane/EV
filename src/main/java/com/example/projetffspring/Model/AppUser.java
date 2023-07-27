package com.example.projetffspring.Model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  username;
    private String passwordHash;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roleList=new ArrayList<>();
}
