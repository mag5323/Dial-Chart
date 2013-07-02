/**
 * Copyright (C) 2009 - 2013 SC 4ViewSoft SRL
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.achartengine.chartdemo.demo.chart;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DialRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.DialRenderer.Type;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

/**
 * Budget demo pie chart.
 */
public class WeightDialChart extends AbstractDemoChart {

  public static double rpm; 
  
  public WeightDialChart(double rpm){
	 rpm = this.rpm;
  }
  /**
   * Returns the chart name.
   * @return the chart name
   */
  public String getName() {
    return "Weight chart";
  }
  
  /**
   * Returns the chart description.
   * @return the chart description
   */
  public String getDesc() {
    return "The weight indicator (dial chart)";
  }
  
  /**
   * Executes the chart demo.
   * @param context the context
   * @return the built intent
   */
  public Intent execute(Context context) {
    CategorySeries category = new CategorySeries("Weight indic");
    category.add("RPM", rpm);
    DialRenderer renderer = new DialRenderer();
    renderer.setChartTitleTextSize(20);
    renderer.setLabelsTextSize(15);
    renderer.setLegendTextSize(15);
    renderer.setMargins(new int[] {20, 30, 15, 0});
    renderer.setBackgroundColor(Color.BLACK);
    renderer.setApplyBackgroundColor(true);
    SimpleSeriesRenderer r = new SimpleSeriesRenderer();
    r.setColor(Color.GREEN);
    renderer.addSeriesRenderer(r);
    renderer.setShowLabels(true);
    renderer.setVisualTypes(new DialRenderer.Type[] {Type.NEEDLE, Type.NEEDLE, Type.NEEDLE});
    renderer.setMinValue(0);
    renderer.setMaxValue(8500);
    return ChartFactory.getDialChartIntent(context, category, renderer, "Weight indicator");
  }

}
