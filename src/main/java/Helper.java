public class Helper{

    protected enum ItemType{
        Regular(""),
        AgedBrie("Aged Brie"),
        Sulfuras("Sulfuras"),
        Backstage("Backstage passes"),
        Conjured("Conjured");

        private final String label;

        private ItemType(String label){
            this.label = label;
        }
    }

    protected static ItemType getItemType(Item item){
        if(item.getName().contains(ItemType.AgedBrie.label))
            return ItemType.AgedBrie;
        else if(item.getName().contains(ItemType.Backstage.label))
            return ItemType.Backstage;
        else if(item.getName().contains(ItemType.Conjured.label))
            return ItemType.Conjured;
        else if(item.getName().contains(ItemType.Sulfuras.label))
            return ItemType.Sulfuras;
        else 
            return ItemType.Regular;
    }

    protected static boolean qualityLimits(int quality){
        return (quality > 50 || quality < 0);
    }

    protected static void decSellIn(Item item){
        item.setSellIn(item.getSellIn()-1);
    }

}