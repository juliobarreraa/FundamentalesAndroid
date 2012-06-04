package com.videotutoriales.juegosandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class SingleTouchTestActivity extends Activity implements OnTouchListener {
	StringBuilder builder = new StringBuilder();
	TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText("Toca y arrastra (Un dedo solamente)");
		
		textView.setOnTouchListener(this);
		setContentView(textView);
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		builder.setLength(0);
		switch(event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				builder.append("down, ");
			break;
			case MotionEvent.ACTION_MOVE:
				builder.append("move, ");
			break;
			case MotionEvent.ACTION_CANCEL:
				builder.append("cancel, ");
			break;
			case MotionEvent.ACTION_UP:
				builder.append("up, ");
			break;
		}
		
		builder.append(event.getX());
		builder.append(", ");
		builder.append(event.getY());
		String text = builder.toString();
		
		textView.setText(text);
		
		Log.d("TouchTest", text);
		return true;
	}
}
