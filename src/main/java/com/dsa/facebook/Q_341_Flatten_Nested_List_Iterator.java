package com.dsa.facebook;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Q_341_Flatten_Nested_List_Iterator {
    // https://www.programcreek.com/2014/05/leetcode-flatten-nested-list-iterator-java/

    public static void main(String[] args) {

    }

}

// Let N be the total number of integers within the nested list,
// L be the total number of lists within the nested list, and
// D be the maximum nesting depth (maximum number of lists inside each other).

//TC:
// Constructor: O(N)
// hasNext() : O(L/N);
// next(): O(1);

//SC: O(N + L)
//In the worst case, where the top list contains N integers, or L empty lists, it will cost O(N + L) space.
// Other expensive cases occur when the nesting is very deep.
// However, it's useful to remember that D ≤ L (because each layer of nesting requires another list), and so we don't need to take this into account.

// Less Optimal
class NestedIterator1 implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<NestedInteger>();

    public NestedIterator1(List<NestedInteger> nestedList) {
        if(nestedList==null)
            return;

        for(int i=nestedList.size()-1; i>=0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger top = stack.peek();
            if(top.isInteger()){
                return true;
            }else{
                stack.pop();
                for(int i=top.getList().size()-1; i>=0; i--){
                    stack.push(top.getList().get(i));
                }
            }
        }

        return false;
    }
}


// More Optimal
// Let N be the total number of integers within the nested list,
// L be the total number of lists within the nested list, and
// D be the maximum nesting depth (maximum number of lists inside each other).

//TC:
// Constructor: O(1)
// hasNext() : O(L/N);
// next(): O(1);

//SC: O(D)

class NestedIterator implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> iteratorStack = new Stack<>();
    Integer next = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList != null)
            iteratorStack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        Integer result = next;
        next = null;
        return result;
    }

    @Override
    public boolean hasNext() {
        while(!iteratorStack.isEmpty() && next == null){
            Iterator<NestedInteger> currIterator = iteratorStack.peek();

            if(!currIterator.hasNext()){
                iteratorStack.pop();
                continue;
            }

            NestedInteger curr = currIterator.next();
            if(curr.isInteger()){
                next = curr.getInteger();
                return true;
            } else{
                iteratorStack.push(curr.getList().iterator());
            }
        }

        return false;
    }
}

interface NestedInteger {
 
              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();
 
              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();
 
              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return empty list if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }