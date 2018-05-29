/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja_m_construcao.domain;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static loja_m_construcao.Loja_M_Construcao.menuPrincipal;

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
    
    public String op;
    public String vendaFile;
    public Scanner ler = new Scanner(System.in);
    
    public Venda() throws IOException{
        this.vendaFile = new File("src\\loja_m_construcao\\files\\venda.txt").getCanonicalPath();
    }
    
    public void menu() throws IOException{
        System.out.println("\tMenu Venda");
        System.out.println("1 -> Nova Venda");
        System.out.println("2 -> Listar Vendas");
        System.out.println("0 -> Voltar");
        System.out.print("\nEscolha uma opção: ");
        op = ler.nextLine();
        
        switch(op){
            case "1":{
                novaVenda();
                break;
            }
            case "2":{
                break;
            }
            case "0":{
                menuPrincipal();
                break;
            }
            default:{
                System.out.println("Erro");
                menu();
            }
        }
    }
    
    public void novaVenda() throws IOException{
        Venda venda = new Venda();
        cliente = new Cliente();
        funcionario = new Funcionario();
        pedido = new ArrayList<>();
        
        venda.data = LocalDate.now();
        
        System.out.println(venda.data);
        System.out.println("Entre com o nome do cliente");
        
    }
}
