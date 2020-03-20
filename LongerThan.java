class LongerThan implements BooleanCondition<String>{
    int d;

    public LongerThan(int d){
        this.d = d;
    }

    public boolean test(String str){
        if(str == null){
            return false;
        } else if(str.length() <= this.d){
            return false;
        } else {
            return true;
        }
    }
}