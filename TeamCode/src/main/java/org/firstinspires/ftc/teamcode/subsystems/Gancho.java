package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Gancho {
    private final Servo gancho;
    public Gancho(HardwareMap hardwareMap){
        gancho = hardwareMap.get(Servo.class,"gancho");
    }

    public void gLocked(){
        gancho.setPosition(-0.5);
    }
    public void gUnlocked(){
        gancho.setPosition(-1);
    }
}
