/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Note;
import utility.ConnectionUtility;

/**
 *
 * @author zohai
 */
public class NoteDAO {
    private Connection connection;
    
    public NoteDAO(){
        connection = ConnectionUtility.getConnection();
    }
    
    public boolean addNote(Note note){
        try {
            String sqlQuery = "INSERT INTO \"DEMO\".\"TODO_LIST\" (NOTE_SUBJECT, NOTE_DESCRIPTION) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            if (!note.getNOTE_SUBJECT().isEmpty() && !note.getNOTE_DESCRIPTION().isEmpty()){
                 ps.setString(1, note.getNOTE_SUBJECT());
                 ps.setString(2, note.getNOTE_DESCRIPTION());
                 ps.executeUpdate();
                 return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(NoteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deleteNote(int noteID){
        try {
            String sqlQuery = "DELETE FROM \"DEMO\".\"TODO_LIST\" WHERE ID=?";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.setInt(1, noteID);
            ps.executeUpdate();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NoteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deleteAllNotes(){
        try {
            String sqlQuery = "DELETE FROM \"DEMO\".\"TODO_LIST\"";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            ps.executeUpdate();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NoteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updateNote(Note note){
        try {
            String sqlQuery = "UPDATE \"DEMO\".\"TODO_LIST\" SET NOTE_SUBJECT=?, NOTE_DESCRIPTION=? WHERE ID=?";
            PreparedStatement ps = connection.prepareStatement(sqlQuery);
            if (!note.getNOTE_SUBJECT().isEmpty() && !note.getNOTE_DESCRIPTION().isEmpty()){
                 ps.setString(1, note.getNOTE_SUBJECT());
                 ps.setString(2, note.getNOTE_DESCRIPTION());
                 ps.setInt(3, note.getnoteID());
                 ps.executeUpdate();
                 return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(NoteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ArrayList<Note> getAllNotes(){
        ArrayList<Note> notes = new ArrayList<Note>();
        String query = "SELECT * FROM \"DEMO\".\"TODO_LIST\"";
        //String query = "SELECT * FROM TODO_LIST";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Note note = new Note();
                note.setnoteID(rs.getInt("ID"));
                note.setNOTE_SUBJECT(rs.getString("NOTE_SUBJECT"));
                note.setNOTE_DESCRIPTION(rs.getString("NOTE_DESCRIPTION"));
                notes.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notes;
    }

    public Note getNoteByID(int noteID){
        Note note = new Note();
        String query = "SELECT * FROM \"DEMO\".\"TODO_LIST\" WHERE ID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, noteID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                note.setnoteID(rs.getInt("ID"));
                note.setNOTE_SUBJECT(rs.getString("NOTE_SUBJECT"));
                note.setNOTE_DESCRIPTION(rs.getString("NOTE_DESCRIPTION"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return note;
    }
}
