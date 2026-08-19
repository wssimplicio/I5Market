package com.i5market.produto;

import com.i5market.ean.ProdutoEanEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "produto")
@Entity(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String descricao;

    @Column()
    private Double preco;

    @Column()
    private Double estoque;

    @Column(columnDefinition = "true", nullable = false)
    private Boolean status;

    @OneToMany(mappedBy = "produto")
    private List<ProdutoEanEntity> ean = new ArrayList<>();
}
