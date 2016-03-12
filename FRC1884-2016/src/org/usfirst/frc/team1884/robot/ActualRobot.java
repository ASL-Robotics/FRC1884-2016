package org.usfirst.frc.team1884.robot;

import org.usfirst.frc.team1884.robot.autonomous.AutonomousHandler;
import org.usfirst.frc.team1884.robot.autonomous.EasyAutonomous;
import org.usfirst.frc.team1884.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class ActualRobot extends IterativeRobot {

	public static OI oi;

	CameraServer server;
	Joystick opJoystick;

	JoystickButton opButton1;
	JoystickButton opButton2;

	public void robotInit() {
		oi = new OI();
		opJoystick = NEXUS.OPERATORSTICK;
		
		server = CameraServer.getInstance();
		server.setQuality(50);
		server.startAutomaticCapture("cam0");
	}

	/**
	 * This function is called once at the beginning of autonomous
	 */
	public void autonomousInit() {
//		AutonomousHandler.INSTANCE.autonomousInit();
		Command auto = new EasyAutonomous();
		auto.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called once at the beginning of operator control
	 */
	public void teleopInit() {
		Elevator.INSTANCE.teleopInit();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
}
