package com.gabriel.draw.view;

import com.gabriel.draw.controller.DrawingWindowController;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.service.AppService;
import javax.swing.*;
import java.awt.*;

public class DrawingFrame extends JFrame {


    public DrawingFrame(AppService appService){
        DrawingWindowController drawingWindowController = new DrawingWindowController(appService);
        this.addWindowListener(drawingWindowController);
        this.addWindowFocusListener(drawingWindowController);
        this.addWindowStateListener(drawingWindowController);

        DrawingView drawingView = new DrawingView(appService);
        this.getContentPane().add(drawingView);

        JButton lineButton = new JButton("Line");
        JButton ellipseButton = new JButton("Ellipse");
        JButton rectangleButton = new JButton("Rectangle");

        lineButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Line));
        ellipseButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Ellipse));
        rectangleButton.addActionListener(e -> appService.setShapeMode(ShapeMode.Rectangle));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(lineButton);
        buttonPanel.add(ellipseButton);
        buttonPanel.add(rectangleButton);

        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(drawingView, BorderLayout.CENTER);
    }
}
