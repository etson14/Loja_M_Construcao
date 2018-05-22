/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja_m_construcao.domain;

import java.time.LocalDate;



public abstract class Pessoa {
    
    public int idPessoa;
    public String nome;
    public LocalDate dataNascimento;
    public String NIF;
    public String BI;
    public String Telefone;
    public String Email;
    public String Naturalidade;
    public String nomePai;
    public String nomeMae;
    public Endereco endereco;
    
    
}
