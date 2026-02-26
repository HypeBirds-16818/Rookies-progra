package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    private final DcMotor cosita, lanzador;

    public Shooter(HardwareMap hardwareMap) {
        //Nombres de los motores :D
        cosita = hardwareMap.get(DcMotor.class, "cosita");
        lanzador = hardwareMap.get(DcMotor.class, "lanzador");

        cosita.setDirection(DcMotorSimple.Direction.FORWARD);
        lanzador.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void cAdelante() {
        cosita.setPower(0.65);

    }

    public void cAtras() {
        cosita.setPower(-0.5);
    }

    public void lAdelante() {
        lanzador.setPower(.6);

    }

    public void lAtras() {
        lanzador.setPower(-0.5);
    }

    public void shooterStop() {
        lanzador.setPower(0);
        cosita.setPower(0);
    }
}
