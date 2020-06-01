import org.junit.Test;

import java.util.LinkedList;

/**
 * @date:2020/6/1 15:20
 */
public class LinkedListTest {

    /**add*/
    @Test
    public void test01(){
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add("a");

        FeignLinkedList<Object> feignLinkedList = new FeignLinkedList<>();
        feignLinkedList.add("a");
        feignLinkedList.add("b");
        feignLinkedList.add("c");
        System.out.println(feignLinkedList.first.e);
        System.out.println(feignLinkedList.last.pre.e);
        System.out.println(feignLinkedList.first.next.e);
        System.out.println(feignLinkedList.first.next.next.e);

    }

    /**
     * 测试完成,完成仿造LinkedList类并完成添加操作!!!
     * Congratulations!
     * */
    class FeignLinkedList<E>{
        //构造方法,无参
        FeignLinkedList(){

        }

        /** 字段*/
        transient int size;
        transient Node<E> first;
        transient Node<E> last;

        class Node<E>{
            E e;
            Node<E> pre;
            Node<E> next;

            public Node(E e, Node<E> pre, Node<E> next) {
                this.e = e;
                this.pre = pre;
                this.next = next;
            }
        }

        /**考虑两种情况,首次添加和后续添加*/
        public boolean add(E e){
            Node<E> l = last;
            Node<E> newNode = new Node<>(e, l, null);
            last=newNode;
            /**
             * first,List
             * then,Node
             * */
            if (l==null){ //首次添加
                first=newNode; //List的首节点也是newNode
            }else{ //二次添加
                l.next = newNode;
            }
            size++;
            return true;
        }
    }

    /**add(int index,E e)*/
    @Test
    public void test02(){
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.add(1,"e");

    }

    /**add(int index,E e)*/
    @Test
    public void test03(){
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.addLast("e");

    }

    @Test
    public void StringEqualsTest(){
        //首先,定义一个变量,指向String对象
        String a = "a";
        String b = a;
        boolean equalsRes = a.equals(b);

        boolean equalsRes2 = "a".equals(new String("a"));

    }




}
