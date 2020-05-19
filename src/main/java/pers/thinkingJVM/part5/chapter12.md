#### JAVA内存模型特征

##### 原子性    

原子操作（concurrent包下所有运算） sychronized     
原子性指令（只有6个）
read load assign use write store

##### 可见性
保证可见性的方式 ：sychronized  volatile  final    
volatile 关键字         
    1. 保证被修饰的变量被所有线程可见（不保证一致性，因为操作符运算的非原子性）    
    2. 保证程序运行时不会发生指令重排序（会在相关字节码之间增加内存屏障）     
sychronized : 基于两条高级指令 monitorenter 和 monitorexit (监视器锁)    
final : 基于常量池     
##### 有序性        
在本线程中观察，所有操作都是有序的。（单一线程内指令串行）    
在一个线程中观察另一个线程，所有的操作都是无序的（指令重排序  工作内存和主存之间存在延迟）    
    
    
    
















