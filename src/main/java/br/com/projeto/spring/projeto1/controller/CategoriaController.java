package br.com.projeto.spring.projeto1.controller;



import br.com.projeto.spring.projeto1.entity.Categoria;
import br.com.projeto.spring.projeto1.servico.CategoriaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    final
    CategoriaServico categoriaServico;

    public CategoriaController(CategoriaServico categoriaServico) {
        this.categoriaServico = categoriaServico;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        List<Categoria> categorias = categoriaServico.getAll();
        if (!categorias.isEmpty())
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Integer id) {

        Categoria categoria = categoriaServico.getById(id);
        if (categoria !=null)
            return new ResponseEntity<>(categoria, HttpStatus.OK);
    else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
        return new ResponseEntity<>(categoriaServico.saveCategoria(categoria), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        Categoria categoriaAtualizada = categoriaServico.updateCategoria(id, categoria);
        if (categoriaAtualizada != null)
            return new ResponseEntity<>(categoriaAtualizada, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategoria(@PathVariable Integer id) {
        if (categoriaServico.deleteCategoria(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }
}







