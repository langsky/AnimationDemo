package hgl.ican.io.animationdemo.materialAnimator;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hgl.ican.io.animationdemo.R;

public class MaterialAnimatorActivity extends AppCompatActivity {

    List<Sample> samples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_animator);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sample_list);
        samples = new ArrayList<>();
        setupSamples();
        setupRecyclerView(recyclerView, samples);
        setupMaterialAnimator();
    }

    private void setupMaterialAnimator() {

    }

    private void setupRecyclerView(RecyclerView recyclerView, List<Sample> samples) {
        SimpleRecyclerAdapter adapter = new SimpleRecyclerAdapter(this, samples);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void setupSamples() {
        samples = Arrays.asList(
                new Sample(0xFF0000, "Transitions"),
                new Sample(0x00FF00, "Shared Elements"),
                new Sample(0x0000FF, "View animations"),
                new Sample(0xFFFF00, "Circular Reveal Animation")
        );
    }

}
