package com.example.datastructurefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText bookTitle, bookAuthor, bookGenre, bookYear;
    private Button addButton, clearButton;
    private ListView bookListView;
    private ArrayList<String> bookList;
    private ArrayAdapter<String> bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        bookTitle = findViewById(R.id.editBookTitle);
        bookAuthor = findViewById(R.id.editBookAuthor);
        bookGenre = findViewById(R.id.editBookGenre);
        bookYear = findViewById(R.id.editBookYear);
        addButton = findViewById(R.id.addButton);
        clearButton = findViewById(R.id.clearButton);
        bookListView = findViewById(R.id.bookListView);

        // Initialize book list and adapter
        bookList = new ArrayList<>();
        bookAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookList);
        bookListView.setAdapter(bookAdapter);

        // Add book functionality
        addButton.setOnClickListener(v -> addBook());

        // Clear all books functionality
        clearButton.setOnClickListener(v -> clearBooks());
    }

    private void addBook() {
        String title = bookTitle.getText().toString().trim();
        String author = bookAuthor.getText().toString().trim();
        String genre = bookGenre.getText().toString().trim();
        String year = bookYear.getText().toString().trim();

        if (title.isEmpty() || author.isEmpty() || genre.isEmpty() || year.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            String bookDetails = title + " by " + author + " | " + genre + " | " + year;
            bookList.add(bookDetails);
            bookAdapter.notifyDataSetChanged();
            clearInputFields();
            Toast.makeText(this, "Book added", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearBooks() {
        bookList.clear();
        bookAdapter.notifyDataSetChanged();
        Toast.makeText(this, "All books cleared", Toast.LENGTH_SHORT).show();
    }

    private void clearInputFields() {
        bookTitle.setText("");
        bookAuthor.setText("");
        bookGenre.setText("");
        bookYear.setText("");
    }
}