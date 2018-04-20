package test;

import java.util.HashMap;
import java.util.Map;

public class Test4 {

    public static void main(String[] args) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", 200183);
        long cid = 200183;
        System.out.println(Long.parseLong(result.get("id").toString())==cid);
    }

}
