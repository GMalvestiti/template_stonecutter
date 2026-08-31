package com.gmalvestiti.minecraft.template.mixin;

import com.gmalvestiti.minecraft.template.injection.TemplateItem;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import static com.gmalvestiti.minecraft.template.TemplateCommon.CONFIG;

@Mixin(Item.class)
public class ItemMixin implements TemplateItem {

    @Unique
    private static int templateValue = CONFIG.data().test1;

    @Override
    public int template$getValue() {
        return templateValue;
    }

    @Override
    public void template$updateValue() {
        templateValue = CONFIG.data().test1;
    }
}
