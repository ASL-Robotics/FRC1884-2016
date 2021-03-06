package org.usfirst.frc.team1884.robot.deprecated;

import java.io.IOException;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * Helps process data from the GRIP Network table.
 * 
 * @author Kaito Arai
 * @version 1
 * @since 29/1/2016
 * 
 */
@Deprecated
public class GRIP extends Subsystem {
	private NetworkTable table;

	public final static GRIP INSTANCE;

	static {
		INSTANCE = new GRIP();
	}

	private GRIP() {
		try {
			new ProcessBuilder("/usr/local/frc/JRE/bin/java", "-jar", "/home/lvuser/grip.jar",
					"/home/lvuser/project.grip").inheritIO().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		table = NetworkTable.getTable("GRIP");
	}

	/**
	 * Finds the center x coordinate of the largest contour.
	 * <p>
	 * First the method finds the contour with the largest area and records the
	 * index number of this contour. It then proceeds to return the value of the
	 * x coordinate of the center of the contour.
	 */
	public double getCenter() {
		int largestIndex = -1;
		double largestNumber = 0;
		double[] area = table.getNumberArray("targets/area", new double[0]);
		double[] centerX = table.getNumberArray("targets/centerX", new double[0]);
<<<<<<< HEAD:Official Test Code/src/org/usfirst/frc/team1884/robot/subsystems/GRIP.java
=======
		if (area.length != centerX.length) {
			return -1;
		}
>>>>>>> 1884Programmers/master:FRC1884-2016/src/org/usfirst/frc/team1884/robot/deprecated/GRIP.java
		if (area.length == 0) {
			return -1;
		}
		for (int i = 0; i < area.length; i++) {
			if (area[i] > largestNumber) {
				largestNumber = area[i];
				largestIndex = i;
			}
		}
		if (largestIndex == -1) {
			return -1;
		}
		return centerX[largestIndex];
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
}
