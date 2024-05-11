package br.com.projeto.spring.projeto1.servico;

import br.com.projeto.spring.projeto1.entity.Pedido;
import br.com.projeto.spring.projeto1.repositorio.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServico {


    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    public List<Pedido> getAll() {

        return pedidoRepositorio.findAll();
    }

    public Pedido getById(Integer id) {

        return pedidoRepositorio.findById(id).orElse(null);
    }

    public Pedido savePedido(Pedido pedido) {

        return pedidoRepositorio.save(pedido);
    }

    public Pedido updatePedido(Integer id, Pedido pedido) {
        Pedido pedidoAtualizado = pedidoRepositorio.findById(id).orElse(pedido);
        if (pedidoAtualizado != null) {
            pedidoAtualizado.setPedidoData(pedido.getPedidoData());
            return pedidoRepositorio.save(pedidoAtualizado);
        } else {
            return null;
        }
    }

    public Boolean deletePedido(Integer id) {
        Pedido pedido = pedidoRepositorio.findById(id).orElse(null);
        if (pedido != null) {
            pedidoRepositorio.delete(pedido);
            return true;

        } else {
            return false;
        }
    }


}
