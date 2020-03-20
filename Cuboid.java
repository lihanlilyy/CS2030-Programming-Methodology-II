public class Cuboid extends Shape3D{
	double Height;
	double Width;
	double Length;
	public Cuboid(double Height, double Width, double Length){
		this.Height = Height;
		this.Width = Width;
		this.Length = Length;
	}
	public Cuboid setLength(double length){
		return new Cuboid(this.Height, this.Width, length);
	}

	public Cuboid setHeight(double height){
		return new Cuboid(height, this.Width, this.Length);
	}
	public Cuboid setWidth(double width){
		return new Cuboid(this.Height, width, this.Length);
	}
	public double getVolume(){
		return this.Height * this.Width * this.Length;
	}

	public double getSurfaceArea(){
		return 2 * this.Height * this.Width + 2 * this.Height * this.Length + 2 * this.Width * this.Length;
	}

	@Override
	public String toString(){
		return String.format("Cuboid [%.2f x %.2f x %.2f]", Height, Width, Length);
	}
}