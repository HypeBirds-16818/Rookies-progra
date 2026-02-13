package org.firstinspires.ftc.teamcode.teleOps;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.TanquesitoBonito;

public class TeleOp extends LinearOpMode {
    private TanquesitoBonito tanquesitoBonito;
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
    }
}
