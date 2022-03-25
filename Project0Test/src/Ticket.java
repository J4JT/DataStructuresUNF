
import java.util.Random;
import java.util.ArrayList;
public abstract class Ticket  {

    //fields
    static ArrayList<Integer> serialMemory=new ArrayList<Integer>();
    private int serial;

    public Ticket()  {

        //ticket generator
int serialNumber;
        //assign and check SN
        Random random=new Random();

        do {
            serialNumber = random.nextInt(10000);

            if (checkSN(serialNumber) == false) {
                serialMemory.add(serialNumber);
                this.serial = serialNumber;
                break;
            }
        }  while(checkSN(serial)!=false);



    }

    abstract int getPrice();


    public int getSN()
    {
        return this.serial;
    }

//private helper that checks if SN is already in static arraylist
    private boolean checkSN(int checker)
    {
        if(serialMemory.contains(checker))
            return true;
        else
            return false;
    }

public String toString()
    {
        String presentation="SN:"+this.getSN() + ", " +"$" +this.getPrice();
        return presentation;
    }


    }


