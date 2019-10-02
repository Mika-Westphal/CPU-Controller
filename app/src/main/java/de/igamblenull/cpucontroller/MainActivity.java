package de.igamblenull.cpucontroller;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import de.igamblenull.cpucontroller.fragments.CPUClkFragment;
import de.igamblenull.cpucontroller.fragments.CPUOverviewFragment;

public class MainActivity extends AppCompatActivity
        implements CPUOverviewFragment.OnFragmentInteractionListener,
                   CPUClkFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        TabItem cpuOverviewTabItem = findViewById(R.id.cpuOverviewTab);
        TabItem cpuCLKTabItem = findViewById(R.id.cpuCLKTab);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    @Override
    public void onFragmentInteraction(Uri uri) {}
}
