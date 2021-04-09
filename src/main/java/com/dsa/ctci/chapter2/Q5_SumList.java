package com.dsa.ctci.chapter2;

public class Q5_SumList {

    public static Node<Integer> sumListBackwards(final Node<Integer> l1, final Node<Integer> l2, final int carry){
        if(l1==null && l2 ==null){
            if(carry > 0){
                Node<Integer> n = new Node<>(carry);
                return n;
            } else {
                return null;
            }
        }

        Node<Integer> n1 = l1 == null ? new Node<Integer>(0) : l1;
        Node<Integer> n2 = l2 == null ? new Node<Integer>(0) : l2;
        int sum = n1.getData() + n2.getData() + carry;
        int curr_carry = sum >= 10 ? 1 : 0;
        int digit = sum % 10;
        Node<Integer> res = new Node<>(digit);
        res.next = sumListBackwards(n1.next, n2.next, curr_carry);
        return res;
    }


    public static Node<Integer> sumListForward(final Node<Integer> l1, final Node<Integer> l2){
        if(l1==null && l2 ==null){
            return  new Node<Integer>(0);
        }

        Node<Integer> n1 = l1;
        Node<Integer> n2 = l2;
        if(getSize(l1) > getSize(l2)){
            n2 = padListWithZeros(l2,getSize(l1)-getSize(l2));
        } else {
            n1 = padListWithZeros(l1,getSize(l2)-getSize(l1));
        }
        Node<Integer> res = new Node<>(0);
        int carry = sum(n1,n2,res);
        if(carry >= 1){
            res.setData(carry);
            return res;
        }
        return res.next;
    }

    public static int sum(final Node<Integer> l1, final Node<Integer> l2, final Node<Integer> res){
        if(l1==null && l2 ==null){
            return 0;
        }
        Node<Integer> data = new Node(0);
        res.next = data;
        int carry = sum(l1.next,l2.next,data);
        int summation = l1.getData() + l2.getData() + carry;
        int digit = summation % 10;
        int curr_carry = summation>= 10 ? 1: 0;
        data.setData(digit);
        return curr_carry;
    }

    public static int getSize(Node n){
        int count =0;
        while (n != null){
            count++;
            n  = n.next;
        }
        return count;
    }

    public static Node<Integer> padListWithZeros(final Node<Integer> head, final int size){
        Node<Integer> currHead = head;
        for(int i=0; i<  size; i++){
            Node<Integer> node = new Node<Integer>(0);
            if(currHead !=  null){
                node.next = currHead.next;
                currHead = node;
            }
        }
        return currHead;
    }


    public static void main(String[] args) {
        Node<Integer> n7 = new Node<>(5);
        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n6 = new Node<>(7);
        n7.next = n1;
        n1.next = n6;

        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(1);
        n5.next = n2;
        n2.next = n3;

        sumListBackwards(n7,n5,0).print();

        sumListForward(n7,n5).print();
    }
}
