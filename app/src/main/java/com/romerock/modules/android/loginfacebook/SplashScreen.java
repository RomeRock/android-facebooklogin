package com.romerock.modules.android.loginfacebook;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends Activity {
	protected int _splashTime = 5000;

	private Thread splashTread;
	private boolean isAllShoppingsIntetn = false;
	private String action = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.splash);
		final SplashScreen sPlashScreen = this;
		splashTread = new Thread() {
			@Override
			public void run() {
				try {
					synchronized (this) {
						wait(_splashTime);
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					Intent intent = new Intent();
					intent.setClass(sPlashScreen, MainActivity.class);
					startActivity(intent);
					finish();
				}
			}
		};
		splashTread.start();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {

		super.onConfigurationChanged(newConfig);
	}

	// Function that will handle the touch
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
		}
		return true;
	}

	@Override
	public void onBackPressed() {
	}

}