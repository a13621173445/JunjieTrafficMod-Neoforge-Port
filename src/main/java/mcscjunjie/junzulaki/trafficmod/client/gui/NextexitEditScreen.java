package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.NextexitEditMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class NextexitEditScreen extends AbstractContainerScreen<NextexitEditMenu> {
	private final static HashMap<String, Object> guistate = NextexitEditMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox exitnumber;
	EditBox distance;
	EditBox exportname;
	Button button_edit;

	public NextexitEditScreen(NextexitEditMenu container, Inventory inventory, Component text) {
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
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		exitnumber.render(guiGraphics, mouseX, mouseY, partialTicks);
		distance.render(guiGraphics, mouseX, mouseY, partialTicks);
		exportname.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (exitnumber.isFocused())
			return exitnumber.keyPressed(key, b, c);
		if (distance.isFocused())
			return distance.keyPressed(key, b, c);
		if (exportname.isFocused())
			return exportname.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.nextexit_edit.label_sign_text_edit"), 8, 8, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.nextexit_edit.label_export_name"), 8, 26, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.nextexit_edit.label_distance"), 8, 116, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.nextexit_edit.label_exit_number"), 8, 71, -1, false);
	}

	@Override
	public void init() {
		super.init();
		exitnumber = new EditBox(this.font, this.leftPos + 9, this.topPos + 90, 160, 18, Component.translatable("gui.junjietrafficmod.nextexit_edit.exitnumber"));
		exitnumber.setMaxLength(32767);
		guistate.put("text:exitnumber", exitnumber);
		this.addWidget(this.exitnumber);
		distance = new EditBox(this.font, this.leftPos + 9, this.topPos + 135, 160, 18, Component.translatable("gui.junjietrafficmod.nextexit_edit.distance"));
		distance.setMaxLength(32767);
		guistate.put("text:distance", distance);
		this.addWidget(this.distance);
		exportname = new EditBox(this.font, this.leftPos + 9, this.topPos + 45, 160, 18, Component.translatable("gui.junjietrafficmod.nextexit_edit.exportname"));
		exportname.setMaxLength(32767);
		guistate.put("text:exportname", exportname);
		this.addWidget(this.exportname);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 1, exitnumber);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 2, distance);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 3, exportname);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.nextexit_edit.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 1, exitnumber.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 2, distance.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 3, exportname.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 8, this.topPos + 161, 73, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
