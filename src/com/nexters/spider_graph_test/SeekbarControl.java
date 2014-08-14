package com.nexters.spider_graph_test;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SeekbarControl implements OnSeekBarChangeListener {

   public float nowSeekbarPercent = (float) 0.5;
   SeekBarType type;
   GraphView graph;

   public SeekbarControl(SeekBarType type, GraphView graph) {
      this.type = type;
      this.graph = graph;
   }

   @Override
   public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {
      GraphData data = graph.data;
      float nowProgress = progress/(float)bar.getMax();
      nowSeekbarPercent = nowProgress;
      switch (type) {
      case CNT:
    	  graph.setPeopleCntColor(nowProgress);
         data.setCnt(nowProgress);
         break;
      case AGE:
    	  graph.setAgeColor(nowProgress);
         data.setAge(nowProgress);
         break;
      case GENDER:
    	 //graph.setGraphColor(nowProgress);
    	  graph.setGenderColor(nowProgress);
         data.setGender(nowProgress);
         break;
      case STUDY:
         data.setStudy(nowProgress);
   	  graph.setStudyColor(nowProgress);
         break;
      case FOREIGNER:
         data.setForigner(nowProgress);
         break;
      default:
         break;

      }

      // �윜諛몄굡占쎌굥�뜝�럥�뒆占쎈ご�뜝占� �뜝�럥堉꾢뜝�럥六� �윜諛몄굡占쎌졎繞벿우삕�뜝�럥堉�.
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