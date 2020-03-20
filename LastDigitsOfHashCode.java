class LastDigitsOfHashCode implements Transformer<Object, Integer> {
    int k;
    public LastDigitsOfHashCode(int k){
        this.k = k;
    }

    public Integer transform(Object o){
        Integer h = o.hashCode();
        Integer intermediate = (int) Math.pow(10, k);
        return Math.abs(h % intermediate);
    }
}