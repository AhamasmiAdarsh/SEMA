package com.example.sema3.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.sema3.R;
import com.example.sema3.databinding.FragmentBlankBinding;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlankFragment extends Fragment {

    private FragmentBlankBinding binding;
    private List<String> xValues = Arrays.asList("Maths", "Physics", "Chemistry", "Biology");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        PieChart pieChart = binding.pieChart;

        // Prepare data entries
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(45f, "Maths"));
        entries.add(new PieEntry(72f, "Physics"));
        entries.add(new PieEntry(68f, "Chemistry"));
        entries.add(new PieEntry(50f, "Biology"));

        // Configure PieDataSet
        PieDataSet dataSet = new PieDataSet(entries, "Subjects");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextSize(12f);

        // Create PieData and set it to the chart
        PieData pieData = new PieData(dataSet);
        pieChart.setData(pieData);

        // Disable description
        Description description = pieChart.getDescription();
        description.setEnabled(false);

        // Set hole radius (for a doughnut-style pie chart)
        pieChart.setHoleRadius(30f);
        pieChart.setTransparentCircleRadius(35f);

        // Invalidate chart to update changes
        pieChart.invalidate();

        return root;
    }
}