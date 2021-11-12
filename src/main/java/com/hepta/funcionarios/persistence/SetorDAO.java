package com.hepta.funcionarios.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hepta.funcionarios.entity.Setor;

public class SetorDAO {

    Connection con = null;
    PreparedStatement pstm = null;
    Scanner leitor = new Scanner(System.in);
    
  //Buscar setor
    public List<Setor> buscarSetor() {
        List<Setor> listaSetor = new ArrayList<Setor>();
        Setor setor = new Setor();
        
        try {
            con = MysqldbConnect.createMySQLConnection();
            
            String query = "SELECT S.ID_SETOR, S.NOME_SETOR FROM SETOR AS S;";
            
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Setor setor1 = new Setor();
                setor1.setIdSetor(rs.getInt("S.ID_SETOR"));
                setor1.setNomeSetor(rs.getString("S.NOME_SETOR"));
                setor1.add(listaSetor);
                
                //System.out.println(setor);
                //System.out.println(setor.getIdSetor());
                //System.out.println(setor.getNomeSetor());
              }
               
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //System.out.println(listaSetor);
        
        return(listaSetor);
    }
    
     // Inserir setor
        public void inserirSetor(Setor setor) {
            
            try {
                con = MysqldbConnect.createMySQLConnection();
                
                String query = "INSERT INTO SETOR (NOME) VALUES (?);";
                
                pstm = con.prepareStatement(query);
                
                pstm.setString(1, setor.getNomeSetor());
                
                pstm.execute();
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                
            }
    
        }
        
     // Alterar setor
        public void alterarSetor(Setor setor) {
            
            try {
                con = MysqldbConnect.createMySQLConnection();
                
                Integer id = 0;
                id = setor.getIdSetor();
                
                String query = "UPDATE SETOR SET NOME_SETOR = ? WHERE ID_SETOR = "+ id +";";
                
                pstm = con.prepareStatement(query);
                
                pstm.setString(1, setor.getNomeSetor());
                
                pstm.execute();
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                
            }
    
        }
        
     // Remover setor
        public void removerSetor(Setor setor) {
            
            try {
                con = MysqldbConnect.createMySQLConnection();
                
                Integer id = 0;
                id = setor.getIdSetor();
                
                String query = "DELETE FROM SETOR AS F WHERE F.ID_SETOR = "+ id +";";
                
                pstm = con.prepareStatement(query);
                
                pstm.execute();
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                
            }
    
        }
    
}
