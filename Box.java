class Box<T>{
    private final T t;

    Box(T t){
        this.t = t;
    }


    static <U> Box<U> of(U t){
        return new Box<U>(T);
    }
    //Box.of("cholocate").get().length();

    static <U> Box<U> empty(){
        return new Box<U>(null);
    }

    void add (T t){
        this.t = t;
    }

    T get(){
        return this.t;
    }

    @Override
    public String toString(){
        return "[" + this.t + "]";
    }
}

// new Box<String> ("chocolate").get().length();
