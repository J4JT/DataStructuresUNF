public abstract class FixedPriceTicket extends Ticket {
    int price;
    public FixedPriceTicket()
    {

    }

    public FixedPriceTicket(int fixed){
        this.price=fixed;
    }


}
