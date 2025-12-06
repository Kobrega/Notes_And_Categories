package com.example.notes_and_categories;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "notes",
        foreignKeys = @ForeignKey(
                entity = Category.class,
                parentColumns = "category_id",
                childColumns = "category_id",
                onDelete = ForeignKey.CASCADE // Si borras la categoría, se borran sus notas
        )
)

public class Note {
    @PrimaryKey(autoGenerate = true)
    public int note_id;

    @ColumnInfo(name = "note_title")
    public String noteTitle;

    @ColumnInfo(name = "note_content")
    public String noteContent;

    @ColumnInfo(name = "created_at")
    public String createdAt;

    @ColumnInfo(name = "category_id")
    public int categoryId;

    public Note(String noteTitle, String noteContent, String createdAt, int categoryId) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
        this.createdAt = createdAt;
        this.categoryId = categoryId;
    }
}
