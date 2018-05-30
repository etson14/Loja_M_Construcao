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
import static loja_m_construcao.Loja_M_Construcao.menuPrincipal;

/**
 *
 * @author Jair
 */
public class Utilizador {
    public String idUtilizador;
    public String nome;
    public String senha;
    public String tipo;
    
    public String utilizadorFile, op;
    public Scanner ler = new Scanner(System.in);
    
    
    public Utilizador() throws IOException{
        this.utilizadorFile = new File("src\\loja_m_construcao\\files\\utilizador.txt").getCanonicalPath();
    }
    
    public void menu() throws IOException{
        System.out.println("\tMenu Utilizadores");
        System.out.println("1 -> Listar utilizadores");
        System.out.println("2 -> Adicionar Utilizador");
        System.out.println("3 -> Pesquisar Utilizadores");
        System.out.println("0 -> Voltar");
        System.out.print("\nEscolha uma opção: ");
        op = ler.nextLine();
        
        switch(op){
            case "1":{
                listar();
                subMenuListar();
                break;
            }
            case "2":{
                adicionar();
                subMenuAddUtil();
                break;
            }
            case "3":{
                pesquisar();
                break;
            }
            case "0":{
                menuPrincipal();
                break;
            }
        }
    }
    
    
    public Utilizador adicionar() throws IOException{
        Utilizador utilizador = new Utilizador();
        List<Utilizador> utilizadorList = lerFicheiro();
        
        System.out.println("Entre com o codigo");
        utilizador.idUtilizador = ler.nextLine();
        
        System.out.println("Entre com o nome");
        utilizador.nome = ler.nextLine();
        
        System.out.println("Entre com a senha (6-12 caracteres)");
        utilizador.senha = ler.nextLine();
        while(!utilizador.senha.matches("[0-9|A-Z|a-z]{6,12}")){
            System.err.println("Senha Invalida");
            System.out.println("Entre com o nova senha (6-12 caracter");
            utilizador.senha = ler.nextLine();
        }
        
        System.out.println("Escolha o tipo de utilizador");
        System.out.println("1 -> Administrador");
        System.out.println("2 -> Vendedor");
        System.out.print("Escolha uma opção: ");
        op = ler.nextLine();
        switch (op) {
            case "1":
                utilizador.tipo = "Administrador";
                break;
            case "2":
                utilizador.tipo = "Vendedor";
                break;
            default:
                System.out.println("Erro!!!");
                utilizador.tipo = "Vendedor";
                break;
        }
        
        utilizadorList.add(utilizador);
        salvarFicheiro(utilizadorList);
        
        return utilizador;
    }
    
    private void listar() throws IOException {
        List<Utilizador> utilizadorList = lerFicheiro();
        System.out.println("Codigo  |Nome      |Senha     |Tipo");
        utilizadorList.forEach(u -> System.out.println(u.idUtilizador +"        "+ u.nome +"      "+ u.senha +"     "+ u.tipo));
    }
    
    private void editar() throws IOException {
        List<Utilizador> utilizadorList = lerFicheiro();
        final String editaUtil;
        
        System.out.print("Escola o codigo do utilizador que quer editar: ");
        editaUtil = ler.nextLine();
        
        
        for(Utilizador u : utilizadorList){
            if(u.idUtilizador.equals(editaUtil)){
                utilizadorList.remove(u);
                Utilizador utilizador = adicionar();
                utilizadorList.add(utilizador);
                salvarFicheiro(utilizadorList);
                listar();
                subMenuListar();
            }
        }
    }

    

    private void eliminar() throws IOException {
        List<Utilizador> utilizadorList = lerFicheiro();
        final String editaUtil;
        
        System.out.print("Escola o codigo do utilizador que quer editar: ");
        editaUtil = ler.nextLine();
        
        
        for(Utilizador u : utilizadorList){
            if(u.idUtilizador.equals(editaUtil)){
                utilizadorList.remove(u);
                System.out.println("Eliminado com sucesso\n");
                salvarFicheiro(utilizadorList);
                listar();
                subMenuListar();
            }
        } 
        
    }
    
    public void pesquisar() throws IOException{
        List<Utilizador> utilizadorList = lerFicheiro(); 
        String nomePesquisa;
        
        System.out.print("Entre com o nome: ");
        nomePesquisa = ler.nextLine();
        
        System.out.println("Codigo  |Nome        |Senha   |Tipo");
        utilizadorList.forEach(u -> {
             if(u.nome.contains(nomePesquisa)){
                 System.out.println(u.idUtilizador +"       "+ u.nome +"    "+ u.senha  +"    "+ u.tipo);
             }             
        });  
        
        System.out.println("\n0 -> Voltar");
        System.out.print("Escolha uma opção: ");
        op = ler.nextLine();
        switch(op){
            case "0":{
                menu();
                break;
            }
            default:{
                menuPrincipal();
            }
        }
    }
    
    
    public void salvarFicheiro(List<Utilizador> utilizador) throws IOException{
        FileWriter utilFileWriter = new FileWriter(utilizadorFile);
        BufferedWriter utilBuffWriter = new BufferedWriter(utilFileWriter);
        
        for(Utilizador m : utilizador){
            utilBuffWriter.write(m.idUtilizador + ";");
            utilBuffWriter.write(m.nome + ";");
            utilBuffWriter.write(m.senha + ";");
            utilBuffWriter.write(m.tipo + "\n");       
        }
        utilBuffWriter.close();
    }
    
    public List<Utilizador> lerFicheiro() throws FileNotFoundException, IOException{
        List<Utilizador> listUtilizador = new ArrayList<>();
        FileReader utilFileReader = new FileReader(utilizadorFile);
        BufferedReader utilBuffReader = new BufferedReader(utilFileReader);  
        String valores;
        
        while((valores = utilBuffReader.readLine()) != null){
            Utilizador utilizador = new Utilizador();
            String[] atributos = valores.split(";");
            
            utilizador.idUtilizador = atributos[0];
            utilizador.nome = atributos[1];
            utilizador.senha = atributos[2];
            utilizador.tipo = atributos[3];
            
            listUtilizador.add(utilizador);
        }
        return listUtilizador;        
    }
    
    public void subMenuListar() throws IOException{
        System.out.println("\n\n1 -> Editar");
        System.out.println("2 -> Eliminar");
        System.out.println("0 -> Voltar");
        System.out.print("\nEscolha uma opção: ");
        String op1;
        op1 = ler.nextLine();
        switch(op1){
            case "1":{
                editar();
                listar();
                subMenuListar();
                break;
            }
            case "2":{
                eliminar();
                listar();
                subMenuListar();
                break;
            }
            case "0":{
                menu();
                break;
            }
            default:{
                System.out.println("Escolha uma opção valida");
                listar();
                subMenuListar();
            }
        }
    }
    
    public void subMenuAddUtil() throws IOException{
        System.out.println("\n1 -> Adicionar novo");
        System.out.println("0 -> Voltar");
        System.out.print("Escolha uma opção: ");
        op = ler.nextLine();
        
        switch(op){
            case "1":{
                adicionar();
                subMenuAddUtil();
                break;
            }
            case "0":{
                menu();
                break;
            }
            default:{
                System.out.println("Erro!!");
                subMenuAddUtil();
            }
        }
    }

    
}
