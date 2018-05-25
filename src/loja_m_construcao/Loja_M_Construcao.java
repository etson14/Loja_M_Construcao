/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja_m_construcao;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import loja_m_construcao.domain.Funcionario;
import loja_m_construcao.domain.Cliente;

public class Loja_M_Construcao {

    public static Scanner ler = new Scanner(System.in);

    
    public static void main(String[] args) throws IOException {
         
        int cod,pp;
        JFrame frame =new JFrame("ok");

        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println("**                                                   **");
        System.out.println("**         LOJA DE MATERIAL DE CONSTRUÇÃO            **");
        System.out.println("**                                                   **");
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");

        
        login();
        
    }
    
    public static void login() throws IOException{
        
        String nomeUsuario, senha;
        System.out.println("\n\nEntre com nome do usuario: ");
        nomeUsuario = ler.nextLine();
        System.out.println("Entre com a senha: ");
        senha = ler.nextLine();
        
        Funcionario f = new Funcionario();
        List<Funcionario> funcionarios = f.lerFicheiro();
        
        for(Funcionario func : funcionarios){
            if(func.nomeUtilizador.equals(nomeUsuario) && func.senha.equals(senha)){
                menuPrincipal();
            }
        }  
        System.err.println("Erro no login \nTenta novamente!!!");
        //login(); 
        
        
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
        System.out.println("**               1->Cliente                          **");
        System.out.println("**               2->Endereço                         **");
        System.out.println("**               3->Fornecedor                       **");
        System.out.println("**               4->Funcionario                      **");
        System.out.println("**               5->Material                         **");
        System.out.println("**               6->Pedido                           **");
        System.out.println("**               7->Pessoa                           **");
        System.out.println("**               8->Venda                            **");
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
                break;
            }

            case "3":{
                break;
            }

            case "4":{
                Funcionario f = new Funcionario();
                f.menu();
                break; 
            }

            case "5":{
                break;
            }
            case "6":{
                break;
            }

            case "7":{
                break;               
            }
            case "8":{
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
    

