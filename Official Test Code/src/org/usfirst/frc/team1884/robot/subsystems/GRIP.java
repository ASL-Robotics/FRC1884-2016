package org.usfirst.frc.team1884.robot.subsystems;

import java.io.IOException;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class GRIP {
	private static String[] GRIP_ARGS;
	private NetworkTable table;

	private final static GRIP INSTANCE;

	static {
		INSTANCE = new GRIP();
	}

	private GRIP() {
		GRIP_ARGS = new String[] { "/usr/local/frc/JRE/bin/java", "-jar", "/home/lvuser/grip.jar",
				"/home/lvuser/project.grip" };
		table = NetworkTable.getTable("grip");
		try {
			Runtime.getRuntime().exec(GRIP_ARGS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double getCenter() {
		int largestIndex = -1;
		double largestNumber = 0;
		double[] area = table.getNumberArray("targets/area", new double[0]);
		double[] centerX = table.getNumberArray("targets/centerX", new double[0]);
		if (area.length == 0) {
			return -1;
		}
		for (int i = 0; i < area.length; i++) {
			if (area[i] > largestNumber) {
				largestNumber = area[i];
				largestIndex = i;
			}
		}
		return centerX[largestIndex];
	}

}
