package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.BridgeEditMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class BridgeEditScreen extends AbstractContainerScreen<BridgeEditMenu> {
	private final static HashMap<String, Object> guistate = BridgeEditMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox pinyin;
	EditBox length;
	EditBox bridgename;
	Button button_edit;

	public BridgeEditScreen(BridgeEditMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 195;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		pinyin.render(guiGraphics, mouseX, mouseY, partialTicks);
		length.render(guiGraphics, mouseX, mouseY, partialTicks);
		bridgename.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (length.isFocused())
			return length.keyPressed(key, b, c);
		if (bridgename.isFocused())
			return bridgename.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		pinyin.tick();
		length.tick();
		bridgename.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.bridge_edit.label_sign_text_edit"), 8, 8, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.bridge_edit.label_pinyin"), 8, 71, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.bridge_edit.label_bridge_name"), 8, 26, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.bridge_edit.label_length"), 8, 116, -1, false);
	}

	@Override
	public void init() {
		super.init();
		pinyin = new EditBox(this.font, this.leftPos + 9, this.topPos + 90, 160, 18, Component.translatable("gui.junjietrafficmod.bridge_edit.pinyin"));
		pinyin.setMaxLength(32767);
		guistate.put("text:pinyin", pinyin);
		this.addWidget(this.pinyin);
		length = new EditBox(this.font, this.leftPos + 9, this.topPos + 135, 160, 18, Component.translatable("gui.junjietrafficmod.bridge_edit.length"));
		length.setMaxLength(32767);
		guistate.put("text:length", length);
		this.addWidget(this.length);
		bridgename = new EditBox(this.font, this.leftPos + 9, this.topPos + 45, 160, 18, Component.translatable("gui.junjietrafficmod.bridge_edit.bridgename"));
		bridgename.setMaxLength(32767);
		guistate.put("text:bridgename", bridgename);
		this.addWidget(this.bridgename);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 1, pinyin);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 2, length);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 3, bridgename);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.bridge_edit.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 1, pinyin.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 2, length.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 3, bridgename.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 8, this.topPos + 161, 73, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
