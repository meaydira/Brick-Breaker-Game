package gui;

import game_engine.BuildingMode;
import game_engine.GameConstants;
import model.bricks.Brick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class BuildingModePanel  extends JPanel implements GameConstants, KeyListener, ActionListener,MouseListener  {

  private static BuildingModePanel building_instance = null;
    private BuildingMode buildingMode;
    private Timer timer;
    private int delay = 2;

    public static BuildingModePanel getInstance(BuildingMode bm) {
        if (building_instance == null) {
            building_instance = new BuildingModePanel();
            building_instance.buildingMode= bm;
            building_instance.setLayout(new GridLayout());
            building_instance.addKeyListener(building_instance);
            building_instance.addMouseListener(building_instance);
            building_instance.setFocusable(true);
            building_instance.setFocusTraversalKeysEnabled(false);
            building_instance.timer = new Timer(building_instance.delay, building_instance);
            building_instance.timer.start();
            building_instance.requestFocusInWindow();
            return building_instance;
        } else {
            return building_instance;
        }
    }



    public void paintComponent(Graphics g) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.getHeight();
        screenSize.getWidth();
        Graphics2D g2d = (Graphics2D) g;
        fillGameBackground(g2d);
        fillGamePanelBackground(g2d);

        // drawing map
        drawMap(g2d);

        drawBorder(g2d);

        drawText(g2d, 14, "PRESS 'G' FOR A RANDOM MAP." , 700, PADDLE_Y_START, Color.BLACK);

        drawBrickType(g2d, "Brick Type: ", 700, 30, Color.BLACK);

        // the paddle
        drawPaddle(g2d);

        // building mode text
        drawBM(g2d);
        g.dispose();

    }

    private void drawMap(Graphics2D g2d){
        for (Brick b : buildingMode.getCurrentMap().getBricks()) {
            if (!b.isDestroyed()) if (b.getClass().getName().equals("model.bricks.MineBrick")) {
                drawMineBrick(g2d, b.getColor(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
            } else if (b.getClass().getName().equals("model.bricks.HalfMetalBrick")) {
                drawHalfMetal(g2d, b.getColor(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
            } else {
                drawSimpleBrick(g2d, b.getColor(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
            }
        }
    }

    private void drawSimpleBrick(Graphics2D g2d, Color color, double x, double y, int width, int height) {
        g2d.setColor(color);
        g2d.fill(new Rectangle2D.Double(x, y, width, height));
    }

    private void drawMineBrick(Graphics2D g2d, Color color, double x, double y, int width, int height) {
        g2d.setColor(color);
        g2d.fill(new Ellipse2D.Double(x, y, width, height));
    }

    private void drawHalfMetal(Graphics2D g2d, Color color, double x, double y, int width, int height) {
        g2d.setColor(color);
        g2d.fill(new Rectangle2D.Double(x, y, width, height - 5));
        g2d.setColor(Color.darkGray);
        g2d.fill(new Rectangle2D.Double(x , y+ height - 8, width, 5));

    }

    private void drawBorder(Graphics2D g2d) {
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setColor(Color.white);
        g2d.setStroke(dashed);
        g2d.drawLine(0, 340, 692, 340);
    }

    private void drawText(Graphics2D g2d, int fontSize, String s, int x, int y, Color color) {
        g2d.setColor(color);
        g2d.setFont(new Font("serif", Font.BOLD, fontSize));
        g2d.drawString(s, x, y);
    }

    private void fillGameBackground(Graphics2D g2d) {
        g2d.setColor(Color.black);
        g2d.fill(new Rectangle(1, 1, 692, 592));
    }

    private void fillGamePanelBackground(Graphics2D g2d) {
        g2d.setColor(Color.white);
        g2d.fillRect(693, 1, 899, 592);
    }


    private void drawBM(Graphics2D g2d){
        //building mode
        drawText(g2d, 15, "BUILDING MODE",320,30,Color.YELLOW);

    }


    private void drawPaddle(Graphics2D g2d) {

        g2d.setColor(Color.yellow);
        Rectangle2D paddleRechtangle =new Rectangle2D.Double(buildingMode.getPaddle().getXpos(), PADDLE_Y_START, buildingMode.getPaddle().getWidth(), PADDLE_HEIGHT);

        AffineTransform tx = new AffineTransform();
        Double radianAngle = Math.toRadians(buildingMode.getPaddle().getAngle());
        double rotationCenter =  (buildingMode.getPaddle().getAngle() < 0) ? (buildingMode.getPaddle().getXpos()) : ( buildingMode.getPaddle().getXpos() + buildingMode.getPaddle().getWidth());
        tx.rotate(radianAngle, rotationCenter, PADDLE_Y_START);
        Shape rotatedVersion = tx.createTransformedShape(paddleRechtangle);
        g2d.fill(rotatedVersion);
    }


    private void drawBrickType(Graphics2D g2d, String text, int x, int y, Color color) {
        drawText(g2d, 25, text , x, y, color);
        drawText(g2d, 25, buildingMode.getCurrentBrick(), x, y + 30, color);
    }


    public void mouseClicked(MouseEvent e) {
        int x=e.getX();
        int y=e.getY();
        buildingMode.handleClick(x,y);
            repaint();
        }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



    public void actionPerformed(ActionEvent e) {

        timer.start();
        building_instance.requestFocusInWindow();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_G) {
            buildingMode.initializeMap();
            System.out.println("G is clicked.");
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            buildingMode.terminate();
            this.setVisible(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_1) {
            buildingMode.changeBrickType(1);
        }

        if (e.getKeyCode() == KeyEvent.VK_2) {
            buildingMode.changeBrickType(2);
        }

        if (e.getKeyCode() == KeyEvent.VK_3) {
            buildingMode.changeBrickType(3);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

