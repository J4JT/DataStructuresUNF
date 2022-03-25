public class ComplementaryTicket extends FixedPriceTicket {
   int price=0;
    public ComplementaryTicket()
    {
        super();
    }

    public int getPrice() {
        return price;
    }


    public int getSN() {
        return super.getSN();
    }
}
