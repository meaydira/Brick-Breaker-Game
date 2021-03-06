package gui;

import controllers.GameController;
import game_engine.GameConstants;
import game_engine.GameStatus;
import model.bricks.Brick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


public class GamePanel extends JPanel implements GameConstants, KeyListener, ActionListener {


    private static GamePanel game_instance = null;
    private GameController gameController;
    private Timer timer;
    private int delay = 2;
    private JButton pauseButton;  // TODO: Implement pause button

    public static GamePanel getInstance(GameController game) {
        if (game_instance == null) {
            game_instance = new GamePanel();
            game_instance.gameController = game;
            game_instance.setLayout(new GridLayout());
            game_instance.addKeyListener(game_instance);
            game_instance.setFocusable(true);
            game_instance.setFocusTraversalKeysEnabled(false);
            game_instance.timer = new Timer(game_instance.delay, game_instance);
            game_instance.timer.start();
            return game_instance;
        } else {
            return game_instance;
        }
    }


    public void paint(Graphics g) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.getHeight();
        screenSize.getWidth();
        Graphics2D g2d = (Graphics2D) g;
        fillGameBackground(g2d);
        fillGamePanelBackground(g2d);

        // drawing map

        for (Brick b : gameController.getBricks()) {
            if (!b.isDestroyed()) if (b.getClass().getName().equals("model.bricks.MineBrick")) {
                drawMineBrick(g2d, b.getColor(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
            } else if (b.getClass().getName().equals("model.bricks.HalfMetalBrick")) {
                drawHalfMetal(g2d, b.getColor(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
            } else {
                drawSimpleBrick(g2d, b.getColor(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
            }
        }

        drawBorder(g2d);

        // the scores
        drawScores(g2d, 25, "Score : ", 700, 30, Color.BLACK);

        //help sign
        if(!gameController.isGameStared() && !gameController.gameIsOver()){
            drawText(g2d, 14, "Press T to throw the ball", 700, PADDLE_Y_START, Color.BLACK);
        }else{
            drawText(g2d, 14, "Press Enter to pause", 700, PADDLE_Y_START, Color.BLACK);
        }
        // running mode sign
        drawRM(g2d);

        // the paddle
        drawPaddle(g2d);

        // the ball
        drawBall(g2d);

        // when you won the game
        if (gameController.getStatus() == GameStatus.Won) {
            drawText(g2d, 30, "You Won", 275, 300, Color.white);
            drawText(g2d, 20, "Press R to Restart", 250, 380, Color.white);
        }

        // when you lose the game
        if (gameController.getStatus() == GameStatus.Lost) {
            showGameOverSign(g2d);
            drawText(g2d, 20, "Press R to Restart", 260, 380, Color.white);
        }

        g.dispose();

    }

    private void drawRM(Graphics2D g2d){
        //running mode
        drawText(g2d, 15, "RUNNING MODE",320,30,Color.YELLOW);

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
        g2d.fill(new Rectangle2D.Double(x, y + height - 8, width, 5));

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

    private void drawScores(Graphics2D g2d, int fontsize, String text, int x, int y, Color color) {
        drawText(g2d, fontsize, text + gameController.getScore(), x, y, color);
    }

    private void showGameOverSign(Graphics2D g2d) {
        drawText(g2d, 25, "Game Over", 290, 320, Color.white);
    }

    private void drawPaddle(Graphics2D g2d) {

        g2d.setColor(Color.yellow);
        Rectangle2D paddleRechtangle = new Rectangle2D.Double(gameController.getPaddleX(), PADDLE_Y_START, gameController.getPaddleWidth(), PADDLE_HEIGHT);

        AffineTransform tx = new AffineTransform();
        Double radianAngle = Math.toRadians(gameController.getPaddleAngle());
        double rotationCenter = (gameController.getPaddleAngle() < 0) ? (gameController.getPaddleX()) : (gameController.getPaddleX() + gameController.getPaddleWidth());
        tx.rotate(radianAngle, rotationCenter, PADDLE_Y_START);
        Shape rotatedVersion = tx.createTransformedShape(paddleRechtangle);
        g2d.fill(rotatedVersion);
    }

    private void drawBall(Graphics2D g2d) {

        Ellipse2D.Double shape = new Ellipse2D.Double(gameController.getBallX(), gameController.getBallY(), BALL_WIDTH, BALL_HEIGHT);
        g2d.setColor(BALL_COLOR);
        g2d.fill(shape);
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gameController.movePaddleRight();
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            gameController.movePaddleLeft();
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameController.switchMode();



            gameController.openPauseMenu();

        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            gameController.changePaddleAngleNegatively();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            gameController.changePaddleAnglePositively();
        }

        if (e.getKeyCode() == KeyEvent.VK_T) {
            gameController.throwBall();
        }
//        if (e.getKeyCode() == KeyEvent.VK_S) {
//            gameController.saveCurrent();
//        }
//
//        if (e.getKeyCode() == KeyEvent.VK_L) {
//            gameController.loadCurrent();
//        }
        if (e.getKeyCode() == KeyEvent.VK_R) {
            gameController.restartGame();
        }

    }


    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void actionPerformed(ActionEvent e) {

        timer.start();
        //TODO: Implement  boolean directionLock = false;
        if (gameController.isRunning()) {
            gameController.runPhysics();
        }
        if(gameController.gameIsOver()){
            gameController.lostGame();
        }
        repaint();
    }

}
