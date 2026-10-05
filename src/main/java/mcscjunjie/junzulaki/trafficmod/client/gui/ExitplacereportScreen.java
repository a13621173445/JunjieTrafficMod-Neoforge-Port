package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.ExitplacereportMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ExitplacereportScreen extends AbstractContainerScreen<ExitplacereportMenu> {
	private final static HashMap<String, Object> guistate = ExitplacereportMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox placebname;
	EditBox placeaname;
	EditBox placeapinyin;
	EditBox placebpinyin;
	Button button_edit;

	public ExitplacereportScreen(ExitplacereportMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 156;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		placebname.render(guiGraphics, mouseX, mouseY, partialTicks);
		placeaname.render(guiGraphics, mouseX, mouseY, partialTicks);
		placeapinyin.render(guiGraphics, mouseX, mouseY, partialTicks);
		placebpinyin.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (placebname.isFocused())
			return placebname.keyPressed(key, b, c);
		if (placeaname.isFocused())
			return placeaname.keyPressed(key, b, c);
		if (placeapinyin.isFocused())
			return placeapinyin.keyPressed(key, b, c);
		if (placebpinyin.isFocused())
			return placebpinyin.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		placebname.tick();
		placeaname.tick();
		placeapinyin.tick();
		placebpinyin.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.exitplacereport.label_sign_text_edit"), 11, 10, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.exitplacereport.label_place_a"), 11, 28, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.exitplacereport.label_place_b"), 11, 73, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.exitplacereport.label_place_a_pinyin"), 131, 28, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.exitplacereport.label_place_b_pinyin"), 131, 73, -1, false);
	}

	@Override
	public void init() {
		super.init();
		placebname = new EditBox(this.font, this.leftPos + 12, this.topPos + 92, 106, 18, Component.translatable("gui.junjietrafficmod.exitplacereport.placebname"));
		placebname.setMaxLength(32767);
		guistate.put("text:placebname", placebname);
		this.addWidget(this.placebname);
		placeaname = new EditBox(this.font, this.leftPos + 12, this.topPos + 47, 106, 18, Component.translatable("gui.junjietrafficmod.exitplacereport.placeaname"));
		placeaname.setMaxLength(32767);
		guistate.put("text:placeaname", placeaname);
		this.addWidget(this.placeaname);
		placeapinyin = new EditBox(this.font, this.leftPos + 132, this.topPos + 47, 106, 18, Component.translatable("gui.junjietrafficmod.exitplacereport.placeapinyin"));
		placeapinyin.setMaxLength(32767);
		guistate.put("text:placeapinyin", placeapinyin);
		this.addWidget(this.placeapinyin);
		placebpinyin = new EditBox(this.font, this.leftPos + 132, this.topPos + 92, 106, 18, Component.translatable("gui.junjietrafficmod.exitplacereport.placebpinyin"));
		placebpinyin.setMaxLength(32767);
		guistate.put("text:placebpinyin", placebpinyin);
		this.addWidget(this.placebpinyin);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 1, placebname);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 2, placeaname);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 3, placeapinyin);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 4, placebpinyin);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.exitplacereport.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 1, placebname.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 2, placeaname.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 3, placeapinyin.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 4, placebpinyin.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 11, this.topPos + 127, 73, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
