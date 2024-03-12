package ru.geegbrain.hw6sem6API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geegbrain.hw6sem6API.model.Note;

import java.util.Optional;
/**
 * Интерфейс репозитория для работы с заметками.
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
}
