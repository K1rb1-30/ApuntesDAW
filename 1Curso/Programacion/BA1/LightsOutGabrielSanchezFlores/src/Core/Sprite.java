package Core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * <h2>This class is the representation of a Sprite in a Pixel Field.</h2> It
 * measures as a rectangle, has collision functions. Every class in a Pixel
 * Field must extend from this class
 * 
 * @see <a href="https://gitlab.com/malbareda/GraphicBoard">Git Repository</a>
 * @version 0.8
 * @author
 *         <h1>Marc Albareda</h1> <img src=
 *         "https://yt3.ggpht.com/a-/AAuE7mAEQPhIx5GSxS4TWhnD_TltoW2pMDvvuveiOg=s288-mo-c-c0xffffffff-rj-k-no"
 *         alt="Smiley face" height="1200" width="1200">
 *
 * 
 */
public class Sprite implements Serializable {

	/**
	 * Margin to detect collisions. This will mark the horizontal range where a
	 * top-down collision will not be detected
	 */
	public int MARGIN = 5;

	/**
	 * Depth to detect collisions. This will mark the depth of the rectangle for the
	 * top/bottom/lateral rectangles
	 */
	public int DEPTH = 20;

	/**
	 * the name of the sprite
	 */
	public String name;

	/**
	 * The horizontal position in the field of the upper-left pixel in the sprite
	 */
	public int x1;
	/**
	 * The vertical position in the field of the upper-left pixel in the sprite
	 */
	public int y1;

	/**
	 * The horizontal position in the field of the bottom-right pixel in the sprite
	 */
	public int x2;
	/**
	 * The vertical position in the field of the bottom-right pixel in the sprite
	 */
	public int y2;

	/**
	 * The rotating angle in degrees
	 */
	public double angle;

	/**
	 * The path to the image to that Sprite
	 */
	public String path;

	/**
	 * Specifies whether this Sprite is solid. Non-solid sprites will not collide.
	 */
	public boolean solid = true;
	/**
	 * Specifies whether this sprite is terrain. Terrains are immobile objects which
	 * can be collided and standed on.
	 */
	public boolean terrain;
	/**
	 * Specifies whether this sprite is unscrollable. Unscrollables won't be
	 * scrolled ever. Used for HUD or fixed objects
	 */
	public boolean unscrollable;
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
	 * checks if an img Array should be used instead of a single image
	 */
	public boolean useImgArray = false;
	/**
	 * position of the image on the img array that should be accessed currently
	 */
	public int currentImg = 0;
	/**
	 * array of images, needed if a single sprite has several images.
	 */
	public String[] imgArray;
	/**
	 * marks this Sprite to be deleted.
	 */

	public int drawingBoxExtraLeft;

	public int drawingBoxExtraRight;

	public int drawingBoxExtraUp;

	public int drawingBoxExtraDown;

	/**
	 * checks whether this sprite has a collision box distinct to its drawing box
	 */
	public boolean collisionBox;

	/**
	 * marks this sprite to be deleted. Deleted sprites aren't drawn and they do not
	 * collide.
	 */
	public boolean delete;
	/**
	 * marks this sprite as a sprite with a palleteSwap
	 */
	public boolean palleteSwap;
	/**
	 * List of the required swaps. The even numbers will be replaced by the
	 * inmediately after number
	 */
	public ArrayList<Color> swapList = new ArrayList<>();

	/**
	 * determines if this sprite is a physicBody. physicBodies move according to a
	 * force and velocity vector and collide among selves.
	 */
	public boolean physicBody = true;

	/**
	 * marks this sprite as a trigger. Triggers move according to physics but do not
	 * stop when colliding with another physicbody
	 */
	public boolean trigger = false;

	/**
	 * marks this sprite as a phantom. Phantom sprites are used only for physic
	 * calculations
	 */
	private boolean phantom = false;

	/**
	 * force vector, measured in pixels/frame^2
	 */
	public double[] constantForce = new double[2];

	/**
	 * force vector, measured in pixels/frame^2
	 */
	public double[] force = new double[2];

	/**
	 * velocity vector, measured in pixels/frame
	 */
	public double[] velocity = new double[2];

	/**
	 * determines if this sprite is a color Sprite. Color Sprites are just squares
	 * with one color
	 * 
	 */
	public boolean colorSprite = false;

	/**
	 * color of a colored sprite, in RGB-Alpha format.
	 */
	public Color color;

