package frc.robot;

import static org.mockito.Mockito.verify;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import frc.robot.subsystems.DriveSubsystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DriveSubsystemTest {

  @Mock private CANSparkMax mockFrontLeftMotor;
  @Mock private CANSparkMax mockRearLeftMotor;
  @Mock private CANSparkMax mockFrontRightMotor;
  @Mock private CANSparkMax mockRearRightMotor;
  @Mock private ADXRS450_Gyro mockGyro;
  private DriveSubsystem driveChassis;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(mockFrontLeftMotor);
    MockitoAnnotations.openMocks(mockFrontRightMotor);
    MockitoAnnotations.openMocks(mockRearLeftMotor);
    MockitoAnnotations.openMocks(mockRearRightMotor);
    MockitoAnnotations.openMocks(mockGyro);
    driveChassis =
        new DriveSubsystem(
            mockFrontLeftMotor,
            mockFrontRightMotor,
            mockRearLeftMotor,
            mockRearRightMotor,
            mockGyro);
  }

  @Test
  void testDrive_zero_one() {

    driveChassis.tankDrive(1.0, 0.0);

    verify(mockFrontLeftMotor).getEncoder();
    verify(mockFrontLeftMotor).set(1.0);
    verify(mockRearLeftMotor).getEncoder();
    verify(mockRearLeftMotor).set(1.0);
    verify(mockFrontRightMotor).getEncoder();
    verify(mockFrontRightMotor).set(0.0);
    verify(mockRearRightMotor).getEncoder();
    verify(mockRearRightMotor).set(0.0);
  }
}
