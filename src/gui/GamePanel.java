package gui;

import game_engine.Game;
import game_engine.GameConstants;
import game_engine.GameStatus;
import game_engine.MapGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements GameConstants, KeyListener, ActionListener {


    private static GamePanel game_instance = null;
    private Game currentGame;
    private Timer timer;
    private MapGenerator map;
    private int score = 0;
    private int delay = 8;

    private JButton pauseButton;

    public static GamePanel getInstance(Game game) {
        if (game_instance == null) {
            game_instance = new GamePanel();
            game_instance.currentGame = game;

            game_instance.setLayout(new GridLayout());
            game_instance.map = new MapGenerator(6, 12);
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


    @Override
    protected void paintComponent(Graphics g) {
//        Image img = Toolkit.getDefaultToolkit().getImage("background.jpg");
//        super.paintComponent(g);
//        g.drawImage(img, 0, 0, null);
    }

    public void paint(Graphics g) {
//      paintComponent(g);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.getHeight();
        screenSize.getWidth();

        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);

        map.draw((Graphics2D) g);

        g.setColor(Color.white);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        // the scores
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + score, 590, 30);

        // the paddle
        g.setColor(Color.yellow);
        g.fillRect(currentGame.getPaddle().getXpos(), PADDLE_Y_START, currentGame.getPaddle().getWidth(), PADDLE_HEIGHT);

        // the ball
        g.setColor(currentGame.getBall().getColor());
        g.fillOval(currentGame.getBall().getX(), currentGame.getBall().getY(), BALL_WIDTH, BALL_HEIGHT);

        // when you won the game
        if (currentGame.getStatus() == GameStatus.Won) {

            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("You Won", 260, 300);

            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press (Enter) to Restart", 230, 350);
        }

        // when you lose the game
        if (currentGame.getStatus() == GameStatus.Lost) {

            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Game Over, Scores: " + score, 190, 300);

            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press (Enter) to Restart", 230, 350);
        }
        g.dispose();

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            currentGame.moveRight();
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            currentGame.moveLeft();

        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            if (!currentGame.isRunning()) {

                currentGame.setRunning(true);
                currentGame.getBall().setX(120);
                currentGame.getBall().setY(530);

                currentGame.getBall().setXDir(-1);
                currentGame.getBall().setYDir(-2);

                currentGame.getPaddle().setXpos(310);
                score = 0;
                currentGame.setTotalBricks(21);
                map = new MapGenerator(6, 12);

                repaint();
            } else switchMode();
        }
    }


    public void switchMode() {
        if (timer.isRunning()) {
            timer.stop();
        } else timer.start();
    }


    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }


    public void actionPerformed(ActionEvent e) {
        timer.start();

        if (currentGame.isRunning()) {
            // check map collision with the ball
            A:
            for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {
                        //scores++;
                        int brickX = j * map.brickWidth + 70;
                        int brickY = i * map.brickHeight + 50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;

                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                        Rectangle ballRect = new Rectangle(currentGame.getBall().getX(), currentGame.getBall().getY(), 20, 20);
                        Rectangle brickRect = rect;

                        if (ballRect.intersects(brickRect)) {
                            map.setBrickValue(0, i, j);
                            score += 5;
                            currentGame.setTotalBricks(currentGame.getTotalBricks() - 1);
                            // when ball hit right or left of brick
                            if (currentGame.getBall().getX() + 19 <= brickRect.x || currentGame.getBall().getX() + 1 >= brickRect.x + brickRect.width) {
                                currentGame.getBall().setXDir(-currentGame.getBall().getXDir());
                            }
                            // when ball hits top or bottom of brick
                            else {
                                currentGame.getBall().setYDir(-currentGame.getBall().getYDir());
                            }
                            break A;
                        }
                    }
                }
            }



            repaint();
        }
    }

}