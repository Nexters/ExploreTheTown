package com.nexters.explorethetown;

import com.nexters.explorethetown.R;
import com.nexters.spider_graph_test.GraphData;
import com.nexters.spider_graph_test.GraphView;
import com.nexters.spider_graph_test.SeekBarType;
import com.nexters.spider_graph_test.SeekbarControl;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
        // ���⼭ width�� ���� ���� ����� ��µȴ�.
	   ImageView imgBgLine = (ImageView)findViewById(R.id.img_question_neighbor_linebg);
	   drawGraph(imgBgLine.getLeft(), imgBgLine.getRight(), imgBgLine.getTop(), imgBgLine.getBottom());
   }
   
   
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
      
      ImageButton helpBtn = (ImageButton)findViewById(R.id.imgBtn_question_neighbor_helpBtn);
      helpBtn.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			RelativeLayout helpLayout = (RelativeLayout)findViewById(R.id.layout_quetion_neighbor_help);
			helpLayout.setVisibility(View.VISIBLE);
		}
	});
      
      ImageButton helpCloseBtn = (ImageButton)findViewById(R.id.imgBtn_question_neighbor_help_close);
      helpCloseBtn.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			RelativeLayout helpLayout = (RelativeLayout)findViewById(R.id.layout_quetion_neighbor_help);
			helpLayout.setVisibility(View.INVISIBLE);
		}
	});
   }

   public void drawGraph(int left, int right, int top, int bottom){


      RelativeLayout vg = (RelativeLayout) findViewById(R.id.main_layout);
      
      
      GraphData data = new GraphData();
      graph = new GraphView(getApplicationContext(), data, 0 , 0 );
      vg.addView(graph, new LayoutParams(800, 700));
      // top
      seek_top = (SeekBar) findViewById(R.id.seek_question_neighbor_peopleCnt);
      seek_top.setMax(200);
      seek_top.setProgress(100);
      seek_top.setOnSeekBarChangeListener(new SeekbarControl(SeekBarType.CNT,
            graph));
      
      seek_rightUp = (SeekBar) findViewById(R.id.seek_question_neighbor_age);
      seek_rightUp.setMax(200);
      seek_rightUp.setProgress(100);
      seek_rightUp.setOnSeekBarChangeListener(new SeekbarControl(SeekBarType.AGE,
            graph));
      
      seek_rightDown = (SeekBar) findViewById(R.id.seek_question_neighbor_gender);
      seek_rightDown.setMax(200);
      seek_rightDown.setProgress(100);
      seek_rightDown.setOnSeekBarChangeListener(new SeekbarControl(SeekBarType.GENDER,
            graph));
      
      seek_leftDown = (SeekBar) findViewById(R.id.seek_question_neighbor_foreigner);
      seek_leftDown.setMax(200);
      seek_leftDown.setProgress(100);
      seek_leftDown.setOnSeekBarChangeListener(new SeekbarControl(SeekBarType.FOREIGNER,
            graph));
      
      seek_leftUp = (SeekBar) findViewById(R.id.seek_question_neighbor_study);
      seek_leftUp.setMax(200);
      seek_leftUp.setProgress(100);
      seek_leftUp.setOnSeekBarChangeListener(new SeekbarControl(SeekBarType.STUDY,
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
   