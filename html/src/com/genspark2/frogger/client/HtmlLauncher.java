package com.genspark2.frogger.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.genspark2.frogger.Frogger;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(Frogger.gameWidth, Frogger.gameHeight);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new Frogger();
        }
}