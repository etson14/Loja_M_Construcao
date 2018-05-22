/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja_m_construcao.domain;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Edson Tavares
 */
public class Venda {
    
    public int idVenda;
    public LocalDate data;
    public float preco;
    public Cliente cliente;
    public Funcionario funcionario;
    public List<Pedido> pedido;
    
}
