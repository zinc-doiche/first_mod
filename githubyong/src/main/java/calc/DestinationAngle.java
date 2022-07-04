package calc;

public class DestinationAngle {

	public DestinationAngle() {
		
	}
	
	public static double getAngle(double yaw, double playerPosX, double playerPosZ, double destinationPosX, double destinationPosZ) {
		yaw += 180; 
		double theta = -Math.toDegrees(Math.atan2(destinationPosX - playerPosX, destinationPosZ - playerPosZ)) + 180;
		return (yaw - theta < 0 ? yaw - theta + 360 : yaw - theta) / 360;
	}
	
}
