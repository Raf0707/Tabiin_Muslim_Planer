package com.example.tabiin.ui.kitab.quran;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabiin.adapters.names.AdaptersFirstUse;
import com.example.tabiin.adapters.names.DrawerNamesAdapter;
import com.example.tabiin.adapters.quran.DrawerQuranAdapter;
import com.example.tabiin.adapters.quran.DrawerSuraContentAdapter;
import com.example.tabiin.databinding.FragmentQuranBinding;
import com.example.tabiin.objects.sures.Sura;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuranFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuranFragment extends Fragment {

    private FragmentQuranBinding binding;
    private DrawerQuranAdapter drawerQuranAdapter;

    private DrawerSuraContentAdapter drawerSuraContentAdapter;

    private List<String> suresContent = new ArrayList<>();
    private List<String> suresName = new ArrayList<>();
    private String[] sures = new String[115];
    private Sura sura;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuranFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KoranFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuranFragment newInstance(String param1, String param2) {
        QuranFragment fragment = new QuranFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Gson gson = new GsonBuilder().create();
        InputStream inputStream = null;
        try {
            inputStream = getContext().getAssets().open("Quran and Tafsir (.json)/1.json");
            String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();
            Sura sura = gson.fromJson(jsonString, Sura.class);
            Log.d("SURA", sura.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentQuranBinding.inflate(inflater, container, false);
        binding.suraContent.setAdapter(new AdaptersFirstUse());

        initContent();
        initMap();

        drawerQuranAdapter = new DrawerQuranAdapter(inflater, suresName, getContext(), binding.suraContent);
        binding.quranContent.setAdapter(drawerQuranAdapter);
        binding.quranContent.setHasFixedSize(false);

        return binding.getRoot();

    }

    private void initContent() {
        // Инициализация массива
        sures[0] = "1. «Аль-Фатиха» \n («Открывающая Книгу»)";
        sures[1] = "2. «Аль-Бакара» \n («Корова»)";
        sures[2] = "3. «Аль-Имран» \n («Семейство Имрана»)";
        sures[3] = "4. «Ан-Ниса» \n («Женщины»)";
        sures[4] = "5. «Аль-Маида» \n («Трапеза»)";
        sures[5] = "6. «Аль-Анам» \n («Скот»)";
        sures[6] = "7. «Аль-Араф» \n («Преграды»)";
        sures[7] = "8. «Аль-Анфаль» \n («Трофеи»)";
        sures[8] = "9. «Ат-Тауба» \n («Покаяние»)";
        sures[9] = "10. «Йунус» \n («Иона»)";
        sures[10] = "11. «Худ» \n («Худ»)";
        sures[11] = "12. «Йусуф» \n («Иосиф»)";
        sures[12] = "13. «Ар-Раад» \n («Гром»)";
        sures[13] = "14. «Ибрахим» \n («Авраам»)";
        sures[14] = "15. «Аль-Хиджр» \n («Хиджр»)";
        sures[15] = "16. «Ан-Нахль» \n («Пчёлы»)";
        sures[16] = "17. «Аль-Исра» \n («Ночной перенос»)";
        sures[17] = "18. «Аль-Кахф» \n («Пещера»)";
        sures[18] = "19. «Марьям» \n («Мария»)";
        sures[19] = "20. «Та Ха» \n («Та Ха»)";
        sures[20] = "21. «Аль-Анбийа» \n («Пророки»)";
        sures[21] = "22. «Аль-Хаджж» \n («Паломничество»)";
        sures[22] = "23. «Аль-Муминун» \n («Верующие»)";
        sures[23] = "24. «Ан-Нур» \n («Свет»)";
        sures[24] = "25. «Аль-Фуркан» \n («Различение»)";
        sures[25] = "26. «Аш-Шуара» \n («Поэты»)";
        sures[26] = "27. «Ан-Намль» \n («Муравьи»)";
        sures[27] = "28. «Аль-Касас» \n («Рассказ»)";
        sures[28] = "29. «Аль-Анкабут» \n («Паук»)";
        sures[29] = "30. «Ар-Рум» \n («Римляне»)";
        sures[30] = "31. «Лукман» \n («Лукман»)";
        sures[31] = "32. «Ас-Саджда» \n («Поклон»)";
        sures[32] = "33. «Аль-Ахзаб» \n («Сонмы»)";
        sures[33] = "34. «Саба» \n («Саба»)";
        sures[34] = "35. «Фатыр» \n («Ангелы»)";
        sures[35] = "36. «Йа син» \n («Йа Син»)";
        sures[36] = "37. «Ас-Саффат» \n («Стоящие в ряд»)";
        sures[37] = "38. «Сад» \n («Сад»)";
        sures[38] = "39. «Аз-Зумар» \n («Толпы»)";
        sures[39] = "40. «Гафир» \n («Прощающий»)";
        sures[40] = "41. «Фуссылят» \n («Разъяснены»)";
        sures[41] = "42. «Аш-Шура» \n («Совет»)";
        sures[42] = "43. «Аз-Зухруф» \n («Украшения»)";
        sures[43] = "44. «Ад-Духан» \n («Дым»)";
        sures[44] = "45. «Аль-Джасия» \n («Коленопреклонённые»)";
        sures[45] = "46. «Аль-Ахкаф» \n («Пески»)";
        sures[46] = "47. «Мухаммад» \n («Мухаммад»)";
        sures[47] = "48. «Аль-Фатх» \n («Победа»)";
        sures[48] = "49. «Аль-Худжурат» \n («Комнаты»)";
        sures[49] = "50. «Каф» \n («Каф»)";
        sures[50] = "51. «Аз-Зарият» \n («Рассеивающие»)";
        sures[51] = "52. «Ат-Тур» \n («Гора»)";
        sures[52] = "53. «Ан-Наджм» \n («Звезда»)";
        sures[53] = "54. «Аль-Камар» \n («Месяц»)";
        sures[54] = "55. «Ар-Рахман» \n («Милосердный»)";
        sures[55] = "56. «Аль-Вакиа» \n («Падающее»)";
        sures[56] = "57. «Аль-Хадид» \n («Железо»)";
        sures[57] = "58. «Аль-Муджадиля» \n («Препирательство»)";
        sures[58] = "59. «Аль-Хашр» \n («Собрание»)";
        sures[59] = "60. «Аль-Мумтахана» \n («Испытуемая»)";
        sures[60] = "61. «Ас-Сафф» \n («Ряды»)";
        sures[61] = "62. «Аль-Джума» \n («Пятница»)";
        sures[62] = "63. «Аль-Мунафикун» \n («Лицемеры»)";
        sures[63] = "64. «Ат-Тагабун» \n («Взаимное обманывание»)";
        sures[64] = "65. «Ат-Таляк» \n («Развод»)";
        sures[65] = "66. «Ат-Тахрим» \n («Запрещение»)";
        sures[66] = "67. «Аль-Мульк» \n («Власть»)";
        sures[67] = "68. «Аль-Калям» \n («Письменная трость»)";
        sures[68] = "69. «Аль-Хакка» \n («Неизбежное»)";
        sures[69] = "70. «Аль-Мааридж» \n («Ступени»)";
        sures[70] = "71. «Нух» \n («Нух»)";
        sures[71] = "72. «Аль-Джинн» \n («Джинны»)";
        sures[72] = "73. «Аль-Муззаммиль» \n («Закутавшийся»)";
        sures[73] = "74. «Аль-Муддассир» \n («Завернувшийся»)";
        sures[74] = "75. «Аль-Кыйама» \n («Воскресение»)";
        sures[75] = "76. «Аль-Инсан» \n («Человек»)";
        sures[76] = "77. «Аль-Мурсалят» \n («Посылаемые»)";
        sures[77] = "78. «Ан-Наба» \n («Весть»)";
        sures[78] = "79. «Ан-Назиат» \n («Вырывающие»)";
        sures[79] = "80. «Абаса» \n («Нахмурился»)";
        sures[80] = "81. «Ат-Таквир» \n («Скручивание»)";
        sures[81] = "82. «Аль-Инфитар» \n («Раскалывание»)";
        sures[82] = "83. «Аль-Мутаффифин» \n («Обвешивающие»)";
        sures[83] = "84. «Аль-Иншикак» \n («Разверзнется»)";
        sures[84] = "85. «Аль-Бурудж» \n («Башни»)";
        sures[85] = "86. «Ат-Тарик» \n («Ночной путник»)";
        sures[86] = "87. «Аль-А'ля» \n («Высочайший»)";
        sures[87] = "88. «Аль-Гашия» \n («Покрывающее»)";
        sures[88] = "89. «Аль-Фаджр» \n («Заря»)";
        sures[89] = "90. «Аль-Баляд» \n («Город»)";
        sures[90] = "91. «Аш-Шамс» \n («Солнце»)";
        sures[91] = "92. «Аль-Ляйл» \n («Ночь»)";
        sures[92] = "93. «Ад-Духа» \n («Утро»)";
        sures[93] = "94. «Аш-Шарх» \n («Раскрытие»)";
        sures[94] = "95 «Ат-Тин» \n («Смоковница»)";
        sures[95] = "96. «Аль-Аляк» \n («Сгусток»)";
        sures[96] = "97. «Аль-Кадр» \n («Могущество»)";
        sures[97] = "98. «Аль-Баййина» \n («Ясное знамение»)";
        sures[98] = "99. «Аз-Залзаля» \n («Землетрясение»)";
        sures[99] = "100. «Аль-Адият» \n («Скачущие»)";
        sures[100] = "101. «Аль-Кари’а» \n («Поражающее»)";
        sures[101] = "102. «Ат-Такасур» \n («Приумножение»)";
        sures[102] = "103. «Аль-Аср» \n («Предвечернее время»)";
        sures[103] = "104. «Аль-Хумаза» \n («Хулитель»)";
        sures[104] = "105. «Аль-Филь» \n («Слон»)";
        sures[105] = "106. «Курайш» \n («Курайшиты»)";
        sures[106] = "107. «Аль-Маун» \n («Милостыня»)";
        sures[107] = "108. «Аль-Каусар» \n («Изобилие»)";
        sures[108] = "109. «Аль-Кяфирун» \n («Неверующие»)";
        sures[109] = "110. «Ан-Наср» \n («Помощь»)";
        sures[110] = "111. «Аль-Масад» \n («Пальмовые волокна»)";
        sures[111] = "112. «Аль-Ихлас» \n («Очищение веры»)";
        sures[112] = "113. «Аль-Фаляк» \n («Рассвет»)";
        sures[113] = "114. «Ан-Нас» \n («Люди»)";
        sures[114] = "Дуа после прочтения Корана";
    }

    private void initMap() {
        // Инициализация HashMap
        suresName.addAll(Arrays.asList(sures));
    }

    private void initSuresContent() {
        int a = sura.getVerses().size();
        for (int i = 0; i < a; ++i) {
            suresContent.add(Integer.toString(i));
        }
    }

}