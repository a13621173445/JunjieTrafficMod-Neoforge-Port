package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.ServiceAreaEditMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ServiceAreaEditScreen extends AbstractContainerScreen<ServiceAreaEditMenu> {
	private final static HashMap<String, Object> guistate = ServiceAreaEditMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox pinyin;
	EditBox surviceareaname;
	Button button_edit;

	public ServiceAreaEditScreen(ServiceAreaEditMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 156;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		pinyin.render(guiGraphics, mouseX, mouseY, partialTicks);
		surviceareaname.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (pinyin.isFocused())
			return pinyin.keyPressed(key, b, c);
		if (surviceareaname.isFocused())
			return surviceareaname.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.service_area_edit.label_sign_text_edit"), 9, 8, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.service_area_edit.label_pinyin"), 9, 76, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.service_area_edit.label_survice_area_name"), 9, 26, -1, false);
	}

	@Override
	public void init() {
		super.init();
		pinyin = new EditBox(this.font, this.leftPos + 10, this.topPos + 98, 155, 18, Component.translatable("gui.junjietrafficmod.service_area_edit.pinyin"));
		pinyin.setMaxLength(32767);
		guistate.put("text:pinyin", pinyin);
		this.addWidget(this.pinyin);
		surviceareaname = new EditBox(this.font, this.leftPos + 10, this.topPos + 46, 155, 18, Component.translatable("gui.junjietrafficmod.service_area_edit.surviceareaname"));
		surviceareaname.setMaxLength(32767);
		guistate.put("text:surviceareaname", surviceareaname);
		this.addWidget(this.surviceareaname);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 1, pinyin);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 2, surviceareaname);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.service_area_edit.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 1, pinyin.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 2, surviceareaname.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 9, this.topPos + 128, 73, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