	/**
	 * Default sprite constructor
	 * 
	 * @param name Name of the sprite, for identification purposes
	 * @param x1   x position (horizontal) of the upper left corner
	 * @param y1   y position (vertical) of the upper left corner
	 * @param x2   x position (horizontal) of the lower right corner
	 * @param y2   y position (vertical) of the lower right corner
	 * @param path path to the image of that sprite, as a relative path
	 */
	public Sprite(String name, int x1, int y1, int x2, int y2, String path) {
		super();
		this.name = name;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.path = path;
		useImgArray = false;
		this.angle = 0;
		if (x2 < x1 || y2 < y1) {
			System.out.println("ERROR. SPRITE INITIALIZED WITH NEGATIVE LENGHT/HEIGHT");
		}
	}

	/**
	 * Default sprite constructor, for sprites with multiple images
	 * 
	 * @param name Name of the sprite, for identification purposes
	 * @param x1   x position (horizontal) of the upper left corner
	 * @param y1   y position (vertical) of the upper left corner
	 * @param x2   x position (horizontal) of the lower right corner
	 * @param y2   y position (vertical) of the lower right corner
	 * @param path path to the array of images of that sprite, as a relative path
	 */
	public Sprite(String name, int x1, int y1, int x2, int y2, String[] path) {
		super();
		this.name = name;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		imgArray = path;
		useImgArray = true;
		this.angle = 0;
		if (x2 < x1 || y2 < y1) {
			System.out.println("ERROR. SPRITE INITIALIZED WITH NEGATIVE LENGHT/HEIGHT");
		}
	}

	/**
	 * Default sprite constructor, for sprites that are rotated from their original
	 * image
	 * 
	 * @param name  Name of the sprite, for identification purposes
	 * @param x1    x position (horizontal) of the upper left corner
	 * @param y1    y position (vertical) of the upper left corner
	 * @param x2    x position (horizontal) of the lower right corner
	 * @param y2    y position (vertical) of the lower right corner
	 * @param angle angle (in degrees) of rotation of the sprite
	 * @param path  path to the image of that sprite, as a relative path
	 */
	public Sprite(String name, int x1, int y1, int x2, int y2, double angle, String path) {
		super();
		this.name = name;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.path = path;
		useImgArray = false;
		this.angle = angle;
		if (x2 < x1 || y2 < y1) {
			System.out.println("ERROR. SPRITE INITIALIZED WITH NEGATIVE LENGHT/HEIGHT");
		}
	}

	/**
	 * Default sprite constructor, for sprites with multiple images that are rotated
	 * from their original image
	 * 
	 * @param name  Name of the sprite, for identification purposes
	 * @param x1    x position (horizontal) of the upper left corner
	 * @param y1    y position (vertical) of the upper left corner
	 * @param x2    x position (horizontal) of the lower right corner
	 * @param y2    y position (vertical) of the lower right corner
	 * @param angle angle (in degrees) of rotation of the sprite
	 * @param path  path to the array of images of that sprite, as a relative path
	 */
	public Sprite(String name, int x1, int y1, int x2, int y2, double angle, String[] path) {
		super();
		this.name = name;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		imgArray = path;
		useImgArray = true;
		this.angle = angle;
		if (x2 < x1 || y2 < y1) {
			System.out.println("ERROR. SPRITE INITIALIZED WITH NEGATIVE LENGHT/HEIGHT");
		}
	}

	/**
	 * Default sprite constructor, for sprites that are simple squares of a single
	 * color
	 * 
	 * @param name  Name of the sprite, for identification purposes
	 * @param x1    x position (horizontal) of the upper left corner
	 * @param y1    y position (vertical) of the upper left corner
	 * @param x2    x position (horizontal) of the lower right corner
	 * @param y2    y position (vertical) of the lower right corner
	 * @param angle angle (in degrees) of rotation of the sprite
	 * @param color color of that sprite.
	 */
	public Sprite(String name, int x1, int y1, int x2, int y2, double angle, Color color) {
		super();
		this.name = name;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.angle = angle;
		this.colorSprite = true;
		this.color = color;
		if (x2 < x1 || y2 < y1) {
			System.out.println("ERROR. SPRITE INITIALIZED WITH NEGATIVE LENGHT/HEIGHT");
		}
	}

	/**
	 * changes the image
	 * 
	 * @param path of the new image
	 */
	public void changeImage(String path) {
		// TODO eventualment anira al setPath quan encapsuli tot...
		this.path = path;
	}

