package com.example.spider_graph_test;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SeekbarControl implements OnSeekBarChangeListener {

	SeekBarType type;
	GraphView graph;

	public SeekbarControl(SeekBarType type, GraphView graph) {
		this.type = type;
		this.graph = graph;
	}

	@Override
	public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {
		GraphData data = graph.data;

		switch (type) {
		case TOP:
			data.setTop(progress);
			break;
		case BOTTOM:
			data.setBottom(progress);
			break;
		case LEFT:
			data.setLeft(progress);
			break;
		case RIGHT:
			data.setRight(progress);
			break;
		default:
			break;

		}

		// 그래프를 다시 그려준다.
		graph.invalidate();

	}

	@Override
	public void onStartTrackingTouch(SeekBar bar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar bar) {
		// TODO Auto-generated method stub

	}

}
