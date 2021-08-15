// cSpell: disable
function initializeCoreMod() {
    Opcodes = Java.type("org.objectweb.asm.Opcodes");

    InsnList = Java.type("org.objectweb.asm.tree.InsnList");

    AbstractInsnNode = Java.type("org.objectweb.asm.tree.AbstractInsnNode");
    VarInsnNode = Java.type("org.objectweb.asm.tree.VarInsnNode");
    MethodInsnNode = Java.type("org.objectweb.asm.tree.MethodInsnNode");

    return {
        "ServerPlayerEntity#sendMessage": {
            target: {
                type: "METHOD",
                class: "net.minecraft.entity.player.ServerPlayerEntity",
                methodName: "sendMessage",
                methodDesc:
                    "(Lnet/minecraft/util/text/ITextComponent;Lnet/minecraft/util/text/ChatType;Ljava/util/UUID;)V",
            },
            transformer: function (methodNode) {
                return methodNode;
            },
        },
    };
}
