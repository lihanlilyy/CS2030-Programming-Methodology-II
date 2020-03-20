List<Integer> integers(); 

//new List<Interger>() cannot run
//new ArrayList<Integer>() can run , gives []
//List<Integer> integers = new ArrayList<Integer>(), asisgnment is
//possible due to covariants, as ArrayList <: List and 
//ArrayList<E> <: List<E>.


// integers.add(1)
//integers.add(2)
//List<Number> numbers = new ArrayList<>(integers)
//numbers.add(3.0) --> double value also can
//List<Object> objects = new ArrayList<>(numbers)
//objects.add("abc")
// ojects ==> [1, 2, 3.0, abc]

//List<?> list = objects
//list.add("abc") --> cannot
//Number foo(List<? extends Numver> list) {return list.get(0);}


/*  
    List<String> strings = Arrays.asList("abc, xy")

    class LenComparator implements Comparator<String>{
        @Override
        public int compare(String s1,  String s2){
            return s1.length() - s2.length();
        }
    }

    strings.sort(new LenComparator())
*/



/* 
    "abc".hashCode()
    "xy".hashCode()

    class hashComparator implements Comparator<Object>{
        @Override
        public int compare(Object o1, Object o2){
            return o1.hashCode() % 1000 - o2.hashCode() % 1000;
        }
    }

    strings.sort(new HashComparator())
    strings --> then returns the sorted version of string.
*/