package com.nexters.explorethetown;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.nexters.custom.CityName;
import com.nexters.spider_graph_test.GraphData;
import com.nexters.spider_graph_test.GraphView;
import com.nexters.spider_graph_test.SeekBarType;
import com.nexters.spider_graph_test.SeekbarControl;

public class QuestionNeighborActivity extends ActionBarActivity {

   SeekBar seek_top;
   SeekBar seek_rightUp;
   SeekBar seek_rightDown;
   SeekBar seek_leftDown;
   SeekBar seek_leftUp;
   GraphView graph;
   
   public SeekbarControl seekBarCntrl_cnt;
   public SeekbarControl seekBarCntrl_age;
   public SeekbarControl seekBarCntrl_gender;
   public SeekbarControl seekBarCntrl_forienger;
   public SeekbarControl seekBarCntrl_study;
   
   String top30Cds;
   String firstCond;
   String firstNeCond;
   CityName selectCityName;
   
   boolean isFirst = true;
   
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_question_neighbor);
//      layoutSetting();
      
      Intent iIntent = getIntent();
      top30Cds = iIntent.getStringExtra("YELLOW_TOP30_CD");
      firstCond = iIntent.getStringExtra("FIRST_COND");
      firstNeCond = iIntent.getStringExtra("FIRST_NE_COND");
		selectCityName = (CityName) iIntent.getSerializableExtra("SELECT_CITY");
      // Hidden Action Bar
      ActionBar actionBar = getActionBar();
      actionBar.hide();
           
     // drawGraph();
           
      setOnClickListener();
   
		
		Toast toast = Toast.makeText(QuestionNeighborActivity.this, "모르는 부분이 있다연 물음표 이미지를 터치해보세요", Toast.LENGTH_LONG);
		toast.show();
   }
   
   
   @Override
   public void onWindowFocusChanged(boolean hasFocus) {
	   super.onWindowFocusChanged(hasFocus);
        // TODO Auto-generated method stub
        // 占쏙옙占썩서 width占쏙옙 占쏙옙咀몌옙占� 占쏙옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙쨉홱占�.
	   if(isFirst){
		   ImageView imgBgLine = (ImageView)findViewById(R.id.img_question_neighbor_linebg);
		   drawGraph(imgBgLine.getLeft(), imgBgLine.getRight(), imgBgLine.getTop(), imgBgLine.getBottom());
		   
		   Log.i("test", "test!!!");
	   }
	   
	   //RelativeLayout vg = (RelativeLayout) findViewById(R.id.main_layout);
	   //drawGraph(vg.getLeft(), vg.getRight(), vg.getTop(), vg.getBottom());
   }
   
   
   public void setOnClickListener(){
      Button imgBtnNext = (Button)findViewById(R.id.imgBtn_questionNeighbor_Next);
      
      imgBtnNext.setOnClickListener(new View.OnClickListener() {
         
         @Override
         public void onClick(View v) {
            // TODO Auto-generated method stub
        	 // Answer Data 
        	 JSONObject sendJson = new JSONObject();
        	 try {
				 sendJson.put("_age",Integer.toString((int)(seekBarCntrl_age.nowSeekbarPercent*100)));
	        	 sendJson.put("_gender",Integer.toString((int)(seekBarCntrl_gender.nowSeekbarPercent*100)));
	        	 sendJson.put("_aca_abili",Integer.toString((int)(seekBarCntrl_study.nowSeekbarPercent*100)));
	        	 sendJson.put("_for",Integer.toString((int)(seekBarCntrl_forienger.nowSeekbarPercent*100)));
	        	 sendJson.put("_pop_den",Integer.toString((int)(seekBarCntrl_cnt.nowSeekbarPercent*100)));
	        	 
	        	 Log.i("test", sendJson.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 
            Intent iIntent = new Intent(QuestionNeighborActivity.this, QuestionHouseActivity.class);
            iIntent.putExtra("NEIGHBOR_RESULT", sendJson.toString());
            iIntent.putExtra("YELLOW_TOP30_CD", top30Cds);
            Log.i("neighbor top 30 cds check",top30Cds);
            iIntent.putExtra("FIRST_COND", firstCond);
            iIntent.putExtra("FIRST_NE_COND", firstNeCond);
            iIntent.putExtra("SELECT_CITY", selectCityName);
            startActivity(iIntent);
            finish();
            isFirst = false;
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

      int centerX = Math.abs(right-left)/2;
      int centerY = Math.abs(top-bottom)/2;
      
      GraphData data = new GraphData(centerX, centerY);
      graph = new GraphView(getApplicationContext(), data, centerX , centerY );
      RelativeLayout.LayoutParams graphLayoutParam =new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
      graphLayoutParam.addRule(RelativeLayout.CENTER_IN_PARENT);
      //vg.setGravity(Gravity.CENTER_VERTICAL | Gravity.TOP);
      vg.addView(graph, graphLayoutParam);
      // top
      seek_top = (SeekBar) findViewById(R.id.seek_question_neighbor_peopleCnt);
      seek_top.setMax(200);
      seek_top.setProgress(100);
      seekBarCntrl_cnt = new SeekbarControl(SeekBarType.CNT, graph);
      seek_top.setOnSeekBarChangeListener(seekBarCntrl_cnt);
      
      seek_rightUp = (SeekBar) findViewById(R.id.seek_question_neighbor_age);
      seek_rightUp.setMax(200);
      seek_rightUp.setProgress(100);
      seekBarCntrl_age = new SeekbarControl(SeekBarType.AGE, graph);
      seek_rightUp.setOnSeekBarChangeListener(seekBarCntrl_age);
      
      seek_rightDown = (SeekBar) findViewById(R.id.seek_question_neighbor_gender);
      seek_rightDown.setMax(200);
      seek_rightDown.setProgress(100);
      seekBarCntrl_gender = new SeekbarControl(SeekBarType.GENDER, graph);
      seek_rightDown.setOnSeekBarChangeListener(seekBarCntrl_gender);
      
      seek_leftDown = (SeekBar) findViewById(R.id.seek_question_neighbor_foreigner);
      seek_leftDown.setMax(200);
      seek_leftDown.setProgress(100);
      seekBarCntrl_forienger = new SeekbarControl(SeekBarType.FOREIGNER, graph);
      seek_leftDown.setOnSeekBarChangeListener(seekBarCntrl_forienger);
      
      seek_leftUp = (SeekBar) findViewById(R.id.seek_question_neighbor_study);
      seek_leftUp.setMax(200);
      seek_leftUp.setProgress(100);
      seekBarCntrl_study = new SeekbarControl(SeekBarType.STUDY, graph);
      seek_leftUp.setOnSeekBarChangeListener(seekBarCntrl_study);


   }
   
   
   private void layoutSetting(){
	   
	   DisplayMetrics metrics = new DisplayMetrics();
	   getWindowManager().getDefaultDisplay().getMetrics(metrics);
	   int screenWidth = metrics.widthPixels;
	   int screenHeight = metrics.heightPixels;
	   
	   
	   
   }
	@Override
	public void onBackPressed() {
		this.finish();
	}
}
   