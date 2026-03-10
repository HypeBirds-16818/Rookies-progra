package org.firstinspires.ftc.teamcode.teleOps;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.subsystems.Gancho;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {

    private Shooter shooter;
    private Gancho gancho;

    @Override

    public void runOpMode() throws InterruptedException {
        shooter = new Shooter(hardwareMap);
        gancho = new Gancho(hardwareMap);
        DcMotor motorIzquierdo = hardwareMap.get(DcMotor.class,"left");
        DcMotor motorDerecho = hardwareMap.get(DcMotor.class,"right");



        waitForStart();
        while (opModeIsActive()) {                                  //Movimiento del tanque
            double mi = -gamepad1.left_stick_y;
            double md = gamepad1.right_stick_y;

            motorIzquierdo.setPower(mi);
            motorDerecho.setPower(md);

                                                    //Código del mecanismo

            //Shooter :P
            if (gamepad1.a) {                                       //Activación del indexer (alineador/cosito)
                shooter.cAdelante();
            } else if (gamepad1.right_bumper) {                     //Activación del launcher
                shooter.lAdelante();
            } else if (gamepad1.y) {                                //Activación del gancho (servo)
                gancho.gAdelante();
            } else if (gamepad1.x) {
                gancho.gAtras();
            } else if (gamepad1.b) {
                shooter.cAtras();
            } else {
                shooter.shooterStop();
                gancho.gStop();
            }
        }
    }
}
