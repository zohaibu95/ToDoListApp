/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author zohai
 */
public class Note {
    private int noteID;
    private String NOTE_SUBJECT;
    private String NOTE_DESCRIPTION;

    public int getnoteID() {
        return noteID;
    }

    public void setnoteID(int id) {
        this.noteID = id;
    }

    public String getNOTE_SUBJECT() {
        return NOTE_SUBJECT;
    }

    public void setNOTE_SUBJECT(String noteSubject) {
        this.NOTE_SUBJECT = noteSubject;
    }

    public String getNOTE_DESCRIPTION() {
        return NOTE_DESCRIPTION;
    }

    public void setNOTE_DESCRIPTION(String NOTE_DESCRIPTION) {
        this.NOTE_DESCRIPTION = NOTE_DESCRIPTION;
    }
    
}
