package com.quiz.cartoonquiz.brain;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GameScene newGame = new GameScene();
		switchContent(this, newGame, "newGame");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void switchContent(Context context,Fragment newFragment,String nameFragment){
		
		FragmentManager fgManager = getSupportFragmentManager();
		FragmentTransaction frgTransaction = fgManager.beginTransaction();
		frgTransaction.replace(R.id.content_frame, newFragment);
		//frgTransaction.addToBackStack(nameFragment);
		frgTransaction.commit();
	}
}
