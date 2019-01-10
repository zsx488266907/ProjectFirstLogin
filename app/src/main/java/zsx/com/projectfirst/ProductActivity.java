package zsx.com.projectfirst;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import zsx.com.projectfirst.frament.Fragment01;
import zsx.com.projectfirst.frament.Fragment02;

public class ProductActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.but1:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.but2:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.but3:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.but4:
                    viewPager.setCurrentItem(3);
                    return true;
                case R.id.but5:
                    viewPager.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i){
                    case 0:
                        return new Fragment01();
                    default:
                        return  new Fragment02();
                }

            }

            @Override
            public int getCount() {
                return 5;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        navigation.setSelectedItemId(R.id.but1);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.but2);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.but3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
