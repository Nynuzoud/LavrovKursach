package ru.sergey.data;


import java.util.ArrayList;
import java.util.HashMap;

public class DefaultData {
    public final static int RASHOD_PG_BASE1 = 15000;
    public final static int RASHOD_PG_BASE2 = 17000;
    public final static int RASHOD_PG_BASE3 = 11000;
    public final static int RASHOD_PG_BASE4 = 13000;
    public final static int RASHOD_PG_BASE5 = 12000;
    public final static int RASHOD_PG_BASE6 = 15000;
    public final static int RASHOD_PG_BASE7 = 17000;
    public final static int RASHOD_PG_BASE8 = 14000;
    public final static int MIN_RASHOD_PG = 10000;
    public final static int MAX_RASHOD_PG = 20000;
    public final static double RASHOD_KOKSA_BASE1 = 64.25;
    public final static double RASHOD_KOKSA_BASE2 = 66.76;
    public final static double RASHOD_KOKSA_BASE3 = 56.08;
    public final static double RASHOD_KOKSA_BASE4 = 49.78;
    public final static double RASHOD_KOKSA_BASE5 = 62.92;
    public final static double RASHOD_KOKSA_BASE6 = 60.02;
    public final static double RASHOD_KOKSA_BASE7 = 81.68;
    public final static double RASHOD_KOKSA_BASE8 = 69.70;
    public final static double EKV_ZAM_KOKSA_BASE1 = 0.59;
    public final static double EKV_ZAM_KOKSA_BASE2 = 0.53;
    public final static double EKV_ZAM_KOKSA_BASE3 = 0.85;
    public final static double EKV_ZAM_KOKSA_BASE4 = 0.59;
    public final static double EKV_ZAM_KOKSA_BASE5 = 0.75;
    public final static double EKV_ZAM_KOKSA_BASE6 = 0.79;
    public final static double EKV_ZAM_KOKSA_BASE7 = 0.87;
    public final static double EKV_ZAM_KOKSA_BASE8 = 0.77;
    public final static double PROIZV_CHUG_BASE1 = 146.4;
    public final static double PROIZV_CHUG_BASE2 = 136.4;
    public final static double PROIZV_CHUG_BASE3 = 134.3;
    public final static double PROIZV_CHUG_BASE4 = 122.3;
    public final static double PROIZV_CHUG_BASE5 = 138.2;
    public final static double PROIZV_CHUG_BASE6 = 138.8;
    public final static double PROIZV_CHUG_BASE7 = 191.4;
    public final static double PROIZV_CHUG_BASE8 = 151.6;
    public final static double SOD_SI_CHUG_BASE1 = 0.59;
    public final static double SOD_SI_CHUG_BASE2 = 0.51;
    public final static double SOD_SI_CHUG_BASE3 = 0.66;
    public final static double SOD_SI_CHUG_BASE4 = 0.60;
    public final static double SOD_SI_CHUG_BASE5 = 0.535;
    public final static double SOD_SI_CHUG_BASE6 = 0.44;
    public final static double SOD_SI_CHUG_BASE7 = 0.40;
    public final static double SOD_SI_CHUG_BASE8 = 0.60;
    public final static double MIN_SI = 0.4;
    public final static double MAX_SI = 0.8;
    public final static double IZM_CHUG_PG1 = -0.0007295;
    public final static double IZM_CHUG_PG2 = -0.0006695;
    public final static double IZM_CHUG_PG3 = 0;
    public final static double IZM_CHUG_PG4 = -0.00072373;
    public final static double IZM_CHUG_PG5 = -0.0007724;
    public final static double IZM_CHUG_PG6 = -0.0006872;
    public final static double IZM_CHUG_PG7 = -0.0007284;
    public final static double IZM_CHUG_PG8 = -0.0007305;
    public final static double IZM_CHUG_KOKS1 = -0.00297;
    public final static double IZM_CHUG_KOKS2 = -0.00297;
    public final static double IZM_CHUG_KOKS3 = -0.002928;
    public final static double IZM_CHUG_KOKS4 = -0.002897;
    public final static double IZM_CHUG_KOKS5 = -0.00297;
    public final static double IZM_CHUG_KOKS6 = -0.00297;
    public final static double IZM_CHUG_KOKS7 = -0.003316;
    public final static double IZM_CHUG_KOKS8 = -0.00356;
    public final static double IZM_SI_PG1 = 0.0001186;
    public final static double IZM_SI_PG2 = 0.0000634;
    public final static double IZM_SI_PG3 = 0.0000642;
    public final static double IZM_SI_PG4 = 0.0000702;
    public final static double IZM_SI_PG5 = 0.0000814;
    public final static double IZM_SI_PG6 = 0.0000789;
    public final static double IZM_SI_PG7 = 0.0001231;
    public final static double IZM_SI_PG8 = 0.0000953;
    public final static double IZM_SI_KOKS1 = 0.0001198;
    public final static double IZM_SI_KOKS2 = 0.0001187;
    public final static double IZM_SI_KOKS3 = 0.0000987;
    public final static double IZM_SI_KOKS4 = 0.000119;
    public final static double IZM_SI_KOKS5 = 0.000109;
    public final static double IZM_SI_KOKS6 = 0.0001143;
    public final static double IZM_SI_KOKS7 = 0.000143;
    public final static double IZM_SI_KOKS8 = 0.000148;
    public final static double IZM_SI_PROIZV1 = -0.0282;
    public final static double IZM_SI_PROIZV2 = -0.0292;
    public final static double IZM_SI_PROIZV3 = -0.03;
    public final static double IZM_SI_PROIZV4 = -0.0229;
    public final static double IZM_SI_PROIZV5 = -0.0277;
    public final static double IZM_SI_PROIZV6 = -0.0231;
    public final static double IZM_SI_PROIZV7 = -0.0154;
    public final static double IZM_SI_PROIZV8 = -0.0141;
    public final static int REZERV_PG = 120000;
    public final static int ZAPAS_KOKS = 520;
    public final static int TREB_PROIZV_CHUG = 1100;

