package com.dsa.facebook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int schedule(char[] tasks, int n) {
        List<String> result = new ArrayList<>();
        int time=1;
        Map<Character, Integer> map = new HashMap<>();

        int index = 0;
        while(index<tasks.length){
            Character task = tasks[index];
            if(map.containsKey(task)){
                int lastExecutionTime = map.get(task);
                if(time-lastExecutionTime>n){
                    map.put(task,time);
                    result.add(Character.toString(task));
                    index++;
                }else{
                    result.add("_");
                }
            } else{
                map.put(task,time);
                result.add(Character.toString(task));
                index++;
            }
            time++;
        }
        System.out.println(result);
        return  result.size();
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskFrequency = new HashMap<>();
        for(char task : tasks){
            taskFrequency.put(task,taskFrequency.getOrDefault(task,0)+1);
        }

        PriorityQueue<TaskFreq> maxHeap = new PriorityQueue<>(Comparator.comparingInt(TaskFreq::getFreq).reversed());
        taskFrequency.forEach((k,v) -> {maxHeap.add(new TaskFreq(k,v));});

        TaskFreq max_freq = maxHeap.poll();
        int max_idle_time = (max_freq.freq-1) * n;
        while (!maxHeap.isEmpty() && max_idle_time>0){
            max_idle_time -= Math.min(max_freq.freq-1, maxHeap.poll().freq);
        }

        max_idle_time = Math.max(0,max_idle_time);
        return max_idle_time+tasks.length;
    }

    public static void main(String[] args) {
        char [] tasks1 = {'A','A','A','B','B','B'}; int cooldown1=2;
        char [] tasks2 = {'A','A','A','B','B','B'}; int cooldown2=0;
        char [] tasks3 = {'A','A','A','B','C','A','D','A'}; int cooldown3=2;

        char [] tasks4 = {'A','A','A','A','A','A','B','C','D','E','F','G'}; int cooldown4=2;

        TaskScheduler t = new TaskScheduler();
//        System.out.println(t.schedule(tasks1,cooldown1));
//        System.out.println(t.schedule(tasks2,cooldown2));
//        System.out.println(t.schedule(tasks3,cooldown3));

        System.out.println(t.leastInterval(tasks4,cooldown4));

    }
}

class TaskFreq {
    char task;
    int freq;

    public TaskFreq(final char task, final int freq) {
        this.task = task;
        this.freq = freq;
    }

    public char getTask() {
        return task;
    }

    public void setTask(final char task) {
        this.task = task;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(final int freq) {
        this.freq = freq;
    }
}
