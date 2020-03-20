import java.lang.Math;
public class Sphere extends Shape3D{
    double Radius;
    
    public Sphere(double Radius){
        this.Radius = Radius;
    }
    public Sphere setRadius(double r){
        return new Sphere(r);
    }

    public double getVolume(){
        double q = 1 / (double) 3;
        return 4 * Math.PI * this.Radius * this.Radius * this.Radius * q; 
    }
    public double getSurfaceArea(){
        return 4 * Math.PI * this.Radius * this.Radius;
    }
    @Override
	public String toString(){
		return String.format("Sphere [%.2f]", Radius);
    }
}