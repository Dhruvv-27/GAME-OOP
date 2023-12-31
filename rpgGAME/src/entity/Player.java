package entity;

//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/player/warrior-10.png.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/warrior-11.png.png"));
            up3  = ImageIO.read(getClass().getResourceAsStream("/player/warrior-12.png.png "));
  
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/warrior-1.png.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/warrior-2.png.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/warrior-3.png.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/player/warrior-4.png.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/warrior-5.png.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/warrior-6.png.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/player/warrior-7.png.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/warrior-8.png.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/warrior-9.png.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
    	if (keyH.upPressed == true||keyH.downPressed == true ||
    			keyH.leftPressed == true|| keyH.rightPressed == true) {
    	
        if (keyH.upPressed == true) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed == true) {
            direction = "down";
            y += speed;
        } else if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
        } else if (keyH.rightPressed == true) {
            direction = "right";
            x += speed;
        }
        spriteCounter++;
        if(spriteCounter > 10) {
        	if(spriteNum == 1) {
        		spriteNum = 2;
        		
        	}
            if(spriteNum == 2) {
            	spriteNum = 3;
            }
            else if (spriteNum == 3) {
            	spriteNum = 1;
            }
            spriteCounter = 0;
            		
    }
        
   }
}
    

    public void draw(Graphics2D g2) {

        // g2.setColor(Color.white);

        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;

        switch (direction) {
            case "up":
            	if(spriteNum == 1)
            		image = up1;
            	if(spriteNum == 2)
            		image = up2;
            	if(spriteNum == 3)
            		image = up3;
                break;

            case "down":
            	if(spriteNum == 1)
            		image = down1;
            	if(spriteNum == 2)
            		image = down2;
            	if(spriteNum == 3)
            		image = down3;
                break;

            case "left":
            	if(spriteNum == 1)
            		image = left1;
            	if(spriteNum == 2)
            		image = left2;
            	if(spriteNum == 3)
            		image = left3;
            	break;

            case "right":
            	if(spriteNum == 1)
            		image = right1;
            	if(spriteNum == 2)
            		image = right2;
            	if(spriteNum == 3)
            		image = right3;
            	break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

}
