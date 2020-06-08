package homework;

public class MyClass {
    public MyClass(int a, int b) {
        int max = a > b ? a : b;
        System.out.println("最大值为：" + max);
    }

    public MyClass(double a, double b, double c) {
        System.out.println("三者乘积为" + a * b * c);
    }

    public MyClass(String s1, String s2) {
        if (s1.equals(s2)) {
            System.out.println("两者相同");
        } else {
            System.out.println("两者不同");
        }
    }

    public static void main(String[] args) {
        MyClass myClass1 = new MyClass(1, 2);
        MyClass myClass2 = new MyClass(5.6,8.9,5.3);
        MyClass myClass3 = new MyClass("abc", "uio");
        MyClass myClass4 = new MyClass("abc", "abc");
    }
}
