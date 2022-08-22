package com.example.tabiin.ui.zickr.names;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.adapters.names.DrawerNamesAdapter;
import com.example.tabiin.adapters.names.NamesAdapter;
import com.example.tabiin.databinding.FragmentAllahNamesBinding;
import com.example.tabiin.objects.names.DrawerNamesContent;
import com.example.tabiin.objects.names.Name;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


public class AllahNamesFragment extends Fragment {
    private String[] namesAllaha = new String[] {

            "للهُﷻ ",
            "الرَّحْمَانُﷻ ",
            "الرَّحِيمُﷻ ",
            "المَلِكُﷻ ",
            "القُدُّوسُﷻ ",
            "السَّلَامُﷻ ",
            "المُؤمِنُﷻ ",
            "المُهَيْمِنُﷻ ",
            "العَزِيزُﷻ ",
            "الجَبَّارُﷻ ",
            "المُتَكَبِّرُﷻ ",
            "الخَالِقُﷻ ",
            "البَارِئُﷻ ",
            "المُصَوِّرُﷻ ",
            "الغَفَّارُﷻ ",
            "القَهَّارُﷻ ",
            "الوَهَّابُﷻ ",
            "الرَّزَّاقُﷻ ",
            "الفَتَّاحُﷻ ",
            "العَلِيمُﷻ ",
            "القَابِضُﷻ ",
            "البَاسِطُﷻ ",
            "الخَافِضُﷻ ",
            "الرَّافِعُﷻ ",
            "المُعِزُّﷻ ",
            "المُذِلُّﷻ ",
            "السَّمِيعُﷻ ",
            "البَصِيرُﷻ " ,
            "الحَكَمُﷻُ ",
            "العَدْلُﷻُ ",
            "اللَّطِيفُﷻُ ",
            "الخَبِيرُﷻ ",
            "الحَلِيمُﷻ ",
            "العَظِيمُﷻ ",
            "الغَفُورُﷻ ",
            "الشَّكُورُﷻ ",
            "العَلِيُّﷻ ",
            "الكَبِيرُﷻ ",
            "الحَفِيظُﷻ ",
            "المُقِيتُﷻ ",
            "الحَسِيبُﷻ ",
            "الجَلِيلُﷻ ",
            "الكَرِيمُﷻ ",
            "الرَّقِيبُﷻ ",
            "المُجِيبُﷻ ",
            "الوَاسِعُﷻ ",
            "الحَكِيمُﷻ ",
            "الوَدُودُﷻ ",
            "المَجِيدُﷻ ",
            "البَاعِثُﷻ ",
            "الشَّهِيدُﷻ ",
            "الحَقُّﷻ ",
            "الوَكِيلُﷻ ",
            "القَوِيُّﷻ ",
            "المَتِينُﷻ ",
            "الوَلِيُّﷻ ",
            "الحَمِيدُﷻ ",
            "المُحْصِيﷻ ",
            "المُبْدِئُﷻ ",
            "المُعِيدُﷻ ",
            "المُحْيِيﷻ ",
            "المُمِيتُﷻ ",
            "الحَيُّﷻ ",
            "القَيُّومُﷻ ",
            "الوَاجِدُﷻ ",
            "المَاجِدُﷻ ",
            "الوَاحِدُﷻ ",
            "الصَّمَدُﷻ ",
            "القَادِرُﷻ ",
            "المُقْتَدِرُﷻ ",
            "المُقَدِّمُﷻ ",
            "المُؤَخِّرُﷻ ",
            "الأَوَّلُﷻ ",
            "الآخِرُﷻ ",
            "الظَّاهِرُﷻ ",
            "البَاطِنُﷻ ",
            "الوَالِيﷻ ",
            "المُتَعَالِيﷻ ",
            "البَرُّﷻ ",
            "التَّوَّابُﷻ ",
            "المُنْتَقِمُﷻ ",
            "العَفُوُّﷻ ",
            "الرَّءُؤفُﷻ ",
            "مَالِكُ المُلْكِﷻ ",
            "ذُو الجَلَالِ وَ الإِكْرَامِﷻ ",
            "المُقْسِطُﷻ ",
            "الجَامِعُﷻ ",
            "الغَنِيُّﷻ ",
            "المُغْنِيﷻ ",
            "المَانِعُﷻ ",
            "الضَّارُّﷻ ",
            "النَّافِعُﷻ ",
            "النُّورُﷻ ",
            "الهَادِيﷻ ",
            "البَدِيعُﷻ ",
            "البَاقِيﷻ ",
            "الوَارِثﷻ ",
            "الرَّشِيدُﷻ ",
            "الصَّبُورُﷻ "

    };

    public static WeakReference<AllahNamesFragment> ctx = null;
    private List<Name> names = new ArrayList<>();
    private List<DrawerNamesContent> namesDrawer = new ArrayList<>();
    private NamesAdapter namesAdapter;
    private DrawerNamesAdapter drawerNamesAdapter;

    private FragmentAllahNamesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAllahNamesBinding.inflate(inflater, container, false);
        ctx = new WeakReference<>(this);

        init();
        initDrawer();

        namesAdapter = new NamesAdapter(getContext(), names);
        binding.drawerListItem.setAdapter(namesAdapter);
        binding.drawerListItem.setHasFixedSize(false);

        drawerNamesAdapter = new DrawerNamesAdapter(getContext(), namesDrawer);
        binding.nameDrawer.setAdapter(drawerNamesAdapter);
        binding.nameDrawer.setHasFixedSize(false);

        return binding.getRoot();

    }

    public void init() {
        for(String n : namesAllaha){
            names.add(new Name(n));
        }
    }

    public void initDrawer() {
        for(String i : namesAllaha){
            namesDrawer.add(new DrawerNamesContent(i));
        }
    }
}