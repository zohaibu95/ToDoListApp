/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.NoteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Note;

/**
 *
 * @author zohaib
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/NoteServlet"})
public class NoteServlet extends HttpServlet {
    private static String INSERT_OR_EDIT = "/note.jsp";
    private static String LIST_USER = "/listNote.jsp";
    private NoteDAO noteDAO;
    
    public NoteServlet(){
        super();
        noteDAO = new NoteDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nextPage = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int noteID = Integer.parseInt(request.getParameter("noteID"));
            noteDAO.deleteNote(noteID);
            nextPage = LIST_USER;
            request.setAttribute("notes", noteDAO.getAllNotes());    
        }else if (action.equalsIgnoreCase("deleteAllNotes")){
            noteDAO.deleteAllNotes();
            nextPage = LIST_USER;
            request.setAttribute("notes", noteDAO.getAllNotes());    
        } else if (action.equalsIgnoreCase("edit")){
            nextPage = INSERT_OR_EDIT;
            System.out.println(request.getParameter("noteID"));
            int noteID = Integer.parseInt(request.getParameter("noteID"));
            Note note = noteDAO.getNoteByID(noteID);
            request.setAttribute("note", note);
        } else if (action.equalsIgnoreCase("listNote")){
            nextPage = LIST_USER;
            request.setAttribute("notes", noteDAO.getAllNotes());
        } else {
            nextPage = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(nextPage);
        view.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Note note = new Note();   
        note.setNOTE_SUBJECT(request.getParameter("NOTE_SUBJECT"));
        note.setNOTE_DESCRIPTION(request.getParameter("NOTE_DESCRIPTION"));
        if (request.getParameter("noteID") == null ||request.getParameter("noteID").isEmpty()  ){
            noteDAO.addNote(note);
        }else{
            note.setnoteID(Integer.parseInt(request.getParameter("noteID")));
            noteDAO.updateNote(note);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("notes", noteDAO.getAllNotes());
        view.forward(request, response);
    }

   
}
