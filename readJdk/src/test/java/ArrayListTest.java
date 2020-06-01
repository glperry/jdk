import org.junit.Test;

import java.util.*;

/**
 * @date:2020/5/30 15:40
 */
public class ArrayListTest {


    @Test
    public void test01(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        Object[] array = list.toArray();//jdk8中,返回Integer[],jdk9+返回的是object[]
        //jdk8中,simpleName是Integer[],这是个bug
        System.out.println(array.getClass().getSimpleName());

        //这里是上面返回数组的证明:jdk8中运行,会报错. jdk9中正常.
        array[0] = new Object();

    }

    @Test
    public void test02(){
        //进行2进制运算,10的二进制为权重+指数,二进制权重为2,指数为位数
        //10=8+2=2^3+2^1=1010>>1=101=2^0+2^2=5
        System.out.println(22>>1);

    }

    @Test
    public void test03(){
        ArrayList<String> strings = new ArrayList<String>(Arrays.asList("gl", "glperry"));
        System.out.println(strings);
        String remove = strings.remove(0);
        System.out.println("remove element:"+remove);
        System.out.println(strings);

    }

    @Test
    public void test04(){
        Object[] objs ={1,2,3};
        Object obj = objs[0];
        objs[0]=4;
        System.out.println(obj);
        System.out.println(objs);

        Arrays.asList(objs).forEach(System.out::println);
    }

    @Test
    public void test05(){
        //空数组的hashCode=0
        ArrayList<Object> objects = new ArrayList<>();
        int i = objects.hashCode();
        objects.add("value1");
        int i2 = objects.hashCode();
        System.out.println(i);
        System.out.println(i2);

        int hex1 = 0x01;
        System.out.println(hex1);
        int hex2 = 0x0f;
        System.out.println(hex2);

        byte[] bytes = "value1".getBytes();
        for (int j = 0; j < bytes.length; j++) {
            System.out.println(bytes[j]);
        }
        //字符转数字,其实是因为每个字符有对应的数字,这个规则表就是ASCII(美国信息交换标准码)
        // --American Standard Code for Information Interchange
        System.out.println(Integer.valueOf('v'));
    }

    @Test
    public void test06(){
        String originalValue ="value1";
        //getByte()是获取字符对应的ASCII数字,组成数组
        byte[]  value = originalValue.getBytes();
            int h = 0;
            for (byte v : value) {
                System.out.println("h的值:"+h);
                System.out.println("v的值:"+v);
                System.out.println("hn的值=31h+v:"+(v & 0xff));
                //0xff=15^2+15^1=240,进行位运算,需要转换位2进制
                //0xff的二进制位11110000
                //v的值为127,10000000为128的二进制 0111000
                //这里是一个比较简单的hash运算:31 x 原hash+ 新value的ASCII
                h = 31 * h + (v & 0xff);
            }
        System.out.println(h);

    }

    /**
     *决定hash碰撞概率的两个指标是:
     * 1.hash这个混杂算法的复杂度:这里只是31*hash+inputValue
     * 2.hash这个混杂算法的计算次数:这里是按照字符串的字符个数来确定累加计算次数
     */

    static ArrayList<Object> list = new ArrayList<>();
    //String的hash算法
    public int stringToHash(Integer salt,String value){
        //这样,一个字符串就有了特定的整数数组
        byte[] bytes = value.getBytes();
        int hash = 0;
        for (int i = 0; i < bytes.length; i++) {
            hash = salt*hash+bytes[i];
        }
        return hash;
    }

    //Array的hash算法,在String的Hash算法上面,再做了一层类String的Hash算法
    public int arrayToHash(Integer salt,ArrayList<String> list){
        int hash = 1;
        for (int i = 0; i < list.size(); i++) {
            hash = 31*hash + stringToHash(salt,list.get(i));
        }
        return hash;
    }

    @Test
    public void createStringHash(){
        int hash = stringToHash(30,"value1");
        System.out.println(hash);
    }

    @Test
    public void createArrayHash(){
        ArrayList<String> strs = new ArrayList<>();
        strs.add("value1");
        int hash = arrayToHash(31, strs);
        System.out.println(hash);
    }

    @Test
    public void iteratorTest(){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("1");
        Iterator<Object> iterator = objects.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

    }

    /**时间复杂度
     * (Function(int n,int x)的总timeUnit =1+n+n+1+n+1=3n+3
     * T(n) =O(Function(int n,int x)) = O(3n+3)
     * 忽略低阶和常量,T(n) =O(n)
     * 最好情况时间复杂度:x=1,T(n)=O(1)
     * 最差情况时间复杂度:x
     * */
    public int Function(int n, int x) {
        int sum = 0; //1个timeUnit
        for (int i = 1; i <= n; ++i) { //n个timeUnit
            if (i == x) //n个timeUnit
                break; //1个timeUnit
            sum += i; //n个timeUnit
        }
        return sum; //1个timeUnit
    }
}
