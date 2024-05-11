package br.com.projeto.spring.projeto1.controller;


import br.com.projeto.spring.projeto1.entity.Produto;
import br.com.projeto.spring.projeto1.servico.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    final
    ProdutoServico produtoServico;

    public ProdutoController(ProdutoServico produtoServico) {
        this.produtoServico = produtoServico;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        List<Produto> produtos = produtoServico.getAll();
        if(!produtos.isEmpty())
            return new ResponseEntity<>(produtos, HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Integer id){
        Produto produto = produtoServico.getById(id);
        if (produto != null)
            return new ResponseEntity<>(produto, HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
@PostMapping
    public ResponseEntity<Produto> saveProduto(@RequestBody Produto produto){
        return new ResponseEntity<>(produtoServico.saveProduto(produto), HttpStatus.CREATED);
}
@PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Integer id , @RequestBody Produto produto){
        Produto produtoAtualizado = produtoServico.updateProduto(id, produto);
        if(produtoAtualizado != null)
            return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
}
@DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduto(@PathVariable Integer id){
        if (produtoServico.deleteProduto(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
}
}
