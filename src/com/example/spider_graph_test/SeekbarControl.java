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
      float nowProgress = progress/(float)bar.getMax();
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

      // 域밸챶�삋占쎈늄�몴占� 占쎈뼄占쎈뻻 域밸챶�젻餓ο옙占쎈뼄.
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