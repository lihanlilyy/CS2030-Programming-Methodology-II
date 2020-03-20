class DivisibleBy implements BooleanCondition<Integer>{
    int d;

    public DivisibleBy(int d){
        this.d = d;
    }

    public boolean test(Integer i){
        if(i == null){
            return false;
        } else if(i % this.d == 0){
            return true;
        } else {
            return false;
        }
    }
}