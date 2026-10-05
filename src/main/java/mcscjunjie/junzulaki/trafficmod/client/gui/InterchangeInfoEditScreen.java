package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.InterchangeInfoEditMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class InterchangeInfoEditScreen extends AbstractContainerScreen<InterchangeInfoEditMenu> {
	private final static HashMap<String, Object> guistate = InterchangeInfoEditMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox exporta;
	EditBox straight;
	EditBox exportb;
	Button button_edit;

	public InterchangeInfoEditScreen(InterchangeInfoEditMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 213;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		exporta.render(guiGraphics, mouseX, mouseY, partialTicks);
		straight.render(guiGraphics, mouseX, mouseY, partialTicks);
		exportb.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (exporta.isFocused())
			return exporta.keyPressed(key, b, c);
		if (straight.isFocused())
			return straight.keyPressed(key, b, c);
		if (exportb.isFocused())
			return exportb.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		exporta.tick();
		straight.tick();
		exportb.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.interchange_info_edit.label_sign_text_edit"), 9, 8, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.interchange_info_edit.label_straight"), 9, 27, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.interchange_info_edit.label_export_a"), 9, 75, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.interchange_info_edit.label_export_b"), 9, 124, -1, false);
	}

	@Override
	public void init() {
		super.init();
		exporta = new EditBox(this.font, this.leftPos + 10, this.topPos + 94, 155, 18, Component.translatable("gui.junjietrafficmod.interchange_info_edit.exporta"));
		exporta.setMaxLength(32767);
		guistate.put("text:exporta", exporta);
		this.addWidget(this.exporta);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 2, exporta);
		straight = new EditBox(this.font, this.leftPos + 10, this.topPos + 46, 155, 18, Component.translatable("gui.junjietrafficmod.interchange_info_edit.straight"));
		straight.setMaxLength(32767);
		guistate.put("text:straight", straight);
		this.addWidget(this.straight);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 1, straight);
		exportb = new EditBox(this.font, this.leftPos + 10, this.topPos + 144, 155, 18, Component.translatable("gui.junjietrafficmod.interchange_info_edit.exportb"));
		exportb.setMaxLength(32767);
		guistate.put("text:exportb", exportb);
		this.addWidget(this.exportb);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 3, exportb);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.interchange_info_edit.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 1, straight.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 2, exporta.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 3, exportb.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 9, this.topPos + 185, 73, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
