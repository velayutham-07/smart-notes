package com.smartnotes.repository;

import com.smartnotes.model.Note;
import java.util.*;

public class NoteRepository {
	
	private final Map<Long, Note> notes = new HashMap<>();
	private long nextId = 1;
	
	public Note save(Note note) {
		note.setId(nextId++);
		notes.put(note.getId(), note);
		return note;
	}
	
	public Optional<Note> findById(Long id) {
		return Optional.ofNullable(notes.get(id));
	}

	public List<Note> findAll() {
		return new ArrayList<>(notes.values());
	}
	
	public void deleteById(Long id) {
		notes.remove(id);
	}
	
	public boolean existsById(Long id) {
		return notes.containsKey(id);
	}
}
