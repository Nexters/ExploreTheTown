package com.example.spider_graph_test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.view.View;

public class GraphView extends View {

	GraphData data;
	Point center;

	Paint paint = new Paint();
	Path path = new Path();

	public GraphView(Context context) {
		super(context);
	}

	public GraphView(Context context, GraphData data) {
		super(context);
		this.data = data;

		// paint 설정
		paint.setColor(Color.BLUE);
		paint.setStyle(Style.FILL);

		// center초기화.
		center = new Point(200, 200);
	}

	@Override
	protected void onDraw(Canvas canvas) {

		// 위치 설정.
		int topX = center.x; // top X
		int topY = center.y - data.getTop(); // top Y

		int rightX = center.x + data.getRight(); // right X
		int rightY = center.y; // right Y

		int bottomX = center.x; // bottom X
		int bottomY = center.y + data.getBottom(); // bottom Y

		int leftX = center.x - data.getLeft(); // left X
		int leftY = center.y; // left Y

		// 그리기
		path.reset(); // only needed when reusing this path for a new build
		path.moveTo(topX, topY); // used for first point
		path.lineTo(rightX, rightY);
		path.lineTo(bottomX, bottomY);
		path.lineTo(leftX, leftY);
		// path.lineTo(x[0], y[0]); // there is a setLastPoint action but i
		// found it not to work as expected

		canvas.drawPath(path, paint);

	}
}
