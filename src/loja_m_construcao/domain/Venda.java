/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja_m_construcao.domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static loja_m_construcao.Loja_M_Construcao.menuPrincipal;
import static loja_m_construcao.Loja_M_Construcao.nomeUsuario;

/**
 *
 * @author Edson Tavares
 */
public class Venda {
    
    public String idVenda;
    public LocalDate data;
    public float preco;
    public Cliente cliente;
    public Utilizador utilizador;
    public Pedido pedido;
    
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
        Pedido pedido = new Pedido();
        List<Pedido> pedidoList = pedido.lerFicheiro();
        Venda venda = new Venda();
        cliente = new Cliente();
        utilizador = new Utilizador();
        Material material = new Material();
        List<Material> materialList = material.lerFicheiro();
        int escolha;
        Random id = new Random();
        id.nextInt(1000);
        
        pedido.idPedido = id.toString();
        venda.idVenda = id.toString();
        venda.data = LocalDate.now();
        utilizador.nome = nomeUsuario;        
        
        System.out.println("Codigo  |Nome        |Preço   |Quantidade");
        materialList.forEach(u -> System.out.println(u.idMaterial +"      "+ u.nome +"         "+ u.preco  +"        "+ u.quantidade));
    
        System.out.println("Escolha um produto(codigo):");
        escolha = ler.nextInt();
        for(Material m : materialList){
            if(Integer.parseInt(m.idMaterial) == escolha){
                pedido.material = m;
                System.out.println("Entre com a quantidade:");
                pedido.quantidade = ler.nextInt();
                if(pedido.quantidade  > m.quantidade){
                    System.out.println("Quantidade Indisponivel");
                }
                pedido.valor = pedido.material.preco * pedido.quantidade;
                System.out.println("Preço: " + pedido.valor);
                
                m.quantidade -= pedido.quantidade;
                pedido.venda.idVenda = venda.idVenda;
                venda.pedido.idPedido = pedido.idPedido;
                
                
               
                pedidoList.add(pedido);
                pedido.salvarFicheiro(pedidoList);
                materialList.add(m);
                material.salvarFicheiro(materialList);
            }
        }
        
        
        
        
        System.out.println("Entre com o nome do cliente");
        cliente.nome = ler.nextLine();
        
        
        
    }
    
    public void salvarFicheiro(List<Venda> venda) throws IOException{
        FileWriter vendaFileWriter = new FileWriter(vendaFile);
        BufferedWriter vendaBuffWriter = new BufferedWriter(vendaFileWriter);
        
        for(Venda v : venda){
            vendaBuffWriter.write(v.data + ";");
            vendaBuffWriter.write(v.preco + ";");
            vendaBuffWriter.write(v.utilizador.nome + ";");
            vendaBuffWriter.write(v.cliente.nome + ";");
            vendaBuffWriter.write(v.idVenda + "\n");            
        }
        vendaBuffWriter.close();
    }
    
    public List<Venda> lerFicheiro() throws FileNotFoundException, IOException{
        List<Venda> listVenda = new ArrayList<>();
        FileReader vendaFileReader = new FileReader(vendaFile);
        BufferedReader vendaBuffReader = new BufferedReader(vendaFileReader);  
        String valores;
        
        while((valores = vendaBuffReader.readLine()) != null){
            Venda venda = new Venda();
            String[] atributos = valores.split(";");
            
            utilizador.idUtilizador = atributos[0];
            
            
            listVenda.add(venda);
        }
        return listVenda;        
    }
}
