package ir.aid.library.Frameworks.helper;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class TabHelper {

    private static final String DEVELOPER = "محمد علی ریاضتی";

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FragmentAdapter fragmentAdapter;

    public TabHelper(AppCompatActivity activity, int viewPagerId, int tabLayoutId) {
        View view = activity.getWindow().getDecorView();
        viewPager = view.findViewById(viewPagerId);
        tabLayout = view.findViewById(tabLayoutId);
        fragmentAdapter = new FragmentAdapter(activity.getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public TabHelper(AppCompatActivity activity, View view, int viewPagerId, int tabLayoutId) {
        viewPager = view.findViewById(viewPagerId);
        tabLayout = view.findViewById(tabLayoutId);
        fragmentAdapter = new FragmentAdapter(activity.getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public TabHelper(AppCompatActivity activity, ViewPager viewPager, TabLayout tabLayout) {
        this.viewPager = viewPager;
        this.tabLayout = tabLayout;
        fragmentAdapter = new FragmentAdapter(activity.getSupportFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void add(Class<? extends Fragment> fragmentClass, String title, int icon) {
        Item item = new Item(fragmentClass, title, icon);
        fragmentAdapter.AddItems(item);
        fragmentAdapter.notifyDataSetChanged();
        refreshIcon();
    }

    public void add(Class<? extends Fragment> fragmentClass, int icon) {
        add(fragmentClass, null, icon);
    }

    public void add(Class<? extends Fragment> fragmentClass, String title) {
        add(fragmentClass, title, 0);
    }

    private void refreshIcon() {
        for(int i = 0; i < fragmentAdapter.getCount(); i++){
            int itemIcon = fragmentAdapter.getRowItem(i).getIcon();
            if(itemIcon != 0){
                tabLayout.getTabAt(i).setIcon(fragmentAdapter.getRowItem(i).getIcon());
            }
        }
    }

    public static class Item {
        private Fragment fragment;
        private String title;
        private int icon;

        public Item(Class<? extends Fragment> fragmentClass, String title, int icon) {
            try{
                this.fragment = fragmentClass.newInstance();
                this.title = title;
                this.icon = icon;
            }catch(InstantiationException e){
                e.printStackTrace();
            }catch(IllegalAccessException e){
                e.printStackTrace();
            }
        }

        public Fragment getFragment() {
            return fragment;
        }

        public String getTitle() {
            return title;
        }

        public int getIcon() {
            return icon;
        }

        public void setTitle(String value) {
            title = value;
        }

        public void setIcon(int value) {
            icon = value;
        }
    }

    public class FragmentAdapter extends FragmentPagerAdapter {

        private List<Item> items = new ArrayList<>();

        public FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position).getFragment();
        }

        public Item getRowItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        public void AddItems(Item item) {
            items.add(item);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return items.get(position).getTitle();
        }
    }

    public void setIcon(int index, int icon) {
        fragmentAdapter.getRowItem(index).setIcon(icon);
        refreshIcon();
    }

    public void setTitle(int index, String title) {
        fragmentAdapter.getRowItem(index).setTitle(title);
        fragmentAdapter.notifyDataSetChanged();
        refreshIcon();
    }

    public void setCurrentItem(int position) {
        viewPager.setCurrentItem(position);
    }

    public static String getDeveloper(){
        return DEVELOPER;
    }
}