    public static ArrayList<HashMap<String, Double>> getDefaultArrayList() {
        return defaultArrayList;
    }

    public static void setDefaultArrayList(ArrayList<HashMap<String, Double>> defaultArrayList) {
        DefaultData.defaultArrayList = defaultArrayList;
    }

    private static ArrayList<HashMap<String, Double>> defaultArrayList;

    public void createDefaultData() {
        defaultArrayList = new ArrayList<>();
        HashMap<String, Double> hashMap = new HashMap<>();

        //Furnace 1
        hashMap.put("rashodPGBase1", (double) RASHOD_PG_BASE1);
        hashMap.put("minRashodPG1", (double) MIN_RASHOD_PG);
        hashMap.put("maxRashodPG1", (double) MAX_RASHOD_PG);
        hashMap.put("rashodKoksaBase1", RASHOD_KOKSA_BASE1);
        hashMap.put("ekvZamKoksaBase1", EKV_ZAM_KOKSA_BASE1);
        hashMap.put("proizvChugBase1", PROIZV_CHUG_BASE1);
        hashMap.put("sodSiChugBase1", SOD_SI_CHUG_BASE1);
        hashMap.put("minSi1", MIN_SI);
        hashMap.put("maxSi1", MAX_SI);
        hashMap.put("izmChugPG1", IZM_CHUG_PG1);
        hashMap.put("izmChugKoks1", IZM_CHUG_KOKS1);
        hashMap.put("izmSiPG1", IZM_SI_PG1);
        hashMap.put("izmSiKoks1", IZM_SI_KOKS1);
        hashMap.put("izmSiProizv1", IZM_SI_PROIZV1);
        hashMap.put("rezervPG", (double) REZERV_PG);
        hashMap.put("zapasKoks", (double) ZAPAS_KOKS);
        hashMap.put("trebProizvChug", (double) TREB_PROIZV_CHUG);
        defaultArrayList.add(hashMap);

        //Furnace 2
        hashMap = new HashMap<>();
        hashMap.put("rashodPGBase2", (double) RASHOD_PG_BASE2);
        hashMap.put("minRashodPG2", (double) MIN_RASHOD_PG);
        hashMap.put("maxRashodPG2", (double) MAX_RASHOD_PG);
        hashMap.put("rashodKoksaBase2", RASHOD_KOKSA_BASE2);
        hashMap.put("ekvZamKoksaBase2", EKV_ZAM_KOKSA_BASE2);
        hashMap.put("proizvChugBase2", PROIZV_CHUG_BASE2);
        hashMap.put("sodSiChugBase2", SOD_SI_CHUG_BASE2);
        hashMap.put("minSi2", MIN_SI);
        hashMap.put("maxSi2", MAX_SI);
        hashMap.put("izmChugPG2", IZM_CHUG_PG2);
        hashMap.put("izmChugKoks2", IZM_CHUG_KOKS2);
        hashMap.put("izmSiPG2", IZM_SI_PG2);
        hashMap.put("izmSiKoks2", IZM_SI_KOKS2);
        hashMap.put("izmSiProizv2", IZM_SI_PROIZV2);
        hashMap.put("rezervPG", (double) REZERV_PG);
        hashMap.put("zapasKoks", (double) ZAPAS_KOKS);
        hashMap.put("trebProizvChug", (double) TREB_PROIZV_CHUG);
        defaultArrayList.add(hashMap);

        //Furnace 3
        hashMap = new HashMap<>();
        hashMap.put("rashodPGBase3", (double) RASHOD_PG_BASE3);
        hashMap.put("minRashodPG3", (double) MIN_RASHOD_PG);
        hashMap.put("maxRashodPG3", (double) MAX_RASHOD_PG);
        hashMap.put("rashodKoksaBase3", RASHOD_KOKSA_BASE3);
        hashMap.put("ekvZamKoksaBase3", EKV_ZAM_KOKSA_BASE3);
        hashMap.put("proizvChugBase3", PROIZV_CHUG_BASE3);
        hashMap.put("sodSiChugBase3", SOD_SI_CHUG_BASE3);
        hashMap.put("minSi3", MIN_SI);
        hashMap.put("maxSi3", MAX_SI);
        hashMap.put("izmChugPG3", IZM_CHUG_PG3);
        hashMap.put("izmChugKoks3", IZM_CHUG_KOKS3);
        hashMap.put("izmSiPG3", IZM_SI_PG3);
        hashMap.put("izmSiKoks3", IZM_SI_KOKS3);
        hashMap.put("izmSiProizv3", IZM_SI_PROIZV3);
        hashMap.put("rezervPG", (double) REZERV_PG);
        hashMap.put("zapasKoks", (double) ZAPAS_KOKS);
        hashMap.put("trebProizvChug", (double) TREB_PROIZV_CHUG);
        defaultArrayList.add(hashMap);

        //Furnace 4
        hashMap = new HashMap<>();
        hashMap.put("rashodPGBase4", (double) RASHOD_PG_BASE4);
        hashMap.put("minRashodPG4", (double) MIN_RASHOD_PG);
        hashMap.put("maxRashodPG4", (double) MAX_RASHOD_PG);
        hashMap.put("rashodKoksaBase4", RASHOD_KOKSA_BASE4);
        hashMap.put("ekvZamKoksaBase4", EKV_ZAM_KOKSA_BASE4);
        hashMap.put("proizvChugBase4", PROIZV_CHUG_BASE4);
        hashMap.put("sodSiChugBase4", SOD_SI_CHUG_BASE4);
        hashMap.put("minSi4", MIN_SI);
        hashMap.put("maxSi4", MAX_SI);
        hashMap.put("izmChugPG4", IZM_CHUG_PG4);
        hashMap.put("izmChugKoks4", IZM_CHUG_KOKS4);
        hashMap.put("izmSiPG4", IZM_SI_PG4);
        hashMap.put("izmSiKoks4", IZM_SI_KOKS4);
        hashMap.put("izmSiProizv4", IZM_SI_PROIZV4);
        hashMap.put("rezervPG", (double) REZERV_PG);
        hashMap.put("zapasKoks", (double) ZAPAS_KOKS);
        hashMap.put("trebProizvChug", (double) TREB_PROIZV_CHUG);
        defaultArrayList.add(hashMap);

        //Furnace 5
        hashMap = new HashMap<>();
        hashMap.put("rashodPGBase5", (double) RASHOD_PG_BASE5);
        hashMap.put("minRashodPG5", (double) MIN_RASHOD_PG);
        hashMap.put("maxRashodPG5", (double) MAX_RASHOD_PG);
        hashMap.put("rashodKoksaBase5", RASHOD_KOKSA_BASE5);
        hashMap.put("ekvZamKoksaBase5", EKV_ZAM_KOKSA_BASE5);
        hashMap.put("proizvChugBase5", PROIZV_CHUG_BASE5);
        hashMap.put("sodSiChugBase5", SOD_SI_CHUG_BASE5);
        hashMap.put("minSi5", MIN_SI);
        hashMap.put("maxSi5", MAX_SI);
        hashMap.put("izmChugPG5", IZM_CHUG_PG5);
        hashMap.put("izmChugKoks5", IZM_CHUG_KOKS5);
        hashMap.put("izmSiPG5", IZM_SI_PG5);
        hashMap.put("izmSiKoks5", IZM_SI_KOKS5);
        hashMap.put("izmSiProizv5", IZM_SI_PROIZV5);
        hashMap.put("rezervPG", (double) REZERV_PG);
        hashMap.put("zapasKoks", (double) ZAPAS_KOKS);
        hashMap.put("trebProizvChug", (double) TREB_PROIZV_CHUG);
        defaultArrayList.add(hashMap);

        //Furnace 6
        hashMap = new HashMap<>();
        hashMap.put("rashodPGBase6", (double) RASHOD_PG_BASE6);
        hashMap.put("minRashodPG6", (double) MIN_RASHOD_PG);
        hashMap.put("maxRashodPG6", (double) MAX_RASHOD_PG);
        hashMap.put("rashodKoksaBase6", RASHOD_KOKSA_BASE6);
        hashMap.put("ekvZamKoksaBase6", EKV_ZAM_KOKSA_BASE6);
        hashMap.put("proizvChugBase6", PROIZV_CHUG_BASE6);
        hashMap.put("sodSiChugBase6", SOD_SI_CHUG_BASE6);
        hashMap.put("minSi6", MIN_SI);
        hashMap.put("maxSi6", MAX_SI);
        hashMap.put("izmChugPG6", IZM_CHUG_PG6);
        hashMap.put("izmChugKoks6", IZM_CHUG_KOKS6);
        hashMap.put("izmSiPG6", IZM_SI_PG6);
        hashMap.put("izmSiKoks6", IZM_SI_KOKS6);
        hashMap.put("izmSiProizv6", IZM_SI_PROIZV6);
        hashMap.put("rezervPG", (double) REZERV_PG);
        hashMap.put("zapasKoks", (double) ZAPAS_KOKS);
        hashMap.put("trebProizvChug", (double) TREB_PROIZV_CHUG);
        defaultArrayList.add(hashMap);

        //Furnace 7
        hashMap = new HashMap<>();
        hashMap.put("rashodPGBase7", (double) RASHOD_PG_BASE7);
        hashMap.put("minRashodPG7", (double) MIN_RASHOD_PG);
        hashMap.put("maxRashodPG7", (double) MAX_RASHOD_PG);
        hashMap.put("rashodKoksaBase7", RASHOD_KOKSA_BASE7);
        hashMap.put("ekvZamKoksaBase7", EKV_ZAM_KOKSA_BASE7);
        hashMap.put("proizvChugBase7", PROIZV_CHUG_BASE7);
        hashMap.put("sodSiChugBase7", SOD_SI_CHUG_BASE7);
        hashMap.put("minSi7", MIN_SI);
        hashMap.put("maxSi7", MAX_SI);
        hashMap.put("izmChugPG7", IZM_CHUG_PG7);
        hashMap.put("izmChugKoks7", IZM_CHUG_KOKS7);
        hashMap.put("izmSiPG7", IZM_SI_PG7);
        hashMap.put("izmSiKoks7", IZM_SI_KOKS7);
        hashMap.put("izmSiProizv7", IZM_SI_PROIZV7);
        hashMap.put("rezervPG", (double) REZERV_PG);
        hashMap.put("zapasKoks", (double) ZAPAS_KOKS);
        hashMap.put("trebProizvChug", (double) TREB_PROIZV_CHUG);
        defaultArrayList.add(hashMap);

        //Furnace 8
        hashMap = new HashMap<>();
        hashMap.put("rashodPGBase8", (double) RASHOD_PG_BASE8);
        hashMap.put("minRashodPG8", (double) MIN_RASHOD_PG);
        hashMap.put("maxRashodPG8", (double) MAX_RASHOD_PG);
        hashMap.put("rashodKoksaBase8", RASHOD_KOKSA_BASE8);
        hashMap.put("ekvZamKoksaBase8", EKV_ZAM_KOKSA_BASE8);
        hashMap.put("proizvChugBase8", PROIZV_CHUG_BASE8);
        hashMap.put("sodSiChugBase8", SOD_SI_CHUG_BASE8);
        hashMap.put("minSi8", MIN_SI);
        hashMap.put("maxSi8", MAX_SI);
        hashMap.put("izmChugPG8", IZM_CHUG_PG8);
        hashMap.put("izmChugKoks8", IZM_CHUG_KOKS8);
        hashMap.put("izmSiPG8", IZM_SI_PG8);
        hashMap.put("izmSiKoks8", IZM_SI_KOKS8);
        hashMap.put("izmSiProizv8", IZM_SI_PROIZV8);
        hashMap.put("rezervPG", (double) REZERV_PG);
        hashMap.put("zapasKoks", (double) ZAPAS_KOKS);
        hashMap.put("trebProizvChug", (double) TREB_PROIZV_CHUG);
        defaultArrayList.add(hashMap);
    }
}
