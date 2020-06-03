import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 在HashMap的基础上,增加排序功能
 * 对于链表:
 * ->HashMap中链表是单向链表,解决的是hash冲突问题
 * ->LinkedHashMap中既包含了HashMap的单向链表(用于节点的next指向),
 *                  又有双向链表,指向前面插入的元素和后面插入的元素,保证顺序.
 * @date:2020/6/2 17:39
 */
public class LinkedHashMapTest {

    @Test
    public void test01(){
        //创建HashMap的时候可以指定容量和负载系数
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(20,0.85f);

    }

    @Test
    public void test02(){
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,1);
        linkedHashMap.put("a",1);

        linkedHashMap.get("a");

        //有序性,在Linked数组遍历的时候就出来了
        //通过第一个node元素/Entry元素,node.after查找遍历下一个元素
        Set<Map.Entry<Object, Object>> entries = linkedHashMap.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }


    }

    /**
     * 能够基于LinkedHaspMap实现LRU(Low Recent Use):
     * 因为LinkedHashMap中accessOrder=true,满足访问顺序
     * 链表数组中,最近访问的放置在了填表的head,越没有访问频次的放在了tail
     * @param <K>
     * @param <V>
     */
    class LRUCache<K,V>extends LinkedHashMap<K,V>{
        private final int cacheSize =0;

        public LRUCache(int cacheSize){
            super((int)Math.ceil(cacheSize/0.75)+1,0.75f,true);
            cacheSize=cacheSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size()>cacheSize;
        }
    }


}
