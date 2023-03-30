package data;

public class Coordinates {
    private long x;
    private Integer y; //Поле не может быть null

    public Coordinates(long x, Integer y){
        this.x = x;
        this.y = y;
    }
    public Coordinates(){}

    public long getX(){return x;}
    public void setX(long x){this.x = x;}
    public int getY(){return y;}
    public void setY(Integer y){this.y = y;}
}
