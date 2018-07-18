package org.sample;

import by.kir.Jop;
import by.kir.Tuple;
import by.kir.lombok.hello.EnableJoptional;

@EnableJoptional
public class Main {

    public static void main(String[] args) {
        Pojo pojo = new JopTest().getPojoWithOutNulls();
        String title1 = Jop.of(pojo.getSubPojo().getSubSubPojo().getTitle());

        pojo.getSubPojo().getSubSubPojo().setTitle(null);
        String title2 = Jop.of(pojo.getSubPojo().getSubSubPojo().getTitle());
        pojo.getSubPojo().setSubSubPojo(null);
        String title3 = Jop.of(pojo.getSubPojo().getSubSubPojo().getTitle());
        pojo.setSubPojo(null);
        String title4 = Jop.of(pojo.getSubPojo().getSubSubPojo().getTitle());
        pojo = null;
        String title5 = Jop.of(pojo.getSubPojo().getSubSubPojo().getTitle());
        System.out.println("title1 = " + title1);
        System.out.println("title2 = " + title2);
        System.out.println("title3 = " + title3);
        System.out.println("title4 = " + title4);
        System.out.println("title5 = " + title5);

//        Tuple<Integer> tuple1 = (1);
    }
}
