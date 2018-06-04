package org.sample;

import by.kir.Jop;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class JopTest {

    @Test
    public void test1() {
        Pojo pojo = getPojoWithOutNulls();
        Assert.assertEquals("h1",pojo.getSubPojo().getSubSubPojo().getTitle());
        Assert.assertEquals("h14",pojo.getSubPojoList().get(0).getSubSubPojoList().get(0).getTitle());
    }

    @Test
    public void test2() {
        Pojo pojo = Jop.of(getPojoWithOutNulls());
        SubPojo subPojo = pojo.getSubPojo();
        SubSubPojo subSubPojo = subPojo.getSubSubPojo();
        String title = subSubPojo.getTitle();
        Assert.assertEquals("h1", title);

        List<SubPojo> subPojoList = pojo.getSubPojoList();
        SubPojo subPojo1 = subPojoList.get(0);
        List<SubSubPojo> subSubPojoList = subPojo1.getSubSubPojoList();
        SubSubPojo subSubPojo1 = subSubPojoList.get(0);
        String title1 = subSubPojo1.getTitle();
        Assert.assertEquals("h14", title1);
    }

    public Pojo getPojoWithOutNulls() {
        Pojo pojo = new Pojo(
            new SubPojo(new SubSubPojo("h1"), new SubSubPojo[]{new SubSubPojo("h2"), new SubSubPojo("h3")},
                        Arrays.asList(new SubSubPojo("h4"), new SubSubPojo("h5"))),
            new SubPojo[]{
                new SubPojo(new SubSubPojo("h6"), new SubSubPojo[]{new SubSubPojo("h7"), new SubSubPojo("h8")},
                            Arrays.asList(new SubSubPojo("h9"), new SubSubPojo("h10")))},
            Arrays.asList(
                new SubPojo(new SubSubPojo("h11"), new SubSubPojo[]{new SubSubPojo("h12"), new SubSubPojo("h13")},
                            Arrays.asList(new SubSubPojo("h14"), new SubSubPojo("h15")))));

        return pojo;
    }
}
