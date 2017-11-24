package com.miguel.a02_customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listViewStudents);

        students = new ArrayList<>();
        students.add(new Student("Damian",18,"Starachowice","https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg"));
        students.add(new Student("Patryk",18,"Starachowice","https://s3.amazonaws.com/uifaces/faces/twitter/k/128.jpg"));
        students.add(new Student("Adrian",18,"Starachowice","https://s3.amazonaws.com/uifaces/faces/twitter/rem/128.jpg"));
        students.add(new Student("Kuba",18,"Starachowice","https://s3.amazonaws.com/uifaces/faces/twitter/kerem/128.jpg"));
        students.add(new Student("Tomek",18,"Starachowice","https://s3.amazonaws.com/uifaces/faces/twitter/mattsince87/128.jpg"));
        students.add(new Student("Konrad",18,"Starachowice","https://s3.amazonaws.com/uifaces/faces/twitter/ashleyford/128.jpg"));

        MyStudentAdapter adapter = new MyStudentAdapter(
                this,
                R.layout.student_item,
                students

        );

        lista.setAdapter(adapter);
    }
}
