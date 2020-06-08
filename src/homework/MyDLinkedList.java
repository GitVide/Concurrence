package homework;

public class MyDLinkedList {


    public static void main(String[] args) {
        System.out.println("测试双向链表");
        Node head = new Node(-1);
        Node cur = head;
//        生成一个有二十个结点的双向链表,有一个虚头结点和一个虚尾结点
        for (int i = 1; i <= 20; i++) {
            cur.next = new Node(i);
            Node temp = cur;
            cur = cur.next;
            cur.pre = temp;
        }

        Node tail = new Node(-1);
        cur.next = tail;
        tail.pre = cur;
        System.out.println("从头到尾打印:");
        cur = head.next;
        while (cur.next != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
        System.out.println("从尾到头打印:");
        cur = tail.pre;
        while (cur.pre != null){
            System.out.print(cur.val + " ");
            cur = cur.pre;
        }

    }
}
//定义链表结点
class Node {
    int val;
    Node next;
    Node pre;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next, Node pre) {
        this.val = val;
        this.next = next;
        this.pre = pre;
    }
}
