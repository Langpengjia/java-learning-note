package pers.thinkingJVM.part2;

/**
 * @classname: FinalizeGC
 * @description: 针对可达性分析而言，要进行至少两次标记，来确定对象是否要被GC
 * 第一次：当对象进行可达性分析后，发现对象没有与GCRoot相连的引用链，进行第一次标记
 * 其余： 当进行第一次标记后，对象进行死缓状态。随后进行一次筛选，判断对象是否有必要
 * 执行finalize()方法。
 * @author: Desire
 * @date: 2020-04-28 9:54
 */
public class FinalizeEscapeGC {

    private static FinalizeEscapeGC hook = null;

    public void isAlive() {
        System.out.println("the entry is still alive ! ");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed ! ");
        FinalizeEscapeGC.hook = this;
    }


    /**
     * 记一次对象的自我拯救
     * 注意：
     *
     * 在hook对象的finalize方法里重新将当前对象赋值，变成可达对象，
     * 当这个hook对象再次变成不可达时还会执行finalize方法吗？答案是否定的，
     * 因为在执行完第一次finalize方法后，此时的hook对象已经和之前的Finalizer对象剥离了，
     * 也就是下答次GC的时候不会再发现Finalizer对象指向该hook对象了，
     * 自然也就不会调用这个hook对象的finalize方法了。
     * @param args
     */
    public static void main(String[] args) {
        try {
            hook = new FinalizeEscapeGC();

            hook = null;

            System.gc();
            Thread.sleep(500);

            if (hook != null) {
                hook.isAlive();
            } else {
                System.out.println("now,I am dead !");
            }

            hook = null;
            System.gc();
            Thread.sleep(500);

            if (hook != null) {
                hook.isAlive();
            } else {
                System.out.println("now,I am dead !");
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
