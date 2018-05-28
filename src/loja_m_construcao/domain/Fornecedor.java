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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Edson Tavares
 */
public class Fornecedor extends Pessoa {
    Scanner ler=new Scanner(System.in);
    public String idFornecedor,op;
    int esc;
    
    
    
    String fornecedorFile;

    public Fornecedor() throws IOException {
        this.fornecedorFile = new File("src\\loja_m_construcao\\files\\fornecedor.txt").getCanonicalPath();     
    }
    
    public void menuFornecedor() throws IOException{
        
        System.out.println("\t Menu Fornecedor");
        System.out.println("1 -> Listar Fornecedor");
        System.out.println("2 -> Adicionar Fornecedor");
        System.out.println("3 -> Editar Fornecedor");
        System.out.println("4 -> Eliminar Fornecedor");
        System.out.println("0 -> Sair");
        System.out.println("Escolha uma opção: ");
        op =ler.nextLine(); 
        
        switch(op){
            
            case "0":{
                System.exit(0);
                break;
            }
            
            case "1":{
                listarFornecedor();
                break;
            }
            
            case "2":{
                adicionar();                
                break;
            }
            
            case "3":{
                break;
            }
            
            case "4":{
                break;
            }
            
            
            default:{ 
                System.out.println("Opcão Incorreto");
                menuFornecedor();
            }  
        }
        
    }
    
    
    public void adicionar() throws IOException{
        
         do{
            
                
        Fornecedor fornecedor=new Fornecedor();
        Endereco endereco=new Endereco();
        
          
        System.out.println("\tAdicionar Fornecedor");
        
        System.out.print("Entre com o codigo:");
        fornecedor.idFornecedor=ler.nextLine();        
        
        System.out.println("Entre com o nome:");
        fornecedor.nome = ler.nextLine ();
        
        System.out.print("Entre com o NIF:");
        fornecedor.NIF=ler.nextLine();
        
        System.out.print("Entre com o BI:");
        fornecedor.BI=ler.nextLine();
        
        System.out.print("Entre com email:");
        fornecedor.Email=ler.nextLine();
        
        System.out.println("\tEndereço");
        System.out.print("Entre com o codigo:");
        endereco.idEndereco=ler.nextInt();
        
        ler.nextLine();
        System.out.println("Entre com a rua: ");
        endereco.rua = ler.nextLine();        
        
        System.out.println("Entre com o numero: ");
        endereco.numero = ler.nextLine(); 
        
        System.out.println("Entre com a bairro: ");
        endereco.bairro = ler.nextLine();        
        
        System.out.println("Entre com a cidade: ");
        endereco.cidade = ler.nextLine();        
        
        System.out.println("Entre com a caixa postal: ");
        endereco.caixaPostal = ler.nextLine();        
        
        System.out.println("Entre com a ilha: ");
        endereco.ilha = ler.nextLine();
        
        
        
        fornecedor.endereco=endereco;
        
        escreverFornecedor(fornecedor);
        
        
        
        System.out.println("\n");
        System.out.println("1->Adicionar novamente");
        System.out.println("2->voltar ao menu fornecedor");
        System.out.println("3->SAIR");
        esc=ler.nextInt();
        
        
        
        if(esc==2){
            menuFornecedor();
        }
        
        }
        while(esc==1);
        
    }
    
    public void escreverFornecedor(Fornecedor fornecedor) throws IOException{
        FileWriter fornecedorFileWriter=new FileWriter(fornecedorFile,true);
        BufferedWriter fornecedorBufferedWriter=new BufferedWriter(fornecedorFileWriter);
        
        fornecedorBufferedWriter.write(fornecedor.idFornecedor + ";" );
        fornecedorBufferedWriter.write(fornecedor.nome + ";");
        fornecedorBufferedWriter.write(fornecedor.NIF + ";");
        fornecedorBufferedWriter.write(fornecedor.BI + ";");
        fornecedorBufferedWriter.write(fornecedor.Email + ";");
        fornecedorBufferedWriter.write(fornecedor.endereco.idEndereco + ";");
        fornecedorBufferedWriter.write(fornecedor.endereco.rua + ";");
        fornecedorBufferedWriter.write(fornecedor.endereco.numero + ";");
        fornecedorBufferedWriter.write(fornecedor.endereco.bairro + ";");
        fornecedorBufferedWriter.write(fornecedor.endereco.cidade + ";");
        fornecedorBufferedWriter.write(fornecedor.endereco.caixaPostal + ";");
        fornecedorBufferedWriter.write(fornecedor.endereco.ilha + "\n");
        
        fornecedorBufferedWriter.close();
    }
    
    
    public List<Fornecedor> lerficheiroFornecedor() throws FileNotFoundException, IOException{
        ArrayList<Fornecedor> listFornecedor = new ArrayList<>();
        FileReader listFileReader = new FileReader(fornecedorFile);
        BufferedReader listBuffReader = new BufferedReader(listFileReader);
        
        String valor;
        
        while((valor = listBuffReader.readLine()) != null){
            Fornecedor fornecedor=new Fornecedor();
            Endereco endereco=new Endereco();
            
            String[] valores = valor.split(";");
            fornecedor.idFornecedor = valores[0];
            fornecedor.nome = valores[1];
            fornecedor.NIF = valores[2];
            fornecedor.BI = valores[3];
            fornecedor.Email = valores[4];
            endereco.idEndereco = Integer.parseInt(valores[5]);
            endereco.rua = valores[6];
            endereco.numero = valores[7];
            endereco.bairro = valores[8];
            endereco.cidade = valores[9];
            endereco.caixaPostal = valores[10];
            endereco.ilha = valores[11];
            
            fornecedor.endereco = endereco;
            
            listFornecedor.add(fornecedor);        
        }
        return listFornecedor;
        
    }
    
    public void listarFornecedor() throws IOException{
        List<Fornecedor> listForn=lerficheiroFornecedor();
        listForn.forEach(u->System.out.println(u.idFornecedor));
    }
    
    
}
