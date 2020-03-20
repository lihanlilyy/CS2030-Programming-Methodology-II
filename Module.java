import java.util.Map;
import java.util.HashMap;
import java.util.Optional;


class Module extends KeyableMap<String, String, Assessment>{
    private String name;
    private Map<String, Assessment> map;

    public Module(String name){
        super(name);
        this.name = name;
        this.map = new HashMap<>();
    }

    @Override 
    Module put(Assessment assessment){
        this.map.put(assessment.getKey(), assessment);
        return this;
    }

    public Optional<Assessment> get(String items) {
        if (this.map.containsKey(items)){
            return Optional.of(this.map.get(items));
        } else {
            return Optional.empty();
        }
    }


    @Override
    public String toString() {
        return (this.name + ": " + map.values()).replace("[", "{").replace("]", "}");
    }

}