package com.nexters.spider_graph_test;

public class GraphXY {
   public int X;
   public int Y;
   
   public GraphXY(){
	      X = 0;
	      Y = 0;
	   }
   public GraphXY(int x, int y){
      X = x;
      Y = y;
   }
   public void setX(int x){
      this.X = x;
   }
   public void setY(int y){
      this.Y = y;
   }
   public int getX(){
      return this.X;
   }
   public int getY(){
      return this.Y;
   }
}