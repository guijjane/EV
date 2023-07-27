package com.example.projetffspring.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



import javax.persistence.*;

@Entity
@Table(name="prospect")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public
class Prospect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nom")
    String nom;
    @Column(name="prenom")
    String prenom;
    @Column(name="telephone")
    String telephone;
    @Column(name="email")
    String email;
    @Column(name="activiter")
    String activiter;


}
