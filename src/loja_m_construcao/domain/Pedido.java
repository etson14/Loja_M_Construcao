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
import static java.lang.Float.valueOf;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edson Tavares
 */
public class Pedido {
    
    public String idPedido;
    public int quantidade;
    public float valor;
    public Material material;
    public Venda venda;
    
    String pedidoFile;
    
    public Pedido() throws IOException{
        this.pedidoFile =  new File("src\\loja_m_construcao\\files\\pedido.txt").getCanonicalPath();
    }
    
    public void salvarFicheiro(List<Pedido> pedido) throws IOException{
        FileWriter pedidoFileWriter = new FileWriter(pedidoFile);
        BufferedWriter pedidoBuffWriter = new BufferedWriter(pedidoFileWriter);
        
        for(Pedido p : pedido){
            pedidoBuffWriter.write(p.idPedido + ";");
            pedidoBuffWriter.write(p.quantidade + ";");
            pedidoBuffWriter.write(p.valor + ";");
            pedidoBuffWriter.write(p.material.nome + ";");
            pedidoBuffWriter.write(p.venda.idVenda + "\n");            
        }
        pedidoBuffWriter.close();
    }
    
    public List<Pedido> lerFicheiro() throws FileNotFoundException, IOException{
        List<Pedido> listMaterial = new ArrayList<>();
        FileReader pedidoFileReader = new FileReader(pedidoFile);
        BufferedReader pedidoBuffReader = new BufferedReader(pedidoFileReader);  
        String valores;
        
        while((valores = pedidoBuffReader.readLine()) != null){
            Pedido pedido = new Pedido();
            String[] atributos = valores.split(";");
            
            pedido.idPedido = atributos[0];
            pedido.quantidade = Integer.parseInt(atributos[1]);
            pedido.valor = valueOf(atributos[2]);
            pedido.material.nome = atributos[3];
            pedido.venda.idVenda = atributos[4];
            
            listMaterial.add(pedido);
        }
        return listMaterial;        
    }
}
