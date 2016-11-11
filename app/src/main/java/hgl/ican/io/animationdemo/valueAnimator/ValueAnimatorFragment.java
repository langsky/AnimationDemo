package hgl.ican.io.animationdemo.valueAnimator;

import android.animation.FloatArrayEvaluator;
import android.animation.IntEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;


import hgl.ican.io.animationdemo.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ValueAnimatorFragment extends Fragment implements View.OnClickListener {

    Button button0, button1;

    static int screenWidth;
    static int screenHeight;

    ImageView view0, view1, view2, view3, view4, view5, view6, view7, view8;


    public ValueAnimatorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_value_animator, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button0 = (Button) view.findViewById(R.id.start_animation_0);
        button1 = (Button) view.findViewById(R.id.start_animation_1);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);

        view0 = (ImageView) view.findViewById(R.id.test_view0);
        view1 = (ImageView) view.findViewById(R.id.test_view1);
        view2 = (ImageView) view.findViewById(R.id.test_view2);
        view3 = (ImageView) view.findViewById(R.id.test_view3);
        view4 = (ImageView) view.findViewById(R.id.test_view4);
        view5 = (ImageView) view.findViewById(R.id.test_view5);
        view6 = (ImageView) view.findViewById(R.id.test_view6);
        view7 = (ImageView) view.findViewById(R.id.test_view7);
        view8 = (ImageView) view.findViewById(R.id.test_view8);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_animation_0:
                startAnimation(view0, new AccelerateDecelerateInterpolator());
                startAnimation(view1, new AccelerateInterpolator());
                startAnimation(view2, new AnticipateOvershootInterpolator());
                startAnimation(view3, new BounceInterpolator());
                startAnimation(view4, new CycleInterpolator(1));
                startAnimation(view5, new DecelerateInterpolator());
                startAnimation(view6, new LinearInterpolator());
                startAnimation(view7, new OvershootInterpolator());
                startAnimation(view8, new AnticipateInterpolator());
                break;
            case R.id.start_animation_1:
                startAnimation1(view0, new AccelerateDecelerateInterpolator());
                startAnimation1(view1, new AccelerateInterpolator());
                startAnimation1(view2, new AnticipateOvershootInterpolator());
                startAnimation1(view3, new BounceInterpolator());
                startAnimation1(view4, new CycleInterpolator(1));
                startAnimation1(view5, new DecelerateInterpolator());
                startAnimation1(view6, new LinearInterpolator());
                startAnimation1(view7, new OvershootInterpolator());
                startAnimation1(view8, new AnticipateInterpolator());
        }
    }

    private void startAnimation1(final View view, TimeInterpolator interpolator) {
        ValueAnimator animator;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.width != screenWidth)
            animator = ValueAnimator.ofInt(view.getWidth(), screenWidth);
        else
            animator = ValueAnimator.ofInt(screenWidth, view.getWidth());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.width = (int) animation.getAnimatedValue();
                view.setLayoutParams(marginLayoutParams);
            }
        });
        animator.setInterpolator(interpolator);
        animator.setTarget(view);
        animator.setDuration(10000).start();
    }

    private void startAnimation(final View view, TimeInterpolator interpolator) {
        ValueAnimator animator;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.leftMargin == 0)
            animator = ValueAnimator.ofInt(0, screenWidth - view.getWidth());
        else
            animator = ValueAnimator.ofInt(screenWidth - view.getWidth(), 0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.leftMargin = (int) animation.getAnimatedValue();
                view.setLayoutParams(marginLayoutParams);
            }
        });
        animator.setInterpolator(interpolator);
        animator.setTarget(view);
        animator.setDuration(10000).start();
    }
}
