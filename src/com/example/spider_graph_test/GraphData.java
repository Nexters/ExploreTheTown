package com.example.spider_graph_test;

public class GraphData {
   
   final private int width = 200;
   final private int height = 200;
   
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
      this.top.setX(width);
      this.top.setY((int)(height - height*progressPercent));
   }

   public GraphXY getRightUp() {
      return rightUp;
   }

   public void setRightUp(float progressPercent) {
      this.rightUp.setX((int)(width + width*0.66*progressPercent));
      this.rightUp.setY((int)(height - height*0.75*progressPercent));
   }

   public GraphXY getRightDown() {
      return rightDown;
   }

   public void setRightDown(float progressPercent) {
      this.rightDown.setX((int)(width + width*0.83*progressPercent));
      this.rightDown.setY((int)(height + height*0.56*progressPercent));
   }

   public GraphXY getLeftDown() {
      return leftDown;
   }

   public void setLeftDown(float progressPercent) {
      this.leftDown.setX((int)(width - width*0.83*progressPercent));
      this.leftDown.setY((int)(height + height*0.56*progressPercent));
   }
   
   public GraphXY getLeftUp(){
      return leftUp;
   }
   
   public void setLeftUp(float progressPercent){

      this.leftUp.setX((int)(width - width*0.66*progressPercent));
      this.leftUp.setY((int)(height - height*0.75*progressPercent));
   }

}