package com.example.danielbastos.msn.Friends.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.danielbastos.msn.Friends.FriendsAdapter;
import com.example.danielbastos.msn.Friends.ListFragment;

/**
 * Created by danielbastos on 3/4/16.
 */

public class TabLoader extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Bloqueados", "Amigos", "Pedidos" };

    public TabLoader(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return ListFragment.newInstance(FriendsAdapter.LISTA_BLOQUEADOS);
            case 1:
                return ListFragment.newInstance(FriendsAdapter.LISTA_AMIGOS);
            case 2:
                return ListFragment.newInstance(FriendsAdapter.LISTA_PEDIDOS);
            default:
                return ListFragment.newInstance(FriendsAdapter.LISTA_AMIGOS);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}