import org.junit.Test;

import java.util.ArrayDeque;

/**
 * Queue是一个很有意思的Collection集合子类
 * 同样是单值存储.底层采用的是数组,为了具备Queue的特性,先进先出.增加了属性int head,int tail.
 * 取值的时候,会从tail取,存值的时候,从head 这个index开始存.
 *
 * @date:2020/6/3 15:12
 */
public class ArrayDequeTest {

    @Test
    public void test01(){
        ArrayDeque arrayDeque = new ArrayDeque();
        //执行的是内部的addLast
        arrayDeque.add("a");
        //执行的也是内部的addLast,不过经过一个offerLast这个去调用
        arrayDeque.offer("b");
        //这个违背了Queue的特性,但是也是一个拓展.添加到了head
        arrayDeque.addFirst("c");

        /**
         * 但是不管是poll还是pop,取出后,原先的元素值赋值为null
         * 这个实现方法有点类似于Consumer的意思,消费一次就没了.
         * 所以消息队列中间件中采用Queue这个单列集合,就是因为这个特性.
         */

        //取出Queue中最前面的元素,head元素.pollFirst()
        arrayDeque.poll();

        //取出Queue中最前面的元素,removeFirst()->pollFirst()同时判断null异常
        arrayDeque.pop();

        Object[] objects = arrayDeque.toArray();
        for (Object obj:objects){
            //这里经过上述的存取后,剩下的元素,我预判为b
            System.out.println(obj);
        }

    }

}
