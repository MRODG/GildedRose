import java.util.ArrayList;
import java.util.List;


public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert Pt2", 0, 20));

        updateQuality();

        for(Item item : items){
            System.out.println("Name: "+item.name +" SellBy: "+ item.sellIn +" Quality: "+ item.quality);
        }
}
    public static void updateQuality()
    {
        for(Item item : items){
            switch(Helper.getItemType(item)){

                case AgedBrie:
                    Helper.decSellIn(item);
                    if(!Helper.qualityLimits(item.getQuality()+1)){
                        item.setQuality(item.getQuality()+1);
                    }
                    break;

                case Backstage:
                    Helper.decSellIn(item);
                    if(item.getSellIn() < 0){
                        item.setQuality(0);
                    }
                    else if(item.getSellIn() <= 5){
                        if(!Helper.qualityLimits(item.getQuality()+3)){
                            item.setQuality(item.getQuality()+3);
                        }
                    }
                    else if(item.getSellIn() <= 10){
                        if(!Helper.qualityLimits(item.getQuality()+2)){
                            item.setQuality(item.getQuality()+2);
                        }
                    }
                    else {
                        if(!Helper.qualityLimits(item.getQuality()+1)){
                            item.setQuality(item.getQuality()+1);
                        }
                    }
                    break;

                case Sulfuras:
                    break;

                case Conjured:
                    Helper.decSellIn(item);
                    if(!Helper.qualityLimits(item.getQuality()-2)){
                        item.setQuality(item.getQuality()-2);
                    }
                    break;

                default:
                    Helper.decSellIn(item);
                    if(!Helper.qualityLimits(item.getQuality()-1)){
                        item.setQuality(item.getQuality()-1);
                    }
                    break;
            }
        }
    }
}