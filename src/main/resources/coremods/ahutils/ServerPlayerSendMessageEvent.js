function initializeCoreMod() {
    // ASMAPI = Java.type("net.minecraftforge.coremod.api.ASMAPI");
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
                // print(ASMAPI.methodNodeToString(methodNode));
                instructions = methodNode.instructions;

                var toInject = new InsnList();
                var escape = new LabelNode();

                {
                    /* LocalVariableTable
                        Slot  Name         Signature
                        0     this         Lnet/minecraft/entity/player/ServerPlayerEntity;
                        1     p_241151_1_  Lnet/minecraft/util/text/ITextComponent;
                        2     p_241151_2_  Lnet/minecraft/util/text/ChatType;
                        3     p_241151_3_  Ljava/util/UUID; 
                    */
                    toInject.add(new VarInsnNode(Opcodes.ALOAD, 1));
                    toInject.add(new VarInsnNode(Opcodes.ALOAD, 2));
                    toInject.add(new VarInsnNode(Opcodes.ALOAD, 3));
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
                }

                instructions.insert(instructions.getFirst(), toInject);

                // print(ASMAPI.methodNodeToString(methodNode));
                return methodNode;
            },
        },
    };
}

//! Original method
/*
public void sendMessage(ITextComponent p_241151_1_, ChatType p_241151_2_, UUID p_241151_3_) {
    this.connection.send(new SChatPacket(p_241151_1_, p_241151_2_, p_241151_3_), (p_241149_4_) -> {
        // ...
    }

*   ========== ByteCode ==========   *

    L0
        LINENUMBER 1195 L0
        ALOAD 0
        GETFIELD net/minecraft/entity/player/ServerPlayerEntity.connection : Lnet/minecraft/network/play/ServerPlayNetHandler;
        NEW net/minecraft/network/play/server/SChatPacket
        DUP
*/

//! Transformed method
/*
public void sendMessage(ITextComponent p_241151_1_, ChatType p_241151_2_, UUID p_241151_3_) {
~+  if (org.auioc.mods.ahutils.server.event.ServerEventRegistry.postServerPlayerEntitySendMessageEvent(p_241151_1_, p_241151_2_, p_241151_3_)){
~+      return;
~+  }

    this.connection.send(new SChatPacket(p_241151_1_, p_241151_2_, p_241151_3_), (p_241149_4_) -> {
        // ...
    }

*   ========== ByteCode ==========   *

~+  L0
~+      ALOAD 1
~+      ALOAD 2
~+      ALOAD 3
~+      INVOKESTATIC org/auioc/mods/ahutils/server/event/ServerEventRegistry.postServerPlayerEntitySendMessageEvent (Lnet/minecraft/util/text/ITextComponent;Lnet/minecraft/util/text/ChatType;Ljava/util/UUID;)Z
~+      IFEQ L1
~+      RETURN
    L1
        LINENUMBER 1195 L0
        ALOAD 0
        GETFIELD net/minecraft/entity/player/ServerPlayerEntity.connection : Lnet/minecraft/network/play/ServerPlayNetHandler;
        NEW net/minecraft/network/play/server/SChatPacket
        DUP
*/
