package com.dowei.phonesys;

import org.testng.annotations.Test;

import java.util.List;

public class TestPhoneDao {
    PhoneDao dao = new PhoneDao();

    @Test
    public void testAdd() {
        Phone phone = new Phone(null, "aa", "aa", "aa", 234.4);
        dao.add(phone);
    }

    @Test
    public void testDel() {
        dao.del(1);
    }

    @Test
    public void testUpdate() {
        Phone phone = new Phone(2, "bb", "bb", "bb", 234.4);
        dao.update(phone);
    }

    @Test
    public void testGetOne() {
        Phone one = dao.getOne(2);
        System.out.println(one);
    }

    @Test
    public void testGetAll() {
        List<Phone> all = dao.getAll();
        for (Phone phone : all) {
            System.out.println("================");
            System.out.println(phone);
        }
    }
}
