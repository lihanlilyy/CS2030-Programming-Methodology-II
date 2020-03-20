class FastFood {

}

class Burger extends FastFood{
    void foo(Burger[] box){ }
    Burger[] bbox = new Burger[1];
}

class CheeseBurger extends Burger{
    CheeseBurger[] cbox = new CheeseBurger[1];
    //foo(cbox) works, just as foo(bbox), as cheeseburger<: burger
    // co-varient, as cheeseburger is subset. 
}

/*
    however, if we do this: 

    void foo(Burger[] box){ box[0] = new Burger();}
    
    then, foo(cbox) won't work. similarly, fbox also wont work
    as the types are different. this is called invariant. 
*/


/* 
    Box<Burger> bbox = Box.of(new Burger());
    foo(bbox) can work. 

    However, if do 
    Box<CheeseBurger> cbox = Box.of(new CheeseBurger())
    foo(cbox) cannot. foo(fbox) also cannot. 

    Cannot sub with a more specific or more generic type. 

    void putBurger(Box<? super Burger> box {box.add(new Burger())})
    putBurger(fbox)
    fbox.get() --> contravarient. 
*/ 