/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja_m_construcao.domain;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Edson Tavares
 */
public class Funcionario extends Pessoa {       
   
    public int idFuncionario;
    public float salario;
    public float comissao;
    public boolean estado;
    public String nomeUtilizador;
    public String senha;
    public int serieCarteira;
    
    public int op, ano, mes, dia;  
    File funcionarioFile = new File("C:\\Users\\Jair\\Documents\\NetBeansProjects\\LMC\\Loja_M_Construcao\\src\\loja_m_construcao\\files\\funcionario.txt");
    Scanner ler = new Scanner(System.in);


    public void menu(){
        System.out.println("\t Menu Funcionarios");
        System.out.println("1 -> Listar Funcionarios");
        System.out.println("2 -> Adicionar Funcionarios");
        System.out.println("3 -> Editar Funcionarios");
        System.out.println("4 -> Eliminar Funcionarios");
        System.out.println("0 -> Sair");
        System.out.println("Escolha uma opção: ");

        switch(op){
            case 1: {
                listar();
                break;
            }
            case 2: {
                adicionar();
                break;
            }
        }
    }

    public void listar(){

    }

    public void adicionar(){
        System.out.println("\t Adicionar Funcionario");
        
        System.out.println("Entre com o codigo");
        this.idFuncionario = ler.nextInt();
        
        System.out.println("Entre com o nome completo");
        this.nome = ler.nextLine();
        
        System.out.println("\t Data Nascimento:");
        System.out.println("Entre com o dia: ");
        this.dia = ler.nextInt();

        System.out.println("Entre com o mes: ");
        this.mes = ler.nextInt();

        System.out.println("Entre com o ano: ");
        this.ano = ler.nextInt();
        this.dataNascimento = LocalDate.of(ano, mes, dia);
        
        ler.nextLine();
        System.out.println("Entre com o NIF");
        this.NIF = ler.nextLine();
        
        System.out.println("Entre com o BI");
        this.BI = ler.nextLine();
        
        System.out.println("Entre com a naturalidade");
        this.Naturalidade = ler.nextLine();
        
        System.out.println("Entre com o email");
        this.Email = ler.nextLine();
        
        System.out.println("Entre com o telefone");
        this.Telefone = ler.nextLine();
        
        System.out.println("Entre com o nome do pai");
        this.nomePai = ler.nextLine();
        
        System.out.println("Entre com o nome da mãe");
        this.nomeMae = ler.nextLine();
        
        System.out.println("Entre com a rua: ");
        this.endereco.rua = ler.nextLine();        
        
        System.out.println("Entre com o numero: ");
        this.endereco.numero = ler.nextLine(); 
        
        System.out.println("Entre com a bairro: ");
        this.endereco.bairro = ler.nextLine();        
        
        System.out.println("Entre com a cidade: ");
        this.endereco.cidade = ler.nextLine();        
        
        System.out.println("Entre com a caixa postal: ");
        this.endereco.caixaPostal = ler.nextLine();        
        
        System.out.println("Entre com a ilha: ");
        this.endereco.ilha = ler.nextLine();
        
        
        
    }
}
