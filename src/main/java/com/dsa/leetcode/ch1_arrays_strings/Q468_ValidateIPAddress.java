package com.dsa.leetcode.ch1_arrays_strings;

public class Q468_ValidateIPAddress {


    public String validIPAddress(String IP) {
        if(IP == null || IP == "")
            return "Neither";

        if(IP.contains(":") && isValidIPV6(IP)){
            return "IPv6";
        } else if(IP.contains(".") && isValidIPV4(IP)){
            return "IPv4";
        }

        return "Neither";
    }

    public static boolean isValidIPV4(String IP){
        String [] sections = IP.split("\\.",-1);
        if(sections.length != 4)
            return false;

        for(String section : sections){
            for(int i=0;i<section.length()-1; i++){
                if(!Character.isDigit(section.charAt(i)))
                    return false;
            }

            try {
                Integer num = Integer.parseInt(section);
                if(num <0 || num >255)
                    return false;

                if(section.length() != String.valueOf(num).length())
                    return false;
            } catch (NumberFormatException e){
                return false;
            }


        }
        return true;
    }

    public static boolean isValidIPV6(String IP){

        String s = "0123456789abcdefABCDEF";
        String [] sections = IP.split(":",-1);
        if(sections.length != 8)
            return false;

        for(String section : sections){
            for(int i=0;i<=section.length()-1; i++){
                if(!s.contains(section.charAt(i)+""))
                    return false;
            }

            if(section.length()<1 || section.length()>4)
                return false;
        }

        return true;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;

        if(l1 == null)
            return l2;

        if(l2 == null)
            return l1;

        int carry =0;
        ListNode head = new ListNode(0);
        ListNode ptr = head;

        while(l1 != null || l2 != null){
            ListNode num1 = l1 == null ? new ListNode(0): l1;
            ListNode num2 = l2 == null ? new ListNode(0): l2;

            int sum = num1.val + num2.val + carry;
            int digit = sum % 10;
            carry = sum >= 10 ? 1: 0;
            ptr.next = new ListNode(digit);

            ptr = ptr.next;
            l1 = num1.next;
            l2 = num2.next;

        }

        if(carry == 1)
            ptr.next = new ListNode(carry);

        return head.next;

    }

    public static void main(String[] args) {
        String ipv4 = "172.16.254.1";
        String ipv6 = "g:f:f:f:f:f:f:g";
        Q468_ValidateIPAddress obj = new Q468_ValidateIPAddress();

        System.out.println(obj.validIPAddress(ipv6));
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }