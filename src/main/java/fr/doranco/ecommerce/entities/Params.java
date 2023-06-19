package fr.doranco.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table
@Getter
public class Params {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String cle_cryptage_pwd;

    @Column(nullable = false)
    private String cle_cryptage_cp;
}
