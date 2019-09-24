package raytracing;

public class Point3D {
double x;
double y;
double z;
	public Point3D(double X,double Y,double Z) {
		x=X;
		y=Y;
		z=Z;
	}
	public Point3D multiply(double scale){
		return new Point3D(x*scale,y*scale,z*scale);
	}
	public static Point3D add(Point3D a, Point3D b){
		return new Point3D(a.x+b.x,a.y+b.y,a.z+b.z);
	}

}
