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
    
    public int op, ano, mes, dia;  
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
        System.out.println("0 -> Sair");
        System.out.println("Escolha uma opção: ");
        op = ler.nextInt();
        
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
    
    public void listar() throws IOException{
        List<Funcionario> funcionarios = lerFicheiro();
        
        funcionarios.forEach(u -> System.out.println( u.nomeUtilizador));
        
        System.out.println("\n\n1 - Voltar");
        System.out.println("2 - Editar um funcionario");
        int op;
        op = ler.nextInt();
        switch(op){
            case 1:{
                menuPrincipal();
                break;
            }
            case 2:{
                break;
            }
            default:{
                System.out.println("Escolha uma opção valida");
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
            Endereco endereco = new Endereco();
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
           endereco.rua = atributos[9];
           endereco.numero = atributos[10];
           endereco.bairro = atributos[11];
           endereco.cidade = atributos[12];
           endereco.caixaPostal = atributos[13];
           endereco.ilha = atributos[14];           
           funcionario.salario = valueOf(atributos[15]);
           funcionario.comissao = valueOf(atributos[16]);
           funcionario.estado = Boolean.parseBoolean(atributos[17]);
           funcionario.nomeUtilizador = atributos[18];  
           funcionario.senha = atributos[19];
           
           funcionario.endereco = endereco;
           
           funcionarioList.add(funcionario);
        }

        return funcionarioList;
    }

    public Funcionario adicionar() throws IOException{
        
        Funcionario funcionario = new Funcionario();
        Endereco endereco = new Endereco();
        
        System.out.println("\t Adicionar Funcionario");
        
        //System.out.println("Entre com o codigo");
       // funcionario.idFuncionario = ler.nextInt();
        
        //ler.nextLine();
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
//        if(!NIF.matches("[0-9]")){
//            System.out.println("Entre com o NIF novamente");
//            this.NIF = ler.nextLine();
//        }
        
        System.out.println("Entre com o BI");
        funcionario.BI = ler.nextLine();
        
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
        
        funcionario.estado = true;
        salvarFicheiro(funcionario);
        
        return funcionario;
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
