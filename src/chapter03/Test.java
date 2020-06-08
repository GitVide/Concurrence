package chapter03;

public class Test {
    public static void main(String[] args){
        /*使用String进行字符串拼接，这是错误的用法！！！！！！！！*/
        String string = "";
        long r1 = Runtime.getRuntime().freeMemory();//获取剩余内存空间
        long t1 = System.currentTimeMillis();//获取当前时间
        for(int i = 0 ; i < 5000 ; i++) {
            string = string + i;//相当于产生了一万个对象
        }
        long r2 = Runtime.getRuntime().freeMemory();
        long t2 = System.currentTimeMillis();
        System.out.println("String占用内存:"+(r1-r2));
        System.out.println("String占用时间:"+(t2-t1));

        /*使用StringBuilder进行字符串拼接*/
        StringBuilder sb = new StringBuilder();

        long t3 = System.currentTimeMillis();
        long r3 = Runtime.getRuntime().freeMemory();

        for(int j = 0 ; j < 5000 ; j++) {
            sb.append(j);
        }
        long r4 = Runtime.getRuntime().freeMemory();
        long t4 = System.currentTimeMillis();
        System.out.println(r3);
        System.out.println(r4);
        System.out.println("StringBuilder占用内存:"+(r3-r4));
        System.out.println("StringBuilder占用时间:"+(t4-t3));;
    }
}
