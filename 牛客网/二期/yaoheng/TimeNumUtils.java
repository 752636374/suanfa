package 牛客网.二期.yaoheng;

public class TimeNumUtils {
    static volatile int num = 0;
    static boolean flag = false;

    private static void start() {
        Thread thread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    // 模拟守护线程的工作
//                    num++;
                }
            } catch (Exception e) {
                // 处理异常，如记录日志等
            } finally {
                // 在守护线程终止时执行一些操作
                System.out.println("执行次数：" + num);
                // 执行一些清理操作或其他必要的操作
            }
        });

        thread.setDaemon(true);
        thread.start();

        // 设置flag变量的值，确保在多线程环境中正确同步访问
        flag = true;

    }

    public static void inc() {
        if (!flag) {
            start();
        }
        num++;
    }

    public static void end() {
        System.out.println("执行次数：" + num);
        num = 0;
    }
}
