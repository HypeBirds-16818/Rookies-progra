package org.firstinspires.ftc.teamcode.teleOps;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.Gancho;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class Maquinadeestados extends LinearOpMode {

    private Shooter shooter;
    private Gancho gancho;
    private Intake intake;

    public enum RS{
        INTAKE,
        OUTAKE,
        SHOOTING,
        IDLE

    }
    private RS currentRobotState = RS.IDLE;

    @Override

    public void runOpMode() throws InterruptedException {
        shooter = new Shooter(hardwareMap);
        gancho = new Gancho(hardwareMap);
        intake = new Intake(hardwareMap);
        DcMotor motorIzquierdo = hardwareMap.get(DcMotor.class, "left");
        DcMotor motorDerecho = hardwareMap.get(DcMotor.class, "right");

        waitForStart();
        while (opModeIsActive()) {                                  //Movimiento del tanque
            double mi = gamepad2.left_stick_y;
            double md = -gamepad2.right_stick_y;

            motorIzquierdo.setPower(md);
            motorDerecho.setPower(mi);

            if (gamepad1.a) {
                currentRobotState = RS.INTAKE;
            }
            if (gamepad1.b) {
                currentRobotState = RS.OUTAKE;
            }
            if (gamepad1.x) {
                currentRobotState = RS.SHOOTING;
            }
            if (gamepad1.y) {
                currentRobotState = RS.IDLE;
            }

            switch(currentRobotState) {
                case INTAKE:
                    intake.iAdelante();
                    gancho.gLocked();
                    break;

                case SHOOTING:
                    gancho.gUnlocked();
                    intake.iAdelante();
                    shooter.lAdelante();
                    break;

                case OUTAKE:
                    shooter.lAtras();
                    intake.iAtras();
                    break;

                case IDLE:
                    gancho.gLocked();
                    intake.iStop();
                    shooter.shooterStop();
                    break;
            }
            telemetry.addData("Estado de el niño: ",currentRobotState);
    }



    }
}