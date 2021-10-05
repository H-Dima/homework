package main;

public class PreciousStones implements Stone{
    String nameStone;
    double caratStone;
    double priceStone;
    int transparencyStone;

    public PreciousStones(String name, double carat, double price, int transparency){
        nameStone=name;
        caratStone=carat;
        priceStone=price;
        transparencyStone=transparency;
    }

    @Override
    public String name() {
        return nameStone;
    }

    @Override
    public double carat() {

        return caratStone;
    }

    @Override
    public double price() {
        return priceStone;
    }

    @Override
    public int transparency() {
        return transparencyStone;
    }
}
