package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "TeleOpAllCode")
public class TeleOpAllCode extends LinearOpMode {

  
  private DcMotor Motor0;
  private DcMotor Motor1;
  private DcMotor Motor2;
  private DcMotor Motor3;
  private Servo Servo0;
  private DcMotor ExpM0;
  
  @Override
  public void runOpMode() {
    Motor0 = hardwareMap.get(DcMotor.class, "Motor 0");
    Motor1 = hardwareMap.get(DcMotor.class, "Motor 1");
    Motor2 = hardwareMap.get(DcMotor.class, "Motor 2");
    Motor3 = hardwareMap.get(DcMotor.class, "Motor 3");
    Servo0 = hardwareMap.get(Servo.class, "Servo 0");
    ExpM0 = hardwareMap.get(DcMotor.class, "ExpM 0");
    
    Servo0.setPosition(0);
    
    Motor3.setDirection(DcMotorSimple.Direction.REVERSE);
    Motor0.setDirection(DcMotorSimple.Direction.REVERSE);
    
    
    waitForStart();
    if (opModeIsActive()) {
      
      while (opModeIsActive()) {
        double y = gamepad1.left_stick_y; 
        double x = gamepad1.left_stick_x; 
        double rx = -gamepad1.right_stick_x;
        
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;
        
        Motor1.setPower(frontLeftPower/2);
        Motor0.setPower(backLeftPower/2);
        Motor3.setPower(frontRightPower/2);
        Motor2.setPower(backRightPower/2);

        
        //working 12-31-22
        //forward, backward
        /*Motor0.setDirection(DcMotorSimple.Direction.FORWARD);
        Motor0.setPower(gamepad1.left_stick_y/1.5);
        Motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        Motor1.setPower(gamepad1.left_stick_y/1.5);
        Motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        Motor2.setPower(gamepad1.left_stick_y/1.5);
        Motor3.setDirection(DcMotorSimple.Direction.FORWARD);
        Motor3.setPower(gamepad1.left_stick_y/1.5);
        //strafe
        Motor0.setDirection(DcMotorSimple.Direction.FORWARD);
        Motor0.setPower(gamepad1.right_stick_x/1.1);
        Motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        Motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        Motor1.setPower(gamepad1.right_stick_x/1.1);
        Motor2.setDirection(DcMotorSimple.Direction.FORWARD);
        Motor2.setDirection(DcMotorSimple.Direction.FORWARD);
        Motor2.setPower(gamepad1.right_stick_x/1.1);
        Motor3.setDirection(DcMotorSimple.Direction.REVERSE);
        Motor3.setPower(gamepad1.right_stick_x/1.1);
        //turn clockwise
        Motor0.setDirection(DcMotorSimple.Direction.FORWARD);
        Motor0.setPower(gamepad1.right_trigger/1.5);
        Motor1.setDirection(DcMotorSimple.Direction.FORWARD);
        Motor1.setPower(gamepad1.right_trigger/1.5);
        Motor2.setDirection(DcMotorSimple.Direction.FORWARD);
        Motor2.setPower(gamepad1.right_trigger/1.5);
        Motor3.setDirection(DcMotorSimple.Direction.FORWARD);
        Motor3.setPower(gamepad1.right_trigger/1.5);
        //turn counter-clockwise
        Motor0.setDirection(DcMotorSimple.Direction.REVERSE);
        Motor0.setPower(gamepad1.left_trigger/1.5);
        Motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        Motor1.setPower(gamepad1.left_trigger/1.5);
        Motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        Motor2.setPower(gamepad1.left_trigger/1.5);
        Motor3.setDirection(DcMotorSimple.Direction.REVERSE);
        Motor3.setPower(gamepad1.left_trigger/1.5);*/
      
        if (gamepad2.y) {
          Servo0.setPosition(0.8);
        } else if (gamepad2.x) {
          Servo0.setPosition(0);
        }
        
        ExpM0.setPower(gamepad2.right_trigger/0.25);
        ExpM0.setPower(gamepad2.left_trigger/-0.25);
        
        if (gamepad2.right_bumper) {
          ExpM0.setDirection(DcMotorSimple.Direction.FORWARD);
        } 
        if (gamepad2.left_bumper) {
          ExpM0.setDirection(DcMotorSimple.Direction.REVERSE);
        }
        telemetry.update();

      }
    }
  }
}
