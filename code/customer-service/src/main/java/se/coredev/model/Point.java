package se.coredev.model;

public final class Point {

	private final int x;
	private final int y;

	public static Point valueOf(String value){
		String[] parts = value.split(":");
		return new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
