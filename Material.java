public class Material{
    String name;
    double Density;

    public Material(String name, double Density){
        this.name = name;
        this.Density = Density;
    }
    public double getDensity(){
        return this.Density;
    }
}