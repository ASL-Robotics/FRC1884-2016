package org.usfirst.frc.team1884.robot.commands;

import org.usfirst.frc.team1884.robot.subsystems.Aimer;
import org.usfirst.frc.team1884.robot.subsystems.GRIP;
import org.usfirst.frc.team1884.robot.subsystems.Spike;
import org.usfirst.frc.team1884.robot.subsystems.WestCoastGearbox;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Aim extends Command {
	
	public Aim() {
		this.requires(Aimer.INSTANCE);
		this.requires(WestCoastGearbox.INSTANCE);
		this.requires(GRIP.INSTANCE);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Aimer.INSTANCE.alignAuto();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Spike.INSTANCE.turnOff();
	}
}
