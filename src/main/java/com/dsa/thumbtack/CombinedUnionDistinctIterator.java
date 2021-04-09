package com.dsa.thumbtack;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;


public class CombinedUnionDistinctIterator<Integer> implements Iterator<Integer> {

    private Iterator<Integer> sourceIteratorA;
    private Iterator<Integer> sourceIteratorB;
    Set<Integer> set = new HashSet<Integer>();

    public CombinedUnionDistinctIterator(final Iterator<Integer> sourceIteratorA, final  Iterator<Integer> sourceIteratorB){
        this.sourceIteratorA = sourceIteratorA;
        this.sourceIteratorB = sourceIteratorB;
    }

    @Override
    public boolean hasNext() {
        return this.sourceIteratorA.hasNext() || this.sourceIteratorB.hasNext();
    }

    @Override
    public Integer next() throws NoSuchElementException {
        return null;
    }

    public static void main(String[] args) {

    }
}
