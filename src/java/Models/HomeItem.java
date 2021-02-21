
package Models;


public class HomeItem {
    private String user;
    private String category;
    private String itemName;
    private String price;
    
    public HomeItem(){
        
    }
    public HomeItem(String user,String category, String itemName,String price){
        this.user = user;
        this.category = category;
        this.itemName= itemName;
        this.price = price;
                
    }
    public String getUser(){
        return user;
    }
    public void setUser(String user){
        this.user = user;
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
    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public String toString() {
		return String.format("%s\t%s\t%s\t%s", user,category,itemName,price);
	}
	public String formatToFile() {
		return String.format("%s,%s,%s,%s,", user,category,itemName,price);
	}
}
