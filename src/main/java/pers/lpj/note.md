--- https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-2.html#jvms-2.5

JVM 由 类加载子系统  运行时数据区  执行引擎  本地方法接口等组成


    类加载子系统(ClassLoader)（以双亲委托机制保证其安全性<HotSpot>）

       一  Java自带的类加载器
            1  根（启动）类加载器 <Bootstrap ClassLoader>
                    加载 rt.jar包内的的类(java.lang包下等),由C++实现,没有父加载器,当试图获取这个类加载时，返回Null
            2  扩展类加载器<Extention ClassLoader>
                    加载 jri/ext 或 用户自定义指定目录下的 jar （ExtClassLoader.class）父加载器是Bootstrap ClassLoader，
                    当试图获取这个类加载时，返回 ExtClassLoader.class
            3  应用（系统）类加载器<Application ClassLoader>
                    加载 classpath下 或 用户自定义的类；父加载器是Extention ClassLoader，
                    当试图获取这个类加载时，返回 AppClassLoader.class

       二  自定义类加载器（必须 extend ClassLoader 或 ClassLoader 的子类）


    Java 运行时数据区 (JVM Running Data Areas )
        一   寄存器（程序计数器）<The pc Register>

        二   虚拟机栈 <JVM Stacks> (由多个栈帧<Frames>组成)
                栈帧 <Frame>（一次方法调用即为一个栈帧）
                ......
                栈帧
                    1 操作数栈 (指定程序执行顺序)
                    2 局部变量表 (存放类或方法的局部变量)
                    3 动态链接 (存放对象的引用<符号引用>)
                    4 方法出口 (返回下一个个方法)
        三   堆 <Heap>
                保存类的实例，JVM最大的一个区域，也是GC主要的运行区域，使用超出分配是会抛出 OutOfMemoryException
        四   方法区 <Method Area>
                存放类和接口的定义 由线程共有 jdk 1.7之前由永久代实现，JDK1.8之后由元数据区（MetaData Area）实现
        五   运行时常量池 <The Run-Time Constant Pool>
                JVM 会为任何初始化的类或接口分配运行时常量池（意思就是每个类都有一个运行时常量池），由方法区分配空间实现，
                存放类 final   static 变量
        六   本地方法栈 <The Native Method Area>
                为 native 方法分配执行空间

    执行引擎

    本地方法接口



类的生命周期


    一  编译(本质上不属于类的生命周期)
        将 java文件(.java) 编译成 字节码文件（.class）

    二  加载
        将 编译后的字节码文件 从硬盘或网络中 加载到内存中，JVM允许类加载器 预料到 某个类会被使用而提前加载它
        注意！！加载不等于初始化；在加载过程中如果出现.class文件缺失或者其他错误时，类加载器要在程序 首次使用时 报告此错误

    三  连接 （完成类的 <验证 准备 解析> 工作）
        1  验证阶段  验证字节码文件的正确性（是否符合java字节码规范）
        2  准备阶段  为类的中静态变量分配空间并赋予<初始值>(string null, boolean = false, int = 0)
        3  解析阶段  将类中的 <符号引用> 转化为 <直接引用>

    四  初始化（类的实例化，为类的实例对象在运行时数据区分配空间）
        <子类被主动调用的时候回导致该类的所有父类或者接口会被初始化>
        当发生类的主动使用时会导致类的初始化，根据JVM规范 以下几种情况会导致类的初始化



    五  使用（执行）
        执行引擎执行程序

    六  销毁（或卸载）
        发生 GC 或 类被卸载，注意！！！JVM自带的ClassLoader永远不会卸载类
