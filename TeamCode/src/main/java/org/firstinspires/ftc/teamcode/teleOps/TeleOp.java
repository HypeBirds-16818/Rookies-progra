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
        while (opModeIsActive()) {                                  //Movimiento del tanque
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
            }                                                       //Código del mecanismo

                                                                    //Shooter :P
            if (gamepad1.a) {                                       //Activación del indexer (alineador/cosito)
                shooter.cAdelante();
            } else if (gamepad1.right_bumper) {                     //Activación del launcher
                shooter.lAdelante();
            } else if (gamepad1.y) {                                //Activación del gancho (servo)
                gancho.gAdelante();
            } else if (gamepad1.x) {
                gancho.gAtras();
            } else {
                shooter.shooterStop();
                gancho.gStop();
            }
        }
    }
}
