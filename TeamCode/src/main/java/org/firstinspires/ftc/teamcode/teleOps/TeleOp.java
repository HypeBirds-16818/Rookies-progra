package org.firstinspires.ftc.teamcode.teleOps;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.TanquesitoBonito;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {
    private TanquesitoBonito tanquesitoBonito;
    private Shooter shooter;
    @Override
    public void runOpMode() throws InterruptedException {
        tanquesitoBonito = new TanquesitoBonito(hardwareMap);
        waitForStart();
        if (gamepad1.dpad_up){
            tanquesitoBonito.adelante();
        }
        else if (gamepad1.dpad_down){
            tanquesitoBonito.atras();
        }
        else if (gamepad1.dpad_right){
            tanquesitoBonito.derecha();
        }
        else if (gamepad1.dpad_left) {
            tanquesitoBonito.izquierda();
        }
        else {
            tanquesitoBonito.stop();
        }
        //shooter :P
        if (gamepad1.a){
            shooter.lAtras();
        } else if (gamepad1.x) {
            shooter.lAdelante();
        } else if (gamepad1.y) {
            shooter.cAdelante();
        } else if (gamepad1.b) {
            shooter.cAtras();
        } else {
            shooter.shooterStop();
        }

    }
}
