package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        List<Province> list = createProvinceList("provinces.csv");

//        list.sort(new Comparator<Province>() {
//            @Override
//            public int compare(Province o1, Province o2) {
//                return o1.getNameEn().compareTo(o2.getNameEn());
//            }
//        });

        list.sort(new Comparator<Province>() {
            @Override
            public int compare(Province o1, Province o2) {
                Collator coll = Collator.getInstance(new Locale("th", "TH"));
                return coll.compare(o1.getNameTh(), o2.getNameTh());
            }
        });
        showList(list);
    }

    public static void showList(List<Province> list) {
        for (Province province : list) {
            System.out.printf("%s %s %s %,.2f %d%n",
                    province.getNameTh(), province.getNameEn(), province.getAbbr(),
                    province.getArea(), province.getNameThLength());
        }
    }

    public static List<Province> createProvinceList(String fileName) {
        List<Province> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                list.add(new Province(data[0], data[1], data[2], Float.parseFloat(data[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

