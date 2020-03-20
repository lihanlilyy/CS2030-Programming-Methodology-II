public class SolidShape3D {
    Shape3D shape;
    Material mat;

    public SolidShape3D(Shape3D shape, Material mat){
        this.shape = shape;
        this.mat = mat;
    }

    public double getMass(){
        return this.mat.getDensity() * this.shape.getVolume();
    }
    public double getDensity(){
        return this.mat.getDensity();
    }
    @Override
	public String toString(){
        return "Solid" + this.shape.toString() + String.format(" with a mass of %.2f" , getMass());
        }
	}