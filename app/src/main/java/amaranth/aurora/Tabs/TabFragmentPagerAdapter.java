package amaranth.aurora.Tabs;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;


import amaranth.aurora.R;

import com.astuetz.PagerSlidingTabStrip;


/**
 * Created by user on 4/20/2015.
 */
public class TabFragmentPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider,ViewPager.OnPageChangeListener{

    final int PAGE_COUNT = 4;

    //private String tabTitles[]={"Calendar","Notification","Add","Settings"};
    private int tabIcons[]={R.drawable.ic_calendar,R.drawable.ic_notifications,R.drawable.ic_add,R.drawable.ic_settings};

    public TabFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Log.i("PAGER", "" + position);
                return CalFragment.newInstance(1);
            case 1:
                Log.i("PAGER", "" + position);
                return NotificationFragment.newInstance(2);
            case 2:
                Log.i("PAGER", "" + position);
                return AddFragment.newInstance(3);
            case 3:
                Log.i("PAGER",""+position);
                return  SettingsFragment.newInstance(4);
            default:
                Log.i("PAGER", "Something went wrong we are outside if statements, position:  " + position);
                return CalFragment.newInstance(1);

        }
    }


    @Override
    public int getPageIconResId(int i) {
        return tabIcons[i];
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position==2){
           

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
