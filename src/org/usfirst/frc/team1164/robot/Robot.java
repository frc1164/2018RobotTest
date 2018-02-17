/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1164.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	
	private static WPI_VictorSPX Left0, Left2, Left1, Right13, Right14, Right15;
	private Joystick Stick;
	double LeftStickValue, RightStickValue;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_chooser.addDefault("Default Auto", kDefaultAuto);
		m_chooser.addObject("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
		
		Left0 = new WPI_VictorSPX(0);
		Left1 = new WPI_VictorSPX(1);
		Left2 = new WPI_VictorSPX(2);
		
		Right13 = new WPI_VictorSPX(13);
		Right14 = new WPI_VictorSPX(14);
		Right15 = new WPI_VictorSPX(15);
		
		Stick = new Joystick(0);
		
		Left0.setInverted(true);
		Right15.setInverted(true);
	

	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		switch (m_autoSelected) {
			case kCustomAuto:
				// Put custom auto code here
				break;
			case kDefaultAuto:
			default:
				// Put default auto code here
				break;
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		LeftStickValue = Stick.getRawAxis(1);
		RightStickValue = Stick.getRawAxis(3);
		
		Left0.set(ControlMode.PercentOutput, LeftStickValue);
		Left1.set(ControlMode.PercentOutput, LeftStickValue);
		Left2.set(ControlMode.PercentOutput, LeftStickValue);
		
		Right13.set(ControlMode.PercentOutput, RightStickValue);
		Right14.set(ControlMode.PercentOutput, RightStickValue);
		Right15.set(ControlMode.PercentOutput, RightStickValue);

		
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
