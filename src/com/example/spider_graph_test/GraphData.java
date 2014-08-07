package com.example.spider_graph_test;

public class GraphData {
   
   private int width = 200;
   private int height = 200;
   
   
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
      this.top.setX((int)(width + width*0.309016*progressPercent));
      this.top.setY((int)(height - height*0.951056*progressPercent));
   }

   public GraphXY getRightUp() {
      return rightUp;
   }

   public void setRightUp(float progressPercent) {
      this.rightUp.setX((int)(width + width*progressPercent));
      this.rightUp.setY((int)(height));
   }

   public GraphXY getRightDown() {
      return rightDown;
   }

   public void setRightDown(float progressPercent) {
      this.rightDown.setX((int)(width + width*0.309016*progressPercent));
      this.rightDown.setY((int)(height + height*0.951056*progressPercent));
   }

   public GraphXY getLeftDown() {
      return leftDown;
   }

   public void setLeftDown(float progressPercent) {
      this.leftDown.setX((int)(width - width*0.809016*progressPercent));
      this.leftDown.setY((int)(height + height*0.587785*progressPercent));
   }
   
   public GraphXY getLeftUp(){
      return leftUp;
   }
   
   public void setLeftUp(float progressPercent){

      this.leftUp.setX((int)(width - width*0.809016*progressPercent));
      this.leftUp.setY((int)(height - height*0.587785*progressPercent));
   }

}