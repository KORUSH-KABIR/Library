package ir.aid.library.Frameworks.helper;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class IntroDesignHelper {

    private static final String DEVELOPER = "محمد علی ریاضتی";

    private ViewPager viewPager;
    private IntroAdapter adapter;
    private View view;
    private Context context;
    private ViewPager.OnPageChangeListener listener;

    public IntroDesignHelper(AppCompatActivity activity , ViewPager viewPager) {
        view = activity.getWindow().getDecorView();
        context = view.getContext();
        this.viewPager = viewPager;
        this.adapter = new IntroAdapter(context);
    }

    public IntroDesignHelper(AppCompatActivity activity , int viewPagerId) {
        view = activity.getWindow().getDecorView();
        context = view.getContext();
        this.viewPager = view.findViewById(viewPagerId);
        this.adapter = new IntroAdapter(context);
    }

    public IntroDesignHelper setLayoutsMode(int[] layouts){
        this.adapter.setLayoutsMode(layouts);
        return this;
    }

    public IntroDesignHelper setItemsMode(@LayoutRes int layout , int layoutLength){
        adapter.setItemsMode(layout , layoutLength);
        return this;
    }

    public IntroDesignHelper addOnPageChangeListener(ViewPager.OnPageChangeListener listener){
        this.listener = listener;
        return this;
    }

    public IntroDesignHelper getItemsOnViewPager(OnViewPagerItems viewPagerItems){
        adapter.getOnItemsViewPager(viewPagerItems);
        return this;
    }

    public int getCountAdapter(){
        return adapter.getCountAdapter();
    }

    public View getView(){
        return adapter.getView();
    }

    public void showIntroDesign(){
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(listener);
    }

    private class IntroAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;
        private boolean mode;
        private int[] layouts;
        private int layout;
        private int lengthCount;
        private OnViewPagerItems viewPagerItems;
        private View view = null;

        private IntroAdapter(Context context) {
            this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        private void setLayoutsMode(int[] layouts){
            this.layouts = layouts;
            this.mode = true;
        }

        private void setItemsMode(@LayoutRes int layout , int lengthCount){
            this.layout = layout;
            this.lengthCount = lengthCount;
            this.mode = false;
        }

        private void getOnItemsViewPager(OnViewPagerItems viewPagerItems){
            this.viewPagerItems = viewPagerItems;
        }

        private int getCountAdapter(){
            return getCount();
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            if(mode){
                view = layoutInflater.inflate(layouts[position], container, false);
            }
            else {
                view = layoutInflater.inflate(layout, container, false);
            }

            if(viewPagerItems != null){
                viewPagerItems.items(view , position);
            }

            container.addView(view);
            return view;
        }

        private View getView(){
            return view;
        }

        @Override
        public int getCount() {
            if(mode){
               return layouts.length;
            }
            else {
                return lengthCount;
            }
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }

    }

    public interface OnViewPagerItems {
        void items(View view, int position);
    }

    public static String getDeveloper(){
        return DEVELOPER;
    }

}
