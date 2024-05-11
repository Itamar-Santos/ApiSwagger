package br.com.projeto.spring.projeto1.servico;

import br.com.projeto.spring.projeto1.entity.Produto;
import br.com.projeto.spring.projeto1.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProdutoServico {

    @Autowired
    public ProdutoRepositorio produtoRepositorio;

    public List<Produto> getAll(){
        return produtoRepositorio.findAll();
    }
    public Produto getById(Integer id){
        return produtoRepositorio.findById(id).orElse(null);
    }
public Produto saveProduto(Produto produto){
        return produtoRepositorio.save(produto);
}
public Produto updateProduto(Integer id, Produto produto) {
    Produto produtoAtualizado = produtoRepositorio.findById(id).orElse(null);
    if (produtoAtualizado != null) {
        produtoAtualizado.setProdutoNome(produto.getProdutoNome());
        produtoAtualizado.setCategoria(produto.getCategoria());
        return produtoRepositorio.save(produtoAtualizado);
    } else {
        return null;
    }
}
        public Boolean deleteProduto(Integer id){
            Produto produto = produtoRepositorio.findById(id).orElse(null);
            if (produto != null){
                produtoRepositorio.delete(produto);
                return true;
            }else{
                return false;
            }

    }
}

