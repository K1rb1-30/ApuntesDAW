package Core;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.MouseWheelListener;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Graphical User Interface that converts the provided Sprites to a graphical
 * representation as a Pixel Field. This class also provides methods to
 * manipulate that board and set how the graphics are displayed.
 * 
 * @author Marc Albareda
 * @version 0.3
 *
 */
public class Field extends JPanel {

	/**
	 * List of Sprites.
	 */
	ArrayList<Sprite> sprites = new ArrayList<>();
	/**
	 * flag set on a draw.
	 */
	private boolean recentDraw = false;
	/**
	 * Path to Background. Null for no background.
	 */
	public String background = null;
	
	/**
	 *  Checks whether the objects out of scrolls should continue moving
	 *  Caution: enabling this will destroy the performance
	 */
	public boolean moveOutOfScroll = false;

	/**
	 * Horizontal scroll applied
	 */
	private int scrollx = 0;
	/**
	 * Vertical scroll applied
	 */
	private int scrolly = 0;
	/**
	 * Checks whether the scroll is locked to an object
	 */
	public boolean lockScroll = false;
	/**
	 * Checks whether the scroll is locked to an object on the Y axis
	 */
	public boolean lockScrollY = false;
	/**
	 * Checks whether the scroll is locked to an object on the X axis
	 */
	public boolean lockScrollX = false;
	/**
	 * Object to which the scroll is locked
	 */
	private Sprite scrollSprite;
	/**
	 * X of last mouse click
	 */
	private int mouseX = -1;
	/**
	 * y of last mouse click
	 */
	private int mouseY = -1;
	/**
	 * X of last mouse click. Will reset after each check.
	 */
	private int currentMouseX = -1;
	/**
	 * Y of last mouse click. Will reset after each check.
	 */
	private int currentMouseY = -1;
	/**
	 * X of last mouse click
	 */
	private int rmouseX = -1;
	/**
	 * Y of last mouse click
	 */
	private int rmouseY = -1;
	/**
	 * X of last mouse click. Will reset after each check.
	 */
	private int rcurrentMouseX = -1;
	/**
	 * Y of last mouse click. Will reset after each check.
	 */
	private int rcurrentMouseY = -1;
	/**
	 * Rotation of the mouseWheel Up is -1 and Down is 1
	 */
	private int mouseWheelRotation = 0;
	/**
	 * Amount scrolled with the mouseWheel
	 */
	private int mouseWheelScroll = 0;
	/**
	 * Width of the field
	 */
	private int fieldWidth = 700;
	/**
	 * Height of the field
	 */
	private int fieldHeight = 400;
	/**
	 * determines whether the field should be autoresized when the window size is
	 * changed
	 */
	private boolean autoresize = false;

	private Window w = null;

	/**
	 * Event handler every time mouse is clicked.
	 */
	private MouseListener ml = new MouseAdapter() {

		public void mousePressed(MouseEvent e) {
			int button = e.getButton();
			Point p = e.getPoint();
			if (button == 1) {
				mouseX = p.x;
				mouseY = p.y;
				currentMouseX = p.x;
				currentMouseY = p.y;
			} else if (button == 3) {
				rmouseX = p.x;
				rmouseY = p.y;
				rcurrentMouseX = p.x;
				rcurrentMouseY = p.y;
			}

		}

	};

