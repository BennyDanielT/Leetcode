import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new AbstractList<List<String>>() {
            List<List<String>> result;

            Map<String, List<String>> map = new HashMap<>();

            public List<String> get(int index) {
                if (result == null) {
                    init();
                }
                return result.get(index);
            }

            public int size() {
                if (result == null) {
                    init();
                }

                return result.size();
            }

            private void init() {
                for (String s : strs) {
                    char[] code = new char[26];
                    for (char ch : s.toCharArray()) {
                        code[ch - 'a']++;

                    }

                    String hashCode = new String(code);
                    List<String> existingList = map.get(hashCode);
                    if (existingList == null) {
                        map.put(hashCode, new ArrayList<>());
                    }

                    map.get(hashCode).add(s);
                }
                result = new ArrayList<>(map.values());

            }
        };

    }
}

/*
 * Abstract Class:
 * What is the purpose of an abstract class?
 * The purpose of an abstract class is to provide a blueprint for derived
 * classes and set some rules that the derived classes must implement when they
 * inherit an abstract class. We can use an abstract class as a base class and
 * all derived classes must implement abstract definitions.
 * ### Approach 1: 7ms
 * 
 * 1. Create a 2D ArrayList to store the result.
 * 2. Create a HashMap.
 * 3. Traverse through the input array of Strings and for each String, repeat
 * steps **3.1-3.2**
 * 1. Convert to Character Array
 * 2. Sort it and convert it back into a String
 * 4. Create a new entry for the String in the **HashMap** if it isn't already
 * present.
 * 5. With the Sorted String as Key and Original String as Value, add the entry
 * to the HashMap.
 * 6. Iterate through the Maps.values() and add it to the result.
 * 
 * 
 * ### Approach 2: 0ms
 * 1. Create an anonymous class extending **AbstractList**.
 * 2. Declare a 2D ArrayList.
 * 3. Override the Get() and size() functions of List.
 * 4. Traverse through the String of Arrays and for each string:
 * 1. Convert it into a "Hash Code" using character subtraction for each
 * characters in the string.
 * 2. Use the hashcode to find if an Inner ArrayList already exists, if not
 * initialize an empty ArrayList in the map.
 * 3. Add the String to the HashMap using the Hashcode as Key and the String as
 * value.
 * 4. Add the Hashmap's values to the 2D Result ArrayList.
 * 
 * 
 * ## Special Learnings
 * 
 * 1. **Abstract Classes**: refers to a class that provides a partial
 * implementation of an interface. Example : An Abstract List
 * 2. **Anonymous Inner Class**: An anonymous inner class is a special type of
 * class in Java that allows you to create a one-time, unnamed class definition
 * inline, without explicitly giving it a name. It's typically used when you
 * need a small, simple implementation of an interface or an extension of a
 * class for a specific task, and you don't need to reuse that implementation
 * elsewhere in your code
 * -> **List.of()** function to define a list with an element `List<String>
 * newList = List.of(existingElement);`
 * -> **Arrays.asList()** function `List<String> newList = new
 * ArrayList<>(Arrays.asList(existingElement));`
 */