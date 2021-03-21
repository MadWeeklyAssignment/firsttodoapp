package com.example.android_todo_first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TodoActivity extends AppCompatActivity {

    private static final String TODO_INDEX = "todoIndex";
    private String[] mTodos;
    private int mTodoIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // set the user interface layout for this Activity
        setContentView(R.layout.activity_todo);

        /* check for saved state due to changes such as rotation
            and restore any saved state such as the TODO_INDEX */
        if (savedInstanceState != null) {
            mTodoIndex = savedInstanceState.getInt(TODO_INDEX, 0);
        }

        // initialize member TextView so we can manipulate it later
        final TextView TodoTextView;
        TodoTextView = (TextView) findViewById(R.id.textViewTodo);

        // read the todoArray from res/values/strings.xml
        Resources res = getResources();
        mTodos = res.getStringArray(R.array.todos);

        // display the first task from mTodo array in the TodoTextView
        TodoTextView.setText(mTodos[mTodoIndex]);

        Button buttonNext;
        buttonNext = (Button) findViewById(R.id.buttonNext);

        // OnClick listener for the  Next button
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTodoIndex = (mTodoIndex + 1) % mTodos.length;
                TodoTextView.setText(mTodos[mTodoIndex]);
            }
        });

        Button buttonPrev = findViewById(R.id.buttonPrev);

        // OnClick listener for the  Previous button
        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTodoIndex = --mTodoIndex;
                if (mTodoIndex < 0) {
                    mTodoIndex = mTodos.length - 1;
                }
                TodoTextView.setText(mTodos[mTodoIndex]);
            }
        });

    }

   
}