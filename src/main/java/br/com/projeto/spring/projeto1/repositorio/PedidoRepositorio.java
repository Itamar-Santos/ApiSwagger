package br.com.projeto.spring.projeto1.repositorio;

import br.com.projeto.spring.projeto1.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
}
