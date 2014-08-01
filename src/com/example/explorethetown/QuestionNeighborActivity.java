package com.example.explorethetown;

import com.example.spider_graph_test.GraphData;
import com.example.spider_graph_test.GraphView;
import com.example.spider_graph_test.SeekBarType;
import com.example.spider_graph_test.SeekbarControl;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.LinearLayout.LayoutParams;

public class QuestionNeighborActivity extends ActionBarActivity {

	SeekBar seek_top;
	SeekBar seek_bottom;
	SeekBar seek_left;
	SeekBar seek_right;
	GraphView graph;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question_house);
			
		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
	        
		drawGraph();
	        	        
	}

	public void drawGraph(){
		setContentView(R.layout.activity_question_neighbor);

		ViewGroup vg = (ViewGroup) findViewById(R.id.main_layout);

		GraphData data = new GraphData();
		graph = new GraphView(getApplicationContext(), data);
		vg.addView(graph, new LayoutParams(400, 400));

		// top
		seek_top = (SeekBar) findViewById(R.id.seek_top);
		seek_top.setMax(200);
		seek_top.setProgress(data.getTop());
		seek_top.setOnSeekBarChangeListener(new SeekbarControl(SeekBarType.TOP,
				graph));

		// bottom
		seek_bottom = (SeekBar) findViewById(R.id.seek_bottom);
		seek_bottom.setMax(200);
		seek_bottom.setProgress(data.getBottom());
		seek_bottom.setOnSeekBarChangeListener(new SeekbarControl(
				SeekBarType.BOTTOM, graph));

		// left
		seek_left = (SeekBar) findViewById(R.id.seek_left);
		seek_left.setMax(200);
		seek_left.setProgress(data.getLeft());
		seek_left.setOnSeekBarChangeListener(new SeekbarControl(
				SeekBarType.LEFT, graph));

		// right
		seek_right = (SeekBar) findViewById(R.id.seek_right);
		seek_right.setMax(200);
		seek_right.setProgress(data.getRight());
		seek_right.setOnSeekBarChangeListener(new SeekbarControl(
				SeekBarType.RIGHT, graph));
	}
}
