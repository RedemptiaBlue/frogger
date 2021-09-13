package com.genspark2.frogger.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.genspark2.frogger.Frogger;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Frogger";
		config.width = 1200;
		config.height = 800;
		new LwjglApplication(new Frogger(), config);
	}
}
