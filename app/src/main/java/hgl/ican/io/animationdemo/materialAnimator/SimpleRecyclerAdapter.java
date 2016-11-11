package hgl.ican.io.animationdemo.materialAnimator;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hgl.ican.io.animationdemo.R;
import hgl.ican.io.animationdemo.databinding.SimpleViewBinding;

/**
 * Created by swd1 on 16-11-11.
 */
public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.MaterialViewHolder> {

    Activity activity;
    List<Sample> samples;
    SimpleViewBinding binding;

    public SimpleRecyclerAdapter(Activity activity, List<Sample> list) {
        this.activity = activity;
        this.samples = list;
    }

    @Override
    public MaterialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.simple_view, parent, false);
        return new MaterialViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(final MaterialViewHolder holder, int position) {
        final Sample sample = samples.get(holder.getAdapterPosition());
        holder.binding.setSample(sample);
        holder.binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (holder.getAdapterPosition()) {
                    case 0:
                        transitionToActivity(TransitionActivity1.class, sample);
                        break;
                    case 1:
                        transitionToActivity(SharedElementActivity.class, holder, sample);
                        break;
                    case 2:
                        transitionToActivity(AnimationsActivity1.class, sample);
                        break;
                    case 3:
                        transitionToActivity(RevealActivity.class, holder, sample, R.string.transition_reveal1);
                        break;
                }
            }
        });
    }

    private void transitionToActivity(Class target, MaterialViewHolder holder, Sample sample, @StringRes int string) {

        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(activity, false,
                new Pair<>(holder.binding.imageView, activity.getString(string)));
        startActivity(target, pairs, sample);
    }

    private void transitionToActivity(Class target, MaterialViewHolder holder, Sample sample) {
        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(activity, false,
                new Pair<>(holder.binding.imageView, activity.getString(R.string.square_blue_name)),
        new Pair<>(holder.binding.textView, activity.getString(R.string.sample_blue_title)));
        startActivity(target, pairs, sample);
    }

    private void transitionToActivity(Class target, Sample sample) {
        Pair<View,String>[] pairs = TransitionHelper.createSafeTransitionParticipants(activity,true);
        startActivity(target,pairs,sample);
    }

    private void startActivity(Class target, Pair<View, String>[] pairs, Sample sample) {
        Intent i = new Intent(activity, target);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pairs);
        i.putExtra("sample", sample);
        activity.startActivity(i, options.toBundle());
    }

    @Override
    public int getItemCount() {
        return samples.size();
    }

    public static class MaterialViewHolder extends RecyclerView.ViewHolder {

        final SimpleViewBinding binding;

        public MaterialViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

    }

}
