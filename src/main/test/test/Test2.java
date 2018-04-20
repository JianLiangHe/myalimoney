package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        /*String str = "1,12,3,4,5,6";
        String[] strs = str.split(",");
        List<Long> list = new ArrayList<Long>();
        for(int i=0; i<strs.length; i++){
            if(Long.parseLong(strs[i])<=3) continue;
            list.add(Long.parseLong(strs[i]));
        }
        System.out.println(list.size());
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }*/
        //test();
        String str2 = "1,12,3,4,5,6";
        splicToLongArray(str2, ",");
    }

    public static void test() {
        String str = "12";
        String[] strs = str.split(",");
        System.out.println(strs[0]);
    }

    public static void splicToLongArray(String str, String regex) {

        String[] strs = str.split(regex);
        Long[] result = new Long[strs.length];
        for(int i = 0; i < strs.length; i++) {
            result[i] = Long.parseLong(strs[i]);
        }

        for(Long l : result) {
            System.out.println(l);
        }
    }

}
