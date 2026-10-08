package org.example.enums;

public enum TickectCategory {

    REGULAR(1),
    PREMIUM(2),
    VIP(3),
    RECLINER(4);
    private  final  int id;

    TickectCategory(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public static  TickectCategory getById(int id){
        for(TickectCategory category : TickectCategory.values()){
            if(category.getId() == id){
                return category;
            }
        }
        throw new IllegalArgumentException(
                "Invalid ticket category: " + id
        );

    }
    public static TickectCategory getByName(String name){
        for(TickectCategory category : TickectCategory.values()){
            if(category.name().equalsIgnoreCase(name)){
                return category;
            }
        }
        throw  new IllegalArgumentException(
                "Invalid name:"+name
        );

    }
}
