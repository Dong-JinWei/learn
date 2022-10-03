package cn.tedu.bean;


/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * JDK 版本：JDK1.5 起
 * <p>
 * 是否 Lazy 初始化：是
 * <p>
 * 是否多线程安全：是
 * <p>
 * 实现难度：较复杂
 * <p>
 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 */
public class Singleton04 {
    private static Singleton04 singleton04;

    private Singleton04() {
    }

    public static Singleton04 getSingleton04() {
        if (singleton04 == null) {
            synchronized (Singleton04.class) {
                if (singleton04 == null) {
                    singleton04 = new Singleton04();
                }
            }
        }
        return singleton04;
    }
}
