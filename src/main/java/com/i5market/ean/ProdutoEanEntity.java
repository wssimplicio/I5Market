package com.i5market.ean;

import com.i5market.produto.ProdutoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Table(name = "produto_ean")
@Entity(name = "produto_ean")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProdutoEanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto", nullable = false)
    private ProdutoEntity produto;

    @Column(nullable = false)
    private BigInteger codigobarras;

    @Column
    private String embalagem;

    @Column(name = "qtd_embalagem")
    private Integer qtdembalagem;

}
