import java.util.HashSet;

/**
 * Collection接口包含了List和Set接口,作为单列集合
 * List存储数据是不去重的
 * Set存储数据是会去重的.这里来研究下Set, HashSet完全是基于HashMap实现的数据存储.
 * @date:2020/6/3 12:14
 */
public class HashSetTest {

    public void test01(){

        HashSet<Object> sets = new HashSet<>();
        sets.add("1");
        sets.add("1");
    }

}
