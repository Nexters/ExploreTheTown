package com.nexters.spider_graph_test;

public class GraphData {
   
   private int width = 200;
   private int height = 200;
   
   
   GraphXY top = new GraphXY(100,100);
   GraphXY rightUp = new GraphXY(100,100);
   GraphXY rightDown = new GraphXY(100,100);
   GraphXY leftUp = new GraphXY(100,100);
   GraphXY leftDown = new GraphXY(100,100);
   
   
   public GraphData(){
      setCnt(0.5f);
      setAge(0.5f);
      setGender(0.5f);
      setStudy(0.5f);
      setForigner(0.5f);
   }
   
   public GraphXY getCnt() {
      return top;
   }

   public void setCnt(float progressPercent) {
      this.top.setX((int)(width + width*0.309016*progressPercent));
      this.top.setY((int)(height - height*0.951056*progressPercent));
   }

   public GraphXY getAge() {
      return rightUp;
   }

   public void setAge(float progressPercent) {
      this.rightUp.setX((int)(width + width*progressPercent));
      this.rightUp.setY((int)(height));
   }

   public GraphXY getGender() {
      return rightDown;
   }

   public void setGender(float progressPercent) {
      this.rightDown.setX((int)(width + width*0.309016*progressPercent));
      this.rightDown.setY((int)(height + height*0.951056*progressPercent));
   }

   public GraphXY getStudy() {
      return leftDown;
   }

   public void setStudy(float progressPercent) {
      this.leftDown.setX((int)(width - width*0.809016*progressPercent));
      this.leftDown.setY((int)(height + height*0.587785*progressPercent));
   }
   
   public GraphXY getForigner(){
      return leftUp;
   }
   
   public void setForigner(float progressPercent){

      this.leftUp.setX((int)(width - width*0.809016*progressPercent));
      this.leftUp.setY((int)(height - height*0.587785*progressPercent));
   }

}