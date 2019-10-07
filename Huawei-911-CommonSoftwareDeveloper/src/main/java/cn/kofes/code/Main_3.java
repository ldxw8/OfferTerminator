package cn.kofes.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 通过 70% 的测试用例
 */
public class Main_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        if (null != br) {

            /* 原始航班表 */

            int N = Integer.parseInt(br.readLine());
            Map<String, String> firstMap = new LinkedHashMap<String, String>();
            for (int i = 0; i < N; i++) {
                // Sample: CZ7132,A1,ZHANGSAN
                String info[] = br.readLine().split(",");

                // 组合航班号与座位号作为唯一 ID
                // TODO 直接修改为 "航班号,座位号",便于格式化的输出
                if ( !firstMap.constainsKey(info[0] + info[1]) ) { // 检查航班记录是否已使用
                    firstMap.put(info[0] + info[1], info[2]);
                }
            }

            /* 航班改签表 */

            int M = Integer.parseInt(br.readLine());
            Map<String, String> secondMap = new LinkedHashMap<String, String>();
            for (int i = 0; i < M; i++) {
                // Sample: CZ7132,A1,CZ7156,A2
                String info[] = br.readLine().split(",");

                // 同时操作：在原始航班表中移除需要改签的条目，同时把移除项中的客户赋值给新记录 (改签记录)
                if ( !firstMap.containsKey(info[0] + info[1]) ) { // 检查是否存在该航班记录
                    String name = firstMap.get(info[0] + info[1]);
                    firstMap.remove(info[0] + info[1]);
                    secondMap.put(info[2] + info[3], name);
                }
            }

            // 将改签好的航班记录添加到原始航班表中

//            Iterator<String, String> iterator = hashSet.iterator();
//            while ( iterator.hasNext() ) {
//                firstMap.put(iterator.getKey(),iterator.getValue()  );
//                iterator.next();
//            }

            for (String key : secondMap.keySet()) {
                firstMap.put(key, secondMap.get(key));
            }

            // TODO 将原始航班表中的键取出来排序；将排完序的键放入 firstMap 中取值；键值搭配输出即可

            Map<String, String> thirMap =  new LinkedHashMap<String, String>();
            for ( String key  :  firstMap.keySet() ) {
                thirMap.put( key.substring(0,6)+firstMap.get(key), key.substring(6) );
            }
            firstMap = new LinkedHashMap<String, String>();
            for ( String key  :  thirMap.keySet() ) {
                firstMap.put( key.substring(0,6)+thirMap.get(key), key.substring(6) );
            }

            String[] keySet = new String[firstMap.size()];
            Object[]  objectSet = firstMap.keySet().toArray();
            for (int i = 0; i < keySet.length; i++) {
                keySet[i] = objectSet[i].toString();
            }
            Arrays.sort(keySet);

            for ( String key : keySet ) {
                System.out.println(
                        key.substring(0, 6) + "," +
                         key.substring(6) + "," +
                         firstMap.get(key)
                );
            }
        }
    }
}