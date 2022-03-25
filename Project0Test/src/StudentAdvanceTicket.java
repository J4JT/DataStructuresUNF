public class StudentAdvanceTicket extends AdvanceTicket {
    int price;
    public StudentAdvanceTicket()
    {
super();
    }
    public StudentAdvanceTicket(int days)
    {
//get price and days from Advanced Ticket

        super(days);
       this.price= super.price/2;
    }
    public int getPrice()
    {
        return this.price;
    }


    public int getSN() {
        return super.getSN();
    }


public String toString()
{
        String presentation="SN:"+this.getSN() + ", " +"$" +this.getPrice() +"(student)";
        return presentation;


}
}