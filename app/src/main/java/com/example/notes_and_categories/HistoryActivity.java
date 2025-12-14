package com.example.notes_and_categories;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryActivity extends AppCompatActivity {
    private NotesController controller;
    private HistoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        controller = new NotesController(this);
        RecyclerView rv = findViewById(R.id.rvHistory);
        Spinner spinner = findViewById(R.id.spinnerFilterAction);

        adapter = new HistoryAdapter();
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);

        // Configurar Filtro
        String[] options = {"TODOS", "INSERT_NOTE", "INSERT_CATEGORY"};
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, options));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> p, View v, int pos, long id) {
                String selected = options[pos];
                adapter.setLogs(controller.getLogsByAction(selected));
            }
            @Override
            public void onNothingSelected(AdapterView<?> p) {}
        });
    }
}
