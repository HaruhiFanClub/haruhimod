package org.auioc.mods.ahutils.utils.game;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;

public class HBlockMaterial {
    public static class Builder {
        private PushReaction pushReaction = PushReaction.NORMAL;
        private boolean blocksMotion = true;
        private boolean flammable = false;
        private boolean liquid = false;
        private boolean replaceable = false;
        private boolean solid = true;
        private MaterialColor color = MaterialColor.NONE;
        private boolean solidBlocking = true;

        public Builder() {}

        public HBlockMaterial.Builder color(MaterialColor color) {
            this.color = color;
            return this;
        }

        public HBlockMaterial.Builder liquid() {
            this.liquid = true;
            return this;
        }

        public HBlockMaterial.Builder nonSolid() {
            this.solid = false;
            return this;
        }

        public HBlockMaterial.Builder noCollider() {
            this.blocksMotion = false;
            return this;
        }

        public HBlockMaterial.Builder notSolidBlocking() {
            this.solidBlocking = false;
            return this;
        }

        public HBlockMaterial.Builder flammable() {
            this.flammable = true;
            return this;
        }

        public HBlockMaterial.Builder replaceable() {
            this.replaceable = true;
            return this;
        }

        public HBlockMaterial.Builder destroyOnPush() {
            this.pushReaction = PushReaction.DESTROY;
            return this;
        }

        public HBlockMaterial.Builder notPushable() {
            this.pushReaction = PushReaction.BLOCK;
            return this;
        }

        public Material build() {
            return new Material(this.color, this.liquid, this.solid, this.blocksMotion, this.solidBlocking, this.flammable, this.replaceable, this.pushReaction);
        }
    }
}
