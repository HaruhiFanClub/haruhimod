// cSpell: disable
function initializeCoreMod() {
    Opcodes = Java.type("org.objectweb.asm.Opcodes");

    InsnList = Java.type("org.objectweb.asm.tree.InsnList");

    AbstractInsnNode = Java.type("org.objectweb.asm.tree.AbstractInsnNode");
    VarInsnNode = Java.type("org.objectweb.asm.tree.VarInsnNode");
    MethodInsnNode = Java.type("org.objectweb.asm.tree.MethodInsnNode");

    return {
        "ServerLifecycleHooks#handleServerLogin": {
            target: {
                type: "METHOD",
                class: "net.minecraftforge.fml.server.ServerLifecycleHooks",
                methodName: "handleServerLogin",
                methodDesc:
                    "(Lnet/minecraft/network/handshake/client/CHandshakePacket;Lnet/minecraft/network/NetworkManager;)Z",
            },
            transformer: function (methodNode) {
                // TODO
                return methodNode;
            },
        },
    };
}

/* net.minecraftforge.fml.server.ServerLifecycleHooks.handleServerLogin
public static boolean handleServerLogin(final CHandshakePacket packet, final NetworkManager manager) {
    if (!allowLogins.get())
    {
        // ......
    }

    // ......
}
*/

/* net.minecraftforge.fml.server.ServerLifecycleHooks.handleServerLogin
public static boolean handleServerLogin(final CHandshakePacket packet, final NetworkManager manager) {
    // ~ INSERT BEGIN ~ //
    org.auioc.mods.ahutils.server.event.ServerEventRegister.registerServerLoginEvent(packet, manager); // TODO
    // ~ INSERT END ~ //

    if (!allowLogins.get())
    {
        // ......
    }

    // ......
}
*/
