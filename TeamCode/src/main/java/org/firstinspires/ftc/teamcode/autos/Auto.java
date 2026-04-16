package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.Gancho;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class Auto extends LinearOpMode {

    private Shooter shooter;
    private Gancho gancho;
    private Intake intake;

    @Override
    public void runOpMode() {
        shooter = new Shooter(hardwareMap);
        gancho = new Gancho(hardwareMap);
        intake = new Intake(hardwareMap);
        DcMotor motorIzquierdo = hardwareMap.get(DcMotor.class,"left");
        DcMotor motorDerecho = hardwareMap.get(DcMotor.class,"right");

        waitForStart();

        //Ir atrás y encender shooter
        motorIzquierdo.setPower(-0.5);
        motorDerecho.setPower(-0.5);
        shooter.lAdelante();
        sleep(2000);

        //Frenar
        motorIzquierdo.setPower(0);
        motorDerecho.setPower(0);
        sleep(2000);

        //Encender indexer (shootear los primeros dos arts)
        intake.iAdelante();
        sleep(2000);

        //Girar a la derecha para salir y activar shooting condition por si captura un art)
        intake.iStop();
        motorIzquierdo.setPower(0.5);
        motorDerecho.setPower(-0.5);
        gancho.gLocked();
        sleep(500);


        //Ir hacia el frente después de girar lo suficiente
        motorDerecho.setPower(0.5);
        sleep(1000);

        //Parar
        motorIzquierdo.setPower(0);
        motorDerecho.setPower(0);

        shooter.lAdelante();



    }
}