	private MouseWheelListener mwl = new MouseWheelListener() {
		public void mouseWheelMoved(MouseWheelEvent e) {

			mouseWheelRotation = e.getWheelRotation();
			mouseWheelScroll = e.getScrollAmount();

			if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
				// System.out.println("MouseWheelEvent.WHEEL_UNIT_SCROLL");
			}

			if (e.getScrollType() == MouseWheelEvent.WHEEL_BLOCK_SCROLL) {
				// System.out.println("MouseWheelEvent.WHEEL_BLOCK_SCROLL");
			}
		}
	};
	/**
	 * Redraws field if window size is changed.
	 */
	public ComponentListener cl = new ComponentAdapter() {
		public void componentResized(ComponentEvent e) {
			if (autoresize) {
				resize();
				repaint();
			}

		}

	};

	/**
	 * sets a Window to this field. It is supposed to be the window that contains
	 * this field
	 * 
	 * @param w
	 */
	public void setWindow(Window w) {
		this.w = w;
	}

	public void resize() {
		double widthQ = (double) this.getWidth() / (double) this.fieldWidth;
		double heightQ = (double) this.getHeight() / (double) this.fieldHeight;
		System.out.println(this.getWidth() + " " + this.fieldWidth);
		System.out.println(widthQ + " " + heightQ);
		for (Sprite s : sprites) {
			s.x1 *= widthQ;
			s.y1 *= heightQ;
			s.x2 *= widthQ;
			s.y2 *= heightQ;
		}

		this.fieldWidth = this.getWidth();
		this.fieldHeight = this.getHeight();
	}

	public Field() {
		// setFocusable(true);
		addMouseListener(ml);
		addMouseWheelListener(mwl);

	}

	/**
	 * Adds an ArrayList to the sprite list to be drawn
	 */
	public void add(ArrayList<? extends Sprite> newSprites) {
		if (recentDraw) {
			clear();
			recentDraw = false;
		}
		sprites.addAll(newSprites);
	}

	/**
	 * Adds a Sprite to the sprite list to be drawn
	 */
	public void add(Sprite newSprites) {
		if (recentDraw) {
			clear();
			recentDraw = false;
		}
		sprites.add(newSprites);
	}

	/**
	 * Clears the sprite list
	 */
	public void clear() {
		sprites.clear();
	}

	/**
	 * Draws the current sprite list, if "add" methods have been used before.
	 */
	public void draw() {
		// TODO
		recentDraw = true;
		repaint();
		for (Sprite sprite : sprites) {
			if(sprite.physicBody) sprite.applyPhysics(this);
		}
	}

	/**
	 * Draws the provided sprite list, and nothing else
	 */
	public void draw(ArrayList<? extends Sprite> sprites2) {
		clear();
		sprites.addAll(sprites2);
		repaint();
		for (Sprite sprite : sprites2) {
			if(sprite.physicBody) sprite.applyPhysics(this);
		}
		
	}

	/**
	 * Draws the provided Sprite, and nothing else
	 */
	public void draw(Sprite s2) {
		sprites.clear();
		sprites.add(s2);
		repaint();
			if(s2.physicBody) s2.applyPhysics(this);


	}

	/**
	 * Scrolls the whole field by the specified ammount
	 * 
	 * @param x
	 *            The ammount of pixels it should be horizontally scrolled (negative
	 *            left, positive right)
	 * @param y
	 *            The ammount of pixels it should be vertically scrolled (negative
	 *            up, positive down)
	 */
	public void scroll(int x, int y) {
		scrollx += x;
		scrolly += y;
	}

	/**
	 * Resets the scroll, being returned at 0,0
	 */
	public void resetScroll() {
		scrollx = 0;
		scrolly = 0;
	}

	/**
	 * locks the scroll to a sprite
	 * 
	 * @param s
	 */
	public void lockScroll(Sprite s, Window w) {
		this.scrollSprite = s;
		this.lockScroll = true;
	}
	
	/**
	 * locks the scroll to a sprite on the selected axis (X or Y)
	 * 
	 * @param s Sprite on which the scroll will be locked
	 * @param w Window that will be locked
	 * @param x whether the X axis will be locked or not
	 * @param y whether the Y axis will be locked or not
	 */
	public void lockScroll(Sprite s, Window w, boolean x, boolean y) {
		this.scrollSprite = s;
		this.lockScroll=false;
		if(x)this.lockScrollX=true;
		if(y)this.lockScrollY=true;
	}

	/**
	 * swaps colors
	 * 
	 * @param img
	 * @param an
	 *            array of colors. Even numbers would be the ones being replaced by
	 *            the inmediately successive numbers
	 * @return
	 */
	public BufferedImage swapColors(BufferedImage img, Color... mapping) {
		int[] pixels = img.getRGB(0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < mapping.length / 2; i++) {
			map.put(mapping[2 * i].getRGB(), mapping[2 * i + 1].getRGB());
		}

		for (int i = 0; i < pixels.length; i++) {
			if (map.containsKey(pixels[i]))
				pixels[i] = map.get(pixels[i]);
		}

		img.setRGB(0, 0, img.getWidth(), img.getHeight(), pixels, 0, img.getWidth());
		return img;
	}

	public BufferedImage toBufferedImage(Image img) {
		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}

		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();

		// Return the buffered image
		return bimage;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		if (background != null) {
			Image img = null;
			try {
				img = new ImageIcon(background).getImage();
			} catch (Exception e) {
				System.out.println("Error on background img");
			}
			g2d.drawImage(img, (int) 0, (int) 0, (int) (getWidth()), (int) (getHeight()), 0, 0, img.getWidth(this),
					img.getHeight(this), this);

		}
		// System.out.println("painting "+sprites);
		for (int i = 0; i < sprites.size(); i++) {
			try {
				if (!sprites.get(i).delete) {
					if (w == null || sprites.get(i).unscrollable || (sprites.get(i).x1 < -this.scrollx + w.getWidth()
							&& sprites.get(i).x2 > -this.scrollx) || moveOutOfScroll) {
						drawSprite(sprites.get(i), g2d);
					}
				}

			} catch (IndexOutOfBoundsException e) {
				//e.printStackTrace();
				System.out.println("CONCURRENCY ERROR. DID YOU FORGET TO USE A TIMER OR A THREAD.SLEEP?");
			} catch (NullPointerException e) {
				//e.printStackTrace();
				System.out.println("CONCURRENCY ERROR. DID YOU FORGET TO USE A TIMER OR A THREAD.SLEEP?");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Excepcio no controlada en Field. Avisa al Marc pls.");
			}
		}
		Toolkit.getDefaultToolkit().sync();
	}

	private void drawSprite(Sprite sprite, Graphics2D g2d) {

		int x, y, width, height;


		if (!sprite.collisionBox) {
			x = sprite.x1;
			y = sprite.y1;
			width = sprite.x2 - sprite.x1;
			height = sprite.y2 - sprite.y1;
		} else {
			x = sprite.x1 - sprite.drawingBoxExtraLeft;
			y = sprite.y1 - sprite.drawingBoxExtraUp;
			width = sprite.x2 + sprite.drawingBoxExtraRight - x;
			height = sprite.y2 + sprite.drawingBoxExtraDown - y;
		}

		try {
			if (sprite.text) {
				// Color inside = new Color(colorlletres[value]);
				// g2d.setPaint(inside);
				// int padding = 5;
				Color inside = new Color(sprite.textColor);
				g2d.setPaint(inside);
				g2d.setFont(sprite.font);
				AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(sprite.angle), x + width / 2,
						y + height / 2);
				g2d.setTransform(a);
				g2d.drawString(sprite.path, sprite.x1, sprite.y2);
				// On drawString the starting point is not the upper left, but the bottom left
			} else {

				Image img;
				if (sprite.useImgArray) {
					img = new ImageIcon((sprite.imgArray[sprite.currentImg])).getImage();
				} else {
					img = new ImageIcon((sprite.path)).getImage();
				}
				if (this.lockScroll) {
					scrollx = -this.scrollSprite.x1+w.getX()/2;
					scrolly = -this.scrollSprite.y1+w.getY()/2;
				}else {
					if(this.lockScrollX) {
						scrollx = -this.scrollSprite.x1+w.getX()/2;
					}if(this.lockScrollY) {
						scrolly = -this.scrollSprite.y1+w.getY()/2;
					}
				}
				if (!sprite.unscrollable) {
					x += scrollx;
					y += scrolly;
				}
				AffineTransform a = AffineTransform.getRotateInstance(Math.toRadians(sprite.angle), x + width / 2,
						y + height / 2);
				g2d.setTransform(a);

				if (sprite.colorSprite) {
					g2d.setColor(sprite.color);
					g2d.drawRect(x, y, width, height);
					g2d.setColor(sprite.color);
					g2d.fillRect(x, y, width, height);
				} else {
					if (sprite.palleteSwap) {
						BufferedImage bimg = this.toBufferedImage(img);
						bimg = swapColors(bimg, sprite.swapList.toArray(new Color[sprite.swapList.size()]));
						img = bimg;
					}

					g2d.drawImage(img, x, y, width, height, this);
				}

			}
		} catch (Exception e) {
			System.out.println("Error on image " + sprite.path + " object: " + sprite.name);
			e.printStackTrace();
		}
	}

	/**
	 * get the X of the pixel last clicked.
	 */
	public int getMouseX() {
		return mouseX;
	}

	/**
	 * get the Y of the pixel last clicked.
	 */
	public int getMouseY() {
		return mouseY;
	}

	/**
	 * get the X of the pixel last clicked. Returns -1 if no pixel was clicked since
	 * last check.
	 */
	public int getCurrentMouseX() {
		int tmp = currentMouseX;
		currentMouseX = -1;
		return tmp;
	}

	/**
	 * get the Y of the pixel last clicked. Returns -1 if no pixel was clicked since
	 * last check.
	 */
	public int getCurrentMouseY() {
		int tmp = currentMouseY;
		currentMouseY = -1;
		return tmp;
	}

	/**
	 * get the X of the pixel last clicked.
	 */
	public int getRightMouseX() {
		return rmouseX;
	}

	/**
	 * get the Y of the pixel last clicked.
	 */
	public int getRightMouseY() {
		return rmouseY;
	}

	/**
	 * get the X of the pixel last clicked. Returns -1 if no pixel was clicked since
	 * last check.
	 */
	public int getCurrentRightMouseX() {
		int tmp = rcurrentMouseX;
		rcurrentMouseX = -1;
		return tmp;
	}

	/**
	 * get the Y of the pixel last clicked. Returns -1 if no pixel was clicked since
	 * last check.
	 */
	public int getCurrentRightMouseY() {
		int tmp = rcurrentMouseY;
		rcurrentMouseY = -1;
		return tmp;
	}

	/**
	 * get the X of the pixel which the mouse is currently hovering.
	 */
	public int getMouseOverX() {
		if (this.getMousePosition() != null)
			return this.getMousePosition().x;
		else
			return -1;
	}

	/**
	 * get the Y of the pixel which the mouse is currently hovering.
	 */
	public int getMouseOverY() {
		if (this.getMousePosition() != null)
			return this.getMousePosition().y;
		else
			return -1;
	}

	public int getScrollx() {
		return scrollx;
	}

	public void setScrollx(int scrollx) {
		this.scrollx = scrollx;
	}

	public int getScrolly() {
		return scrolly;
	}

	public void setScrolly(int scrolly) {
		this.scrolly = scrolly;
	}

}
