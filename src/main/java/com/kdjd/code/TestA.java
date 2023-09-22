package com.kdjd.code;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class TestA {

    public static void main(String[] args) {
//        String a = "abc";
//        String b = "abc";
//        System.out.println(a == b);
//
//        Entity a1 = new Entity("abc");
//        Entity a2 = new Entity("abc");
//
//        System.out.println(Objects.equals(a1, a2));
//
//        System.out.println(a == a1.getValue());


        //Long a = 1L;
        //Long b = 1L;
        //System.out.println(a == b);
        //System.out.println(a.equals(b));
        //
        //
        //a = 200L;
        //b = 200L;
        //System.out.println(a == b);
        //System.out.println(a.equals(b));

        //BitSet bits1 = new BitSet(16);
        //BitSet bits2 = new BitSet(16);
        //
        //// set some bits
        //for(int i=0; i<16; i++) {
        //    if((i%2) == 0) bits1.set(i);
        //    if((i%5) != 0) bits2.set(i);
        //}
        //System.out.println("Initial pattern in bits1: ");
        //System.out.println(bits1);
        //System.out.println("\nInitial pattern in bits2: ");
        //System.out.println(bits2);
        //
        //// AND bits
        ////bits2.and(bits1);
        ////System.out.println("\nbits2 AND bits1: ");
        ////System.out.println(bits2);
        //
        //// OR bits
        ////bits2.or(bits1);
        ////System.out.println("\nbits2 OR bits1: ");
        ////System.out.println(bits2);
        //
        //// XOR bits
        //bits2.xor(bits1);
        //System.out.println("\nbits2 XOR bits1: ");
        //System.out.println(bits2);
        //System.out.println("==");
        //
        //boolean ba = true;
        //boolean bb = true;
        //System.out.println( ba && bb);
        //System.out.println( ba || bb);
        //System.out.println(  !bb);
        //System.out.println( ba ^ bb);
        //System.out.println("==");
        //ba = true;
        //bb = false;
        //System.out.println( ba && bb);
        //System.out.println( ba || bb);
        //System.out.println(  !bb);
        //System.out.println( ba ^ bb);
        //System.out.println("==");
        //ba = false;
        //bb = false;
        //System.out.println( ba && bb);
        //System.out.println( ba || bb);
        //System.out.println(  !bb);
        //System.out.println( ba ^ bb);
        //
        //System.out.println("==");
        //
        //bits1 = new BitSet(3);
        //bits2 = new BitSet(3);
        //
        //System.out.println(bits2.get(3));
        //System.out.println(bits1.length());
        //
        //bits1.set(1,2);
        //bits2.set(1);
        //bits2.set(3);
        //System.out.println(bits2.get(3));
        //System.out.println(bits1.length());
        //
        //System.out.println(bits1);
        //System.out.println(bits2);
        //System.out.println("==");
        //bits2.xor(bits1);
        //System.out.println(bits2);


        int size = 1000000;
        long start = System.currentTimeMillis();
        Random random = new Random();
        BitSet bs = new BitSet(size);
        while (bs.length() < size) {
            int i = random.nextInt(size);
            if (!bs.get(i)) {
                bs.set(i);
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(bs.length());

        System.out.println("====");

        start = System.currentTimeMillis();
        random = new Random();
        Set<Integer> set = new HashSet<>(size); 
        while (set.size() < size) {
            int i = random.nextInt(size);
            set.add(i);
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(set.size());


        System.out.println("====");

        start = System.currentTimeMillis();
        random = new Random();
        Map<Integer,Integer> map = new HashMap<>(size);
        while (map.size() < size) {
            int i = random.nextInt(size);
            map.put(i,i);
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(set.size());

    }
}

class Entity {
    String value;

    public Entity() {
    }

    public Entity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}