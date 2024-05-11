package br.com.projeto.spring.projeto1.entity;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Set;

@Entity(name = "pedido")
@Table(name = "pedido")
public class Pedido {

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public LocalTime getPedidoData() {
        return pedidoData;
    }

    public void setPedidoData(LocalTime pedidoData) {
        this.pedidoData = pedidoData;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id")
    private Integer pedidoId;

    @Column(name = "pedido_data")
    private LocalTime pedidoData;

    @ManyToMany
    Set<Produto> produtos;
}
