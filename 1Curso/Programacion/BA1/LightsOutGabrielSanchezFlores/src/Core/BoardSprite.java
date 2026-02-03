package Core;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * This class is the representation of a sprite in a Board. It is a very simple sprite that can be drawn over a matrix board. 
 * @author Marc
 *
 */
public class BoardSprite {

	/**
	 * the name of the sprite
	 */
	public String name;

	/**
	 * The row where the sprite will begin. The sprite upper border will be on the top of this row
	 */
	public int row1;
	
	/**
	 * The column where the sprite will begin. The sprite left border will be on the beggining of this column
	 */
	public int col1;

	/**
	 * The row where the sprite will end. The sprite lower border will be at the bottom of this row
	 */
	public int row2;
	
	/**
	 * The column where the sprite will end. The sprite right border will be at the end of this column
	 */
	public int col2;

	/**
	 * The path to the image to that Sprite
	 */
	public String path;

	/**
	 * Specifies whether this sprite is text. Text won't use an image path and will
	 * print the String specified as path.
	 */
	public boolean text;
	
	/**
	 * Font for the text if the Sprite is used as text
	 */
	public Font font = new Font("SansSerif", Font.PLAIN, 16);
	
	/**
	 * Color for the text if the Sprite is used as text
	 */
	public int textColor = 0x000000;
	
	/**
	 * image object for the sprite
	 */
	public Image img;
	
	/**
	 * Creates a new board sprite
	 * @param name the name of the sprite
	 * @param r1 The row where the sprite will begin. The sprite upper border will be on the top of this row
	 * @param c1 The column where the sprite will begin. The sprite left border will be on the beggining of this column
	 * @param r2 The row where the sprite will end. The sprite lower border will be at the bottom of this row
	 * @param c2 The column where the sprite will end. The sprite right border will be at the end of this column
	 * @param path The path to the image to that Sprite, or the text in a text Sprite
	 */
	public BoardSprite(String name, int r1, int c1, int r2, int c2, String path) {
		super();
		this.name = name;
		this.row1 = r1;
		this.col1 = c1;
		this.row2 = r2;
		this.col2 = c2;
		this.path = path;
		img = new ImageIcon((this.path)).getImage();
		if(c2<c1||r2<r1) {
			System.out.println("ERROR. SPRITE INITIALIZED WITH NEGATIVE LENGHT/HEIGHT");
		}
	}

}
