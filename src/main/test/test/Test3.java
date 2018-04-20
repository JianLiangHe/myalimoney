package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求：推送信息，每次只能推500个用户。现在我选了50001个用户在一个集合里面，
 * 如何分组，每次只推送500个用户,分好次数 推送信息给用户
 */
public class Test3 {

    public static void main(String[] args) {
        //初始化用户
        List list = new ArrayList();
        for(int i=0; i<100; i++){
            list.add("user_"+i);
        }

        push(list, 20);
    }

    /**
     * 推送
     * @param list  所有用户集合
     * @param num   每次推送人数
     */
    public static void push(List list, int num){
        int index = 0;//初始化索引
        int cnt = Math.round(list.size()/num);//获取推送次数,用户人数/每次推送人数
        List pushList = new ArrayList();
        for(int i=0; i<cnt; i++){
            for(int j=0; j<num; j++){
                try {
                    System.out.println("推送用户: "+list.get(index));
                    pushList.add(list.get(index++));
                } catch (RuntimeException e) {
                    System.out.println("索引溢出...");
                    break;
                }
            }
            System.out.println("==================分割线====================");
            pushList.clear();
        }
    }

}
