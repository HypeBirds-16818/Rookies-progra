package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {
    private final DcMotor lanzador;

    public Shooter(HardwareMap hardwareMap) {
        //Nombres de los motores :D
        lanzador = hardwareMap.get(DcMotor.class, "lanzador");

        lanzador.setDirection(DcMotorSimple.Direction.REVERSE);
    }


    public void lAdelante() {
        lanzador.setPower(.8);

    }

    public void lAtras() {
        lanzador.setPower(-0.5);
    }

    public void shooterStop() {
        lanzador.setPower(0);
    }
}
