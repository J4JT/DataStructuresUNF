public class WalkupTicket extends FixedPriceTicket {
    int price=50;
    public WalkupTicket()
    {
    }

    public int getPrice()
    {
        return this.price;
    }


    public int getSN() {
        return super.getSN();
    }
}
