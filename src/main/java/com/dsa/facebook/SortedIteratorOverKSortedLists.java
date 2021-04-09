package com.dsa.facebook;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortedIteratorOverKSortedLists implements Iterator<Integer> {

    PriorityQueue<Element> pq = new PriorityQueue<Element>(Comparator.comparingInt(Element::getCurrentValue));

    public SortedIteratorOverKSortedLists(List<List<Integer>> lists) {
        for(List<Integer> list : lists){
            Iterator<Integer> it = list.iterator();
            if(it.hasNext()){
                pq.add(new Element(it));
            }
        }
    }

    @Override
    public boolean hasNext() {
        return pq.size() > 0;
    }

    @Override
    public Integer next() {
      if(!hasNext())
          try {
              throw new Exception("No Elements!");
          } catch (Exception e) {
              e.printStackTrace();
          }

      Element e = pq.poll();
      int res = e.next();
      if(e.hasNext)
          pq.add(e);
      return res;
    }
}

class Element{

    public Iterator<Integer> iterator;
    public Integer currentValue;
    public boolean hasNext;

    public Element(final Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.currentValue = iterator.next();
        this.hasNext = true;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    public boolean hasNext(){
        return hasNext;
    }

    public Integer next(){
        int val = currentValue;

        if(iterator.hasNext())
            currentValue = iterator.next();
        else hasNext = false;

        return val;
    }
}