package com.hepta.funcionarios.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hepta.funcionarios.dto.FuncionarioDTO;
import com.hepta.funcionarios.entity.Funcionario;

public class FuncionarioDAO {
    
    Connection con = null;
    PreparedStatement pstm = null;
    Scanner leitor = new Scanner(System.in);
    
    // Inserir funcionário
    public Funcionario inserirFuncionario(Funcionario funcionario) {
        
        try {
            con = MysqldbConnect.createMySQLConnection();
            
            String query = "INSERT INTO FUNCIONARIO (NOME, SALARIO, EMAIL, IDADE, FK_SETOR) VALUES (?, ?, ?, ?, ?)";
            
            pstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            pstm.setString(1, funcionario.getNomeFuncionario());
            pstm.setDouble(2, funcionario.getSalario());
            pstm.setString(3, funcionario.getEmail());
            pstm.setInt(4, funcionario.getIdade());
            pstm.setInt(5, funcionario.getSetorID());
            
            pstm.execute();
            ResultSet result = pstm.getGeneratedKeys();
            while(result.next()) {
                funcionario.setIdFuncionario(result.getInt(1));
            }
            
            con.close();
            pstm.close();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        
        return(funcionario);

    }
    
    //Lista de Funcionarios
    private List<Funcionario> buscarFuncionarios(String query){
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            con = MysqldbConnect.createMySQLConnection();
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                int idfuncionario = rs.getInt("ID_FUNCIONARIO");
                String nomefuncionario = rs.getString("NOME");
                Double salario = rs.getDouble("SALARIO");
                String email = rs.getString("EMAIL");
                Integer idade = rs.getInt("IDADE");
                Integer setorid = rs.getInt("FK_SETOR");
                
                funcionarios.add(new Funcionario(idfuncionario, nomefuncionario, salario, email, idade, setorid));
            }
            
            con.close();
            stmt.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return(funcionarios);
        
    }
    
    //Buscar Funcionarios
    public List<FuncionarioDTO> buscarTodosFuncionarios() {
        
        String query = "SELECT F.ID_FUNCIONARIO, F.NOME, S.NOME_SETOR FROM FUNCIONARIO AS F INNER JOIN SETOR AS S WHERE F.FK_SETOR = S.ID_SETOR;";
        List<FuncionarioDTO> funcionariosDTO = new ArrayList<>();
        
        try {
            con = MysqldbConnect.createMySQLConnection();
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                int idfuncionario = rs.getInt("ID_FUNCIONARIO");
                String nomefuncionario = rs.getString("NOME");
                String nomesetor = rs.getString("NOME_SETOR");
                
                funcionariosDTO.add(new FuncionarioDTO(idfuncionario, nomefuncionario, nomesetor));
            }
            
            con.close();
            stmt.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return(funcionariosDTO);
        
    }
    
    //Buscar funcionário
    public Funcionario buscarFuncionario(Integer idfuncionario) {
            
        String query = "SELECT F.ID_FUNCIONARIO, F.NOME, F.SALARIO, F.EMAIL, F.IDADE, F.FK_SETOR FROM FUNCIONARIO AS F WHERE F.ID_FUNCIONARIO = " + idfuncionario;
        
        List<Funcionario> result = buscarFuncionarios(query);
        
        if(result.isEmpty()) {
            return(null);
        }
        
        return(result.get(0));
    }
    
    
     // Alterar funcionário
        public Funcionario alterarFuncionario(Funcionario funcionario) {
            
            try {
                con = MysqldbConnect.createMySQLConnection();
                
                String query = "UPDATE FUNCIONARIO SET NOME = ?, SALARIO = ?, EMAIL = ?, IDADE = ?, FK_SETOR = ? WHERE ID_FUNCIONARIO = ?;";
                
                pstm = con.prepareStatement(query);
                
                pstm.setString(1, funcionario.getNomeFuncionario());
                pstm.setDouble(2, funcionario.getSalario());
                pstm.setString(3, funcionario.getEmail());
                pstm.setInt(4, funcionario.getIdade());
                pstm.setInt(5, funcionario.getSetorID());
                pstm.setInt(6, funcionario.getIdFuncionario());
                
                pstm.execute();
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                
            }
            
            return(funcionario);
    
        }
    
        
     // Remover funcionário
        public boolean removerFuncionario(Integer idfuncionario) {
            boolean result = true;
            
            try {
                con = MysqldbConnect.createMySQLConnection();
                
                String query = "DELETE FROM FUNCIONARIO AS F WHERE F.ID_FUNCIONARIO = ?";
                
                pstm = con.prepareStatement(query);
                
                pstm.setInt(1, idfuncionario);
                
                result = pstm.execute();
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                
            }
            
            return(result); 
    
        }
    
}
