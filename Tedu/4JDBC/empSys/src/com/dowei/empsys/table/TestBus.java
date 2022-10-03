package com.dowei.empsys.table;

import java.util.ArrayList;

public class TestBus {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> busCompany = new ArrayList<>();
        ArrayList<String> bus1 = new ArrayList<>();
        ArrayList<String> bus2 = new ArrayList<>();
        ArrayList<String> bus3 = new ArrayList<>();
        ArrayList<String> bus4 = new ArrayList<>();
        ArrayList<String> bus5 = new ArrayList<>();
        bus1.add("乘客11");
        bus1.add("乘客12");
        bus1.add("乘客13");
        bus1.add("乘客14");
        busCompany.add(bus1);

        bus2.add("乘客21");
        bus2.add("乘客22");
        bus2.add("乘客23");
        busCompany.add(bus2);

        bus3.add("乘客31");
        bus3.add("乘客32");
        bus3.add("乘客33");
        bus3.add("乘客34");
        bus3.add("乘客35");
        busCompany.add(bus3);

        bus4.add("乘客41");
        bus4.add("乘客42");
        bus4.add("乘客43");
        busCompany.add(bus4);

        bus5.add("乘客51");
        bus5.add("乘客52");
        bus5.add("乘客53");
        bus5.add("乘客54");
        bus5.add("乘客55");
        bus5.add("乘客56");
        busCompany.add(bus5);

        for(ArrayList<String> bus : busCompany){
            for(String people : bus){
                System.out.println(people);
            }
        }
    }
}
