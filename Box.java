class Box<T>{
    public final T t;
    private static final Box <?> EMPTY_BOX = new Box<>(null);


    Box(T t){
        this.t = t;
    }

    static <U> Box<U> of(U t){
        if(t == null){
            return null;
        } else {
            return new Box<U>(t);
        }
    }

    @Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj instanceof Box<?>){
			Box<T> oBox = (Box<T>) obj;
			if(this.get() == null){
				return oBox.get() == null;
			}
			if(this.get().equals(oBox.get())){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
        }
    }

    T get(){
        return this.t;
    }

    @SuppressWarnings("unchecked")
    static <T> Box<T> empty(){
        return (Box<T>)EMPTY_BOX;
    }

    static <T> Box<T> ofNullable(T t){
        if(t == null){
            return empty();
        } else {
            return new Box<T>(t);
        }
    }

    public boolean isPresent(){
        if(this.get() == null){
            return false;
        } else {
            return true;
        }
    }

    public Box<T> filter(BooleanCondition<? super T> bc){
        if(t == null){
            return empty();
        } else if(bc.test(this.t)){
            return new Box<T>(this.t);
        } else {
            return empty();
        }
    }

    public <U> Box<U> map(Transformer<? super T, ? extends U> y){
        if(t == null || y == null){
            return empty();
        } else {
            return new Box<U>(y.transform(this.t));
        }
    }
    /*

    
*/
    @Override
    public String toString(){
        if (this.t == null){
            return "[]";
        } else{
            return "[" + this.t + "]";
        }
    }
}

/*
    why must wright get()
*/