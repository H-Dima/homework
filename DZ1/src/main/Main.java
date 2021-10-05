package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Stone> necklace = new ArrayList<Stone>();
        double totalCarat=0;
        double totalPrice=0;
        int start, end;

        for(int i=1; i<=4; i++){
            necklace.add(new PreciousStones(
                    "PreciousStones"+i,
                    Math.round((0+(double) (Math.random() * 10))*100.0)/100.0,
                    Math.round((0+(double) (Math.random() * 1000))*100.0)/100.0,
                    1+(int) (Math.random() * 4 )));
            necklace.add(new SemiPreciousStones(
                    "SemiPreciousStones"+i,
                    Math.round((0+(double) (Math.random() * 20))*100.0)/100.0,
                    Math.round((0+(double) (Math.random() * 100))*100.0)/100.0,
                    1+(int) (Math.random() * 4)));
        }
        for(Stone stone: necklace){
            totalCarat+=stone.carat();
            totalPrice+=stone.price();
        }

        totalCarat=Math.round(totalCarat*100.0)/100.0;
        totalPrice=Math.round(totalPrice*100.0)/100.0;
        System.out.println("Общий вес в каратах "+totalCarat);
        System.out.println("Общая стоимость "+totalPrice);

        necklace.sort(new Comparator<Stone>() {
            @Override
            public int compare(Stone o1, Stone o2) {
                if(o1.price()>o2.price()){
                    return 1;
                } else if(o1.price()<o2.price()){
                    return -1;
                }else
                return 0;
            }
        });
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте диапазон прозрачности камней от 1 до 4");
        start=scanner.nextInt();
        end=scanner.nextInt();
        System.out.println("В заданом диапазоне прозрачности камней в ожерелье находятся следующие камни");
        for(Stone stone: necklace){
            if(stone.transparency()>=start&stone.transparency()<=end){
                System.out.println("Камень: "+stone.name());
               /* System.out.println(stone.carat());
                System.out.println(stone.price());*/
                System.out.println("прозрачность камня: "+stone.transparency());
            }
        }
    }
}
