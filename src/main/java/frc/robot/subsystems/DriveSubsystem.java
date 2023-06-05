package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/** DriveSubsystem. */
@java.lang.SuppressWarnings({"java:S1068","unused"}) // Remove when finished implementing.
public class DriveSubsystem {

  private final CANSparkMax frontLeft;
  private final CANSparkMax rearLeft;
  private final CANSparkMax frontRight;
  private final CANSparkMax rearRight;
  private final MotorControllerGroup leftMotor;
  private final MotorControllerGroup rightMotor;
  private final DifferentialDrive robotDrive;

  private final Gyro gyro;

  private final RelativeEncoder frontLeftEncoder;
  private final RelativeEncoder frontRightEncoder;
  private final RelativeEncoder rearLeftEncoder;
  private final RelativeEncoder rearRightEncoder;
  /**
   * Drive subsystem constructor when four motor controllers are used.
   *
   * @param frontLeft The front left motor controller.
   * @param frontRight The front right motor controller.
   * @param rearLeft The rear left motor controller.
   * @param rearRight The rear right motor controller.
   * @param gyro The gyro for directional correction.
   */
  public DriveSubsystem(
      CANSparkMax frontLeft,
      CANSparkMax frontRight,
      CANSparkMax rearLeft,
      CANSparkMax rearRight,
      Gyro gyro) {

    this.frontLeft = frontLeft;
    this.frontRight = frontRight;
    this.rearLeft = rearLeft;
    this.rearRight = rearRight;
    this.gyro = gyro;

    leftMotor = new MotorControllerGroup(this.frontLeft, this.rearLeft);
    rightMotor = new MotorControllerGroup(this.frontRight, this.rearRight);

    frontLeftEncoder = this.frontLeft.getEncoder();
    frontRightEncoder = this.frontRight.getEncoder();
    rearLeftEncoder = this.rearLeft.getEncoder();
    rearRightEncoder = this.rearRight.getEncoder();

    robotDrive = new DifferentialDrive(leftMotor, rightMotor);
  }

  public DifferentialDrive getRobotDrive() {
    return robotDrive;
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    this.robotDrive.tankDrive(leftSpeed, rightSpeed, false);
  }
}
