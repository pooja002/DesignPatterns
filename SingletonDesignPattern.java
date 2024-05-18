public class SingletonDesignPattern {

    public  static void  main(String args[])
    {
        SingletonEager singletonEagerInstance1 = SingletonEager.getSingletonEagerInstance();

        System.out.println("SingletonEagerInstance1 object "+singletonEagerInstance1);

        SingletonEager singletonEagerInstance2 = SingletonEager.getSingletonEagerInstance();

        System.out.println("singletonEagerInstance2 object"+singletonEagerInstance2);

        SingletonDesignPatternLazy singletonDesignPatternLazyInstance1 = SingletonDesignPatternLazy.getSingletonDesignPatternLazyInstance();

        System.out.println("singletonDesignPatternLazyInstance1 object "+singletonDesignPatternLazyInstance1);

        SingletonDesignPatternLazy singletonDesignPatternLazyInstance2 = SingletonDesignPatternLazy.getSingletonDesignPatternLazyInstance();

        System.out.println("singletonDesignPatternLazyInstance2 object "+singletonDesignPatternLazyInstance2);



    }


}

class SingletonEager
{
    // Eager loading means creating the object despite it's need, whether it is asked for or not

    // declare and define the instance at the same time
    private static   SingletonEager singletonEagerInstance = new SingletonEager();

    // make constructor private

    private  SingletonEager()
    {

    }
    public static SingletonEager getSingletonEagerInstance()
    {
        return singletonEagerInstance;
    }
}

class SingletonDesignPatternLazy
{
    // lazy loading is about creating the object only if necessary

    // declare the instance but don't define it yet
    private static SingletonDesignPatternLazy singletonDesignPatternLazyInstance ;

    // private constructor
    private  SingletonDesignPatternLazy() {
    }

    // create the instance if it doesn't already exist
    public static SingletonDesignPatternLazy getSingletonDesignPatternLazyInstance() {

        if(singletonDesignPatternLazyInstance==null)
        {
            singletonDesignPatternLazyInstance = new SingletonDesignPatternLazy();
        }
        return singletonDesignPatternLazyInstance;
    }
}

class SingletonThreadSafe
{
    // when two users are trying to access same thing, the normal singleton pattern may not be thread safe
    private static SingletonThreadSafe singletonThreadSafeInstance ;

    private SingletonThreadSafe(){};

    // make the entire method synchronized for read write operations on the object
    public static synchronized SingletonThreadSafe singletonThreadSafeInstance(){
        if(singletonThreadSafeInstance==null)
        {
            singletonThreadSafeInstance  = new SingletonThreadSafe();
        }
        return singletonThreadSafeInstance;
    }
}


class SingletonThreadSafe2
{
    private static SingletonThreadSafe2 singletonThreadSafe2Instance;

    private  SingletonThreadSafe2(){};

    public static  SingletonThreadSafe2 getSingletonThreadSafe2()
    {
        if(singletonThreadSafe2Instance==null)
        {
            synchronized (SingletonThreadSafe2.class){
                if(singletonThreadSafe2Instance==null)
                {
                    singletonThreadSafe2Instance = new SingletonThreadSafe2();
                }
            }

        }
        return singletonThreadSafe2Instance;
    }
}
