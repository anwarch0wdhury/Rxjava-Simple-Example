package com.anwar.exampleappforrxjava.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anwar.exampleappforrxjava.R;
import com.anwar.exampleappforrxjava.model.TeststoryModel;
import com.anwar.exampleappforrxjava.adapters.TestsAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   TestViewModel testViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testViewModel = new ViewModelProvider (this).get(TestViewModel.class);
        testViewModel.getStories ();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        final TestsAdapter adapter = new TestsAdapter ();
        recyclerView.setLayoutManager(new LinearLayoutManager (this));
        recyclerView.setAdapter(adapter);
        testViewModel.postsMutableLiveData.observe(this, new Observer<List<TeststoryModel>> () {
            @Override
            public void onChanged(List<TeststoryModel> teststoryModels) {
                adapter.setList(teststoryModels);
            }
        });
    }
}