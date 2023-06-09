// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand autoCommand =
      new ExampleCommand("ExampleCommand", this.exampleSubsystem);
  private PowerDistribution pdp = new PowerDistribution();

  // Create Drive Robot Parts
  private final CANSparkMax frontLeft =
      new CANSparkMax(DriveConstants.FRONT_LEFT_MOTOR_PORT, MotorType.kBrushless);
  private final CANSparkMax rearLeft =
      new CANSparkMax(DriveConstants.REAR_LEFT_MOTOR_PORT, MotorType.kBrushless);
  private final CANSparkMax frontRight =
      new CANSparkMax(DriveConstants.FRONT_RIGHT_MOTOR_PORT, MotorType.kBrushless);
  private final CANSparkMax rearRight =
      new CANSparkMax(DriveConstants.REAR_RIGHT_MOTOR_PORT, MotorType.kBrushless);
  private final Gyro gyro = new ADXRS450_Gyro();
  private final DriveSubsystem driveSystem =
      new DriveSubsystem(frontLeft, frontRight, rearLeft, rearRight, gyro);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings();
  }

  public DriveSubsystem getDriveSystem() {
    return driveSystem;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return this.autoCommand;
  }

  /**
   * Use this to get the PDP for data logging.
   *
   * @return The PowerDistribution module.
   */
  public PowerDistribution getPdp() {
    return this.pdp;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Add bindings here
  }
}
