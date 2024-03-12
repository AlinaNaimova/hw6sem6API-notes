package ru.geegbrain.hw6sem6API.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geegbrain.hw6sem6API.model.Note;
import ru.geegbrain.hw6sem6API.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

/**
 * Класс контроллера для работы с заметками.
 */
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    // Добавление новой заметки
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        Note savedNote = noteRepository.save(note);
        return ResponseEntity.ok(savedNote);
    }

    // Получение всех заметок
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteRepository.findAll();
        return ResponseEntity.ok(notes);
    }

    // Получение заметки по ID
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            return ResponseEntity.ok(optionalNote.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Обновление заметки
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note updatedNote) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            updatedNote.setId(id);
            Note savedNote = noteRepository.save(updatedNote);
            return ResponseEntity.ok(savedNote);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Удаление заметки
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            noteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}