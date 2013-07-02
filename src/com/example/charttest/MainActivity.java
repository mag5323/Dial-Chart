package com.example.charttest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.chartdemo.demo.chart.WeightDialChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DialRenderer;
import org.achartengine.renderer.DialRenderer.Type;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class MainActivity extends Activity {

	private GraphicalView mChartView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		
		/*View chart = ChartFactory.getDialChartView(this, catSeries, renderer);
		setContentView(chart);*/
		
		/*try{
	        Intent achartIntent = new WeightDialChart(1500).execute(this);
	        startActivity(achartIntent);
	    }catch (Exception e){
	             
	        Log.d("oncreate",e.getMessage());
	    }*/
		
        LinearLayout layout = (LinearLayout) findViewById(R.id.graph);
        CategorySeries category = new CategorySeries("Weight indic2");
        category.add("RPM", 2500);
        DialRenderer renderer = new DialRenderer();
        renderer.setChartTitleTextSize(14);
        renderer.setLabelsTextSize(16);
        renderer.setLegendTextSize(20);
        renderer.setMargins(new int[] {20, 30, 15, 0});

        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(Color.GREEN);
        renderer.addSeriesRenderer(r);
        renderer.setVisualTypes(new DialRenderer.Type[] {Type.NEEDLE});
        renderer.setMinValue(0);
        renderer.setMaxValue(8500);

        renderer.setApplyBackgroundColor(true);
        renderer.setBackgroundColor(Color.BLACK);
        renderer.setPanEnabled(false);
        
        mChartView = ChartFactory.getDialChartView(this, category, renderer);
        layout.addView(mChartView, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        //mChartView.repaint();
        
	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
