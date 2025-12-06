package com.example.notes_and_categories;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public  interface AppDao {
    @Insert
    void insertCategory(Category category);

    @Query("SELECT * FROM categories")
    List<Category> getAllCategories();

    // --- Notas ---
    @Insert
    void insertNote(Note note);

    @Query("SELECT * FROM notes")
    List<Note> getAllNotes();

    // Búsqueda Dinámica con LIKE
    @Query("SELECT * FROM notes WHERE note_title LIKE '%' || :searchQuery || '%' OR note_content LIKE '%' || :searchQuery || '%'")
    List<Note> searchNotes(String searchQuery);

    // Consulta Avanzada: Obtener Categorías pobladas con sus notas (Relación 1:N)
    @Transaction
    @Query("SELECT * FROM categories")
    List<CategoryWithNotes> getCategoriesWithNotes();

    // Consulta para obtener notas filtradas por categoría específica
    @Query("SELECT * FROM notes WHERE category_id = :catId")
    List<Note> getNotesByCategoryId(int catId);


}
