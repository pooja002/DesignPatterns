
/*
Header notes:
1.Factory design pattern is a creational design pattern, primarly used when we have multiple subclasses
   of a super class & based on input we will create & return the class instance
2. Provides abstraction b/w implementation & client class
3. Remove instantiation of client class from client code

Implementation Style Notes:

1. Super class can be interface or abstract class or base class
2. Factory class has a static method which returns the instance of sub-class based on input

 * */

abstract class Medicine
{
    public abstract int getDosage();

    public String toString()
    {
        return "Dosage:"+this.getDosage();
    }
}

class Dolo65 extends Medicine {
    int dosage;

    Dolo65(int dosage){
        this.dosage = dosage;
    }

    @Override
    public int getDosage() {
        return this.dosage;
    }
}

class Citrizen extends Medicine
{
    int dosage;

    Citrizen(int dosage)
    {
        this.dosage = dosage;
    }

    @Override
    public int getDosage() {
        return this.dosage;
    }
}

class MedicineFactory
{
    public static Medicine getMedicineInstance(String type, int dosage)
    {

        if(type.equals("Dolo65"))
        {
            return new Dolo65(dosage);
        }
        else if (type.equals("Citrizen"))
        {
            return new Citrizen(dosage);
        }

        return null;

    }
}

public class FactoryDesignPattern {

    public static void  main (String[] args)
    {
        Medicine dolo = MedicineFactory.getMedicineInstance("Dolo65",50);

        System.out.println("dolo "+dolo.getDosage());

        Medicine citrizen = MedicineFactory.getMedicineInstance("Citrizen",100);

        System.out.println("citirizen "+citrizen.getDosage());

    }

}


