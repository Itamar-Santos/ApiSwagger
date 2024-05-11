package br.com.projeto.spring.projeto1.servico;


import br.com.projeto.spring.projeto1.entity.Categoria;
import br.com.projeto.spring.projeto1.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CategoriaServico {

    @Autowired
     CategoriaRepositorio categoriaRepositorio;


    public List<Categoria> getAll() {
        return categoriaRepositorio.findAll();

    }

    public Categoria getById(Integer id) {
        return categoriaRepositorio.findById(id).orElse(null);

    }

    public Categoria saveCategoria(Categoria categoria) {

        return categoriaRepositorio.save(categoria);
    }

    public Categoria updateCategoria(Integer id, Categoria categoria) {
        Categoria categoriaAtualizada = categoriaRepositorio.findById(id).orElse(null);
        if (categoriaAtualizada != null) {
            categoriaAtualizada.setCategoriaNome(categoria.getCategoriaNome());
            return categoriaRepositorio.save(categoriaAtualizada);
        } else {
            return null;

        }
    }

    public Boolean deleteCategoria(Integer id) {
        Categoria categoria = categoriaRepositorio.findById(id).orElse(null);
        if (categoria != null) {
            categoriaRepositorio.delete(categoria);
            return true;
        }else{
            return false;
        }


    }
}

