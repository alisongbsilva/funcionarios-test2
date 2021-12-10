package com.hepta.funcionarios.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.hepta.funcionarios.entity.Setor;

public class SetorDAO {

    Connection con = null;
    PreparedStatement pstm = null;
    Scanner leitor = new Scanner(System.in);
    @SuppressWarnings("unused")
    private EntityManager em;
    
    public void FilmeDaoImpl(EntityManager em) {
        this.em = em;
    }
    
    // Inserir setor
    public Setor inserirSetor(Setor setor) {
        
        try {
            con = MysqldbConnect.createMySQLConnection();
            
            String query = "INSERT INTO SETOR (NOME_SETOR) VALUES (?);";
            
            pstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            pstm.setString(1, setor.getNomesetor());
            
            pstm.execute();
            ResultSet result = pstm.getGeneratedKeys();
            while(result.next()) {
              setor.setIdSetor(result.getInt(1));
            }
            
            con.close();
            pstm.close();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        
        return(setor);

    }

    //Lista de Setores
    private List<Setor> buscarSetores(String query){
        List<Setor> setores = new ArrayList<>();
        
        try {
            con = MysqldbConnect.createMySQLConnection();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                int idsetor = rs.getInt("ID_SETOR");
                String nomesetor = rs.getString("NOME_SETOR");
                setores.add(new Setor(idsetor, nomesetor));
            }
               
            con.close();
            stmt.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return(setores);
    }
    
  //Buscar setores
    public List<Setor> buscarTodosSetores() {
        String query = "SELECT S.ID_SETOR, S.NOME_SETOR FROM SETOR AS S;";
        List<Setor> result = buscarSetores(query);
        
        return(result);
    }
    
    
      //Buscar setor
        public Setor buscarSetor(Integer idsetor) {
            
            String query = "SELECT S.ID_SETOR, S.NOME_SETOR FROM SETOR AS S WHERE S.ID_SETOR = " + idsetor;

            List<Setor> result = buscarSetores(query);
            
            if(result.isEmpty()) {
                return(null);
            }
            
            return(result.get(0));
        }
    
        
     // Alterar setor
        public Setor alterarSetor(Setor setor) {
            
            try {
                Integer idsetor = setor.getIdSetor();
                
                con = MysqldbConnect.createMySQLConnection();
                
                String query = "UPDATE SETOR SET NOME_SETOR = ? WHERE ID_SETOR = ?;";
                
                pstm = con.prepareStatement(query);
                
                pstm.setString(1, setor.getNomesetor());
                pstm.setInt(2, idsetor);
                
                pstm.execute();
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                
            }
            
            return(setor);
    
        }
        
     // Remover setor
        public boolean removerSetor(Integer idsetor) {
            boolean result = true;
            
            try {
                con = MysqldbConnect.createMySQLConnection();
                
                String query = "DELETE FROM SETOR AS F WHERE F.ID_SETOR = ?;";
                
                pstm = con.prepareStatement(query);
                
                pstm.setInt(1, idsetor);
                
                result = pstm.execute();
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                
            }
            
            return(result);
    
        }

}
