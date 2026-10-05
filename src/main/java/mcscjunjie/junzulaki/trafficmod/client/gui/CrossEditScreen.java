package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.CrossEditMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;
import net.minecraft.core.BlockPos;
import mcscjunjie.junzulaki.trafficmod.block.SIDEcross1Block;
import mcscjunjie.junzulaki.trafficmod.block.SIDEcross2Block;
import mcscjunjie.junzulaki.trafficmod.block.SIDEcross3Block;
import mcscjunjie.junzulaki.trafficmod.block.SIDEcross4Block;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CrossEditScreen extends AbstractContainerScreen<CrossEditMenu> {
	private final static HashMap<String, Object> guistate = CrossEditMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox nameoftheroad;
	EditBox leftleadroad;
	EditBox leftroadpinyin;
	EditBox leftroaddistance;
	EditBox straightroaddistance;
	EditBox straightleadroad;
	EditBox straightroadpinyin;
	EditBox rightleadroad;
	EditBox rightroadpinyin;
	EditBox rightroaddistance;
	EditBox direction;
	Button button_edit;

	public CrossEditScreen(CrossEditMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 378;
		this.imageHeight = 193;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		nameoftheroad.render(guiGraphics, mouseX, mouseY, partialTicks);
		leftleadroad.render(guiGraphics, mouseX, mouseY, partialTicks);
		leftroadpinyin.render(guiGraphics, mouseX, mouseY, partialTicks);
		leftroaddistance.render(guiGraphics, mouseX, mouseY, partialTicks);
		straightroaddistance.render(guiGraphics, mouseX, mouseY, partialTicks);
		straightleadroad.render(guiGraphics, mouseX, mouseY, partialTicks);
		straightroadpinyin.render(guiGraphics, mouseX, mouseY, partialTicks);
		rightleadroad.render(guiGraphics, mouseX, mouseY, partialTicks);
		rightroadpinyin.render(guiGraphics, mouseX, mouseY, partialTicks);
		rightroaddistance.render(guiGraphics, mouseX, mouseY, partialTicks);
		direction.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (nameoftheroad.isFocused())
			return nameoftheroad.keyPressed(key, b, c);
		if (leftleadroad.isFocused())
			return leftleadroad.keyPressed(key, b, c);
		if (leftroadpinyin.isFocused())
			return leftroadpinyin.keyPressed(key, b, c);
		if (leftroaddistance.isFocused())
			return leftroaddistance.keyPressed(key, b, c);
		if (straightroaddistance.isFocused())
			return straightroaddistance.keyPressed(key, b, c);
		if (straightleadroad.isFocused())
			return straightleadroad.keyPressed(key, b, c);
		if (straightroadpinyin.isFocused())
			return straightroadpinyin.keyPressed(key, b, c);
		if (rightleadroad.isFocused())
			return rightleadroad.keyPressed(key, b, c);
		if (rightroadpinyin.isFocused())
			return rightroadpinyin.keyPressed(key, b, c);
		if (rightroaddistance.isFocused())
			return rightroaddistance.keyPressed(key, b, c);
		if (direction.isFocused())
			return direction.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.cross_edit.label_sign_text_edit"), 10, 7, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.cross_edit.label_name_of_the_road"), 85, 174, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.cross_edit.label_left_lead_road"), 10, 25, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.cross_edit.label_leftroad_distance"), 262, 25, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.cross_edit.label_straight_lead_road"), 10, 70, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.cross_edit.label_straightroad_pinyin"), 136, 70, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.cross_edit.label_leftroad_pinyin"), 136, 25, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.cross_edit.label_straightroad_distance"), 262, 70, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.cross_edit.label_right_lead_road"), 10, 115, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.cross_edit.label_rightroad_distance"), 262, 115, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.cross_edit.label_rightroad_pinyin"), 136, 115, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.cross_edit.label_direction"), 236, 173, -1, false);
	}

	@Override
	public void init() {
		super.init();
		nameoftheroad = new EditBox(this.font, this.leftPos + 173, this.topPos + 170, 52, 18, Component.translatable("gui.junjietrafficmod.cross_edit.nameoftheroad"));
		nameoftheroad.setMaxLength(32767);
		guistate.put("text:nameoftheroad", nameoftheroad);
		this.addWidget(this.nameoftheroad);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 1, nameoftheroad);
		leftleadroad = new EditBox(this.font, this.leftPos + 11, this.topPos + 44, 115, 18, Component.translatable("gui.junjietrafficmod.cross_edit.leftleadroad"));
		leftleadroad.setMaxLength(32767);
		guistate.put("text:leftleadroad", leftleadroad);
		this.addWidget(this.leftleadroad);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 2, leftleadroad);
		leftroadpinyin = new EditBox(this.font, this.leftPos + 137, this.topPos + 44, 115, 18, Component.translatable("gui.junjietrafficmod.cross_edit.leftroadpinyin"));
		leftroadpinyin.setMaxLength(32767);
		guistate.put("text:leftroadpinyin", leftroadpinyin);
		this.addWidget(this.leftroadpinyin);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 3, leftroadpinyin);
		leftroaddistance = new EditBox(this.font, this.leftPos + 263, this.topPos + 44, 106, 18, Component.translatable("gui.junjietrafficmod.cross_edit.leftroaddistance"));
		leftroaddistance.setMaxLength(32767);
		guistate.put("text:leftroaddistance", leftroaddistance);
		this.addWidget(this.leftroaddistance);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 4, leftroaddistance);
		straightroaddistance = new EditBox(this.font, this.leftPos + 263, this.topPos + 89, 106, 18, Component.translatable("gui.junjietrafficmod.cross_edit.straightroaddistance"));
		straightroaddistance.setMaxLength(32767);
		guistate.put("text:straightroaddistance", straightroaddistance);
		this.addWidget(this.straightroaddistance);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 7, straightroaddistance);
		straightleadroad = new EditBox(this.font, this.leftPos + 11, this.topPos + 89, 115, 18, Component.translatable("gui.junjietrafficmod.cross_edit.straightleadroad"));
		straightleadroad.setMaxLength(32767);
		guistate.put("text:straightleadroad", straightleadroad);
		this.addWidget(this.straightleadroad);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 5, straightleadroad);
		straightroadpinyin = new EditBox(this.font, this.leftPos + 137, this.topPos + 89, 115, 18, Component.translatable("gui.junjietrafficmod.cross_edit.straightroadpinyin"));
		straightroadpinyin.setMaxLength(32767);
		guistate.put("text:straightroadpinyin", straightroadpinyin);
		this.addWidget(this.straightroadpinyin);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 6, straightroadpinyin);
		rightleadroad = new EditBox(this.font, this.leftPos + 11, this.topPos + 134, 115, 18, Component.translatable("gui.junjietrafficmod.cross_edit.rightleadroad"));
		rightleadroad.setMaxLength(32767);
		guistate.put("text:rightleadroad", rightleadroad);
		this.addWidget(this.rightleadroad);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 8, rightleadroad);
		rightroadpinyin = new EditBox(this.font, this.leftPos + 137, this.topPos + 134, 115, 18, Component.translatable("gui.junjietrafficmod.cross_edit.rightroadpinyin"));
		rightroadpinyin.setMaxLength(32767);
		guistate.put("text:rightroadpinyin", rightroadpinyin);
		this.addWidget(this.rightroadpinyin);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 9, rightroadpinyin);
		rightroaddistance = new EditBox(this.font, this.leftPos + 263, this.topPos + 134, 106, 18, Component.translatable("gui.junjietrafficmod.cross_edit.rightroaddistance"));
		rightroaddistance.setMaxLength(32767);
		guistate.put("text:rightroaddistance", rightroaddistance);
		this.addWidget(this.rightroaddistance);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 10, rightroaddistance);
		direction = new EditBox(this.font, this.leftPos + 287, this.topPos + 170, 52, 18, Component.translatable("gui.junjietrafficmod.cross_edit.direction"));
		direction.setMaxLength(32767);
		guistate.put("text:direction", direction);
		this.addWidget(this.direction);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 0, direction);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.cross_edit.button_edit"), e -> {
			net.minecraft.world.level.block.Block block = this.world.getBlockState(new BlockPos(this.x, this.y, this.z)).getBlock();
			boolean isA = block instanceof SIDEcross1Block;
			boolean isB = block instanceof SIDEcross2Block;
			boolean isC = block instanceof SIDEcross3Block;
			boolean isD = block instanceof SIDEcross4Block;
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 0, direction.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 1, nameoftheroad.getValue());
			if (isA || isB || isD) {
				TextEngine.onEditButtonPressed(this.x, this.y, this.z, 2, leftleadroad.getValue());
				TextEngine.onEditButtonPressed(this.x, this.y, this.z, 3, leftroadpinyin.getValue());
			}
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 4, leftroaddistance.getValue());
			if (isA || isB || isC) {
				TextEngine.onEditButtonPressed(this.x, this.y, this.z, 5, straightleadroad.getValue());
				TextEngine.onEditButtonPressed(this.x, this.y, this.z, 6, straightroadpinyin.getValue());
				TextEngine.onEditButtonPressed(this.x, this.y, this.z, 7, straightroaddistance.getValue());
			}
			if (isA || isC || isD) {
				TextEngine.onEditButtonPressed(this.x, this.y, this.z, 8, rightleadroad.getValue());
				TextEngine.onEditButtonPressed(this.x, this.y, this.z, 9, rightroadpinyin.getValue());
				TextEngine.onEditButtonPressed(this.x, this.y, this.z, 10, rightroaddistance.getValue());
			}
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 10, this.topPos + 169, 73, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
