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

      // paint �꽕�젙
      paint.setColor(Color.BLUE);
      paint.setStyle(Style.FILL);

      // center珥덇린�솕.
      center = new Point(300, 900);
   }

   @Override
   protected void onDraw(Canvas canvas) {

      // �쐞移� �꽕�젙.
      int topX = data.getTop().getX(); // top X
      int topY = data.getTop().getY(); // top Y

      int rightUpX = data.getRightUp().getX();
      int rightUpY = data.getRightUp().getY();
      
      int rightDownX = data.getRightDown().getX();
      int rightDownY = data.getRightDown().getY();
      
      int leftDownX = data.getLeftDown().getX();
      int leftDownY = data.getLeftDown().getY();
      
      int leftUpX = data.getLeftUp().getX();
      int leftUpY = data.getLeftUp().getY();

      // 洹몃━湲�
      path.reset(); // only needed when reusing this path for a new build
      path.moveTo(topX, topY); // used for first point
      path.lineTo(rightUpX, rightUpY);
      path.lineTo(rightDownX, rightDownY);
      path.lineTo(leftDownX, leftDownY);
      path.lineTo(leftUpX, leftUpY);
      path.lineTo(topX, topY);
      // path.lineTo(x[0], y[0]); // there is a setLastPoint action but i
      // found it not to work as expected

      canvas.drawPath(path, paint);

   }
}