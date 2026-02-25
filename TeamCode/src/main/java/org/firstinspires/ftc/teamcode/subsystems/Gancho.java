package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Gancho {
    private final CRServo gancho;
    public Gancho(HardwareMap hardwareMap){
        gancho = hardwareMap.get(CRServo.class,"gancho");
    }

    public void gAdelante(){
        gancho.setPower(-1);
    }
    public void gAtras(){
        gancho.setPower(1);
    }
    public void gStop(){
        gancho.setPower(0);
    }
}
