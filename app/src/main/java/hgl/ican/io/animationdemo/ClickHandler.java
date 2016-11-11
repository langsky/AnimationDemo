package hgl.ican.io.animationdemo;

import android.content.Intent;

/**
 * Created by swd1 on 16-11-2.
 */

public class ClickHandler {

    public static final String ACTION_VALUE_ANIMATOR = "hgl.ican.io.action.value_animator";
    public static final String ACTION_VIEW_ANIMATOR = "hgl.ican.io.action.view_animator";
    public static final String ACTION_DRAWABLE_ANIMATOR = "hgl.ican.io.action.drawable_animator";
    public static final String ACTION_MATERIAL_ANIMATOR = "hgl.ican.io.action.material_animator";

    private ClickHandler() {
    }

    public static ClickHandler getInstance() {
        return InnerClass.handler;
    }

    private static class InnerClass {
        private static ClickHandler handler = new ClickHandler();
    }

    public void onMainActivityButtonClicked(int id) {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        switch (id) {
            case 0:
                intent.setAction(ACTION_VALUE_ANIMATOR);
                break;
            case 1:
                intent.setAction(ACTION_VIEW_ANIMATOR);
                break;
            case 2:
                intent.setAction(ACTION_DRAWABLE_ANIMATOR);
                break;
            case 3:
                intent.setAction(ACTION_MATERIAL_ANIMATOR);
                break;
            default:
                throw new IllegalArgumentException("wrong id !");
        }
        AnimatorApp.getInstance().startActivity(intent);
    }

}
