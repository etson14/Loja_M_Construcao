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
    
    
    
    public void meno() throws IOException{        
        System.out.println("\t Menu Cliente");
        System.out.println("1 -> Listar Cliente");
        System.out.println("2 -> Adicionar Cliente");
        System.out.println("3 -> Editar Cliente");
        System.out.println("4 -> Eliminar Cliente");
        System.out.println("0 -> sair");
        System.out.println("Escolha uma opção");
        
        switch(op){
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
        
         System.out.println("\t Adicionar Cliente");
         
         System.out.println("Entre com o nome completo");
         this.nome = ler.nextLine();
         
         System.out.println("Entre com a data nascimento");
         System.out.println("Entre com dia");
         this.dia = ler.nextInt();
         
         System.out.println("Entre com mes");
         this.mes = ler.nextInt();
         
         System.out.println("Entre com ano");
         this.ano = ler.nextInt();
         this.dataNascimento = LocalDate.of(ano, mes ,dia);
         
         ler.nextLine();
         System.out.println("BI");
         this.BI = ler.nextLine();
         
         System.out.println("Entre com Naturalidade");
         this.Naturalidade = ler.nextLine();
         
         System.out.println("Entre com Email");
         this.Email = ler.nextLine();
         
         System.out.println("Entre com Telefone");
         this.Telefone = ler.nextLine();
         
         System.out.println("Entre com Nome Pai");
         this.nomePai = ler.nextLine();
         
         System.out.println("Entre com Nome Mae");
         this.nomeMae = ler.nextLine();
         
         System.out.println("Entre com Rua");
         this.endereco.rua = ler.nextLine();
         
         System.out.println("Entre com Numero");
         this.endereco.numero = ler.nextLine();
         
         System.out.println("Entre com Bairro");
         this.endereco.bairro = ler.nextLine();
         
         System.out.println("Entre com Cidade");
         this.endereco.cidade = ler.nextLine();
         
         System.out.println("Entre com Caixa Postal");
         this.endereco.caixaPostal = ler.nextLine();
         
         System.out.println("Entre com Ilha");
         this.endereco.ilha = ler.nextLine();
         
         System.out.println("Entre com Total Rendimento");
         this.totalRendimento = ler.nextFloat();
         
         clienteBufferedWriter.write(this.nome + ";");
         clienteBufferedWriter.write(this.dataNascimento + ";");
         clienteBufferedWriter.write(this.BI + ";");
         clienteBufferedWriter.write(this.Naturalidade + ";");         
         clienteBufferedWriter.write(this.Email + ";");         
         clienteBufferedWriter.write(this.Telefone + ";");
         clienteBufferedWriter.write(this.nomePai + ";");
         clienteBufferedWriter.write(this.nomeMae + ";");
         clienteBufferedWriter.write(this.endereco.rua + ";");
         clienteBufferedWriter.write(this.endereco.numero + ";");
         clienteBufferedWriter.write(this.endereco.bairro + ";");
         clienteBufferedWriter.write(this.endereco.cidade+ ";");
         clienteBufferedWriter.write(this.endereco.caixaPostal + ";");
         clienteBufferedWriter.write(this.endereco.ilha + ";");
         clienteBufferedWriter.write(this.totalRendimento + "\n");
         
          clienteBufferedWriter.close();
    }
}
