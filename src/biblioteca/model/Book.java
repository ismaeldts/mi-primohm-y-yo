package biblioteca.model;

public class Book {

    private String id;
    private String name;
    private String description;
    private Integer localStock;

    public Book (){

    }

    public Book(String id, String name, String description, Integer localStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.localStock = localStock;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLocalStock() {
        return localStock;
    }

    public void setLocalStock(Integer localStock) {
        this.localStock = localStock;
    }
}
