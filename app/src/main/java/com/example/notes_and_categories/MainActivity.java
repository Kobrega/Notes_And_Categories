package com.example.notes_and_categories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NotesController controller;
    private NotesAdapter adapter;
    private Spinner spinnerFilter;
    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new NotesController(this);


        etSearch = findViewById(R.id.etSearch);
        spinnerFilter = findViewById(R.id.spinnerFilterCategory);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewNotes);

        adapter = new NotesAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Botón Buscar
        findViewById(R.id.btnSearch).setOnClickListener(v -> {
            String query = etSearch.getText().toString();
            List<Note> results = controller.getNotes(query);
            adapter.setNotes(results);
        });

        // Botón Ir a Agregar
        findViewById(R.id.btnGoToAdd).setOnClickListener(v -> {
            startActivity(new Intent(this,
                    AddActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarSpinnerYNotas();
    }

    private void cargarSpinnerYNotas() {

        List<Category> categories = controller.getCategories();


        List<Category> filterList = new ArrayList<>(categories);
        Category allCat = new Category("Todas las Categorías");
        allCat.category_id = -1; // ID bandera
        filterList.add(0, allCat);

        ArrayAdapter<Category> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, filterList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFilter.setAdapter(spinnerAdapter);


        spinnerFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Category selected = (Category) parent.getSelectedItem();
                if (selected.category_id == -1) {

                    adapter.setNotes(controller.getNotes(""));
                } else {

                    adapter.setNotes(controller.getNotesByCategory(selected.category_id));
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}