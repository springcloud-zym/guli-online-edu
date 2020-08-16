package test;

import java.lang.ref.SoftReference;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.*;

/**
 * @author
 * @date 2020/7/26-14:08
 */
public class Test {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        threadPool.shutdown();

        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference(o);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.atOffset(ZoneOffset.ofHours(8)));

        LocalDateTime of = LocalDateTime.of(2015, 1, 1, 1, 1, 1);
        System.out.println(of);

    }
}





