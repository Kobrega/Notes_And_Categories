package com.example.notes_and_categories;

import android.content.Context;

import java.util.List;

public class NotesController {
    private AppDao dao;

    public NotesController(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        this.dao = db.appDao();
    }

    //  Categorías
    public void addCategory(String name) {
        dao.insertCategory(new Category(name));
    }

    public List<Category> getCategories() {
        return dao.getAllCategories();
    }

    // Notas
    public void addNote(String title, String content, int catId) {
        // Usamos una fecha simple como String
        String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(new java.util.Date());
        dao.insertNote(new Note(title, content, date, catId));
    }

    public List<Note> getNotes(String searchQuery) {
        if (searchQuery == null || searchQuery.isEmpty()) {
            return dao.getAllNotes();
        } else {
            return dao.searchNotes(searchQuery);
        }
    }

    // Método para notas y categorias
    public List<Note> getNotesByCategory(int catId) {
        return dao.getNotesByCategoryId(catId);
    }
}
