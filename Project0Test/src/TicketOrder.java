import java.util.ArrayList;
public class TicketOrder  {
    //data struct
    ArrayList<Ticket> Order = new ArrayList<>();
String result;


    public void add(Ticket ticket) {
        Order.add(ticket);
    }

    public int getPrice() {
        //goes to total price
        int sum = 0;
        for (Ticket a : Order) {
            int current = a.getPrice();
            sum = sum + current;
        }
        return sum;
    }

    public int totalPrice() {
        return getPrice();
    }

    public String toString() {
        for (Ticket a: Order) {
            result = a.toString();
            System.out.println(result);
        }
        return " ";
    }
}



