package com.example.dishant.spaceappsui;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        return view;
    }

    private void setupTabIcons(){
        RelativeLayout relativeLayout1 = (RelativeLayout) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        TextView number1 = (TextView) relativeLayout1.findViewById(R.id.number);
        TextView tabName1 = (TextView) relativeLayout1.findViewById(R.id.tabName);
        number1.setText("25");
        tabName1.setText("questions");
        tabLayout.getTabAt(0).setCustomView(relativeLayout1);

        RelativeLayout relativeLayout2 = (RelativeLayout) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        TextView number2 = (TextView) relativeLayout2.findViewById(R.id.number);
        TextView tabName2 = (TextView) relativeLayout2.findViewById(R.id.tabName);
        number2.setText("35");
        tabName2.setText("answers");
        tabLayout.getTabAt(1).setCustomView(relativeLayout2);

        RelativeLayout relativeLayout3 = (RelativeLayout) LayoutInflater.from(getActivity()).inflate(R.layout.custom_tab, null);
        TextView number3 = (TextView) relativeLayout3.findViewById(R.id.number);
        TextView tabName3 = (TextView) relativeLayout3.findViewById(R.id.tabName);
        number3.setText("40");
        tabName3.setText("contributions");
        tabLayout.getTabAt(2).setCustomView(relativeLayout3);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new UserQuestion(), "QUESTIONS");
        adapter.addFragment(new UserAnswer(), "ANSWERS");
        adapter.addFragment(new UserQuestion(), "CONTRIBUTIONS");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
