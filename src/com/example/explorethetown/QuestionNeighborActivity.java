package com.example.explorethetown;

import com.example.spider_graph_test.GraphData;
import com.example.spider_graph_test.GraphView;
import com.example.spider_graph_test.SeekBarType;
import com.example.spider_graph_test.SeekbarControl;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.LinearLayout.LayoutParams;

public class QuestionNeighborActivity extends ActionBarActivity {

   SeekBar seek_top;
   SeekBar seek_rightUp;
   SeekBar seek_rightDown;
   SeekBar seek_leftDown;
   SeekBar seek_leftUp;
   GraphView graph;
   
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_question_house);
         
      // Hidden Action Bar
      ActionBar actionBar = getActionBar();
      actionBar.hide();
           
      drawGraph();
           
      setOnClickListener();
   }
   
   // Go to Next
   public void setOnClickListener(){
      ImageButton imgBtnNext = (ImageButton)findViewById(R.id.imgBtn_questionNeighbor_Next);
      
      imgBtnNext.setOnClickListener(new View.OnClickListener() {
         
         @Override
         public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent iIntent = new Intent(QuestionNeighborActivity.this, QuestionHouseActivity.class);
            startActivity(iIntent);
         }
      });
   }

   public void drawGraph(){
      setContentView(R.layout.activity_question_neighbor);

      ViewGroup vg = (ViewGroup) findViewById(R.id.main_layout);

      GraphData data = new GraphData();
      graph = new GraphView(getApplicationContext(), data);
      vg.addView(graph, new LayoutParams(600, 1300));

      // top
      seek_top = (SeekBar) findViewById(R.id.seek_top);
      seek_top.setMax(200);
      seek_top.setProgress(100);
      seek_top.setOnSeekBarChangeListener(new SeekbarControl(SeekBarType.TOP,
            graph));
      
      seek_rightUp = (SeekBar) findViewById(R.id.seek_rightUp);
      seek_rightUp.setMax(200);
      seek_rightUp.setProgress(100);
      seek_rightUp.setOnSeekBarChangeListener(new SeekbarControl(SeekBarType.RIGHTUP,
            graph));
      
      seek_rightDown = (SeekBar) findViewById(R.id.seek_rightDown);
      seek_rightDown.setMax(200);
      seek_rightDown.setProgress(100);
      seek_rightDown.setOnSeekBarChangeListener(new SeekbarControl(SeekBarType.RIGHTDOWN,
            graph));
      
      seek_leftDown = (SeekBar) findViewById(R.id.seek_leftDown);
      seek_leftDown.setMax(200);
      seek_leftDown.setProgress(100);
      seek_leftDown.setOnSeekBarChangeListener(new SeekbarControl(SeekBarType.LEFTDOWN,
            graph));
      
      seek_leftUp = (SeekBar) findViewById(R.id.seek_leftUp);
      seek_leftUp.setMax(200);
      seek_leftUp.setProgress(100);
      seek_leftUp.setOnSeekBarChangeListener(new SeekbarControl(SeekBarType.LEFTUP,
            graph));


   }
}