package model;

import model.reflexion.Eliminate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andri on 11/8/2016.
 */
public class NoteBook implements DynamicNoteList {
    /**
     * the list of notes
     */
    private List<Note> notes;

    /**
     * base constructor
     */
    public NoteBook() {
        notes = new ArrayList<Note>();
    }

    public NoteBook(List<Note> notes) {
        this.notes = notes;
    }

    /**
     * this method adds the note to notebook
     * @param note the note, which will be added
     */
    public void addNote(Note note) {
        notes.add(note);
    }

    /**
     * this method deletes the note from notebook by index
     * @param index note's index
     */
    public void deleteNote(int index) {
        notes.remove(index);
    }

    @Eliminate(enabled = true)
    public List<Note> getNotes() {
        return notes;
    }

    @Eliminate(enabled = true)
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
