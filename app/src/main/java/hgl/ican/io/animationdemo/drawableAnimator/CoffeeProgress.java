package hgl.ican.io.animationdemo.drawableAnimator;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import hgl.ican.io.animationdemo.R;

/**
 * Created by swd1 on 16-11-2.
 */

public class CoffeeProgress extends ImageView {

    private AnimationDrawable animationDrawable;

    public CoffeeProgress(Context context) {
        this(context, null);
    }

    public CoffeeProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CoffeeProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CoffeeProgress(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        this.setBackgroundResource(R.drawable.drawable_animation_coffee);
        animationDrawable = (AnimationDrawable) this.getBackground();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animationDrawable.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animationDrawable.stop();
    }
}
