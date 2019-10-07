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
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        if (null != br) {

            int N = Integer.parseInt(br.readLine());
            Map<String, String> firstMap = new LinkedHashMap<String, String>();

            for (int i = 0; i < N; i++) {
                String info[] = br.readLine().split(",");
                // 组合航班号与座位号，作为唯一 ID
                firstMap.put(info[0] + info[1], info[2]);
            }

            int M = Integer.parseInt(br.readLine());
            Map<String, String> secondMap = new LinkedHashMap<String, String>();
            for (int i = 0; i < M; i++) {
                String info[] = br.readLine().split(",");
                String name = firstMap.get(info[0] + info[1]);
                firstMap.remove(info[0] + info[1]);
                secondMap.put(info[2] + info[3], name);
            }

            for (String key : secondMap.keySet()) {
                firstMap.put(key, secondMap.get(key));
            }

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