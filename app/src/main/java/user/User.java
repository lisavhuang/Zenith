import java.util.*;

import user.Task;

public class User {
    private String name;
    private int currentHp;
    private int currentExp;
    private int currentLvl;
    private int coins;
    private String imgname;

    private int maxHp;
    private int maxExp;

    private int potion;
    private static  ArrayList<Task> list= new ArrayList<Task>();


    public User(String name, String imgname){
        this.name = name;
        this.imgname= imgname;
        currentHp = 15;
        currentExp=0;
        currentLvl=1;
        coins = 0;
        maxExp=10;
        maxHp = 15;

    }
    public String getImgName(){
        return imgname;
    }
    public String getName(){
        return imgname;
    }
    public int getCurrentHp(){
        return currentHp;
    }
    public int getCurrentExp(){
        return currentExp;
    }
    public int getCurrrentLvl(){
        return currentLvl;
    }
    public int getCoins(){
        return coins;
    }
    public void lvlUp(){
        maxExp+= currentLvl *100/2;
        maxHp +=2;
        currentExp=0;
        currentHp = maxHp;
        coins += 2;
    }

    public void died(){
        if(currentExp>=50) {
            currentExp -= 50;
        } else {
            currentExp=0;
        }
        //needs to include red overlay img
    }

    public void buyPotion(){
        if(coins >=25){
            coins-=25;
            potion++;
        } else{
        }
    }

    public void water(){
        if(potion>0) {
            currentHp += 10;
        } else{

        }

    }
    public void completeTask(){
        currentExp+=10;
    }

}
