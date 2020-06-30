package com.example.CodeCommander;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter

{

    ArrayList<Fragment> mFragmentList;
    ArrayList<String> mFragnmentTitleList;

    PageAdapter(FragmentManager fmng)
    {
        super(fmng);
        mFragmentList = new ArrayList<>();
        mFragnmentTitleList = new ArrayList<>();


    }

    @NonNull
    @Override
    public Fragment getItem(int position){


        return mFragmentList.get(position);
    }

    @Override
    public int getCount(){
        return mFragmentList.size();
    }

    public void addFragnent(Fragment fragment, String title){

        mFragmentList.add(fragment);
        mFragnmentTitleList.add(title);


    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return mFragnmentTitleList.get(position);
    }


}
