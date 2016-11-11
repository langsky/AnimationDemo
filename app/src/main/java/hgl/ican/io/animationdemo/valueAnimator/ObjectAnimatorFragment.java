package hgl.ican.io.animationdemo.valueAnimator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import hgl.ican.io.animationdemo.R;

public class ObjectAnimatorFragment extends Fragment implements View.OnClickListener {

    Button button;
    ImageView image;


    public ObjectAnimatorFragment() {
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
        return inflater.inflate(R.layout.fragment_object_animator, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = (Button) view.findViewById(R.id.button0);
        image = (ImageView) view.findViewById(R.id.image0);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startObjectAnimation();
    }

    private void startObjectAnimation() {
        Log.e("HGL",image.getScaleX()+" "+image.getScaleY());
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 3.0f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 3.0f);
        ObjectAnimator animator1 = ObjectAnimator.ofPropertyValuesHolder(image, scaleX, scaleY);
        animator1.setDuration(3000);


        animator1.addPauseListener(new Animator.AnimatorPauseListener() {
            @Override
            public void onAnimationPause(Animator animation) {

            }

            @Override
            public void onAnimationResume(Animator animation) {

            }
        });

        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });

        animator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.e("HGL","start " +image.getScaleX()+" "+image.getScaleY());
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.e("HGL","end "+image.getScaleX()+" "+image.getScaleY());
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator1.start();


        /*AnimatorSet animator = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(),R.animator.my_object_animation);
        animator.setTarget(image);
        animator.start();*/
    }
}
