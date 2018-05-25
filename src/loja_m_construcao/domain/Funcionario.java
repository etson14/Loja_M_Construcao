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
import javax.swing.JOptionPane;
import static loja_m_construcao.Loja_M_Construcao.menuPrincipal;

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
        System.out.println("3 -> Editar Funcionarios");
        System.out.println("4 -> Eliminar Funcionarios");
        System.out.println("5 -> Pesquisar Funcionarios");
        System.out.println("0 -> Voltar");
        
        System.out.println("Escolha uma opção: ");
        op = ler.nextLine(); 
        
        switch(op){
            case "1": {
                listar();
                break;
            }
            case "2": {
                adicionar();
                break;
            }
            case "3": {
                
                break;
            }
            case "4": {
                
                break;
            }
            case "5": {
                
                break;
            }
            case "0":{
                menuPrincipal();
                break;
            }
            default:{
                System.out.println("Erro!!!");
                menu();
            }
        }
        
    }
    
    public void listar() throws IOException{
        List<Funcionario> funcionarios = lerFicheiro();
        System.out.println("Nome Completo   |Data Nascimento  |NIF        |BI        |Naturalidade   "
                 + "|Email           |Telefone    |Nome pai     |Nome mãe   |Rua      |Numero      |Bairro    |Cidade    "
                + "|Caixa Postal   |Ilha      |Salario     |Comissão   |Estado    |Nome Utilizador   |Senha");
        funcionarios.forEach(u -> System.out.println( u.nome 
                +"     "+ u.dataNascimento +"       "+ u.NIF +"      "+ u.BI +"         "+ u.Naturalidade 
                +"          "+ u.Email +"     "+ u.Telefone +"         "+ u.nomePai +"               "+ u.nomeMae 
                +"      "+ u.endereco.rua +"     "+ u.endereco.numero +"     "+ u.endereco.bairro +"      "+ u.endereco.cidade 
                +"      "+ u.endereco.caixaPostal +"    "+ u.endereco.ilha +"       "+ u.salario +"      "+ u.comissao
                +"     "+ u.estado  +"      "+ u.nomeUtilizador  +"            "+ u.senha  
        ));
        
        System.out.println("\n\n1 - Voltar");
        System.out.println("2 - Editar um funcionario");
        System.out.println("3 - Eliminar um funcionario");
        String op1;
        op1 = ler.nextLine();
        switch(op1){
            case "1":{
                menu();
                break;
            }
            case "2":{
                break;
            }
            default:{
                System.out.println("Escolha uma opção valida");
            }
        }
    }
    
    public List<Funcionario> eliminar() throws IOException{
        List<Funcionario> funcionarios = lerFicheiro();
        String elimina;
        System.out.println("Escolha um BI");
        elimina = ler.nextLine();
        
        for(Funcionario f : funcionarios){
            if(f.BI.equals(elimina)){
                funcionarios.remove(f);
            }else{
                System.out.println("BI funcionario não encontrado");
            }
        }
        return funcionarios;        
    }
    
    public Funcionario adicionar() throws IOException{
        Funcionario funcionario = new Funcionario();
        Endereco endereco = new Endereco();
        
        System.out.println("\t Adicionar Funcionario");
                

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
            JOptionPane.showMessageDialog(null,"erro");
            System.out.println("Entre com o NIF novamente");
            funcionario.NIF = ler.nextLine();
        }
        
        System.out.println("Entre com o BI");
        funcionario.BI = ler.nextLine();
        if(!funcionario.BI.matches("[0-9]{9}")){
            //while(!funcionario.BI.matches("[0-9]{9}")){
                System.out.println("Entre com o NIF novamente");
                funcionario.BI = ler.nextLine();
            //}
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
        funcionario.endereco = endereco;
        
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
        
        salvarFicheiro(funcionario);

        System.out.println("\n\n1 - Voltar");
        System.out.println("2 - Adicionar um funcionario");
        String op1;
        op1 = ler.nextLine();
        switch(op1){
            case "1":{
                menu();
                break;
            }
            case "2":{
                adicionar();
                break;
            }
            default:{
                System.out.println("Escolha uma opção valida");
            }
        }
        
        return funcionario;
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
           
           funcionario.endereco = endereco1;
           
           funcionarioList.add(funcionario);
        }

        return funcionarioList;
    }

    
    public void salvarFicheiro(Funcionario funcionario) throws IOException{
        FileWriter funFileWriter = new FileWriter(funcionarioFile, true);
        BufferedWriter funBuffWriter = new BufferedWriter(funFileWriter);
        
        funBuffWriter.write(funcionario.nome + ";");
        funBuffWriter.write(funcionario.dataNascimento + ";");
        funBuffWriter.write(funcionario.NIF + ";");
        funBuffWriter.write(funcionario.BI + ";");
        funBuffWriter.write(funcionario.Naturalidade + ";");         
        funBuffWriter.write(funcionario.Email + ";");         
        funBuffWriter.write(funcionario.Telefone + ";");
        funBuffWriter.write(funcionario.nomePai + ";");
        funBuffWriter.write(funcionario.nomeMae + ";");
        funBuffWriter.write(funcionario.endereco.rua + ";");
        funBuffWriter.write(funcionario.endereco.numero + ";");
        funBuffWriter.write(funcionario.endereco.bairro + ";");
        funBuffWriter.write(funcionario.endereco.cidade + ";");
        funBuffWriter.write(funcionario.endereco.caixaPostal + ";");
        funBuffWriter.write(funcionario.endereco.ilha + ";");
        funBuffWriter.write(funcionario.salario + ";");
        funBuffWriter.write(funcionario.comissao + ";");
        funBuffWriter.write(funcionario.estado + ";");
        funBuffWriter.write(funcionario.nomeUtilizador + ";");
        funBuffWriter.write(funcionario.senha + "\n");
        
        funBuffWriter.close();
    }
}
