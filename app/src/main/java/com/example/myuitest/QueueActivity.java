package com.example.myuitest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://blog.csdn.net/z69183787/article/details/81064982
 */
public class QueueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);


        int peopleNum = 10000;//吃饭人数
        int tableNum = 10;//饭桌数量

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        CountDownLatch count = new CountDownLatch(1);//计数器

        //将吃饭人数放入队列（吃饭的人进行排队）
        for(int i=1;i<=peopleNum;i++){
            queue.offer("消费者_" + i);
        }
        //执行10个线程从队列取出元素（10个桌子开始供饭）
        Log.e("hel", "-----------------------------------开饭了-----------------------------------");
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(tableNum);
        for(int i=0;i<tableNum;i++) {
            executorService.submit(new Dinner("00" + (i+1), queue, count));
        }
        //计数器等待，直到队列为空（所有人吃完）
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time = System.currentTimeMillis() - start;
        Log.e("hel", "-----------------------------------所有人已经吃完-----------------------------------");
        Log.e("hel", "共耗时：" + time);
        //停止线程池
        executorService.shutdown();
    }

    private static class Dinner implements Runnable {
        private String name;
        private ConcurrentLinkedQueue<String> queue;
        private CountDownLatch count;

        public Dinner(String name, ConcurrentLinkedQueue<String> queue, CountDownLatch count) {
            this.name = name;
            this.queue = queue;
            this.count = count;
        }

        @Override
        public void run() {
//            while (queue.size() > 0){
            while (!queue.isEmpty()) {
                //从队列取出一个元素 排队的人少一个
                Log.e("hel", "【" + queue.poll() + "】----已吃完...， 饭桌编号：" + name);
            }
            count.countDown();//计数器-1
        }
    }
}
