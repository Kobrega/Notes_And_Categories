package com.example.notes_and_categories;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddActivity extends AppCompatActivity {
    private NotesController controller;
    private Spinner spinnerCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        controller = new NotesController(this);
        spinnerCategories = findViewById(R.id.spinnerSelectCategory);

        cargarCategorias();

        // Agregar Categoría
        Button btnAddCat = findViewById(R.id.btnAddCategory);
        EditText etCatName = findViewById(R.id.etNewCatName);
        btnAddCat.setOnClickListener(v -> {
            String name = etCatName.getText().toString();
            if (!name.isEmpty()) {
                controller.addCategory(name);
                Toast.makeText(this, "Categoría agregada", Toast.LENGTH_SHORT).show();
                etCatName.setText("");
                cargarCategorias(); // Recargar spinner
            }
        });

        // Agregar Nota
        Button btnAddNote = findViewById(R.id.btnAddNote);
        EditText etTitle = findViewById(R.id.etNoteTitle);
        EditText etContent = findViewById(R.id.etNoteContent);

        btnAddNote.setOnClickListener(v -> {
            Category selectedCat = (Category) spinnerCategories.getSelectedItem();
            if (selectedCat == null) {
                Toast.makeText(this, "Crea una categoría primero", Toast.LENGTH_SHORT).show();
                return;
            }

            String title = etTitle.getText().toString();
            String content = etContent.getText().toString();

            if (!title.isEmpty() && !content.isEmpty()) {
                controller.addNote(title, content, selectedCat.category_id);
                Toast.makeText(this, "Nota guardada", Toast.LENGTH_SHORT).show();
                finish(); // Volver a la pantalla principal
            }
        });
    }

    private void cargarCategorias() {
        List<Category> categories = controller.getCategories();
        ArrayAdapter<Category> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategories.setAdapter(adapter);
    }
}
