package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.IntergoingEditMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;
import mcscjunjie.junzulaki.trafficmod.block.GantryGInterStraightBlock;
import mcscjunjie.junzulaki.trafficmod.block.GantryGInterRightBlock;
import mcscjunjie.junzulaki.trafficmod.block.GantryGInterLeftBlock;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class IntergoingEditScreen extends AbstractContainerScreen<IntergoingEditMenu> {
	private final static HashMap<String, Object> guistate = IntergoingEditMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox expwynumber;
	EditBox province;
	EditBox direction;
	EditBox distance;
	EditBox firstline;
	EditBox secondline;
	Button button_edit;

	public IntergoingEditScreen(IntergoingEditMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 214;
		this.imageHeight = 195;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		expwynumber.render(guiGraphics, mouseX, mouseY, partialTicks);
		province.render(guiGraphics, mouseX, mouseY, partialTicks);
		direction.render(guiGraphics, mouseX, mouseY, partialTicks);
		distance.render(guiGraphics, mouseX, mouseY, partialTicks);
		firstline.render(guiGraphics, mouseX, mouseY, partialTicks);
		secondline.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (expwynumber.isFocused())
			return expwynumber.keyPressed(key, b, c);
		if (province.isFocused())
			return province.keyPressed(key, b, c);
		if (direction.isFocused())
			return direction.keyPressed(key, b, c);
		if (distance.isFocused())
			return distance.keyPressed(key, b, c);
		if (firstline.isFocused())
			return firstline.keyPressed(key, b, c);
		if (secondline.isFocused())
			return secondline.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		expwynumber.tick();
		province.tick();
		direction.tick();
		distance.tick();
		firstline.tick();
		secondline.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.intergoing_edit.label_sign_text_edit"), 9, 8, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.intergoing_edit.label_expwy_number"), 9, 26, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.intergoing_edit.label_direction"), 9, 71, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.intergoing_edit.label_distance"), 117, 71, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.intergoing_edit.label_province"), 117, 26, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.intergoing_edit.label_first_line"), 9, 116, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.intergoing_edit.label_second_line"), 117, 116, -1, false);
	}

	@Override
	public void init() {
		super.init();
		expwynumber = new EditBox(this.font, this.leftPos + 10, this.topPos + 45, 88, 18, Component.translatable("gui.junjietrafficmod.intergoing_edit.expwynumber"));
		expwynumber.setMaxLength(32767);
		guistate.put("text:expwynumber", expwynumber);
		this.addWidget(this.expwynumber);
		province = new EditBox(this.font, this.leftPos + 118, this.topPos + 45, 88, 18, Component.translatable("gui.junjietrafficmod.intergoing_edit.province"));
		province.setMaxLength(32767);
		guistate.put("text:province", province);
		this.addWidget(this.province);
		direction = new EditBox(this.font, this.leftPos + 10, this.topPos + 90, 88, 18, Component.translatable("gui.junjietrafficmod.intergoing_edit.direction"));
		direction.setMaxLength(32767);
		guistate.put("text:direction", direction);
		this.addWidget(this.direction);
		distance = new EditBox(this.font, this.leftPos + 118, this.topPos + 90, 88, 18, Component.translatable("gui.junjietrafficmod.intergoing_edit.distance"));
		distance.setMaxLength(32767);
		guistate.put("text:distance", distance);
		this.addWidget(this.distance);
		firstline = new EditBox(this.font, this.leftPos + 10, this.topPos + 135, 88, 18, Component.translatable("gui.junjietrafficmod.intergoing_edit.firstline"));
		firstline.setMaxLength(32767);
		guistate.put("text:firstline", firstline);
		this.addWidget(this.firstline);
		secondline = new EditBox(this.font, this.leftPos + 118, this.topPos + 135, 88, 18, Component.translatable("gui.junjietrafficmod.intergoing_edit.secondline"));
		secondline.setMaxLength(32767);
		guistate.put("text:secondline", secondline);
		this.addWidget(this.secondline);
		boolean isG = world.getBlockState(new net.minecraft.core.BlockPos(x, y, z)).getBlock() instanceof GantryGInterStraightBlock
				|| world.getBlockState(new net.minecraft.core.BlockPos(x, y, z)).getBlock() instanceof GantryGInterRightBlock
				|| world.getBlockState(new net.minecraft.core.BlockPos(x, y, z)).getBlock() instanceof GantryGInterLeftBlock;
		TextEngine.prefillEditBox(this.x, this.y, this.z, 1, expwynumber);
		if (!isG)
			TextEngine.prefillEditBox(this.x, this.y, this.z, 2, province);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 3, direction);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 4, distance);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 5, firstline);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 6, secondline);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.intergoing_edit.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 1, expwynumber.getValue());
			if (!isG)
				TextEngine.onEditButtonPressed(this.x, this.y, this.z, 2, province.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 3, direction.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 4, distance.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 5, firstline.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 6, secondline.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 9, this.topPos + 170, 73, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
