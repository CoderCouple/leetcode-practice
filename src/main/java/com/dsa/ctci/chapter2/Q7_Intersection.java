package com.dsa.ctci.chapter2;

public class Q7_Intersection {

    // const -> private static final int  = 32;
    // fixme -> FIXME: 11/30/20
    // geti ->
    // key -> private static final String KEY_ = "";
    // logt -> private static final String TAG = "Q7_Intersection";
    // main = psvm ->
    // noInstance ->
    // newInstance ->
    // noop -> /* no-op */
    // psvm ->
    // psf ->  public static final
    // prsf -> private static final
    // psfs -> public static final String
    // psfi -> public static final int
    // sbc -> !
    // starter ->
    // stopship ->
    // todo -> TODO: 11/30/20



    public static Node<Integer> getIntersection(final Node<Integer> l1, final Node<Integer> l2){
        boolean hasIntersection = false;
        if(l1 == null && l2 == null)
            return null;

        if(l1 == null || l2 == null){
            return null;
        }


        int c1 = 1;
        int c2 = 1;
        int diff = 0;

        Node<Integer> n1 = l1;
        while (n1.next != null){
            c1++;
            n1 = n1.next;
        }

        Node<Integer> n2 = l2;
        while (n2.next != null){
            c2++;
            n2 = n2.next;
        }

        if(n1 == n2)
            hasIntersection = true;

        Node<Integer> l = l1;
        Node<Integer> s = l2;

        if(c1<c2){
            l = l2;
            s = l1;
            diff = c2-c1;
        } else {
            l = l1;
            s = l2;
            diff = c1-c2;
        }

        while (diff > 0){
            l = l.next;
            diff--;
        }
        while (l != null){
           if(l == s)
               return l;
           l= l.next;
           s = s.next;
        }
        return null;
    }


    public static void main(String[] args) {
        Node<Integer> n7 = new Node<>(5);
        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n6 = new Node<>(5);
        n7.next = n1;
        n1.next = n6;

        Node<Integer> n9 = new Node<>(9);
        n9.next = n1;

        System.out.println(getIntersection(n7, n9));
    }
}
