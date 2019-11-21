import java.util.ArrayList;
import java.util.Random;

public class Market {
    private Ship ship;
    private ArrayList<Item> goods;

    public Market(TechLevel techLevel, double priceAdjust, boolean isGameWinning) {
        //one ship
        //some fuel
        //1 or more ship upgrades
        //repair ship
        Random random = new Random();
        int numUpgrades = random.nextInt(5);
        goods = new ArrayList<Item>();

        for (int i = 0; i < numUpgrades; i++) {
            goods.add(new ShipUpgrade(techLevel, priceAdjust));
        }
        ship = Ship.getRandomShip();
        goods.add(new Item("Ship", 1000 * (techLevel.getPriceAdjust() + priceAdjust)
                , 1000 * (techLevel.getPriceAdjust() - priceAdjust)
                , 1000, 0, TechLevel.PREAGRICULTURAL));
        if (isGameWinning)
        {
            goods.add(new Item(  Player.getName() + "'s Universe", 9999, 9999, 9999, 0, TechLevel.PREAGRICULTURAL));
        }
    }

    public String[] toArray(int goodNum) {
        String[] response = new String[7];
        if ((goods.size() - 1 < goodNum) || goodNum < 0) {
            response[0] = "Empty";
        } else {
            response[0] = goods.get(goodNum).getName();
            response[1] = (int) goods.get(goodNum).getBuyPrice() + " credits";
            response[2] = goods.get(goodNum).getCargoSpace() + " space used";
        }
        return response;
    }

    public int getGoodsLength() {
        return goods.size();
    }

    public Item removeGood(int goodNum) {
        return goods.remove(goodNum);
    }

    public double getGoodBuyPrice(int goodNum) {
        return goods.get(goodNum).getBuyPrice();
    }

    public int getGoodCargo(int goodNum) {
        return goods.get(goodNum).getCargoSpace();
    }

    public void addGood(Item item) {
        goods.add(item);
    }

    public String getGoodName(int goodNum) {
        return goods.get(goodNum).getName();
    }

}
