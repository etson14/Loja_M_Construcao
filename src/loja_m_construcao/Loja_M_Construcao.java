/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja_m_construcao;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import loja_m_construcao.domain.Funcionario;
import loja_m_construcao.domain.Cliente;
import loja_m_construcao.domain.Fornecedor;
import loja_m_construcao.domain.Material;
import loja_m_construcao.domain.Utilizador;
import loja_m_construcao.domain.Venda;

public class Loja_M_Construcao {

    public static Scanner ler = new Scanner(System.in);
    public static String nomeUsuario;
    
    public static void main(String[] args) throws IOException {
//         Utilizador utilizador = new Utilizador();
//        utilizador.menu();
        
        LocalDateTime dataSistema = LocalDateTime.now();
        JFrame frame =new JFrame("ok");

       System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println("**                                                   **");
        System.out.println("**         LOJA DE MATERIAL DE CONSTRUÇÃO            **");
        System.out.println("**                                                   **");
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");

        if(dataSistema.getDayOfWeek().toString().equals("SUNDAY") || dataSistema.getDayOfWeek().toString().equals("SATURDAY")){
            System.err.println("Fim de semana");
            System.err.println("Não há sistema\n");
        }else{
            login();
        }
    }
    
    public static void login() throws IOException{
        
        String  senha;
        System.out.println("\n\nEntre com nome do usuario: ");
        nomeUsuario = ler.nextLine();
        System.out.println("Entre com a senha: ");
        senha = ler.nextLine();
        
        Utilizador utilizador = new Utilizador();
        List<Utilizador> utilizadorList = utilizador.lerFicheiro();
        
        for(Utilizador u : utilizadorList){
           if(u.nome.equals(nomeUsuario) && u.senha.equals(senha)){
                menuPrincipal();
           }
        }  
        //System.err.println("Erro no login \nTenta novamente!!!");
        //login(); 
        
        //return nomeUsuario;
    }
    public static void menuPrincipal() throws IOException{
        String opc;
        System.out.println("\n\n");
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println("**                                                   **");
        System.out.println("**     BENVINDO A LOJA DE MATERIAL DE CONSTRUÇÃO     **");
        System.out.println("**                                                   **");
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println("**                                                   **");
        System.out.println("**                                                   **");
        System.out.println("**               1 -> Clientes                       **");
        System.out.println("**               2 -> Fornecedores                   **");
        System.out.println("**               3 -> Funcionarios                   **");
        System.out.println("**               4 -> Materias                       **");
        System.out.println("**               5 -> Vendas                         **");
        System.out.println("**               6 -> Utilizadores                   **");
        System.out.println("**                                                   **");
        System.out.println("**               0-SAIR                              **");
        System.out.println("**                                                   **");
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");

        System.out.println("Escolha uma Opcao:");
        opc=ler.nextLine();

        switch(opc){

            case "1":{
                Cliente c = new Cliente();
                c.menu();
                break;
            }

            case "2":{
                Fornecedor c3=new Fornecedor();
                c3.menuFornecedor(); 
                break;
            }

            case "3":{
                Funcionario f = new Funcionario();
                f.menu();                      
                break;
            }

            case "4":{
                Material m = new Material();
                m.menu();
                break; 
            }

            case "5":{
                Venda v = new Venda();
                v.menu();
                break;
            } 
            case "6":{
                Utilizador u = new Utilizador();
                u.menu();
                break;
            } 
            case "0":{
                System.exit(0);
                break;
            }
            default:{ 
                System.out.println("Opcão Incorreta");
                menuPrincipal();
            }
        }
   
    }
    
   

}
    

