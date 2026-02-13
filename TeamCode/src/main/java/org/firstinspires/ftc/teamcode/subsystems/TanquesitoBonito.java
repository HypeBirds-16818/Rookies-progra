package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TanquesitoBonito {
    private final DcMotor right, left;

    public TanquesitoBonito(HardwareMap hardwareMap){
        //Nombres de los motores :D
        right = hardwareMap.get(DcMotor.class, "right");
        left = hardwareMap.get(DcMotor.class,"left");

        //Direccion de los motores :o
        right.setDirection(DcMotorSimple.Direction.REVERSE);
        left.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void adelante(){
        right.setPower(1);
        left.setPower(1);
    }

    public void atras(){
        right.setPower(-1);
        left.setPower(-1);
    }

    public void derecha(){
        right.setPower(1);
        left.setPower(-1);
    }
    public void izquierda(){
        right.setPower(-1);
        left.setPower(1);
    }

    public void stop() {
        right.setPower(0);
        left.setPower(0);
    }
}
