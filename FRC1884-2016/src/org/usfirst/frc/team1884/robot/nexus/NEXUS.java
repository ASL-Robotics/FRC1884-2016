package org.usfirst.frc.team1884.robot.nexus;

import org.usfirst.frc.team1884.robot.sensors.UltrasonicSensor;

import edu.wpi.first.wpilibj.Joystick;

@SuppressWarnings("unused")
public class NEXUS {
  public static final Joystick JOYSTICK;

  static {
    JOYSTICK = new Joystick(0);
  }
}
