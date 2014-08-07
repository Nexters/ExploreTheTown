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

   public GraphView(Context context, GraphData data, int startX, int startY) {
      super(context);
      this.data = data;
      // paint 占쎄퐬占쎌젟
      paint.setColor(Color.BLUE);
      paint.setStyle(Style.FILL);

      // center�룯�뜃由곤옙�넅.
      center = new Point(startX, startY);
      
   }

   @Override
   protected void onDraw(Canvas canvas) {

      // 占쎌맄燁삼옙 占쎄퐬占쎌젟.
      int topX = center.x + data.getTop().getX(); // top X
      int topY = center.y + data.getTop().getY(); // top Y

      int rightUpX = center.x + data.getRightUp().getX();
      int rightUpY = center.y + data.getRightUp().getY();
      
      int rightDownX = center.x + data.getRightDown().getX();
      int rightDownY = center.y + data.getRightDown().getY();
      
      int leftDownX = center.x + data.getLeftDown().getX();
      int leftDownY = center.y + data.getLeftDown().getY();
      
      int leftUpX = center.x + data.getLeftUp().getX();
      int leftUpY = center.y + data.getLeftUp().getY();

      // 域밸챶�봺疫뀐옙
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