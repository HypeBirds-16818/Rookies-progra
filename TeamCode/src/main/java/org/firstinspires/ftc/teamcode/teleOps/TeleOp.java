package org.firstinspires.ftc.teamcode.teleOps;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.subsystems.Gancho;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {

    private Shooter shooter;
    private Gancho gancho;
    private Intake intake;

    @Override

    public void runOpMode() throws InterruptedException {
        shooter = new Shooter(hardwareMap);
        gancho = new Gancho(hardwareMap);
        intake = new Intake(hardwareMap);
        DcMotor motorIzquierdo = hardwareMap.get(DcMotor.class,"left");
        DcMotor motorDerecho = hardwareMap.get(DcMotor.class,"right");



        waitForStart();
        while (opModeIsActive()) {                                  //Movimiento del tanque
            double mi = gamepad2.left_stick_y;
            double md = -gamepad2.right_stick_y;

            motorIzquierdo.setPower(md);
            motorDerecho.setPower(mi);

            //Código del mecanismo

            //Shooter :P
            if (gamepad1.a) {                                       //Activación del indexer (alineador/cosito)
                intake.iAdelante();
            } else if (gamepad1.dpad_right) {                       //Activación del launcher
                shooter.shooterStop();
            } else if (gamepad1.right_bumper) {                     //Activación del launcher
                shooter.lAdelante();
            } else if (gamepad1.left_bumper) {                      //Activación del launcher
                shooter.lAtras();
            } else if (gamepad1.y) {                                //Activación del gancho (servo)
                gancho.gLocked();
            } else if (gamepad1.x) {
                gancho.gUnlocked();
            } else if (gamepad1.b) {
                intake.iAtras();
            } else {
                intake.iStop();
            }
        }
    }
}