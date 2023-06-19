package com.example.tareasqlite;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SectionsPageAdapter extends FragmentStateAdapter {
    public SectionsPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                VerNotas tab1obj=new VerNotas();
                return tab1obj;
            case 1:
                EditarNotas tab2obj=new EditarNotas();
                return tab2obj;

            case 2:
                CrearNotas tab3obj=new CrearNotas();
                return tab3obj;
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
