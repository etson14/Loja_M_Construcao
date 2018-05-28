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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import javax.swing.JOptionPane;
import static loja_m_construcao.Loja_M_Construcao.menuPrincipal;

/**
 *
 * @author Edson Tavares
 */
public class Funcionario extends Pessoa {       
   
    public String idFuncionario;
    public float salario;
    public float comissao;
    public boolean estado;
    public String nomeUtilizador;
    public String senha;
    public int serieCarteira;
    
    public int  ano, mes, dia;
    String op;
    String funcionarioFile;
    Scanner ler = new Scanner(System.in);

    public Funcionario() throws IOException {
        this.funcionarioFile = new File("src\\loja_m_construcao\\files\\funcionario.txt").getCanonicalPath();
    }


    public void menu() throws IOException{
        
        System.out.println("\t Menu Funcionarios");
        System.out.println("1 -> Listar Funcionarios");
        System.out.println("2 -> Adicionar Funcionarios");
        System.out.println("3 -> Pesquisar Funcionarios");
        System.out.println("0 -> Voltar");
        
        System.out.print("Escolha uma opção: ");
        op = ler.nextLine(); 
        
        switch(op){
            case "1": {
                listar();
                break;
            }
            case "2": {
                adicionar();
                subMuneAdicionar();
                break;
            }
            case "3": {
                pesquisar();
                subMenuEditarRemover();
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
        List<Funcionario> funcionarios = lerFicheiro();
        System.out.println("Codigo |Nome Completo   |Data Nascimento  |NIF        |BI        |Naturalidade   "
                 + "|Email           |Telefone    |Nome pai     |Nome mãe   |Rua      |Numero      |Bairro    |Cidade    "
                + "|Caixa Postal   |Ilha      |Salario     |Comissão   |Estado    |Nome Utilizador   |Senha");
        funcionarios.forEach(u -> System.out.println( u.idFuncionario +"       "+u.nome 
                +"     "+ u.dataNascimento +"       "+ u.NIF +"      "+ u.BI +"         "+ u.Naturalidade 
                +"          "+ u.Email +"     "+ u.Telefone +"         "+ u.nomePai +"               "+ u.nomeMae 
                +"      "+ u.endereco.rua +"     "+ u.endereco.numero +"     "+ u.endereco.bairro +"      "+ u.endereco.cidade 
                +"      "+ u.endereco.caixaPostal +"    "+ u.endereco.ilha +"       "+ u.salario +"      "+ u.comissao
                +"     "+ u.estado  +"      "+ u.nomeUtilizador  +"            "+ u.senha  
        ));
                
        System.out.println("\n\n1 -> Editar um funcionario");
        System.out.println("2 -> Eliminar um funcionario");
        System.out.println("0 -> Voltar");
        System.out.print("\nEscolha uma opção: ");
        String op1;
        op1 = ler.nextLine();
        switch(op1){
            case "1":{
                editar();
                subMenuEditarRemover();
                break;
            }
            case "2":{
                eliminar();
                subMenuEditarRemover();
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
    
    public Funcionario adicionar() throws IOException{
        List<Funcionario> funcionarioList = lerFicheiro();
        Funcionario funcionario = new Funcionario();
        Endereco endereco1 = new Endereco();
        
        System.out.println("\t Adicionar Funcionario");
          
        System.out.println("Entre com o codigo");
        funcionario.idFuncionario = ler.nextLine();

        System.out.println("Entre com o nome completo");
        funcionario.nome = ler.nextLine();
        
        System.out.println("\t Data Nascimento:");
        System.out.println("Entre com o dia: ");
        this.dia = ler.nextInt();

        System.out.println("Entre com o mes: ");
        this.mes = ler.nextInt();

        System.out.println("Entre com o ano: ");
        this.ano = ler.nextInt();
        funcionario.dataNascimento = LocalDate.of(ano, mes, dia);
        
        ler.nextLine();
        System.out.println("Entre com o NIF");
        funcionario.NIF = ler.nextLine();
        while(!funcionario.NIF.matches("[0-9]{9}")){
            //JOptionPane.showMessageDialog(null,"erro");
            System.out.println("Entre com o NIF novamente");
            funcionario.NIF = ler.nextLine();
        }
        
        System.out.println("Entre com o BI");
        funcionario.BI = ler.nextLine();        
        while(!funcionario.BI.matches("[0-9]{6}")){
            System.out.println("Entre com o BIF novamente");
            funcionario.BI = ler.nextLine();
        }
        
        
        System.out.println("Entre com a naturalidade");
        funcionario.Naturalidade = ler.nextLine();
        
        System.out.println("Entre com o email");
        funcionario.Email = ler.nextLine();
        
        System.out.println("Entre com o telefone");
        funcionario.Telefone = ler.nextLine();
        
        System.out.println("Entre com o nome do pai");
        funcionario.nomePai = ler.nextLine();
        
        System.out.println("Entre com o nome da mãe");
        funcionario.nomeMae = ler.nextLine();
        
        System.out.println("Entre com a rua: ");
        endereco1.rua = ler.nextLine();        
        
        System.out.println("Entre com o numero: ");
        endereco1.numero = ler.nextLine(); 
        
        System.out.println("Entre com a bairro: ");
        endereco1.bairro = ler.nextLine();        
        
        System.out.println("Entre com a cidade: ");
        endereco1.cidade = ler.nextLine();        
        
        System.out.println("Entre com a caixa postal: ");
        endereco1.caixaPostal = ler.nextLine();        
        
        System.out.println("Entre com a ilha: ");
        endereco1.ilha = ler.nextLine();
        funcionario.endereco = endereco1;
        
        System.out.println("Entre com o salario");
        funcionario.salario = ler.nextFloat();
        
        System.out.println("Entre com a comissão");
        funcionario.comissao = ler.nextFloat();
        
        ler.nextLine();
        System.out.println("Registar o nome do utilizador");
        funcionario.nomeUtilizador = ler.nextLine(); 
        
        System.out.println("Entre com palavra passe (6-12 caracteres)");
        funcionario.senha = ler.nextLine();
        while(funcionario.senha.length() <= 6 || funcionario.senha.length() >= 12){
            System.err.println("Senha invalida");
            System.out.println("Entre com palavra passe novamente (6-12 caracteres)");
            funcionario.senha = ler.nextLine();
        }
        
        funcionario.estado = true;
        
        funcionarioList.add(funcionario);
        salvarFicheiros(funcionarioList);
        
        return funcionario;
    }
    
    
    public void editar() throws IOException{
        List<Funcionario> funcionarios = lerFicheiro();
        
        String edita;
        System.out.print("Escolha o codigo do funcionario que quer editar: ");
        edita = ler.nextLine();
        
        for(Funcionario f : funcionarios){
            if(f.idFuncionario.equals(edita)){
                funcionarios.remove(f);
            }
        }        
        
        Funcionario funEditado = adicionar();
        System.out.println("Editado com sucesso");
        funcionarios.add(funEditado);
        salvarFicheiros(funcionarios);
    }
    
     public void eliminar() throws IOException{
        List<Funcionario> funcionarios = lerFicheiro();
        String elimina;
        System.out.print("Escolha o codigo do funcionario: ");
        elimina = ler.nextLine();
        
        for(Funcionario f : funcionarios){
            if(f.idFuncionario.equals(elimina)){
                funcionarios.remove(f);
                System.out.println("Eliminado com sucesso");
            }
        }
       // funcionarios.forEach(u -> System.out.println(u.nome));
        salvarFicheiros(funcionarios);
                
    }
     
    public void pesquisar() throws IOException{
        List<Funcionario> funcionarios = lerFicheiro();
        String nomePesquisa;
        System.out.println("Escolha um nome");
        nomePesquisa = ler.nextLine();
        
        for(Funcionario f : funcionarios){
            if(f.nome.contains(nomePesquisa)){
                System.out.println(f.idFuncionario + " " +f.nome +"  "+ f.nomeUtilizador);
            }
        }      

    }
     
    public void subMuneAdicionar() throws IOException{
        System.out.println("\n\n1 -> Adicionar um novo funcionario");
        System.out.println("0 -> Voltar");
        System.out.print("\nEscolha uma opção: ");
        String op1;
        op1 = ler.nextLine();
        switch(op1){
            case "0":{
                menu();
                break;
            }
            case "1":{
                adicionar();
                break;
            }
            default:{
                System.out.println("Escolha uma opção valida");
                menu();
            }
        }
    }
    
    public void subMenuEditarRemover() throws IOException{
        System.out.println("\n\n1 -> Listar");
        System.out.println("0 -> Voltar");
        System.out.print("\nEscolha uma opção: ");
        String op1;
        op1 = ler.nextLine();
        switch(op1){
            case "0":{
                menu();
                break;
            }
            case "1":{
                listar();
                break;
            }
            default:{
                System.out.println("Escolha uma opção valida");
                menu();
            }
        }
        
    }
    
    public List<Funcionario> lerFicheiro() throws FileNotFoundException, IOException{
        ArrayList<Funcionario> funcionarioList = new ArrayList<>();
        FileReader funcFileReader = new FileReader(funcionarioFile);
        BufferedReader funcBuffReader = new BufferedReader(funcFileReader);  
        String valores;
        
        while((valores = funcBuffReader.readLine()) != null){
            Funcionario funcionario = new Funcionario();
            Endereco endereco1 = new Endereco();
            String[] atributos = valores.split(";");
            
            /**** String em data ****/
            String datas = atributos[1];
            String[] datasDados = datas.split("-");
            int ano1 = Integer.parseInt(datasDados[0]), mes1 = Integer.parseInt(datasDados[1]), dia1 = Integer.parseInt(datasDados[2]);
            LocalDate dataNasc;
            dataNasc = LocalDate.of(ano1, mes1, dia1);
            /***************/
            
           funcionario.nome = atributos[0];
           funcionario.dataNascimento = dataNasc;
           funcionario.NIF = atributos[2];
           funcionario.BI = atributos[3];
           funcionario.Naturalidade = atributos[4];
           funcionario.Email = atributos[5];
           funcionario.Telefone = atributos[6];    
           funcionario.nomePai = atributos[7];
           funcionario.nomeMae = atributos[8];
           endereco1.rua = atributos[9];
           endereco1.numero = atributos[10];
           endereco1.bairro = atributos[11];
           endereco1.cidade = atributos[12];
           endereco1.caixaPostal = atributos[13];
           endereco1.ilha = atributos[14];           
           funcionario.salario = valueOf(atributos[15]);
           funcionario.comissao = valueOf(atributos[16]);
           funcionario.estado = Boolean.parseBoolean(atributos[17]);
           funcionario.nomeUtilizador = atributos[18];  
           funcionario.senha = atributos[19];
           funcionario.idFuncionario = atributos[20];
           
           funcionario.endereco = endereco1;
           
           funcionarioList.add(funcionario);
        }

        return funcionarioList;
    }    
    
    public void salvarFicheiros(List<Funcionario> funcionario) throws IOException{
        FileWriter funFileWriter = new FileWriter(funcionarioFile);
        BufferedWriter funBuffWriter = new BufferedWriter(funFileWriter);
        
        for(Funcionario f : funcionario){
            funBuffWriter.write(f.nome + ";");
            funBuffWriter.write(f.dataNascimento + ";");
            funBuffWriter.write(f.NIF + ";");
            funBuffWriter.write(f.BI + ";");
            funBuffWriter.write(f.Naturalidade + ";");         
            funBuffWriter.write(f.Email + ";");         
            funBuffWriter.write(f.Telefone + ";");
            funBuffWriter.write(f.nomePai + ";");
            funBuffWriter.write(f.nomeMae + ";");
            funBuffWriter.write(f.endereco.rua + ";");
            funBuffWriter.write(f.endereco.numero + ";");
            funBuffWriter.write(f.endereco.bairro + ";");
            funBuffWriter.write(f.endereco.cidade + ";");
            funBuffWriter.write(f.endereco.caixaPostal + ";");
            funBuffWriter.write(f.endereco.ilha + ";");
            funBuffWriter.write(f.salario + ";");
            funBuffWriter.write(f.comissao + ";");
            funBuffWriter.write(f.estado + ";");
            funBuffWriter.write(f.nomeUtilizador + ";");
            funBuffWriter.write(f.senha + ";");
            funBuffWriter.write(f.idFuncionario + "\n");
        }
        funBuffWriter.close();
    }
     
}
