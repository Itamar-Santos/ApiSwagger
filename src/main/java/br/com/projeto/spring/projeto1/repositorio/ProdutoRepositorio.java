package br.com.projeto.spring.projeto1.repositorio;

import br.com.projeto.spring.projeto1.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {
}
