package com.example.spider_graph_test;

public class GraphData {
   
   final private int width = 200;
   final private int height = 200;
   
   final private int startX = 150;
   final private int startY = 550;
   
   GraphXY top = new GraphXY(100,100);
   GraphXY rightUp = new GraphXY(100,100);
   GraphXY rightDown = new GraphXY(100,100);
   GraphXY leftUp = new GraphXY(100,100);
   GraphXY leftDown = new GraphXY(100,100);
   
   
   public GraphData(){
      setTop(0.5f);
      setRightUp(0.5f);
      setRightDown(0.5f);
      setLeftUp(0.5f);
      setLeftDown(0.5f);
   }
   public GraphXY getTop() {
      return top;
   }

   public void setTop(float progressPercent) {
      this.top.setX(startX + width);
      this.top.setY(startY + (int)(height - height*progressPercent));
   }

   public GraphXY getRightUp() {
      return rightUp;
   }

   public void setRightUp(float progressPercent) {
      this.rightUp.setX((int)(startX + width + width*0.95*progressPercent));
      this.rightUp.setY((int)(startY + height - height*0.30*progressPercent));
   }

   public GraphXY getRightDown() {
      return rightDown;
   }

   public void setRightDown(float progressPercent) {
      this.rightDown.setX((int)(startX + width + width*0.59*progressPercent));
      this.rightDown.setY((int)(startY + height + height*0.81*progressPercent));
   }

   public GraphXY getLeftDown() {
      return leftDown;
   }

   public void setLeftDown(float progressPercent) {
      this.leftDown.setX((int)(startX + width - width*0.59*progressPercent));
      this.leftDown.setY((int)(startY + height + height*0.81*progressPercent));
   }
   
   public GraphXY getLeftUp(){
      return leftUp;
   }
   
   public void setLeftUp(float progressPercent){

      this.leftUp.setX((int)(startX + width - width*0.95*progressPercent));
      this.leftUp.setY((int)(startY + height - height*0.30*progressPercent));
   }

}