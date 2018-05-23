/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja_m_construcao;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import loja_m_construcao.domain.Funcionario;
public class Loja_M_Construcao {

    
    public static void main(String[] args) throws IOException {
        int cod,opc,pp;
        
        Scanner ler =new Scanner(System.in);
        JFrame frame =new JFrame("ok");
     
        
         
    System.out.println("*******************************************************");
    System.out.println("*******************************************************");
    System.out.println("**                                                   **");
    System.out.println("**         LOJA DE MATERIAL DE CONSTRUÇÃO            **");
    System.out.println("**                                                   **");
    System.out.println("*******************************************************");
    System.out.println("*******************************************************");
    
    
    
    System.out.print("Codigo:");
    cod=ler.nextInt();
    System.out.print("Palavra-Passe:");
    pp=ler.nextInt();
    
    if(cod!=1234 || pp!=1234){
        JOptionPane.showMessageDialog(frame,"Codigo ou Palavra-Passe Incorreto");
    }
    else 
    
    {
        
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
    opc=ler.nextInt();
        
    
    
    
    
    switch(opc){
        
        case 1:{
            
        break;}
        
        case 2:{
            
        break;}
        
        case 3:{
            
        break;}
        
        case 4:{
            Funcionario f = new Funcionario();
            f.menu();
            break; 
        }
        
        case 5:{
            
        break; }
        
        
        case 6:{
            
            
        }
        
        case 7:{
        
        break;    
        }
        
        
        case 8:{
        
        break;    
        }
        
        case 0:{
            System.exit(0);
            
         break;
        }
        
        
        default:System.out.println("Opcão Incorreta");
        
    }
        
    }
   
    }
    
    }
    

