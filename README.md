# Concurrence
## JUC
### 并发流程控制
#### CountDownLatch
- 1.作用
(1) 作为一个倒数门闩
(2) 流程：倒数结束之前，一直处于等待状态，直到倒数结束，线程才继续工作
- 2.主要方法
(1) 构造方法CountDownLatch(int count) 参数为需要等待的次数
(2) await() 等待，直到倒数结束
(3) countDown() 倒数一次，减少等待次数

- 3.实用场景
(1) 一个线程等待多个线程，比如产品需要经过5个质检员质检，才能进行后续操作
(2) 多个线程等待一个线程，比如多个运动员等待指令抢响
(3) 混合使用，比如多个运动员等待裁判打响指令枪，指令枪响后，裁判等待所有运动员跑过终点，宣布比赛结束。
    这里要使用两个CountDownLatch实例，一个begin，一个end