	/**
	 * Swaps the two colors
	 * 
	 * @param c1 the color that will be swapped out
	 * @param c2 the color that will be swapped in
	 */
	public void palleteSwap(int c1, int c2) {
		this.palleteSwap = true;
		swapList.add(new Color(c1));
		swapList.add(new Color(c2));
	}

	/**
	 * Defines this sprite as having a drawing box different from the collision box
	 * 
	 * @param x1 extra width of the drawing box (left side)
	 * @param x2 extra width of the drawing box (right side)
	 * @param y1 extra height of the drawing box (upper side)
	 * @param y2 extra height of the drawing box (lower side)
	 */
	public void collisionBox(int x1, int x2, int y1, int y2) {
		this.drawingBoxExtraLeft = x1;
		this.drawingBoxExtraRight = x2;
		this.drawingBoxExtraUp = y1;
		this.drawingBoxExtraDown = y2;
		this.collisionBox = true;
	}

	/**
	 * removes the collision box
	 */
	public void removeCollisionBox() {
		this.collisionBox = false;
	}

	protected Shape getRect() {
		Rectangle myRect;
		if (this.physicBody && !this.phantom) {
			myRect = new Rectangle(x1 - 1, y1 - 1, x2 - x1 + 2, y2 - y1 + 2);
		} else {
			myRect = new Rectangle(x1, y1, x2 - x1, y2 - y1);
		}

		AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(angle), (x1 + x2) / 2, (y1 + y2) / 2);
		Shape rotatedRect = at.createTransformedShape(myRect);

