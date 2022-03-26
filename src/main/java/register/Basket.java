package register;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Goods> goodsList;

    public Basket(){
        goodsList = new ArrayList<>();
    }

    public String createReceipt() {
        String s = "";

        for (Goods g : goodsList) {
            s += g.getName() + " " + g.getPrice() + "\r\n";
        }

        return s;
    }

    public int getTotalPrice() {
        return goodsList.stream().mapToInt(Goods::getPrice).sum();
    }
}
