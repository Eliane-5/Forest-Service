public class Animals {
    private String name;
    public Animals(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
//    public int getId(){
//        return id;
//    }

    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animals)) {
            return false;
        } else {
            Animals newAnimal = (Animals) otherAnimal;
            return this.getName().equals(newAnimal.getName());
        }
    }


}
