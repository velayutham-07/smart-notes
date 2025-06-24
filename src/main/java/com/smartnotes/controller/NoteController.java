package com.smartnotes.controller;

import com.smartnotes.model.Note;
import com.smartnotes.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
	
	private final NoteService noteService;
	
	@Autowired
	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@PostMapping
	public Note createNote(@RequestBody Note note) {
		return noteService.createNote(note.getTitle(), note.getContent());
	}
	
	@GetMapping("/{id}")
	public Optional<Note> getNoteById(@PathVariable Long id) {
		return noteService.getNoteById(id);
	}
	
	@GetMapping
	public List<Note> getAllNotes() {
		return noteService.getAllNotes();
	}
	
	@DeleteMapping("/{id}")
	public String deleteNote(@PathVariable Long id) {
		Boolean deleted = noteService.deleteNote(id);
		return deleted ? "Note Deleted." : "Note not found.";
	}
	
}
