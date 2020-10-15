package com.lim.test.base.demo;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Li Ming
 * @date 2020/8/13
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
//        fixedThreadPool();
//        singleThreadExecutor();
        scheduledExecutor();
    }

    public static void fixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("tid" + Thread.currentThread().getId());
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void singleThreadExecutor() {
        ExecutorService executorService = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(4),
                r -> new Thread(r, "mq_recv_client"), new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 10; i++) {
            final Integer c = i;
            executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                    executorService.submit(() -> log.info("a {} {}", c, LocalDateTime.now()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void scheduledExecutor() {
        ScheduledExecutorService scheduledExecutor = new ScheduledThreadPoolExecutor(1,
                r -> new Thread(r, "msg_consumer_background_monitor_task"));

        scheduledExecutor.scheduleWithFixedDelay(() -> log.info("a1"), 2, 1, TimeUnit.SECONDS);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduledExecutor.shutdown();
        scheduledExecutor = new ScheduledThreadPoolExecutor(1,
                r -> new Thread(r, "msg_consumer_background_monitor_task"));
        scheduledExecutor.scheduleWithFixedDelay(() -> log.info("a2"), 2, 1, TimeUnit.SECONDS);
    }

    public static void fileter() {
/*        String queueName = "mq:test:1:pt,mq:test:1:pn,mq:test:2:pf:c1,mq:test:2:pf:c2,";
        LinkedHashSet<String> mqNameSet = queueName.split(",");
        String[] mqNames = getMsgParam.getMqNameSet().stream().filter(e -> StringUtils.isEmpty(e))
                .map(e -> MqUtil.getQueueNameByClientId(e, getMsgParam.getClientId())).toArray(String[]::new);*/
    }
}
