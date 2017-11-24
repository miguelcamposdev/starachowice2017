package com.miguel.a01_simplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    // 1. Create a ListView variable
    ListView lista;

    // 3. Create a List of students (only names)
    List<String> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. connect the ListView variable with
        // the view component
        lista = findViewById(R.id.listViewStudents);

        // 4. Create the list of students
        students = new ArrayList<>();
        students.add("Damian");
        students.add("Patryk");
        students.add("Adrian");
        students.add("Kuba");
        students.add("Tomek");
        students.add("Konrad");
        students.add("Norbert");
        students.add("Gracjan");
        students.add("Martyna");
        students.add("Weronika");
        students.add("Mark");
        students.add("Wojtek I");
        students.add("Wiktor");
        students.add("Wojtek II");
        students.add("Daniel");
        students.add("Janek");

        // 5. Adapter
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                students
        );

        // 6. lista <--> adapter
        lista.setAdapter(adapter);

        // 7. Item click events
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String studentName = students.get(position);
        Toast.makeText(this, "Name: "+studentName, Toast.LENGTH_SHORT).show();

        view.animate().rotationX(360).setDuration(1000).start();
    }
}
