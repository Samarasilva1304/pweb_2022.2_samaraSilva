package com.samaraSilva.biritaShop.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.samaraSilva.biritaShop.model.Cliente;
import com.samaraSilva.biritaShop.model.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido, Long>{
    List<Pedido> findBYClientePedido(Cliente Cliente);
}