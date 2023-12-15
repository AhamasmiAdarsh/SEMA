package com.example.sema3.Fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.sema3.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        LineChart lineChart = rootView.findViewById(R.id.lineChart);
        setupLineChart(lineChart);

        return rootView;
    }

    private void setupLineChart(LineChart lineChart) {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 4));
        entries.add(new Entry(1, 8));
        entries.add(new Entry(2, 6));
        entries.add(new Entry(3, 12));
        entries.add(new Entry(4, 10));

        LineDataSet dataSet = new LineDataSet(entries, "Sample Data");
        dataSet.setDrawFilled(true);
        dataSet.setColor(Color.WHITE);
        dataSet.setFillColor(Color.parseColor("#FF7200"));
        dataSet.setFillAlpha(100);
        dataSet.setDrawCircles(false);

        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);

        lineChart.getDescription().setEnabled(false);
        lineChart.getLegend().setEnabled(false);

        // Customizing X-axis and Y-axis if needed
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter());

        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setTextColor(Color.WHITE);

        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);

        lineChart.invalidate();
    }
}
