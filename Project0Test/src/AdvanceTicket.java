import java.util.InputMismatchException;
import java.time.*;
public class AdvanceTicket extends Ticket
{
 int price;
    public AdvanceTicket()
    {
    }

    public AdvanceTicket(int days) throws InputMismatchException
    {
//price set
        if(days<10) {
            this.price = 40;
        }
        else if(days>10) {
            this.price = 30;
        }

        if (days<0) {
            System.exit(0);
        }

    }




    public int getPrice()
    {
        return this.price;
    }

//get SN from Ticket
    public int getSN() {
        return super.getSN();
    }
}
