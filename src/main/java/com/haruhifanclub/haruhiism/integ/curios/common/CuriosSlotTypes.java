package com.haruhifanclub.haruhiism.integ.curios.common;

import top.theillusivec4.curios.api.SlotTypeMessage;

public final class CuriosSlotTypes {

    public static final SlotTypeMessage FACE = initBuilder("face").build();

    private static SlotTypeMessage.Builder initBuilder(String id) {
        return new SlotTypeMessage.Builder(id);
    }

}
