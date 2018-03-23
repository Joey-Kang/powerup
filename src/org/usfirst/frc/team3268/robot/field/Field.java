package org.usfirst.frc.team3268.robot.field;

import edu.wpi.first.wpilibj.DriverStation;

public class Field {

	public static Side OUR_NEAR_SWITCH_SIDE;
	public static Side OUR_FAR_SWITCH_SIDE;
	public static Side OUR_SCALE_SIDE;
	
	public static void init() {
		
		String info = DriverStation.getInstance().getGameSpecificMessage();
		if (info == null) return;
		info = info.toUpperCase();
		
		OUR_NEAR_SWITCH_SIDE = info.charAt(0) == 'R' ? Side.RIGHT : Side.LEFT;
		OUR_FAR_SWITCH_SIDE = info.charAt(1) == 'R' ? Side.RIGHT : Side.LEFT;
		OUR_SCALE_SIDE = info.charAt(2) == 'R' ? Side.RIGHT : Side.LEFT;
		
	}
	
}
