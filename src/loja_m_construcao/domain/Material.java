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
import java.util.Scanner;
import static loja_m_construcao.Loja_M_Construcao.menuPrincipal;


public class Material {
    
    public String idMaterial;
    public String nome;
   // public String descricao;
    public String marca;
   // public String modelo;
   // public String cor;
  //  public LocalDate dataFabricacao;
   // public String unidadeMedida;
    public float preco;
    public int quantidade;
    
    String op;
    String materialFile;
    Scanner ler = new Scanner(System.in);

    public Material() throws IOException {
        this.materialFile = new File("src\\loja_m_construcao\\files\\material.txt").getCanonicalPath();
    }
    
    
    public void menu() throws IOException{
        
        System.out.println("\t Menu Material");
        System.out.println("1 -> Listar materias");
        System.out.println("2 -> Adicionar material");
        System.out.println("3 -> Adicionar quantidade de um material");
        System.out.println("4 -> Pesquisar material");
        System.out.println("0 -> Voltar");
        
        System.out.print("Escolha uma opção: ");
        op = ler.nextLine(); 
        
        switch(op){
            case "1": {
                listar();
                subMenuListar();
                break;
            }
            case "2": {
                addcionar();
                subMenuAddMat();
                break;
            }
            case "3": {
                listar();
                editarQuantidade();
                menu();
                break;
            }
            case "4": {
                pesquisar();
                break;
            }
            case "0":{
                menuPrincipal();
                break;
            }
            default:{
                System.out.println("Escolha uma opção Valida!!!");
                menu();
            }
        }        
    }
    
    public void listar() throws IOException{
        List<Material> listMaterial = lerFicheiro();
        System.out.println("Codigo  |Nome        |Preço   |Quantidade   |Marca");
        listMaterial.forEach(u -> System.out.println(u.idMaterial +"      "+ u.nome +"    "+ u.preco  +"    "+ u.quantidade +"  "+u.marca));
    }
    
    public Material addcionar() throws IOException{
        Material material = new Material();
        List<Material> listMaterial = lerFicheiro();
        
        System.out.println("Entre com o codigo");
        material.idMaterial = ler.nextLine();

        System.out.println("Entre com o nome do matrial");
        material.nome = ler.nextLine();
        
        
        System.out.println("Entre com o preço");
        material.preco = ler.nextFloat();

        System.out.println("Entre com a quantidade");
        material.quantidade = ler.nextInt();

        ler.nextLine();
        System.out.println("Entre com o marca ");
        material.marca = ler.nextLine();
        
        listMaterial.add(material);
        
        salvarFicheiro(listMaterial);
        
        return material;        
    }
    
    public void editar() throws IOException{
        List<Material> listMaterial = lerFicheiro();        
        String edita;
        
        System.out.print("Escolha o codigo do material que quer editar: ");
        edita = ler.nextLine();
        
        for(Material m : listMaterial){
            if(m.idMaterial.equals(edita)){
                listMaterial.remove(m);
            }            
        }
        
        Material material = addcionar();
        System.out.println("Editado com sucesso");
        listMaterial.add(material);
        salvarFicheiro(listMaterial);
    }
    
    public void editarQuantidade() throws IOException{
        List<Material> listMaterial = lerFicheiro();        
        final String edita;
        final int soma;
        
        System.out.print("Escolha o codigo do material que quer adicionar: ");
        edita = ler.nextLine();
        System.out.print("Insire a quantidade que quer acrescentar: ");            
        soma = ler.nextInt();
        
        listMaterial.forEach(u -> {
             if(u.idMaterial.equals(edita)){
                 u.quantidade += soma;
             }
        });
        
        salvarFicheiro(listMaterial);

    }
    
    public void pesquisar() throws IOException{
        List<Material> listMaterial = lerFicheiro();  
        String nomePesquisa;
        
        System.out.print("Entre com o nome: ");
        nomePesquisa = ler.nextLine();
        
        System.out.println("Codigo  |Nome        |Preço   |Quantidade   |Marca");
        listMaterial.forEach(u -> {
             if(u.nome.contains(nomePesquisa)){
                 System.out.println(u.idMaterial +"       "+ u.nome +"    "+ u.preco  +"    "+ u.quantidade +"  "+u.marca );
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
   /* public void eliminar() throws IOException{
        List<Material> listMaterial = lerFicheiro();        
        String edita;
        
        System.out.print("Escolha o codigo do material que quer remover: ");
        edita = ler.nextLine();
        
        for(Material m : listMaterial){
            if(m.idMaterial.equals(edita)){
                listMaterial.remove(m);
                System.out.println("Eliminado com sucesso");
            }
        }        
    }*/
    
    
    public void subMenuListar() throws IOException{
        System.out.println("\n\n1 -> Editar");
        System.out.println("0 -> Voltar");
        System.out.print("\nEscolha uma opção: ");
        String op1;
        op1 = ler.nextLine();
        switch(op1){
            case "1":{
                editar();
                break;
            }
            case "0":{
                menu();
                break;
            }
            default:{
                System.out.println("Escolha uma opção valida");
                listar();
            }
        }
    }
    
    public void subMenuAddMat() throws IOException{
        System.out.println("\n1 -> Adicionar novo");
        System.out.println("0 -> Voltar");
        System.out.print("\nEscolha uma opção: ");
        op = ler.nextLine();
        
        switch(op){
            case "1":{
                break;
            }
            case "0":{
                menu();
                break;
            }
            default:{
                System.out.println("Erro!!");
                menuPrincipal();
            }
        }
    }
    
    public void salvarFicheiro(List<Material> material) throws IOException{
        FileWriter matFileWriter = new FileWriter(materialFile);
        BufferedWriter matBuffWriter = new BufferedWriter(matFileWriter);
        
        for(Material m : material){
            matBuffWriter.write(m.idMaterial + ";");
            matBuffWriter.write(m.nome + ";");
            matBuffWriter.write(m.preco + ";");
            matBuffWriter.write(m.quantidade + ";");
            matBuffWriter.write(m.marca + "\n");            
        }
        matBuffWriter.close();
    }
    
    public List<Material> lerFicheiro() throws FileNotFoundException, IOException{
        List<Material> listMaterial = new ArrayList<>();
        FileReader matFileReader = new FileReader(materialFile);
        BufferedReader matBuffReader = new BufferedReader(matFileReader);  
        String valores;
        
        while((valores = matBuffReader.readLine()) != null){
            Material material = new Material();
            String[] atributos = valores.split(";");
            
            material.idMaterial = atributos[0];
            material.nome = atributos[1];
            material.preco = valueOf(atributos[2]);
            material.quantidade = Integer.parseInt(atributos[3]);
            material.marca = atributos[4];
            
            listMaterial.add(material);
        }
        return listMaterial;        
    }
     
    
}
