package hgl.ican.io.animationdemo;

import android.app.Application;

/**
 * Created by swd1 on 16-11-2.
 */

public class AnimatorApp extends Application {

    private static AnimatorApp app;

    public static AnimatorApp getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