		return rotatedRect;
	}

	protected Rectangle getNonRotatingRect() {
		Rectangle myRect;
		if (this.physicBody && !this.phantom) {
			myRect = new Rectangle(x1 - 1, y1 - 1, x2 - x1 + 2, y2 - y1 + 2);
		} else {
			myRect = new Rectangle(x1, y1, x2 - x1, y2 - y1);
		}
		return myRect;
	}

	protected Rectangle getBottomRect() {
		if (this.physicBody && !this.phantom) {
			return new Rectangle(x1 + MARGIN, y2 - DEPTH, x2 - x1 - MARGIN * 2, DEPTH + 2);
		} else {
			return new Rectangle(x1 + MARGIN, y2 - DEPTH, x2 - x1 - MARGIN * 2, DEPTH);
		}

	}

	protected Rectangle getTopRect() {
		if (this.physicBody && !this.phantom) {
			return new Rectangle(x1 + MARGIN, y1 - 2, x2 - x1 - MARGIN * 2, DEPTH);
		} else {
			return new Rectangle(x1 + MARGIN, y1, x2 - x1 - MARGIN * 2, DEPTH);
		}

	}

	protected Rectangle getLeftRect() {
		if (this.physicBody && !this.phantom) {
			return new Rectangle(x1 - 2, y1 + MARGIN, DEPTH, y2 - y1 - MARGIN * 2);
		} else {
			return new Rectangle(x1, y1 + MARGIN, DEPTH, y2 - y1 - MARGIN * 2);
		}

	}

	protected Rectangle getRightRect() {
		if (this.physicBody && !this.phantom) {
			return new Rectangle(x2 - DEPTH, y1 + MARGIN, DEPTH + 2, y2 - y1 - MARGIN * 2);
		} else {
			return new Rectangle(x2 - DEPTH, y1 + MARGIN, DEPTH, y2 - y1 - MARGIN * 2);
		}

	}

	/**
	 * Returns the all the Sprites in the provided list that collide with this
	 * Sprite
	 * 
	 * @param others A list of Sprites or classes that extends Sprite
	 * @return A list with all the sprites in the sprites list in the List that
	 *         collides. <br>
	 *         Returns an Empty list if there is no collision with any Sprite
	 */
	public ArrayList<Sprite> collidesWithList(ArrayList<? extends Sprite> others) {
		ArrayList<Sprite> list = new ArrayList<>();
		for (Sprite s : others) {
			if (this.collidesWith(s))
				list.add(s);
		}
		return list;

	}

	/**
	 * Checks if this sprite collides with the provided sprite. It won't collide
	 * with itself, against non-solid sprites, or sprites marked as deleted
	 * 
	 * @param other The other sprite
	 */
	public boolean collidesWith(Sprite other) {
		if(!this.equals(other)&&!this.delete&&!other.delete&&other.solid&&this.solid) {
			if(this.angle%180==0&&other.angle%180==0) {
				//els dos son rectangles, es pot fer servir un rectangle intersect sense cap rotacio
				return this.getNonRotatingRect().intersects( other.getNonRotatingRect());
			}
			//TODO INVESTIGAR COM ES POT RETRANSFORMAR A RECTANGLE UN RECTANGLE ROTAT AMB AFFINETRANSFORM
			if(this.angle%90==0&&other.angle%180==0) {
				//els dos son rectangles pero un esta rotat 90 o 270 .
				return this.getRect().intersects(other.getNonRotatingRect());
			}else if(this.angle%180==0&&other.angle%90==0) {
				//els dos son rectangles pero un esta rotat 90 o 270 .
				return other.getRect().intersects(this.getNonRotatingRect());
			}else {
				//hi han rotacions de no %90 o els dos estan rotats %90
				Area areaA = new Area(this.getRect());
				areaA.intersect(new Area(other.getRect()));
				return (!areaA.isEmpty());
			}
			
		}else {
			return false;
		}
		
	}
	

	/**
	 * Checks if this sprite collides with the provided sprite. It won't collide
	 * against non-solid sprites, or sprites marked as deleted
	 * 
	 * @param other The other sprite
	 */
	public double collidesWithPercent(Sprite other) {
		Area areaStart = new Area(this.getRect());
		Area areaA = new Area(this.getRect());
		areaA.intersect(new Area(other.getRect()));
		double sizestart = areaStart.getBounds2D().getWidth() * areaStart.getBounds2D().getHeight();
		double sizeA = areaA.getBounds2D().getWidth() * areaA.getBounds2D().getHeight();
		return sizeA / sizestart * 100.0;
	}

	/**
	 * Checks if this sprite collides with the point in coordinates x,y *
	 * 
	 * @param other The other sprite
	 */
	public boolean collidesWithPoint(int x, int y) {
		return this.getRect().contains(x, y);
	}

	/**
	 * Returns the first Sprite in the provided filed that collides with this Sprite
	 * 
	 * @param f A Pixel Field
	 * @return The first Sprite in the sprites list in the Pixel Field that
	 *         collides. <br>
	 *         The Pixel Field is ordered by insertion in the code <br>
	 *         Returns null if there is no collision with any Sprite
	 */
	public Sprite firstCollidesWithField(Field f) {
		return this.firstCollidesWithList(f.sprites);
	}

	/**
	 * Returns the all the Sprites in the provided filed that collide with this
	 * Sprite
	 * 
	 * @param f A Pixel Field
	 * @return A list with all the sprites in the sprites list in the Pixel Field
	 *         that collides. <br>
	 *         The Pixel Field is ordered by insertion in the code <br>
	 *         Returns an Empty list if there is no collision with any Sprite
	 */
	public ArrayList<Sprite> collidesWithField(Field f) {
		return this.collidesWithList(f.sprites);
	}

	/**
	 * Returns the all the PhysicBody Sprites in the provided filed that collide
	 * with this Sprite
	 * 
	 * @param f A Pixel Field
	 * @return A list with all the PhysicBodysprites in the sprites list in the
	 *         Pixel Field that collides. <br>
	 *         The Pixel Field is ordered by insertion in the code <br>
	 *         Returns an Empty list if there is no collision with any Sprite
	 */
	private ArrayList<Sprite> collidesWithPhysicBodyInField(Field f) {
		Sprite p = new Sprite("phantom",x1-1, y1-1, x2+1, y2+1, this.angle,"");
		ArrayList<Sprite> list = new ArrayList<>();
		for (int i = 0; i < f.sprites.size(); i++) {
			if (((f.sprites.get(i).physicBody && !f.sprites.get(i).trigger) || f.sprites.get(i).terrain)
					&& p.collidesWith(f.sprites.get(i)))
				list.add(f.sprites.get(i));
		}
		return list;
	}

	/**
	 * Returns the all the PhysicBody Sprites in the provided filed that collide
	 * with this Sprite
	 * 
	 * @param f A Pixel Field
	 * @return A list with all the PhysicBodysprites in the sprites list in the
	 *         Pixel Field that collides. <br>
	 *         The Pixel Field is ordered by insertion in the code <br>
	 *         Returns an Empty list if there is no collision with any Sprite
	 */
	private boolean isCollidingWithPhysicBodyInField(Field f) {
		ArrayList<Sprite> list = new ArrayList<>();
		for (int i = 0; i < f.sprites.size(); i++) {
			if (f.sprites.get(i).physicBody && this.collidesWith(f.sprites.get(i)))
				return true;
		}
		return false;
	}

	/**
	 * Returns the first Sprite in the provided list that collides with this Sprite
	 * 
	 * @param others A list of Sprites or classes that extends Sprite
	 * @return The first Sprite in the llist that collides <br>
	 *         Returns null if there is no collision with any Sprite
	 */
	public Sprite firstCollidesWithList(ArrayList<? extends Sprite> others) {
		for (Sprite s : others) {
			if (this.collidesWith(s))
				return s;
		}
		return null;

	}

	/**
	 * Returns collision type
	 * 
	 * @param other The second sprite
	 * @return A String depending on the collision type <br>
	 *         c: Contains. The other sprite is inside this <br>
	 *         i: Inside. This sprite is inside the other <br>
	 *         l: left. There is a collision between the left side of this sprite
	 *         and any part of the other sprite <br>
	 *         r: right. There is a collision between the right side of this sprite
	 *         and any part of the other sprite <br>
	 *         u: up. There is a collision between the upper side of this sprite and
	 *         any part of the other sprite <br>
	 *         d: down. There is a collision between the bottom side of this sprite
	 *         and any part of the other sprite <br>
	 *         o: other. There is another type of collision between the two sprites.
	 *         They are colliding, but in an unexpected way <br>
	 *         n: none. There is no collision between the two sprites, or the other
	 *         sprite is not solid. <br>
	 *         The string may contain several chars. for instance, "lu" would mean
	 *         there is both a left and an upper collision.
	 */
	public String getCollisionType(Sprite other) {
		if ((!this.getRect().intersects(other.getNonRotatingRect())) || !other.solid)
			return "n";
		else {
			String ret = "";
			if (this.getRect().contains(other.getNonRotatingRect()))
				ret += 'c';
			if (other.getRect().contains(this.getNonRotatingRect()))
				ret += 'i';
			if (this.getLeftRect().intersects(other.getNonRotatingRect()))
				ret += 'l';
			if (this.getRightRect().intersects(other.getNonRotatingRect()))
				ret += 'r';
			if (this.getTopRect().intersects(other.getNonRotatingRect()))
				ret += 'u';
			if (this.getBottomRect().intersects(other.getNonRotatingRect()))
				ret += 'd';
			if (ret.isEmpty())
				return "o";
			else
				return ret;
		}
	}

	/**
	 * Checks if this sprite has the other sprite just below
	 */
	public boolean stepsOn(Sprite other) {
		return (this.collidesWith(other) && this.getBottomRect().intersects(other.getTopRect())) ? true : false;
	}

	/**
	 * Checks if this sprite has the other sprite just above
	 */
	public boolean headOn(Sprite other) {
		return (this.collidesWith(other) && this.getTopRect().intersects(other.getBottomRect())) ? true : false;
	}

	/**
	 * Checks if this sprite has the other sprite just on its left
	 */
	public boolean leftOn(Sprite other) {
		return (this.collidesWith(other) && this.getLeftRect().intersects(other.getRightRect())) ? true : false;
	}

	/**
	 * Checks if this sprite has the other sprite just on its right
	 */
	public boolean rightOn(Sprite other) {
		return (this.collidesWith(other) && this.getRightRect().intersects(other.getLeftRect())) ? true : false;
	}

	/**
	 * Checks if this sprite is colliding with terrain below
	 */
	public boolean isGrounded(Field f) {
		Sprite s = new Sprite("phantom", this.x1, this.y1, this.x2, this.y2, this.angle, "");
		s.phantom = true;
		if (this.physicBody) {
			// this.delete=true;
			s.y1 += 2;
			s.y2 += 2;
		}
		for (int i = 0; i < f.sprites.size(); i++) {
			if (f.sprites.get(i) != null && f.sprites.get(i).terrain && s.stepsOn(f.sprites.get(i))) {
				// this.delete=false;
				return true;
			}
		}
		// this.delete=false;
		return false;
	}

	/**
	 * Checks if this sprite is colliding with terrain above
	 */
	public boolean isOnCeiling(Field f) {
		Sprite s = new Sprite("phantom", this.x1, this.y1, this.x2, this.y2, this.angle, "");
		s.phantom = true;
		if (this.physicBody) {
			s.y1 -= 3;
			s.y2 -= 3;
		}
		for (int i = 0; i < f.sprites.size(); i++) {
			if (f.sprites.get(i).terrain && s.headOn(f.sprites.get(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if this sprite is colliding with terrain on its sides
	 */
	public boolean isOnColumn(Field f) {
		Sprite s = new Sprite("phantom", this.x1, this.y1, this.x2, this.y2, this.angle, "");
		s.phantom = true;
		if (this.physicBody) {
			s.x1 -= 3;
			s.x2 += 3;
		}
		for (int i = 0; i < f.sprites.size(); i++) {
			if (f.sprites.get(i).terrain && s.leftOn(f.sprites.get(i))) {
				return true;
			}
			if (f.sprites.get(i).terrain && s.rightOn(f.sprites.get(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if this sprite is stuck on terrain
	 */
	public boolean isStuckOnTerrain(Field f) {
		return (isGrounded(f) || isOnCeiling(f) || isOnColumn(f));
	}

	/**
	 * Returns this sprite to ground level if it gets stuck into a terrain below it
	 * <br>
	 * Useful for controlling landings<br>
	 * 
	 * @return true if it had succesfully unstucked the character, false if it
	 *         wasn't stuck
	 */
	public boolean getGrounded(Field f) {
		boolean flag = false;
		for (int i = 0; i < f.sprites.size(); i++) {
			if (f.sprites.get(i).terrain && this.stepsOn(f.sprites.get(i))) {
				int dist = (y2 - f.sprites.get(i).y1) - 1;
				y2 -= dist;
				y1 -= dist;
				flag = true;
			}
		}
		return flag;

	}

	/**
	 * Returns this sprite to the appropiate position if it gets stuck into a
	 * terrain above it <br>
	 * Useful for controlling jumps<br>
	 * 
	 * @return true if it had succesfully unstucked the character, false if it
	 *         wasn't stuck
	 */
	public boolean getCeiling(Field f) {
		boolean flag = false;
		for (int i = 0; i < f.sprites.size(); i++) {
			if (f.sprites.get(i).terrain && this.headOn(f.sprites.get(i))) {
				int dist = (f.sprites.get(i).y2 - y1) + 1;
				y2 += dist;
				y1 += dist;
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * Returns this sprite to the appropiate position if it gets stuck into a
	 * terrain on its sides <br>
	 * Useful for controlling dashes<br>
	 * 
	 * @return true if it had succesfully unstucked the character, false if it
	 *         wasn't stuck
	 */
	public boolean getSided(Field f) {
		boolean flag = false;
		for (int i = 0; i < f.sprites.size(); i++) {
			if (f.sprites.get(i).terrain && this.rightOn(f.sprites.get(i))) {
				int dist = (x2 - f.sprites.get(i).x1) - 1;
				x2 -= dist;
				x1 -= dist;
				flag = true;
			} else if (f.sprites.get(i).terrain && this.leftOn(f.sprites.get(i))) {
				int dist = (f.sprites.get(i).x2 - x1) + 1;
				x2 += dist;
				x1 += dist;
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * Returns this sprite to the appropiate position if it gets stuck into a
	 * terrain <br>
	 * 
	 * @return true if it had succesfully unstucked the character, false if it
	 *         wasn't stuck
	 */
	public boolean deattach(Field f) {
		return (getGrounded(f) | getCeiling(f) | getSided(f));
	}

	/**
	 * marks this sprite to be deleted. Sprites marked for deletion won't collide or
	 * be drawn.
	 */
	public void delete() {
		delete = true;
	}

	public void applyPhysics(Field field) {
		// TODO Auto-generated method stub
		if (this.constantForce[0] < 0) {
			this.force[0] = this.force[0] > this.constantForce[0] ? this.force[0] += this.constantForce[0]
					: this.force[0];
			
		} else {
			this.force[0] = this.force[0] < this.constantForce[0] ? this.force[0] += this.constantForce[0]
					: this.force[0];
			
		}
		if (this.constantForce[1] < 0) {
			this.force[1] = this.force[1] > this.constantForce[1] ? this.force[1] += this.constantForce[1]
				: this.force[1];
		}else {
			this.force[1] = this.force[1] < this.constantForce[1] ? this.force[1] += this.constantForce[1]
				: this.force[1];
		}

		// System.out.println(this.force[1]);

		this.velocity[0] += this.force[0];
		this.velocity[1] += this.force[1];

		// System.out.println("vector vel "+this.velocity[0]+", "+this.velocity[1]);

		if (this.velocity[0] != 0 || this.velocity[1] != 0) {
			
			/*if(velocity[0]<(this.x2-this.x1) && velocity[1]<(this.y2-this.y1)) {
				Sprite s = new Sprite("phantom", this.x1, this.y1, this.x2, this.y2, this.angle, "");
				s.phantom = true;
				this.delete = true;
				s.x1 += (int)velocity[0];
				s.x2 += (int)velocity[0];
				s.y1 += (int)velocity[1];
				s.y2 += (int)velocity[1];
				//System.out.println("going a");
				if(!s.collidesWithPhysicBodyInField(field).isEmpty()) {
					//System.out.println("going b");
					this.delete=false;
					applyPhysicSteps(field);
				}else {
					this.delete=false;
					this.x1 += (int)velocity[0];
					this.x2 += (int)velocity[0];
					this.y1 += (int)velocity[1];
					this.y2 += (int)velocity[1];
				}
				
			}
			else */if (!this.trigger) {
				applyPhysicSteps(field);
			} else if (this.trigger) {
				this.x1 += (int)velocity[0];
				this.x2 += (int)velocity[0];
				this.y1 += (int)velocity[1];
				this.y2 += (int)velocity[1];
			}
			
			/*
			int w = this.y2-this.y1;
			System.out.println("going a"+(this.y2-this.y1));
			Sprite s = new Sprite("phantom", this.x1, this.y1, this.x2, this.y2, this.angle, "");
			s.phantom = true;
			this.delete = true;

			s.y2 += (int)velocity[1];
			s.y1 += (int)velocity[1];

			s.x1 += velocity[0];
			s.x2 += velocity[0];
			int w6 = s.y2-s.y1;
			if(w!=w6)System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
			//System.out.println("going a, length "+(this.y2-this.y1));
			if(!s.collidesWithPhysicBodyInField(field).isEmpty()) {
				System.out.println("going b"+(this.y2-this.y1));
				this.delete=false;
				applyPhysicSteps(field);
				int w3 = this.y2-this.y1;
				if(w!=w3)System.out.println("BBBBBBBBBBBBBBBBBBBBB");
			}else {
				//System.out.println("going c, length "+(this.y2-this.y1));
				
				System.out.println("going c"+(this.y2-this.y1));
				int w5 = this.y2-this.y1;
				if(w!=w5)System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
				
				this.x1 = s.x1;
				this.x2 = s.x2;
				this.y1 = s.y1;
				this.y2 = s.y2;
				this.delete=false;
				//System.out.println("going d, length "+(this.y2-this.y1));
				int w4 = this.y2-this.y1;
				if(w!=w4)System.out.println("CCCCCCCCCCCCCCCCCC");

			}
			int w2 = this.y2-this.y1;
			if(w!=w2)System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
*/
		}

	}

	private void applyPhysicSteps(Field field) {
		try {

			int[] physStep = gcdVector(this.velocity);

			// System.out.println(this);
			// System.out.println(this.name + " axxx " + physStep[0]+" "+physStep[1]+"
			// "+physStep[2]);

			for (int i = 0; i < physStep[2]; i++) {
				Sprite s = new Sprite("phantom", this.x1, this.y1, this.x2, this.y2, this.angle, "");
				s.phantom = true;
				this.delete = true;
				// System.out.println(physStep[0] + " " + physStep[1]);
				s.x1 += physStep[0];
				s.x2 += physStep[0];
				s.y1 += physStep[1];
				s.y2 += physStep[1];

				ArrayList<Sprite> coll = s.collidesWithPhysicBodyInField(field);
				if (!coll.isEmpty()) {
					// provo amb x primer
					int div = 0;
					do {
						div++;
						s = new Sprite("phantom", this.x1, this.y1, this.x2, this.y2, this.angle, "");
						s.phantom = true;
						s.x1 += physStep[0] / div;
						s.x2 += physStep[0] / div;
					} while (!s.collidesWithList(coll).isEmpty() && (physStep[0] / div) != 0);
					this.x1 += physStep[0] / div;
					this.x2 += physStep[0] / div;
					// si he xocat per x anulo la velocitat de x
					if (div != 1) {
						//faig un reajustament pixel a pixel  (haurien de ser pocs pixels, poc eficient, TODO)
						s = new Sprite("phantom", this.x1, this.y1, this.x2, this.y2, this.angle, "");
						int minStep;
						if(velocity[0]==0)minStep =0;else if(velocity[0]<0)minStep= -1; else minStep= 1;
						while(s.collidesWithList(coll).isEmpty() && minStep!=0) {
							s.x1+=minStep;
							s.x2+=minStep;						
						}
						this.x1=s.x1-minStep;
						this.x2=s.x2-minStep;
						this.velocity[0] = 0;
					}
					// provo amb y despres
					div = 0;
					do {
						div++;
						s = new Sprite("phantom", this.x1, this.y1, this.x2, this.y2, this.angle, "");
						s.phantom = true;
						s.y1 += physStep[1] / div;
						s.y2 += physStep[1] / div;
					} while (!s.collidesWithList(coll).isEmpty() && (physStep[1] / div) != 0);
					this.y1 += physStep[1] / div;
					this.y2 += physStep[1] / div;
					// si he xocat per y anulo la velocitat de y
					if (div != 1) {
						s = new Sprite("phantom", this.x1, this.y1, this.x2, this.y2, this.angle, "");
						int minStep;
						if(velocity[1]==0)minStep =0;else if(velocity[1]<0)minStep= -1; else minStep= 1;
						
						while(s.collidesWithList(coll).isEmpty() && minStep!=0) {
							s.y1+=minStep;
							s.y2+=minStep;
						}
						this.y1=s.y1-minStep;
						this.y2=s.y2-minStep;
						this.velocity[1] = 0;
					}
					break;

					/*
					 * 
					 * // intenta reajustar el terreny i mira si funciona. TODO poc eficient.
					 * boolean unstuck = false; //unstuck = this.getCeiling(field) ||
					 * this.getGrounded(field) || this.getSided(field); if (!unstuck) { // estic
					 * colisionant amb algo que no es un terreny clarament. this.x1 -= physStep[0];
					 * this.x2 -= physStep[0]; if (this.isCollidingWithPhysicBodyInField(field)) {
					 * // estava colisionant per la part de les y (i potser per la de les x) this.y1
					 * -= physStep[1]; this.y2 -= physStep[1]; this.velocity[1] = 0; //
					 * System.out.println(this.name + " a " + this.velocity[0]); // TODO mirar tambe
					 * x? this.x1 += physStep[0]; this.x2 += physStep[0]; if
					 * (this.isCollidingWithPhysicBodyInField(field)) { // colisionava per les dues
					 * parts this.x1 -= physStep[0]; this.x2 -= physStep[0]; this.velocity[0] = 0; }
					 * else { // nomes colisionava per y } } else { // estava colisionant nomes per
					 * la part de les x
					 * 
					 * this.velocity[0] = 0; // System.out.println("b"); }
					 * 
					 * } else { // System.out.println("getgrr"); } break;
					 * 
					 */
				} else {
					// tot ok
					this.x1 += physStep[0];
					this.x2 += physStep[0];
					this.y1 += physStep[1];
					this.y2 += physStep[1];
				}

			}
			this.delete = false;
		} catch (Exception e) {
			this.delete=false;
			System.out.println("Something happened while applying physic steps. Consider reducing the ammount of rigidbodies, or decreasing the framerate");
		}
	}

	private int[] gcdVector(double[] velocity2) {
		if(velocity[0]<(this.x2-this.x1) && velocity[1]<(this.y2-this.y1)) {
			int num1 = (int) velocity2[0];
			int num2 = (int) velocity2[1];
			int gcd = 1;
			int[] a = { num1 / gcd, num2 / gcd, gcd };
			// System.out.println(a[0] + " " + a[1] + " " + a[2]);
			return a;
		}else {
			int num1 = (int) velocity2[0];
			int num2 = (int) velocity2[1];
			int gcd = 1;
			if (num1 == 0 && num2 != 0) {
				gcd = Math.abs(num2);
			} else if (num2 == 0 && num1 != 0) {
				gcd = Math.abs(num1);
			} else {
				for (int i = 1; i <= num1 && i <= num2; i++) {
					if (num1 % i == 0 && num2 % i == 0)
						gcd = i;
				}
			}
	
			int[] a = { num1 / gcd, num2 / gcd, gcd };
			// System.out.println(a[0] + " " + a[1] + " " + a[2]);
			return a;
		}
	}

	public void setConstantForce(double x, double y) {
		this.constantForce[0] = x;
		this.constantForce[1] = y;
	}

	public void setForce(double x, double y) {
		this.force[0] = x;
		this.force[1] = y;
	}

	public void setVelocity(double x, double y) {
		this.velocity[0] = x;
		this.velocity[1] = y;
	}

	public void addConstantForce(double x, double y) {
		this.constantForce[0] += x;
		this.constantForce[1] += y;
	}

	public void addForce(double x, double y) {
		this.force[0] += x;
		this.force[1] += y;
	}

	public void addVelocity(double x, double y) {
		this.velocity[0] += x;
		this.velocity[1] += y;
	}

}
