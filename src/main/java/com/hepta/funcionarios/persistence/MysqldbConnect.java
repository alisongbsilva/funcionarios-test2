package com.hepta.funcionarios.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;

public class MysqldbConnect {
    
    public static Connection createMySQLConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection newConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/funcionarios?useTimezone=true&serverTimezone=UTC","root","Alison14");
        return newConnection;
    }

    public static void main(String[]args) throws Exception {
        
        Scanner leitor = new Scanner(System.in);

        Connection con = createMySQLConnection();

        if (con != null) {
            
            //Teste de conexão
            System.out.println("Conexão realizada com sucesso!");
            
            //Cria novo objeto funcionario
            //Funcionario funcionario = new Funcionario();
            
            //Teste Inserir funcionário
            /*System.out.println("Adicionar novo funcionário: ");
            System.out.println("Nome: ");
            funcionario.setNome(leitor.next());
            System.out.println("Salario: ");
            funcionario.setSalario(leitor.nextDouble());
            System.out.println("Email: ");
            funcionario.setEmail(leitor.next());
            System.out.println("Idade: ");
            funcionario.setIdade(leitor.nextInt());*/
            
            //Teste Alterar funcionário
            /*System.out.println("Alterar funcionário: ");
            System.out.println("ID do funcionário: ");
            funcionario.setId(leitor.nextInt());
            
            System.out.println("Novos dados: ");
            System.out.println("Nome: ");
            funcionario.setNome(leitor.next());
            System.out.println("Salario: ");
            funcionario.setSalario(leitor.nextDouble());
            System.out.println("Email: ");
            funcionario.setEmail(leitor.next());
            System.out.println("Idade: ");
            funcionario.setIdade(leitor.nextInt());*/
            
            //Teste Remover funcionário
            /*System.out.println("Remover funcionário: ");
            System.out.println("ID do funcionário: ");
            funcionario.setId(leitor.nextInt());*/
            
            //nova instância de objetos
            //FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            SetorDAO setorDAO = new SetorDAO();
            
            //funcões Setor 
            Setor setor = new Setor();
            ArrayList<setor> resultado = null;
            resultado = (ArrayList<setor>)setorDAO.buscarSetor();
            
            //Funcões Funcionario
            //funcionarioDAO.inserirFuncionario(funcionario);
            //funcionarioDAO.alterarFuncionario(funcionario);
            //funcionarioDAO.removerFuncionario(funcionario);
            //funcionarioDAO.buscarFuncionario();
            
            
            
            leitor.close();
            con.close();
        }

    }

}
