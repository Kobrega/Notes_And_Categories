package com.example.notes_and_categories;

import android.content.Context;

import java.util.List;

public class NotesController {
    private AppDao dao;
    private HistoryDao historyDao;


    public NotesController(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        this.dao = db.appDao();
        this.historyDao = db.historyDao();
    }

    private String getCurrentTimestamp() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }

    //  Categorías
    public void addCategory(String name) {
        dao.insertCategory(new Category(name));

        historyDao.insertHistory(new History("INSERT_CATEGORY", getCurrentTimestamp(), "Categoría creada: " + name));
    }

    public List<Category> getCategories() {
        return dao.getAllCategories();
    }

    // Notas
    public void addNote(String title, String content, int catId) {
        String date = getCurrentTimestamp();
        dao.insertNote(new Note(title, content, date, catId));

        historyDao.insertHistory(new History("INSERT_NOTE", date, "Nota creada: " + title));
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


    public List<History> getAllLogs() { return historyDao.getAllHistory(); }

    public List<History> getLogsByAction(String action) {
        if (action.equals("TODOS")) return historyDao.getAllHistory();
        return historyDao.getHistoryByAction(action);
    }

}
