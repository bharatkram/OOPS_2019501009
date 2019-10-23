 /**
 * This is JUnit that tests the methods of the Clock.
 * This contains 2 testcases.
 * 
 * Please don't run this file.
 * You can add your own test cases to this file by just copy and 
 * paste the last three lines of the code (TestCase2).
 * 
 * @author Siva Sankar
 * @author Jagan
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestJUnit {

   @Test
   public void testCase1() {
      System.out.println("TestCase for Add method in Lists.");
      List<Integer> lst = new List<Integer>();
      lst.add(5);
      assertEquals("1. List Object", "[5]", lst.toString());

      AbstractList<Integer> lst1 = new List<Integer>();
      for (int i = 0; i < 20; i++) {
         lst1.add(i);
      }
      assertEquals("2. List Object through abstract class", "[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]", lst1.toString());

      ListInterface<Integer> lst2 = new List<Integer>();
      for (int i = 0; i < 20; i++)
         lst2.add(i);
      assertEquals("3. List Object through interface", "[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19]", lst2.toString());
   }

   @Test
   public void testCase2() {
      System.out.println("TestCase for Add element at specific position menthod in Lists.");
      List<Integer> lst = new List<Integer>();

      Integer[] arr = {1,2,3,4,5,6};
      try {
         lst.addAll(arr);
         lst.add(2, 7);
         assertEquals("1. List Object", "[1,2,7,3,4,5,6]", lst.toString());
      } catch(Exception ex) {
         assertEquals("1. ", "Invalid index to add element", ex.getMessage());
      }

      try {
         lst.add(8, 7);
      } catch(Exception ex) {
         assertEquals("2. ", "Invalid index to add element", ex.getMessage());
      }
      
      try {
         lst.add(-1, 7);
      } catch(Exception ex) {
         assertEquals("3. ", "Invalid index to add element", ex.getMessage());
      }
      try {
         lst.add(0, 7);
      } catch(Exception ex) {

      }
      assertEquals("4. List Object", "[7,1,2,7,3,4,5,6]", lst.toString());
   }

   @Test
   public void testCase3() {
      System.out.println("TestCase for AddAll method in Lists.");
      List<Integer> lst = new List<Integer>();
      AbstractList<Integer> lst1 = new List<Integer>();
      ListInterface<Integer> lst2 = new List<Integer>();

      lst.add(5);
      Integer[] arr = {1,2,3,4,5,6};
      try { lst.addAll(arr); } catch(Exception ex) { }
      assertEquals("1. List Object", "[5,1,2,3,4,5,6]", lst.toString());

      lst1.add(6);
      try { lst1.addAll(arr); } catch(Exception ex) { }
      assertEquals("2. List Object through abstract class", "[6,1,2,3,4,5,6]", lst1.toString());

      lst2.add(7);
      try { lst2.addAll(arr); } catch(Exception ex) { }
      assertEquals("3. List Object through interface", "[7,1,2,3,4,5,6]", lst2.toString());
   }

   @Test
   public void testCase4() {
      System.out.println("TestCase for Size method in Lists.");
      List<String> lst = new List<String>();

      assertEquals("0. List Object", "0", "" + lst.size());
      lst.add("5");
      String[] arr = {"1","2","3","4","5","6"};
      try { lst.addAll(arr); } catch(Exception ex) { }
      assertEquals("1. List Object", "7", "" + lst.size());

      AbstractList<String> lst1 = new List<String>();
      lst1.add("6");
      try { lst1.addAll(arr); } catch(Exception ex) { }
      assertEquals("2. List Object through abstract class", "7", "" + lst1.size());

      ListInterface<String> lst2 = new List<String>();
      lst2.add("7");
      try { lst2.addAll(arr); } catch(Exception ex) { }
      assertEquals("3. List Object through interface", "7", "" + lst2.size());
   }

   @Test
   public void testCase5() {
      System.out.println("TestCase for Get method in Lists.");

      List<Float> lst = new List<Float>();
      lst.add(5.2f);
      Float[] arr = {1.2f, 2.2f, 3.2f, 4.2f, 5.2f, 6.2f};
      try { lst.addAll(arr); } catch(Exception ex) { }
      try {
         assertEquals("1.1 List Object", 5.2, lst.get(5), 0.001);
      } catch(Exception ex) {
         assertEquals("1.1 List Object through interface", "Index is out of range", ex.getMessage());
      }
      
      try {
         lst.get(8);
      }  catch(Exception ex) {
         assertEquals("1.2 List Object through interface", "Index is out of range", ex.getMessage());
      }
      
      try {
         lst.get(-1);
      } catch(Exception ex) {
         assertEquals("1.3 List Object through interface", "Index is out of range", ex.getMessage());
      }
      
      AbstractList<Float> lst1 = new List<Float>();
      lst1.add(6.2f);
      try { lst1.addAll(arr); } catch(Exception ex) { }
      try {
         assertEquals("2.1 List Object through abstract class", 4.2f, lst1.get(4), 0.001);
      }  catch(Exception ex) {
         assertEquals("2.1 List Object through interface", "Index is out of range", ex.getMessage());
      }
      try {
         lst1.get(100);
      } catch(Exception ex) {
         assertEquals("2.2 List Object through interface", "Index is out of range", ex.getMessage());
      }
      try {
         lst1.get(-1);
      }  catch(Exception ex) {
         assertEquals("2.3. List Object through interface", "Index is out of range", ex.getMessage());
      }
      
      ListInterface<Float> lst2 = new List<Float>();
      lst2.add(7.2f);
      try { lst2.addAll(arr); } catch(Exception ex) { }
      try {
         assertEquals("3.1 List Object through interface", 7.2, lst2.get(0), 0.001);
         lst2.get(45);
      } catch(Exception ex) {
         assertEquals("3.2 List Object through interface", "Index is out of range", ex.getMessage());
      }
      try {
         lst2.get(-2);
      } catch(Exception ex) {
         assertEquals("3.3 List Object through interface", "Index is out of range", ex.getMessage());
      }
   }  

   @Test
   public void testCase6() {
      System.out.println("TestCase for Indexof method in Lists.");

      List<Double> lst = new List<Double>();
      lst.add(5.2);
      Double[] arr = {1.2, 2.2, 3.2, 4.2, 5.2, 6.2};
      try { lst.addAll(arr); } catch(Exception ex) { }
      assertEquals("1.1 List Object", 0, lst.indexOf(5.2));
      assertEquals("1.2 List Object", -1, lst.indexOf(8.0));
      assertEquals("1.3 List Object", -1, lst.indexOf(-1.2));
      
      AbstractList<Double> lst1 = new List<Double>();
      lst1.add(6.2);
      try { lst1.addAll(arr); } catch(Exception ex) { }
      assertEquals("2.0 List Object through abstract class", "[6.2,1.2,2.2,3.2,4.2,5.2,6.2]", lst1.toString());
      assertEquals("2.1 List Object through abstract class", 4, lst1.indexOf(new Double(4.2)));
      assertEquals("2.2 List Object through abstract class", "-1", "" + lst1.indexOf(100.0));
      assertEquals("2.3 List Object through abstract class", "-1", "" + lst1.indexOf(-1.2));
      
      ListInterface<Double> lst2 = new List<Double>();
      lst2.add(7.0);
      
      try { lst2.addAll(arr); } catch(Exception ex) { }
      assertEquals("3.1 List Object through interface", 6, lst2.indexOf(6.2));
      assertEquals("3.2 List Object through interface", "-1", "" + lst2.indexOf(45.2));
      assertEquals("3.3 List Object through interface", "-1", "" + lst2.indexOf(-2.2));
   }

   @Test
   public void testCase7() {
      System.out.println("TestCase for Contains method in Lists.");

      List<Character> lst = new List<Character>();
      lst.add('a');
      Character[] arr = {'1','2','3','4','5','6'};

      try {
         lst.addAll(arr);
      } catch(Exception ex) {

      }
      
      assertEquals("1.1 List Object", true, lst.contains('5'));
      assertEquals("1.2 List Object", false, lst.contains('8'));
      assertEquals("1.3 List Object", true, lst.contains('1'));
      
      Integer ar[] = {1,2,3,4,5,6};
      AbstractList<Integer> lst1 = new List<Integer>();
      lst1.add(6);
      try {
         lst1.addAll(ar);
      } catch(Exception ex) {

      }
      assertEquals("2.1 List Object through abstract class", "true", "" + lst1.contains(4));
      assertEquals("2.2 List Object through abstract class", "false", "" + lst1.contains(100));
      assertEquals("2.3 List Object through abstract class", "false", "" + lst1.contains(-1));
      
      ListInterface<Integer> lst2 = new List<Integer>();

      lst2.add(7);
      try {
         lst2.addAll(ar);
      } catch(Exception ex) {

      }
      assertEquals("3.1 List Object through interface", "true", "" + lst2.contains(3));
      assertEquals("3.2 List Object through interface", "false", "" + lst2.contains(45));
      assertEquals("3.3 List Object through interface", "false", "" + lst2.contains(-2));
   }

   @Test
   public void testCase8() {
      System.out.println("TestCase for Remove method in Lists.");
      
      List<Integer> lst = new List<Integer>();
      lst.add(5);
      Integer[] arr = {1,2,3,4,5,6};
      try {
         lst.addAll(arr);
      } catch(Exception ex) {

      }

      try {
         lst.remove(5);
      } catch(Exception ex) {
         assertEquals("1.1 ", "Invalid index to remove eleemnt", ex.getMessage());
      }

      assertEquals("1.2 List Object", "[5,1,2,3,4,6]", lst.toString());
      
      AbstractList<Integer> lst1 = new List<Integer>();
      lst1.add(6);
      try { lst1.addAll(arr); } catch(Exception ex) { }

      try {
         lst1.remove(3);
      } catch(Exception ex) {
         assertEquals("2.1 ", "Invalid index to remove eleemnt", ex.getMessage());
      }
      assertEquals("2.2 List Object through abstract class", "[6,1,2,4,5,6]", lst1.toString());
      
      ListInterface<Integer> lst2 = new List<Integer>();
      lst2.add(7);
      try {
         lst2.addAll(arr);
         lst2.remove(5);
      } catch(Exception ex) { }
      
      assertEquals("3. List Object through interface", "[7,1,2,3,4,6]" ,lst2.toString());
   }

   @Test
   public void testCase9() {
      System.out.println("TestCase for LastIndexOf method in Lists.");

      List<Integer> lst = new List<Integer>();
      lst.add(5);
      Integer[] arr = {1,2,3,4,5,6};
      try {
         lst.addAll(arr);
      } catch(Exception ex) {
         
      }
      assertEquals("1. List Object", "5", "" + lst.lastIndexOf(5));
      
      AbstractList<Integer> lst1 = new List<Integer>();
      lst1.add(6);
      try {
         lst1.addAll(arr);
      } catch(Exception ex) {
         
      }
      assertEquals("2.1 List Object through abstract class", "6", "" + lst1.lastIndexOf(6));
      assertEquals("2.2 List Object through abstract class", "-1", "" + lst1.lastIndexOf(16));
      
      ListInterface<Integer> lst2 = new List<Integer>();
      lst2.add(7);
      try {
         lst2.addAll(arr);
      } catch(Exception ex) {
         
      }
      assertEquals("3.1 List Object through interface", "6" ,""+ lst2.lastIndexOf(6));
      assertEquals("3.2 List Object through abstract class", "-1", "" + lst2.lastIndexOf(16));
   }

   @Test
   public void testCase10() {
      System.out.println("TestCase for Count method in Lists.");

      List<Integer> lst = new List<Integer>();
      lst.add(5);
      Integer[] arr = {1,2,3,4,5,6};
      try { lst.addAll(arr); } catch(Exception ex) { }
      assertEquals("1. List Object", "2", "" + lst.count(5));
      assertEquals("2. List Object through interface", "0" ,""+ lst.count(16));
      
      AbstractList<Integer> lst1 = new List<Integer>();
      lst1.add(6);
      try { lst1.addAll(arr); } catch(Exception ex) { }
      assertEquals("3. List Object through abstract class", "2", "" + lst1.count(6));
      assertEquals("4. List Object through interface", "0" ,""+ lst1.count(16));
      
      ListInterface<Integer> lst2 = new List<Integer>();
      lst2.add(7);
      try { lst2.addAll(arr); } catch(Exception ex) { }
      assertEquals("5. List Object through interface", "1" ,""+ lst2.count(6));
      assertEquals("6. List Object through interface", "0" ,""+ lst2.count(16));
   }

   @Test
   public void testCase11() {
      System.out.println("TestCase for Set method in Lists.");
      List<Integer> lst = new List<Integer>();
      AbstractList<Integer> lst1 = new List<Integer>();
      ListInterface<Integer> lst2 = new List<Integer>();

      lst.add(5);
      Integer[] arr = {1,2,3,4,5,6};
      try {
         lst.addAll(arr);
      } catch(Exception ex) {

      }
      try {
         lst.set(2,7);
      } catch(Exception ex) {

      }
      assertEquals("1.1 List Object", "[5,1,7,3,4,5,6]", lst.toString());
   }

   @Test
   public void testCase12() {
      System.out.println("TestCase for SubList method in Lists.");
      List<Integer> lst = new List<Integer>();
      List<Integer> lstout;

      lst.add(5);
      Integer[] arr = {1,2,3,4,5,6};
      try {
         lst.addAll(arr);
         lstout = lst.subList(1,4);
         assertEquals("1.1 List Object", "[1,2,3]", lstout.toString());
      } catch(Exception ex) {

      }

      AbstractList<Integer> lst1 = new List<Integer>();
      lst1.add(6);
      try {
         lst1.addAll(arr);
         lstout = lst1.subList(2,6);
         assertEquals("2.1 List Object through abstract class", "[2,3,4,5]", lstout.toString());
      } catch(Exception ex) {

      }
      
      ListInterface<Integer> lst2 = new List<Integer>();
      lst2.add(7);
      try {
         lst2.addAll(arr);
         lstout = lst2.subList(3,5);
         assertEquals("3.1 List Object through interface", "[3,4]" ,lstout.toString());
         lstout = lst2.subList(0, lst2.size());
         assertEquals("3.2 List Object through interface", "[7,1,2,3,4,5,6]" ,lstout.toString());
         lstout = lst2.subList(0, lst2.size()-1);
         assertEquals("3.3 List Object through interface", "[7,1,2,3,4,5]" ,lstout.toString());
      } catch(Exception ex) {
         
      }

      try {
         lst2.subList(-1, lst2.size());
      } catch(Exception ex) {
         assertEquals("3.4 ", "fromIndex is less than 0", ex.getMessage());
      }

      try {
         lst2.subList(0, 0);
      } catch(Exception ex) {
         assertEquals("3.5 ", "fromIndex is greater than or equal to toIndex", ex.getMessage());
      }

      try {
         lst2.subList(lst2.size(), lst2.size());
      } catch(Exception ex) {
         assertEquals("3.6 ", "fromIndex is greater than or equal to toIndex", ex.getMessage());
      }

      try {
         lst2.subList(lst2.size()-1, lst2.size()+1);
      } catch(Exception ex) {
         assertEquals("3.7 ", "toIndex is greater than size", ex.getMessage());
      }
   }

   @Test
   public void testCase13() {
      System.out.println("TestCase for Add List method in Lists.");
      List<Integer> lst = new List<Integer>();
      List<Integer> lstin = new List<Integer>();

      Integer[] arr = {1,2,3,4,5,6};
      try {
         lstin.addAll(arr);
         lst.addAll(lstin);
         assertEquals("1. List Object", "[1,2,3,4,5,6]", lst.toString());
      } catch(Exception ex) {

      }
      
      AbstractList<Integer> lst1 = new List<Integer>();
      try {
         lst1.addAll(lstin);
      } catch(Exception ex) {

      }
      assertEquals("2. List Object through abstract class", "[1,2,3,4,5,6]", lst1.toString());
      
      ListInterface<Integer> lst2 = new List<Integer>();
      try {
         lst2.addAll(lstin);
      } catch(Exception ex) {

      }
      assertEquals("3. List Object through interface", "[1,2,3,4,5,6]" ,lst2.toString());
   }

   @Test
   public void testCase14() {
      List<Integer> l = new List<Integer>();
      l.add(5);
      l.add(-1);
      assertEquals("1. ", 2, l.size());
      assertEquals("2. ", "[5,-1]", l.toString());
      l.add(0);
      l.add(99);
      assertEquals("3. ", "[5,-1,0,99]", l.toString());
      try {
         l.remove(1);
      } catch(Exception ex) {

      }
      assertEquals("4. ", "[5,0,99]", l.toString());
      assertEquals("5. ", 3, l.size());
      assertEquals("6. ", "[5,0,99]", l.toString());
      assertEquals("7. ", -1, l.indexOf(-1));
      try {
         assertEquals("8. ", "99", ""+l.get(2));
      } catch(Exception ex) {

      }
      assertEquals("9. ", true, l.contains(5));
   }

   @Test
   public void testCase15() {
      List<Integer> lst = new List<Integer>();
      lst.add(8);
      lst.add(12);
      lst.add(97);
      assertEquals("1. ", "[8,12,97]", lst.toString());
      lst.add(11);
      assertEquals("2. ", 4, lst.size());
      try {
         lst.remove(12);
      } catch(Exception ex) {
         
      }
      assertEquals("3. ", "[8,12,97,11]", lst.toString());
      assertEquals("4. ", 4, lst.size());
      assertEquals("5. ", 0, lst.indexOf(8));
      try {
         assertEquals("6. ", "97", ""+lst.get(2));
      } catch(Exception ex) {

      }
      
      try {
         lst.get(12);
      } catch(Exception ex) {
         assertEquals("7.", "Index is out of range", ex.getMessage());
      }

      try {
         lst.get(5);
      } catch(Exception ex) {
         assertEquals("8.", "Index is out of range", ex.getMessage());
      }

      try {
         lst.get(50);
      } catch(Exception ex) {
         assertEquals("9.", "Index is out of range", ex.getMessage());
      }

      try {
         assertEquals("9.1. ", true, lst.contains(97));
      } catch(Exception ex) {
         assertEquals("9.1.", "Index is out of range", ex.getMessage());
      }

      try {
         lst.remove(1);
      } catch(Exception ex) {
         assertEquals("10. ", "Invalid index to remove eleemnt", ex.getMessage());
      }
      assertEquals("10. ", false, lst.contains(12));
   }
}