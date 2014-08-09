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
      redColor = 0xB2;
      greenColor = 0x80;
      blueColor = 0xCC;
      alphaColor = 0xFF;
      paint.setColor(0xFFB280CC);
      paint.setStyle(Style.FILL);

      // center�룯�뜃由곤옙�넅.
      center = new Point(startX, startY);
      
   }
   private int makeColor(int inRed, int inGreen, int inBlue, int inAlpha){
	   return ((((inAlpha * 0x100) + inRed) * 0x100 + inGreen) * 0x100 + inBlue);
   }
   public void setAgeColor(float progressPercent){
	   greenColor = 0xCC - (int)((0xCC-0x33)*progressPercent);
	   paint.setColor(makeColor(redColor,greenColor,blueColor,alphaColor));
   }
   public void setGenderColor(float progressPercent){
	   redColor = 0x99 + (int)((0xCC-0x99)*progressPercent);
	   paint.setColor(makeColor(redColor,greenColor,blueColor,alphaColor));
   }
   public void setStudyColor(float progressPercent){
	   blueColor = 0xff - (int)((0xff-0x99)*progressPercent);
	   paint.setColor(makeColor(redColor,greenColor,blueColor,alphaColor));
   }
   public void setPeopleCntColor(float progressPercent){
	   alphaColor = 0x77 + (int)((0xff-0x77)*progressPercent);
	   paint.setColor(makeColor(redColor,greenColor,blueColor,alphaColor));
   }
   // 이거가 원래꺼
   public void setGraphColor(float progressPercent){
	   int alpha = 0xFF;
	   int red = 0x99 + (int)((0xCC-0x99)*progressPercent);
	   int green = 0xCC - (int)((0xCC-0x33)*progressPercent);
	   int blue = 0xff - (int)((0xff-0x99)*progressPercent);
	   int color = makeColor(red,green,blue,alpha);
	   paint.setColor(color);
	   
   }

   @Override
   protected void onDraw(Canvas canvas) {

      // 占쎌맄燁삼옙 占쎄퐬占쎌젟.
      int topX = center.x + data.getCnt().getX(); // top X
      int topY = center.y + data.getCnt().getY(); // top Y

      int rightUpX = center.x + data.getAge().getX();
      int rightUpY = center.y + data.getAge().getY();
      
      int rightDownX = center.x + data.getGender().getX();
      int rightDownY = center.y + data.getGender().getY();
      
      int leftDownX = center.x + data.getStudy().getX();
      int leftDownY = center.y + data.getStudy().getY();
      
      int leftUpX = center.x + data.getForigner().getX();
      int leftUpY = center.y + data.getForigner().getY();

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
   private int redColor;
   private int greenColor;
   private int blueColor;
   private int alphaColor;
}