package cn.kofes.code;

import java.util.*;

/**
 * <pre>
 * author: Kofe
 * blog  : https://www.kofes.cn
 * time  : 2019/10/07
 * desc  :
 * ==============================================
 * 华为 2020 届校园招聘 -- 软件题 -- 编程 3
 * 通过 70% 的测试用例 ( 程序已修改，有待重新测试 )
 * ==============================================
 * 题目描述：
 * X 航空公司经营 N 条航线，最近因天气原因取消了一批航班，
 * 需对乘客的机票进行改签。即根据改签的航班号，对出售的机票信息进行修改。
 * ==============================================
 * </pre>
 */
public class Main_3 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        if (null != scanner) {

            /* 原始航班表 */

            int N = Integer.parseInt(scanner.next());
            Map<String, String> firstMap = new LinkedHashMap<String, String>(N);
            for (int i = 0; i < N; i++) {
                // Sample: CZ7132,A1,ZHANGSAN
                String info[] = scanner.next().split(",");

                // 组合航班号与座位号作为唯一 ID
                // "航班号,座位号" ( 加入 "," 是为了便于格式化输出 )
                String id = info[0] + "," + info[1];
                if (!firstMap.containsKey(id)) { // 检查航班记录是否已使用
                    firstMap.put(id, info[2]);
                }
            }

            /* 航班改签表 */

            int M = Integer.parseInt(scanner.next());
            Map<String, String> secondMap = new LinkedHashMap<String, String>();
            for (int i = 0; i < M; i++) {
                // Sample: CZ7132,A1,CZ7156,A2
                String info[] = scanner.next().split(",");

                // 同时操作：
                // 在原始航班表中移除需要改签的条目，
                // 同时把移除项中的客户赋值给新记录 (改签记录)
                String id = info[0] + "," + info[1];
                if (!firstMap.containsKey(id)) { // 检查是否存在该航班记录
                    String name = firstMap.get(id);
                    firstMap.remove(id);
                    secondMap.put(info[2] + "," + info[3], name);
                }
            }

            // 将改签好的航班记录添加到原始航班表中
            for (String key : secondMap.keySet()) {
                firstMap.put(key, secondMap.get(key));
            }

            // 1) 将原始航班表中的键取出来排序；
            // 2) 将排完序的键放入 firstMap 中取值；
            // 3) 键值搭配输出即可
            Object[] keys = firstMap.keySet().toArray();
            Arrays.sort(keys);

            for (Object key : keys) {
                System.out.println(key.toString() + "," + firstMap.get(key));
            }

        }
    }
}