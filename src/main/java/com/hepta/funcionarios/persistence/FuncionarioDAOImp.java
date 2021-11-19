package com.hepta.funcionarios.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.hepta.funcionarios.entity.Funcionario;

public class FuncionarioDAOImp {
    
    Connection con = null;
    PreparedStatement pstm = null;
    Scanner leitor = new Scanner(System.in);
    
    
    //Buscar funcionário
    public void buscarFuncionario() {
        try {
            con = MysqldbConnect.createMySQLConnection();
            
            String query = "SELECT F.NOME, S.NOME_SETOR, F.SALARIO, F.EMAIL, F.IDADE FROM FUNCIONARIO AS F JOIN SETOR AS S ON F.FK_SETOR = S.ID_SETOR;";
            
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            System.out.println("Funcionários cadastrados: ");
            
            while (rs.next()) {
                String funcionarioNome = rs.getString("F.NOME");
                String setorNome = rs.getString("S.NOME_SETOR");
                double salario = rs.getDouble("F.SALARIO");
                String email = rs.getString("F.EMAIL");
                int idade = rs.getInt("F.IDADE");
                System.out.println(funcionarioNome + ", " + setorNome + ", " + salario +
                                   ", " + email + ", " + idade);
              }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Inserir funcionário
    public void inserirFuncionario(Funcionario funcionario) {
        
        try {
            con = MysqldbConnect.createMySQLConnection();
            
            String query = "INSERT INTO FUNCIONARIO (NOME, SALARIO, EMAIL, IDADE) VALUES (?, ?, ?, ?)";
            
            pstm = con.prepareStatement(query);
            
            pstm.setString(1, funcionario.getNome());
            pstm.setDouble(2, funcionario.getSalario());
            pstm.setString(3, funcionario.getEmail());
            pstm.setInt(4, funcionario.getIdade());
            
            pstm.execute();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }

    }
    
     // Alterar funcionário
        public void alterarFuncionario(Funcionario funcionario) {
            
            try {
                con = MysqldbConnect.createMySQLConnection();
                
                Integer id = 0;
                id = funcionario.getId();
                
                String query = "UPDATE FUNCIONARIO SET NOME = ?, SALARIO = ?, EMAIL = ?, IDADE = ? WHERE ID_FUNCIONARIO = "+ id +";";
                
                pstm = con.prepareStatement(query);
                
                pstm.setString(1, funcionario.getNome());
                pstm.setDouble(2, funcionario.getSalario());
                pstm.setString(3, funcionario.getEmail());
                pstm.setInt(4, funcionario.getIdade());
                
                pstm.execute();
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                
            }
    
        }
    
        
     // Remover funcionário
        public void removerFuncionario(Funcionario funcionario) {
            
            try {
                con = MysqldbConnect.createMySQLConnection();
                
                Integer id = 0;
                id = funcionario.getId();
                
                String query = "DELETE FROM FUNCIONARIO AS F WHERE F.ID_FUNCIONARIO = "+ id +";";
                
                pstm = con.prepareStatement(query);
                
                pstm.execute();
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                
            }
    
        }
    
}
