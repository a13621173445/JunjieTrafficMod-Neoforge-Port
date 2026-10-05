package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.ExpwyExportReportEditMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ExpwyExportReportEditScreen extends AbstractContainerScreen<ExpwyExportReportEditMenu> {
	private final static HashMap<String, Object> guistate = ExpwyExportReportEditMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox exitnumber1;
	EditBox exitnumber2;
	EditBox exitnumber3;
	EditBox exportname1;
	EditBox exportname2;
	EditBox exportname3;
	EditBox distance1;
	EditBox distance2;
	EditBox distance3;
	EditBox expwynumber;
	EditBox branchnumber;
	EditBox expwyname;
	Button button_edit;

	public ExpwyExportReportEditScreen(ExpwyExportReportEditMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 315;
		this.imageHeight = 199;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		exitnumber1.render(guiGraphics, mouseX, mouseY, partialTicks);
		exitnumber2.render(guiGraphics, mouseX, mouseY, partialTicks);
		exitnumber3.render(guiGraphics, mouseX, mouseY, partialTicks);
		exportname1.render(guiGraphics, mouseX, mouseY, partialTicks);
		exportname2.render(guiGraphics, mouseX, mouseY, partialTicks);
		exportname3.render(guiGraphics, mouseX, mouseY, partialTicks);
		distance1.render(guiGraphics, mouseX, mouseY, partialTicks);
		distance2.render(guiGraphics, mouseX, mouseY, partialTicks);
		distance3.render(guiGraphics, mouseX, mouseY, partialTicks);
		expwynumber.render(guiGraphics, mouseX, mouseY, partialTicks);
		branchnumber.render(guiGraphics, mouseX, mouseY, partialTicks);
		expwyname.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (exitnumber1.isFocused())
			return exitnumber1.keyPressed(key, b, c);
		if (exitnumber2.isFocused())
			return exitnumber2.keyPressed(key, b, c);
		if (exitnumber3.isFocused())
			return exitnumber3.keyPressed(key, b, c);
		if (exportname1.isFocused())
			return exportname1.keyPressed(key, b, c);
		if (exportname2.isFocused())
			return exportname2.keyPressed(key, b, c);
		if (exportname3.isFocused())
			return exportname3.keyPressed(key, b, c);
		if (distance1.isFocused())
			return distance1.keyPressed(key, b, c);
		if (distance2.isFocused())
			return distance2.keyPressed(key, b, c);
		if (distance3.isFocused())
			return distance3.keyPressed(key, b, c);
		if (expwynumber.isFocused())
			return expwynumber.keyPressed(key, b, c);
		if (branchnumber.isFocused())
			return branchnumber.keyPressed(key, b, c);
		if (expwyname.isFocused())
			return expwyname.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.label_sign_text_edit"), 10, 8, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.label_exit_number"), 10, 71, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.label_export_name"), 91, 71, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.label_distance"), 235, 71, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.label_expwy_number"), 10, 26, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.label_expwy_name"), 181, 26, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.label_branch_number"), 91, 26, -1, false);
	}

	@Override
	public void init() {
		super.init();
		exitnumber1 = new EditBox(this.font, this.leftPos + 11, this.topPos + 90, 61, 18, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.exitnumber1"));
		exitnumber1.setMaxLength(32767);
		guistate.put("text:exitnumber1", exitnumber1);
		this.addWidget(this.exitnumber1);
		exitnumber2 = new EditBox(this.font, this.leftPos + 11, this.topPos + 117, 61, 18, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.exitnumber2"));
		exitnumber2.setMaxLength(32767);
		guistate.put("text:exitnumber2", exitnumber2);
		this.addWidget(this.exitnumber2);
		exitnumber3 = new EditBox(this.font, this.leftPos + 11, this.topPos + 144, 61, 18, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.exitnumber3"));
		exitnumber3.setMaxLength(32767);
		guistate.put("text:exitnumber3", exitnumber3);
		this.addWidget(this.exitnumber3);
		exportname1 = new EditBox(this.font, this.leftPos + 92, this.topPos + 90, 124, 18, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.exportname1"));
		exportname1.setMaxLength(32767);
		guistate.put("text:exportname1", exportname1);
		this.addWidget(this.exportname1);
		exportname2 = new EditBox(this.font, this.leftPos + 92, this.topPos + 117, 124, 18, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.exportname2"));
		exportname2.setMaxLength(32767);
		guistate.put("text:exportname2", exportname2);
		this.addWidget(this.exportname2);
		exportname3 = new EditBox(this.font, this.leftPos + 92, this.topPos + 144, 124, 18, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.exportname3"));
		exportname3.setMaxLength(32767);
		guistate.put("text:exportname3", exportname3);
		this.addWidget(this.exportname3);
		distance1 = new EditBox(this.font, this.leftPos + 236, this.topPos + 90, 70, 18, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.distance1"));
		distance1.setMaxLength(32767);
		guistate.put("text:distance1", distance1);
		this.addWidget(this.distance1);
		distance2 = new EditBox(this.font, this.leftPos + 236, this.topPos + 117, 70, 18, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.distance2"));
		distance2.setMaxLength(32767);
		guistate.put("text:distance2", distance2);
		this.addWidget(this.distance2);
		distance3 = new EditBox(this.font, this.leftPos + 236, this.topPos + 144, 70, 18, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.distance3"));
		distance3.setMaxLength(32767);
		guistate.put("text:distance3", distance3);
		this.addWidget(this.distance3);
		expwynumber = new EditBox(this.font, this.leftPos + 11, this.topPos + 45, 61, 18, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.expwynumber"));
		expwynumber.setMaxLength(32767);
		guistate.put("text:expwynumber", expwynumber);
		this.addWidget(this.expwynumber);
		branchnumber = new EditBox(this.font, this.leftPos + 92, this.topPos + 45, 70, 18, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.branchnumber"));
		branchnumber.setMaxLength(32767);
		guistate.put("text:branchnumber", branchnumber);
		this.addWidget(this.branchnumber);
		expwyname = new EditBox(this.font, this.leftPos + 182, this.topPos + 45, 124, 18, Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.expwyname"));
		expwyname.setMaxLength(32767);
		guistate.put("text:expwyname", expwyname);
		this.addWidget(this.expwyname);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 1, exitnumber1);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 2, exitnumber2);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 3, exitnumber3);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 4, exportname1);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 5, exportname2);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 6, exportname3);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 7, distance1);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 8, distance2);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 9, distance3);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 10, expwynumber);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 11, branchnumber);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 12, expwyname);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.expwy_export_report_edit.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 1, exitnumber1.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 2, exitnumber2.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 3, exitnumber3.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 4, exportname1.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 5, exportname2.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 6, exportname3.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 7, distance1.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 8, distance2.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 9, distance3.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 10, expwynumber.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 11, branchnumber.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 12, expwyname.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 10, this.topPos + 170, 73, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
