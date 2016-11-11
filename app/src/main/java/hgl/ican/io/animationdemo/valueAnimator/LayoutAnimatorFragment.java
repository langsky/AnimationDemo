package hgl.ican.io.animationdemo.valueAnimator;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import hgl.ican.io.animationdemo.R;


public class LayoutAnimatorFragment extends Fragment implements View.OnClickListener {

    LayoutTransition transition;
    GridLayout layout;
    Button button;

    static int color = 0;


    public LayoutAnimatorFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout_animator, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layout = (GridLayout) view.findViewById(R.id.grid);
        transition = new LayoutTransition();
        transition.setStagger(LayoutTransition.CHANGE_APPEARING, 300);
        transition.setStagger(LayoutTransition.CHANGE_DISAPPEARING, 300);
        layout.setLayoutTransition(transition);
        button = (Button) view.findViewById(R.id.addButton);
        button.setOnClickListener(this);
        //initTransition();
        customLayoutTransition();
    }

    private void initTransition() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(null, "rotationX", 0.0f, 180f);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(null, "rotationY", 180f, 0.0f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(null, "rotationX", 0.0f, 360f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(null, "rotationY", 360f, 0f);
        transition.setAnimator(LayoutTransition.CHANGE_APPEARING, animator);
        transition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, animator1);
        transition.setAnimator(LayoutTransition.APPEARING, animator2);
        transition.setAnimator(LayoutTransition.DISAPPEARING, animator3);
    }

    @Override
    public void onClick(View v) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setImageResource(R.mipmap.ic_launcher);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50, 50);
        imageView.setLayoutParams(params);
        if (color % 2 == 0)
            imageView.setBackgroundResource(R.color.colorAccent);
        else
            imageView.setBackgroundResource(R.color.colorPrimary);
        color++;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.removeView(v);
                color--;
            }
        });
        layout.addView(imageView, Math.min(0, layout.getChildCount()));
    }

    public void customLayoutTransition(){

        /**
         * Add Button
         * LayoutTransition.APPEARING
         *
         */
        ObjectAnimator mAnimatorAppearing = ObjectAnimator.ofFloat(null, "rotationY", 90.0f,0.0f)
                .setDuration(transition.getDuration(LayoutTransition.APPEARING));

        transition.setAnimator(LayoutTransition.APPEARING, mAnimatorAppearing);
        mAnimatorAppearing.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // TODO Auto-generated method stub
                super.onAnimationEnd(animation);
                View view = (View) ((ObjectAnimator) animation).getTarget();
                view.setRotationY(0.0f);
                Log.e("AAA","LayoutTransition.APPEARING");
            }
        });

        /**
         * Add Button
         * LayoutTransition.CHANGE_APPEARING
         *
         */

        PropertyValuesHolder pvhLeft =
                PropertyValuesHolder.ofInt("left", 0, 1);
        PropertyValuesHolder pvhTop =
                PropertyValuesHolder.ofInt("top", 0, 1);
        PropertyValuesHolder pvhRight =
                PropertyValuesHolder.ofInt("right", 0, 1);
        PropertyValuesHolder pvhBottom =
                PropertyValuesHolder.ofInt("bottom", 0, 1);

        PropertyValuesHolder mHolderScaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f,0.0f,1.0f);
        PropertyValuesHolder mHolderScaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f,0.0f,1.0f);
        ObjectAnimator mObjectAnimatorChangeAppearing = ObjectAnimator.ofPropertyValuesHolder(this, pvhLeft,
                pvhTop,pvhRight,pvhBottom,mHolderScaleX,mHolderScaleY).setDuration(transition
                .getDuration(LayoutTransition.CHANGE_APPEARING));
        transition.setAnimator(LayoutTransition.CHANGE_APPEARING, mObjectAnimatorChangeAppearing);
        mObjectAnimatorChangeAppearing.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // TODO Auto-generated method stub
                super.onAnimationEnd(animation);
                View view = (View) ((ObjectAnimator) animation).getTarget();
                view.setScaleX(1f);
                view.setScaleY(1f);
                Log.e("AAA","LayoutTransition.CHANGE_APPEARING");
            }
        });

        /**
         * Delete Button
         * LayoutTransition.DISAPPEARING
         *
         */
        ObjectAnimator mObjectAnimatorDisAppearing = ObjectAnimator.ofFloat(null, "rotationX", 0.0f,90.0f)
                .setDuration(transition.getDuration(LayoutTransition.DISAPPEARING));
        transition.setAnimator(LayoutTransition.DISAPPEARING, mObjectAnimatorDisAppearing);
        mObjectAnimatorDisAppearing.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // TODO Auto-generated method stub
                super.onAnimationEnd(animation);
                View view = (View) ((ObjectAnimator) animation).getTarget();
                view.setRotationX(0.0f);
                Log.e("AAA","LayoutTransition.DISAPPEARING");
            }
        });

        /**
         * Delete Button
         * LayoutTransition.CHANGE_DISAPPEARING
         *
         */
        //Keyframe
        Keyframe mKeyframeStart = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe mKeyframeMiddle = Keyframe.ofFloat(0.5f, 180.0f);
        Keyframe mKeyframeEndBefore = Keyframe.ofFloat(0.999f, 360.0f);
        Keyframe mKeyframeEnd = Keyframe.ofFloat(1.0f, 0.0f);

        PropertyValuesHolder mPropertyValuesHolder = PropertyValuesHolder.ofKeyframe("rotation",
                mKeyframeStart,mKeyframeMiddle,mKeyframeEndBefore,mKeyframeEnd);
        ObjectAnimator mObjectAnimatorChangeDisAppearing = ObjectAnimator.ofPropertyValuesHolder(this, pvhLeft,pvhTop,pvhRight,pvhBottom,mPropertyValuesHolder)
                .setDuration(transition.getDuration(LayoutTransition.CHANGE_DISAPPEARING));
        transition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, mObjectAnimatorChangeDisAppearing);
        mObjectAnimatorChangeDisAppearing.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // TODO Auto-generated method stub
                super.onAnimationEnd(animation);
                View view = (View) ((ObjectAnimator) animation).getTarget();
                view.setRotation(0.0f);
                Log.e("AAA","LayoutTransition.CHANGE_DISAPPEARING");
            }
        });
    }
}
