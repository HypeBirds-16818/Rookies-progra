package org.firstinspires.ftc.teamcode.teleOps;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Gancho;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.TanquesitoBonito;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {
    private TanquesitoBonito tanquesitoBonito;
    private Shooter shooter;
    private Gancho gancho;
    @Override
    public void runOpMode() throws InterruptedException {
        tanquesitoBonito = new TanquesitoBonito(hardwareMap);
        shooter = new Shooter(hardwareMap);
        gancho = new Gancho(hardwareMap);
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up) {
                tanquesitoBonito.adelante();
            } else if (gamepad1.dpad_down) {
                tanquesitoBonito.atras();
            } else if (gamepad1.dpad_right) {
                tanquesitoBonito.derecha();
            } else if (gamepad1.dpad_left) {
                tanquesitoBonito.izquierda();
            } else {
                tanquesitoBonito.stop();
            }
            //shooter :P
            if (gamepad1.a) {
                shooter.lAdelante();
                shooter.cAdelante();
                gancho.gAdelante();
            } else if (gamepad1.x) {
                shooter.lAtras();
                shooter.cAtras();
                gancho.gAtras();
            } else {
                shooter.shooterStop();
                gancho.gStop();
            }
        }
    }
}
