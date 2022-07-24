package com.haruhifanclub.haruhiism.integ.curios.common;

import net.minecraftforge.fml.InterModComms;
import top.theillusivec4.curios.api.SlotTypeMessage;

public final class CuriosIMC {

    public static void send() {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> CuriosSlotTypes.FACE);
    }

}
