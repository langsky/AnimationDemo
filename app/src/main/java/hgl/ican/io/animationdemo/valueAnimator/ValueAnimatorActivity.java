package hgl.ican.io.animationdemo.valueAnimator;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import hgl.ican.io.animationdemo.R;


public class ValueAnimatorActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        tabs.setupWithViewPager(viewPager);
        viewPager.setAdapter(adapter);
    }


    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ValueAnimatorFragment();
                case 1:
                    return new ObjectAnimatorFragment();
                case 2:
                    return new LayoutAnimatorFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Value Animator";
                case 1:
                    return "Object Animator";
                case 2:
                    return "Layout Animator";
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
