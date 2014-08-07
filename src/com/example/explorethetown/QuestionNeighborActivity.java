package com.example.explorethetown;

import com.example.spider_graph_test.GraphData;
import com.example.spider_graph_test.GraphView;
import com.example.spider_graph_test.SeekBarType;
import com.example.spider_graph_test.SeekbarControl;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
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
      setContentView(R.layout.activity_question_neighbor);
//      layoutSetting();
      
      // Hidden Action Bar
      ActionBar actionBar = getActionBar();
      actionBar.hide();
           
     // drawGraph();
           
      setOnClickListener();
   
   
   }
   @Override
   public void onWindowFocusChanged(boolean hasFocus) {
	   super.onWindowFocusChanged(hasFocus);
        // TODO Auto-generated method stub
        // 여기서 width를 찍어보면 값이 제대로 출력된다.
	   ImageView imgBgLine = (ImageView)findViewById(R.id.img_question_neighbor_linebg);
	   drawGraph(imgBgLine.getLeft(), imgBgLine.getRight(), imgBgLine.getTop(), imgBgLine.getBottom());
   }
   
   // Go to Next
   public void setOnClickListener(){
      Button imgBtnNext = (Button)findViewById(R.id.imgBtn_questionNeighbor_Next);
      
      imgBtnNext.setOnClickListener(new View.OnClickListener() {
         
         @Override
         public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent iIntent = new Intent(QuestionNeighborActivity.this, QuestionHouseActivity.class);
            startActivity(iIntent);
         }
      });
   }

   public void drawGraph(int left, int right, int top, int bottom){
      setContentView(R.layout.activity_question_neighbor);

      ViewGroup vg = (ViewGroup) findViewById(R.id.main_layout);
      
      
      GraphData data = new GraphData();
      graph = new GraphView(getApplicationContext(), data, left+50 , top+30 );
      vg.addView(graph, new LayoutParams(1000, 1300));
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
   
   
   private void layoutSetting(){
	   
	   DisplayMetrics metrics = new DisplayMetrics();
	   getWindowManager().getDefaultDisplay().getMetrics(metrics);
	   int screenWidth = metrics.widthPixels;
	   int screenHeight = metrics.heightPixels;
	   
	   
	   ImageView imgView;
	   
	   imgView = (ImageView)findViewById(R.id.img_question_neighbor_topbg);
	   imgView.getLayoutParams().height=  (int) (screenHeight * 0.101041);
	   imgView.setScaleType(ScaleType.FIT_XY);
	   
	   imgView = (ImageView)findViewById(R.id.img_question_neighbor_navi);
	   imgView.getLayoutParams().height = (int) (screenHeight*0.101041);
	   imgView.getLayoutParams().width = (int) (screenWidth * 0.101041);
	   imgView.setScaleType(ScaleType.FIT_XY);
	   
	   imgView = (ImageView)findViewById(R.id.img_question_neighbor_title);
	   imgView.getLayoutParams().height = (int) (screenHeight*0.02708);
	   imgView.getLayoutParams().width = (int) (screenWidth * 0.203703);
	   imgView.setPadding((int) (screenWidth*0.01667), 0, 0, 0);
	   imgView.setScaleType(ScaleType.FIT_XY);
	   

	   
	   
	   
	   
	   
	   
	   
	   
	   
   }
   
}
   