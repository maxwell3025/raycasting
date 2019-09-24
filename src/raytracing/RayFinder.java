package raytracing;

public class RayFinder {
	static double precision = 100;
	public static int atray(int[][][] map, Point3D player, Point3D ray){
		Point3D move = ray.multiply(1/precision);
		int result = 0;
		double distance = 0;
		while(result==0){
			
			Point3D scanpoint = Point3D.add(player, move.multiply(distance));
			distance++;
			result = arrayat(map, scanpoint);
		}
		return result;
	}
	public static int arrayat(int[][][] toscan, Point3D scanpoint){
		int x=(int)Math.floor(scanpoint.x);
		int y=(int)Math.floor(scanpoint.y);
		int z=(int)Math.floor(scanpoint.z);
		return toscan[x][y][z];
	}
}
