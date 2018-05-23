/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja_m_construcao.domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Edson Tavares
 */
public class Cliente extends Pessoa {
    
    public int idCliente;
    public String estadoCivil;
    public String sexo;
    public float totalRendimento;
    
    
    public  int op, dia, mes, ano;
    public File clienteFile = new File("C:\\Users\\Janito\\Documents\\NetBeansProjects\\Loja_M_Construcao\\src\\loja_m_construcao\\files\\cliente.txt");
    Scanner ler = new Scanner(System.in);
    
    
    
    public void menu() throws IOException{        
        System.out.println("\t Menu Cliente");
        System.out.println("1 -> Listar Cliente");
        System.out.println("2 -> Adicionar Cliente");
        System.out.println("3 -> Editar Cliente");
        System.out.println("4 -> Eliminar Cliente");
        System.out.println("0 -> sair");
        System.out.println("Escolha uma opção");
        op  = ler.nextInt();
        
        switch(op){
            case 0:{
                break;
            }
            case 1:{
                break;
            }
            case 2:{
                adicionar();
                break;
               
            }
            case 3:{
                break;
            }
            case 4:{
                break;
            }
        }
     } 
   
    public void adicionar() throws IOException{
        FileWriter clienteFileWriter = new FileWriter(clienteFile,true);
        BufferedWriter clienteBufferedWriter = new BufferedWriter(clienteFileWriter);
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        
        ler.nextLine();
        System.out.println("\t Adicionar Cliente");
         
         System.out.println("Entre com o nome completo");
         cliente.nome = ler.nextLine();
         
         System.out.println("Entre com a data nascimento");
         System.out.println("Dia");
         this.dia = ler.nextInt();
         
         System.out.println("Mes");
         this.mes = ler.nextInt();
         
         System.out.println("Ano");
         this.ano = ler.nextInt();
         cliente.dataNascimento = LocalDate.of(ano, mes ,dia);
         
         ler.nextLine();
         System.out.println("BI");
         cliente.BI = ler.nextLine();
         
         System.out.println("Entre com Naturalidade");
         cliente.Naturalidade = ler.nextLine();
         
         System.out.println("Entre com Email");
         cliente.Email = ler.nextLine();
         
         System.out.println("Entre com Telefone");
         cliente.Telefone = ler.nextLine();
         
         System.out.println("Entre com Nome Pai");
         cliente.nomePai = ler.nextLine();
         
         System.out.println("Entre com Nome Mae");
         cliente.nomeMae = ler.nextLine();
         
         System.out.println("Entre com Rua");
         endereco.rua = ler.nextLine();
         
         System.out.println("Entre com Numero");
         endereco.numero = ler.nextLine();
         
         System.out.println("Entre com Bairro");
         endereco.bairro = ler.nextLine();
         
         System.out.println("Entre com Cidade");
         endereco.cidade = ler.nextLine();
         
         System.out.println("Entre com Caixa Postal");
         endereco.caixaPostal = ler.nextLine();
         
         System.out.println("Entre com Ilha");
         endereco.ilha = ler.nextLine();
         cliente.endereco =  endereco;
         
         System.out.println("Entre com Total Rendimento");
         cliente.totalRendimento = ler.nextFloat();
         
         clienteBufferedWriter.write(cliente.nome + ";");
         clienteBufferedWriter.write(cliente.dataNascimento + ";");
         clienteBufferedWriter.write(cliente.BI + ";");
         clienteBufferedWriter.write(cliente.Naturalidade + ";");         
         clienteBufferedWriter.write(cliente.Email + ";");         
         clienteBufferedWriter.write(cliente.Telefone + ";");
         clienteBufferedWriter.write(cliente.nomePai + ";");
         clienteBufferedWriter.write(cliente.nomeMae + ";");
         clienteBufferedWriter.write(cliente.endereco.rua + ";");
         clienteBufferedWriter.write(cliente.endereco.numero + ";");
         clienteBufferedWriter.write(cliente.endereco.bairro + ";");
         clienteBufferedWriter.write(cliente.endereco.cidade+ ";");
         clienteBufferedWriter.write(cliente.endereco.caixaPostal + ";");
         clienteBufferedWriter.write(cliente.endereco.ilha + ";");
         clienteBufferedWriter.write(cliente.totalRendimento + "\n");
         
          clienteBufferedWriter.close();
    }
}
