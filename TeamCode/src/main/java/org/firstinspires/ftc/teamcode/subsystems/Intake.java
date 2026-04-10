package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private final DcMotor intake;
            public Intake (HardwareMap hardwareMap){
                intake = hardwareMap.get(DcMotor.class, "intake");

                intake.setDirection(DcMotorSimple.Direction.FORWARD);
            }

    public void iAdelante() {
        intake.setPower(1);

    }

    public void iAtras() {
        intake.setPower(-1);
    }
    public void iStop() {
                intake.setPower(0);
    }
}

