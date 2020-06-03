import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap其实就是数组+单项链表结构,核心为:Node<E><k,v>[],node的field为hash,key,value,next单向指向.
 * Hash冲突:
 * ->hash(key)的值并不能保证唯一
 * ->hash(key)/size,不同的hash值,也可能变成同样的结果
 * 解决方法:
 * ->开放寻址法
 * ->链表法
 *  ->进一步,红黑树
 *  ->进一步,跳表
 * @date:2020/6/2 14:08
 */
public class HashMapTest {

    @Test
    public void test01(){
        HashMap<Object, Object> map = new HashMap<>();
        //这里1->"a"会存储在HashMap中Node<E><k,v>数组中的hash&(capacity-1)/size节点
        map.put(1,"a");
        //这里"a"->"b",存储的时候hash对应的Node数组中的index中如果有了node存在,则
        //在new Node<hash,k,v> 放置在index的首个node.next指向中.
        map.put("a","b");
        //查找某个值得时候,首先看它对应得hash在HashMap中的index,再获取Node<E><k,v> table[index]获取node节点
        //node.hash && node.key 如果相等,则返回本node节点;如果不等,则node.next获取下一个节点,进行上述重复操作
        //直到相等位置.返回node节点的value
        Object value = map.get("a");

    }

    /**测试HashMap的扩容*/
    @Test
    public void test02(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put(1,1);
        map.put("a",1);
        map.put("b",1);
        map.put(2,1);
        map.put(3,1);
        map.put(4,1);
        map.put(5,1);
        map.put(6,1);
        map.put(7,1);
        map.put(8,1);
        map.put(9,1);
        map.put(10,1);
        map.put(11,1);
        //HashMap的首次扩容后,容量为16,负载系数为0.75即3/4,负载阈值=12
        //里面添加了12个元素后,达到负载阈值.
        map.put(12,1);
        //添加第13个元素的时候,突破负载阈值,会进行第二次扩容!
        //除第一次扩容外,每次扩容,容器容量翻倍,负载系数仍是0.75
        map.put(13,1);

        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        for (Map.Entry entry:entries){
            System.out.println(entry.getKey()+"," + entry.getValue());
        }

        Set<Object> keys = map.keySet();
        for (Object key:keys){
            System.out.println(key);
        }

    }


}
