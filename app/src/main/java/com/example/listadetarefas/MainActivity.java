package com.example.listadetarefas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText task;
    ListView taskList;
    Button add;

    ArrayAdapter<String> adapter;
    ArrayList<String> taskArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setupView();
    }

    private void setupView()
    {
        task = findViewById(R.id.taskEditText);
        taskList = findViewById(R.id.tasksListView);
        add = findViewById(R.id.addButton);

        taskArr = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, R.layout.activity_main, taskArr);

        taskList.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewTask();
            }
        });

        task.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if(keyCode == KeyEvent.KEYCODE_ENTER)
                    addNewTask();
                return true;
            }
        });
    }


    protected void addNewTask() {
        taskArr.add(0,task.getText().toString());
        task.setText("");
        adapter.notifyDataSetChanged();
    }


}