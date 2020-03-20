public class SolidCuboid{
    double Height;
	double Width;
    double Length;
    double Density;
	public SolidCuboid(double Height, double Width, double Length,double Density){
		this.Height = Height;
		this.Width = Width;
        this.Length = Length;
        this.Density = Density;
	}
	public SolidCuboid setLength(double length){
		return new SolidCuboid(this.Height, this.Width, length, this.Density);
	}

	public SolidCuboid setHeight(double height){
		return new SolidCuboid(height, this.Width, this.Length, this.Density);
	}
	public SolidCuboid setWidth(double width){
		return new SolidCuboid(this.Height, width, this.Length, this.Density);
    }
    public SolidCuboid setDensity(double density){
        return new SolidCuboid(this.Height, this.Width, this.Length, density);
    }
    public double getDensity(){
        return this.Density;
    }
    public double getMass(){
        return getDensity() * getVolume();
    }
	public double getVolume(){
		return this.Height * this.Width * this.Length;
	}

	public double getSurfaceArea(){
		return 2 * this.Height * this.Width + 2 * this.Height * this.Length + 2 * this.Width * this.Length;
	}

	@Override
	public String toString(){
		return String.format("SolidCuboid [%.2f x %.2f x %.2f] with a mass of %.2f", Height, Width, Length, getMass());
	}
}