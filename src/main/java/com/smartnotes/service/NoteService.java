package com.smartnotes.service;

import com.smartnotes.model.Note;
import com.smartnotes.repository.NoteRepository;
import java.util.List;
import java.util.Optional;

public class NoteService {
	
	private final NoteRepository noteRepository;

	public NoteService() {
		this.noteRepository = new NoteRepository();
	}
	
	public Note createNote(String title, String content) {
		Note note = new Note(null, title, content);
		return noteRepository.save(note);
	}
	
	public Optional<Note> getNoteById(Long id) {
		return noteRepository.findById(id);
	}
	
	public List<Note> getAllNotes() {
		return noteRepository.findAll();	
	}
	
	public boolean deleteNote(Long id) {
		if(noteRepository.existsById(id)) {
			noteRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
