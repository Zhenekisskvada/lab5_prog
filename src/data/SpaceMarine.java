package data;

import java.time.LocalDateTime;

public class SpaceMarine {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float health; //Поле не может быть null, Значение поля должно быть больше 0
    private Integer height; //Поле может быть null
    private Weapon weaponType; //Поле не может быть null
    private MeleeWeapon meleeWeapon; //Поле не может быть null
    private Chapter chapter; //Поле не может быть null

    public SpaceMarine(int id, String name, Coordinates coordinates, LocalDateTime creationDate,Float health, Integer height, Weapon weaponType,
            MeleeWeapon meleeWeapon,Chapter chapter) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.health = health;
        this.height = height;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public SpaceMarine(){}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public java.time.LocalDateTime getCreationDate(){return creationDate;}
    public void setCreationDate(java.time.LocalDateTime creationDate){this.creationDate = creationDate;}
    public float getHealth(){return health;}
    public void setHealth(Float health){this.health = health;}
    public int getHeight(){return height;}
    public void setHeight(Integer height){this.height = height;}
    public Weapon getWeaponType(){return weaponType;}
    public void setWeaponType(Weapon weaponType){this.weaponType = weaponType;}
    public MeleeWeapon getMeleeWeapon(){return meleeWeapon;}
    public void setMeleeWeapon(MeleeWeapon meleeWeapon){this.meleeWeapon = meleeWeapon;}
    public Chapter getChapter(){return chapter;}
    public void setChapter(Chapter chapter){this.chapter = chapter;}
}
