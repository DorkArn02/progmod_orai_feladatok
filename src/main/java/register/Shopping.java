package register;

public class Shopping extends Basket{

    public void addGoods(Goods g) {
        goodsList.add(g);
    }

    public void removeGoods(Goods g) {
        goodsList.remove(g);
    }

    public void updatePrice(String name, int expectedPrice) {
        for (Goods g : goodsList) {
            if(g.getName().equals(name))
                g.setPrice(expectedPrice);
        }
    }
}
