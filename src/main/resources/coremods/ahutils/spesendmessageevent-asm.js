// cSpell: disable
function initializeCoreMod() {
    Opcodes = Java.type("org.objectweb.asm.Opcodes");

    InsnList = Java.type("org.objectweb.asm.tree.InsnList");
    InsnNode = Java.type("org.objectweb.asm.tree.InsnNode");
    VarInsnNode = Java.type("org.objectweb.asm.tree.VarInsnNode");
    MethodInsnNode = Java.type("org.objectweb.asm.tree.MethodInsnNode");
    JumpInsnNode = Java.type("org.objectweb.asm.tree.JumpInsnNode");
    LabelNode = Java.type("org.objectweb.asm.tree.LabelNode");

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
                instructions = methodNode.instructions;

                var toInject = new InsnList();

                var escape = new LabelNode();

                toInject.add(new VarInsnNode(Opcodes.ALOAD, 1)); // ITextComponent p_241151_1_
                toInject.add(new VarInsnNode(Opcodes.ALOAD, 2)); // ChatType p_241151_2_
                toInject.add(new VarInsnNode(Opcodes.ALOAD, 3)); // UUID p_241151_3_
                toInject.add(
                    new MethodInsnNode(
                        Opcodes.INVOKESTATIC,
                        "org/auioc/mods/ahutils/server/event/ServerEventRegistry",
                        "postServerPlayerEntitySendMessageEvent",
                        "(Lnet/minecraft/util/text/ITextComponent;Lnet/minecraft/util/text/ChatType;Ljava/util/UUID;)Z",
                        false
                    )
                );
                toInject.add(new JumpInsnNode(Opcodes.IFEQ, escape));
                toInject.add(new InsnNode(Opcodes.RETURN));
                toInject.add(escape);

                instructions.insert(instructions.getFirst(), toInject);

                return methodNode;
            },
        },
    };
}

/* net.minecraft.entity.player.ServerPlayerEntity.sendMessage
public void sendMessage(ITextComponent p_241151_1_, ChatType p_241151_2_, UUID p_241151_3_) {
    this.connection.send(new SChatPacket(p_241151_1_, p_241151_2_, p_241151_3_), (p_241149_4_) -> {
        // ...
    }
*/

/* net.minecraft.entity.player.ServerPlayerEntity.sendMessage
public void sendMessage(ITextComponent p_241151_1_, ChatType p_241151_2_, UUID p_241151_3_) {
    // ~ INSERT BEGIN ~ //
    if (org.auioc.mods.ahutils.server.event.ServerEventRegistry.postServerPlayerEntitySendMessageEvent(p_241151_1_, p_241151_2_, p_241151_3_)){
        return;
    }
    // ~ INSERT END ~ //

    this.connection.send(new SChatPacket(p_241151_1_, p_241151_2_, p_241151_3_), (p_241149_4_) -> {
        // ...
    }
*/
