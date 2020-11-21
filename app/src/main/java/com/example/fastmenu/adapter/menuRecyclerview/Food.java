package com.example.fastmenu.adapter.menuRecyclerview;

//import com.google.firebase.database.IgnoreExtraProperties;

//@IgnoreExtraProperties
public class Food {
    private String foodPic;
    private String foodName;
    private String foodPrice;
    private String salePeriod;

    public Food(){}

    public Food(String foodPic, String foodName, String foodPrice, String salePeriod){
        this.foodPic = foodPic;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.salePeriod = salePeriod;
    }

    public String getFoodPic() {
        return foodPic;
    }

    public void setFoodPic(String foodPic) {
        this.foodPic = foodPic;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getSalePeriod() {
        return salePeriod;
    }

    public void setSalePeriod(String salePeriod) {
        this.salePeriod = salePeriod;
    }




}
