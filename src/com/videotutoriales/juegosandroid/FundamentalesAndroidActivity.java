package com.videotutoriales.juegosandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FundamentalesAndroidActivity extends ListActivity {
	String pruebas[] = {
			"LifeCycleTest",
			"SingleTouchTest",
			"MultiTouchTest",
			"KeyTest",
			"AccelerometerTest",
			"AssetsTest",
			"ExternalStorageTest",
			"SoundPoolTest",
			"MediaPlayerTest",
			"FullScreenTest",
			"RenderViewTest",
			"FontTest",
			"SurfaceViewTest",
			"MessageTest",
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(
					new ArrayAdapter<String>(
							this, android.R.layout.simple_list_item_1, pruebas
					)
				);
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
	
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String nombrePrueba = pruebas[position];
		
		try {
			
			Class<?> clazz = Class.forName("com.videotutoriales.juegosandroid." + nombrePrueba + "Activity");
			Intent intent = new Intent(this, clazz);
			startActivity(intent);
			System.out.println("<<<<:)");
			
			
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
	}
}