package br.com.projeto.spring.projeto1.controller;

import br.com.projeto.spring.projeto1.entity.Pedido;
import br.com.projeto.spring.projeto1.servico.PedidoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    final
    PedidoServico pedidoServico;

    public PedidoController(PedidoServico pedidoServico) {
        this.pedidoServico = pedidoServico;
    }


    @GetMapping
    public ResponseEntity <List<Pedido>> getAll(){
    List<Pedido> pedidos = pedidoServico.getAll();
    if(!pedidos.isEmpty())
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
     else
            return new ResponseEntity<>(null
            , HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
            public ResponseEntity<Pedido> getById(@PathVariable Integer id){
            Pedido pedido = pedidoServico.getById(id);
            if (pedido != null)
                return new ResponseEntity<>(pedido, HttpStatus.OK);
            else
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    @PostMapping
            public ResponseEntity<Pedido> savePedido(@RequestBody Pedido pedido){
        return new ResponseEntity<>(pedidoServico.savePedido(pedido), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pedido>  updatePedido(@PathVariable Integer id, @RequestBody Pedido pedido ){
        Pedido pedidoAtualizado = pedidoServico.updatePedido(id, pedido);
        if (pedidoAtualizado != null)
            return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
@DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePedido(@PathVariable Integer id){
        if (pedidoServico.deletePedido(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
}


    }




