package org.auioc.mods.ahutils.utils;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public interface I18nUtils {
    static ITextComponent getTranslatedText(String key) {
        return new TranslationTextComponent(key);
    }
}
