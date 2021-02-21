
package Models;


public class HomeItem {
    private String category;
    private String itemName;
    private int price;
    
    public HomeItem(){
        
    }
    public HomeItem(String category, String itemName,int price){
        this.category = category;
        this.itemName= itemName;
        this.price = price;
                
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public String getItemName(){
        return itemName;
    }
    public void setItemName(String itemName){
        this.itemName = itemName;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public String toString() {
		return String.format("%d\t%s\t%s", category,itemName,price);
	}
	public String formatToFile() {
		return String.format("%d , %s , %s", category,itemName,price);
	}
}
