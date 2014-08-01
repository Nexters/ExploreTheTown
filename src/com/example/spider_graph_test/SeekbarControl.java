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
         data.setTop(progress/(float)bar.getMax());
         break;
      case RIGHTUP:
         data.setRightUp(progress/(float)bar.getMax());
         break;
      case RIGHTDOWN:
         data.setRightDown(progress/(float)bar.getMax());
         break;
      case LEFTDOWN:
         data.setLeftDown(progress/(float)bar.getMax());
         break;
      case LEFTUP:
         data.setLeftUp(progress/(float)bar.getMax());
         break;
      default:
         break;

      }

      // 洹몃옒�봽瑜� �떎�떆 洹몃젮以��떎.
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