package com.gmalvestiti.minecraft.template.config;

import com.gmalvestiti.minecraft.easyconfig.api.ConfigFormat;
import com.gmalvestiti.minecraft.easyconfig.api.annotations.Config;
import com.gmalvestiti.minecraft.easyconfig.api.annotations.ConfigEntry;

@Config(name="template", format = ConfigFormat.TOML, comment={
    " This is a template config file for the EasyConfig library.",
    "",
    " Use this file as a reference for creating your own config files."})
public class TemplateConfig {

    @ConfigEntry(name = "template_enabled", comment = "Whether the template is enabled or not")
    public boolean enabled = true;
}
