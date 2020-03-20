public class SolidSphere{
    double Radius;
    double Density;

    public SolidSphere(double Radius, double Density){
        this.Radius = Radius;
        this.Density = Density;
    }

    public double getVolume(){
            double q = 1 / (double) 3;
            return 4 * Math.PI * this.Radius * this.Radius * this.Radius * q; 
    }

    public double getSurfaceArea(){
        return 4 * Math.PI * this.Radius * this.Radius;
    }
    public double getDensity(){
        return this.Density;
    }
    public double getMass(){
        return getDensity() * getVolume();
    }
    public SolidSphere setRadius(double r){
        return new SolidSphere(r, this.Density);
    }
    public SolidSphere setDensity(double d){
        return new SolidSphere(this.Radius, d);
    }

	@Override
	public String toString(){
		return String.format("SolidSphere [%.2f] with a mass of %.2f", Radius, getMass());
	}
}