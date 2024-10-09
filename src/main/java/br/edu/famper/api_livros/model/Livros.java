package br.edu.famper.api_livros.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "livro")
@Data

public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long codigo;

    @Column(name = "titulo", length = 250)
    private String titulo;

    @Column(name = "autor", length = 250)
    private String autor;

    @Column(name = "ano_publicacao")
    private Integer ano_publicacao;

    @Column(name = "preço", length = 6)
    private Double preco;

}
