package Core;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Graphical User Interface that converts a given matrix into a graphical board.
 * This class also provides methods to manipulate that board and set how the
 * graphics are displayed. This interface can work with either colors, text, or
 * defined image sprites. Other options as displaying backgrounds, overdraws, or
 * changing the size of individual cells are provided.
 * 
 * @author Marc Albareda
 * @version 2.15
 *
 */
public class Board extends JPanel {

	/**
	 * internal representation of the matrix
	 */
	private Square[][] squares;
	/**
	 * margin that the board will have relative to the window
	 */
	private int PADDING = 20;
	/**
	 * how many rows the matrix has
	 */
	private int rows = -1;
	/**
	 * how many colums the matrix has
	 */
	private int cols = -1;
	/**
	 * layered matrix sent by user
	 */
	private int[][][] matrix3d;
	/**
	 * type of draw requested by user, by layer
	 */
	private char[] type3d;
	/**
	 * checks whether the matrix needs initialization. Not used currently.
	 */
	private boolean init = false;
	/**
	 * activates drawing border lines between every cell
	 */
	private boolean actborder = false;
	/**
	 * color of the border lines between every cell
	 */
	private int borderColor = 0x8cc8a0;
	/**
	 * activates freedraw, assigning a weight multiplier to every sprite
	 */
	private boolean actfreedraw = false;
	/**
	 * Horizontal weight. Sets weight for every image. 1 is the normal size. 2 twice
	 * the size, 0.5 half the size
	 */
	private double[] freedrawx;
	/**
	 * Vertical weight. Sets weight for every image. 1 is the normal size. 2 twice
	 * the size, 0.5 half the size
	 */
	private double[] freedrawy;
	/**
	 * activates using an image as background
	 */
	private boolean actimgbackground = false;
	/**
	 * path to the image in the background
	 */
	private String imgbackground;
	/**
	 * color of the background if there is no image as background
	 */
	private int backgroundColor = 0x0000ff;
	/**
	 * RGB color pallete for each integer. In the array each position relates to a
	 * number in the matrix <br>
	 * (first position will be the color of number 0 in the matrix, etc.)
	 */
	private int[] colors;
	/**
	 * text written in each position relative to the number in the matrix
	 */
	private String[] text;
	/**
	 * RBG color pallete for the color of the text. Only if text is enabled.
	 */
	private int[] colortext;
	/**
	 * font used in the text
	 */
	private Font font = new Font("SansSerif", Font.PLAIN, 22);
	/**
	 * path of the image displayed in each cell relative to the number in the matrix
	 */
	private String[] sprites;

	/**
	 * row of last mouse click
	 */
	private int mouseRow = -1;
	/**
	 * col of last mouse click
	 */
	private int mouseCol = -1;
	/**
	 * row of last mouse click. Will reset after each check.
	 */
	private int currentMouseRow = -1;
	/**
	 * col of last mouse click. Will reset after each check.
	 */
	private int currentMouseCol = -1;
	/**
	 * row of last mouse click
	 */
	private int rmouseRow = -1;
	/**
	 * col of last mouse click
	 */
	private int rmouseCol = -1;
	/**
	 * row of last mouse click. Will reset after each check.
	 */
	private int rcurrentMouseRow = -1;
	/**
	 * col of last mouse click. Will reset after each check.
	 */
	private int rcurrentMouseCol = -1;
	/**
	 * the layer that mouse clicks should reference in a layered matrix
	 */
	private int mouseLayer = 0;
	/**
	 * the list of pixelSprites that will be drawn over the matrixes.
	 */
	private ArrayList<BoardSprite> boardSprites = new ArrayList<>();
	private boolean useboardSprites = false;

	public Board() {
		addMouseListener(ml);

	}

	// Drawing methods.

	/**
	 * Inherited method from AWT, paints the matrix on the board.
	 */
	protected void paintComponent(Graphics g) {

		if (init) { // nothing will be shown until the first draw call

			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			if (actimgbackground) {
				Image img = null;
				try {
					img = new ImageIcon(imgbackground).getImage();
				} catch (Exception e) {
					System.out.println("Error on background img");
				}
				g2.drawImage(img, (int) 0, (int) 0, (int) (getWidth()), (int) (getHeight()), 0, 0, img.getWidth(this),
						img.getHeight(this), this);
				// g2.drawImage(img, (int) PADDING, (int) PADDING, (int) (getWidth()-PADDING*2),
				// (int) (getHeight()-PADDING*2), PADDING, PADDING,
				// img.getWidth(this)-PADDING*2,
				// img.getHeight(this)-PADDING*2, this);
				// TODO PER QUE FUNCIONA MALAMENT AMB EL PADDING
			} else {
				g2.setPaint(new Color(backgroundColor));
				g2.fill(new Rectangle((int) PADDING, (int) PADDING, (int) (getWidth() - PADDING * 2),
						(int) (getHeight() - PADDING * 2)));
			}
			g2.setPaint(Color.blue); // default is blue
			for (int k = 0; k < matrix3d.length; k++) {
				rows = matrix3d[k].length;
				cols = matrix3d[k][0].length;
				initSquares(rows, cols);
				for (int i = 0; i < matrix3d[k].length; i++) {
					for (int j = 0; j < matrix3d[k][0].length; j++) {
						squares[i][j].draw(g2, matrix3d[k][i][j], type3d[k], colors, actborder, borderColor,
								backgroundColor, text, colortext, sprites, actimgbackground, actfreedraw, freedrawx,
								freedrawy, font);
					}
				}

			}
			
			if(useboardSprites) {
				for(int value = 0; value<boardSprites.size();value++) {
					BoardSprite sprite = boardSprites.get(value);
					int w = getWidth();
					int h = getHeight();
					double xInc = (double) (w - 2 * PADDING) / cols; // Each cell will have the same size. Total width/number of
																	// squares
					double yInc = (double) (h - 2 * PADDING) / rows;
					int x = PADDING+(int) (sprite.col1*xInc);
					int y = PADDING+(int) (sprite.row1*yInc);
					if (sprite.text) {
						Color inside = new Color(sprite.textColor);
						g2.setPaint(inside);
						g2.setFont(sprite.font);
						g2.drawString(sprite.path, x, (int) ((sprite.row1+1)*yInc));
						// On drawString the starting point is not the upper left, but the bottom left
					}else {
						Image img;
						img = sprite.img;
						g2.drawImage(img, x, y, (int) ((sprite.col2-sprite.col1+1)*xInc), (int) ((sprite.row2-sprite.row1+1)*yInc), this);

					}
				}
			}

		}

	}

	/**
	 * Initializes the board the first time used
	 * 
	 * @param fil number of rows
	 * @param col number of cols
	 */
	private void initSquares(int row, int col) {

		squares = new Square[row][col];
		int w = getWidth();
		int h = getHeight();
		double xInc = (double) (w - 2 * PADDING) / col; // Each cell will have the same size. Total width/number of
														// squares
		double yInc = (double) (h - 2 * PADDING) / row;
		for (int i = 0; i < row; i++) {
			double y = PADDING + i * yInc;
			for (int j = 0; j < col; j++) {
				double x = PADDING + j * xInc;
				Rectangle2D.Double r = new Rectangle2D.Double(x, y, xInc, yInc);
				squares[i][j] = new Square(i, j, r, x, y, xInc, yInc, this);
			}
		}
	}

	/**
	 * Redraws board if window size is changed.
	 */
	ComponentListener cl = new ComponentAdapter() {
		public void componentResized(ComponentEvent e) {
			squares = null;
			repaint();
		}
	};

	/**
	 * Public draw method. This is the method called by the user and draws the
	 * matrix received
	 * 
	 * @param a int matrix to be drawn. It will draw as a board using the options
	 *          received
	 * @param c type of the matrix to be drawn. 'c' will mean color, 't' text and
	 *          's' sprite
	 */
	public void draw(int[][] a, char c) {
		int[][][] b = { a };
		mouseLayer = 0;
		char[] d = { c };
		draw(b, d);
	};

	/**
	 * Public draw method. This is the method called by the user and draws the
	 * matrix received
	 * 
	 * @param a  int matrix to be drawn. It will draw as a board using the options
	 *           received
	 * @param c  type of the matrix to be drawn. 'c' will mean color, 't' text and
	 *           's' sprite
	 * @param x1 y1 x2 y2 the four corners of the submatrix to be actually drawn
	 */
	public void draw(int[][] a, char c, int x1, int y1, int x2, int y2) {
		int[][] a2 = new int[x2 - x1][y2 - y1];
		for (int i = 0; i < a2.length; i++) {
			for (int j = 0; j < a2[0].length; j++) {
				a2[i][j] = a[x1 + i][y1 + j];
			}
		}

		int[][][] b = { a2 };
		mouseLayer = 0;
		char[] d = { c };
		draw(b, d);
	}

	/**
	 * Public draw method. This is the method called by the user and draws the
	 * matrix received
	 * 
	 * @param a  int matrix to be drawn. It will draw as a board using the options
	 *           received. It will be assumed as a sprite matrix
	 * @param x1 y1 x2 y2 the four corners of the submatrix to be actually drawn
	 */
	public void draw(int[][] a, int x1, int y1, int x2, int y2) {
		draw(a, 's', x1, y1, x2, y2);
	};

	/**
	 * Public draw method. This is the method called by the user and draws the
	 * matrix received
	 * 
	 * @param a int matrix to be drawn. It will draw as a board using the options
	 *          received. It will be assumed as a sprite matrix
	 */
	public void draw(int[][] a) {
		draw(a, 's');
	};

	/**
	 * Public draw method. This is the method called by the user and draws the
	 * matrixes received in a layered way, with the first being the bottom one and
	 * the last being the top one
	 * 
	 * @param a array of int matrixes to be drawn. It will draw as a board using the
	 *          options received.
	 * @param b array of chars, one for each layer, showing the type of the matrix
	 *          to be drawn. 'c' will mean color, 't' text and 's' sprite
	 */
	public void draw(int[][][] a, char[] b) {
		this.matrix3d = a;
		type3d = b;
		init = true;
		rows = a[mouseLayer].length;
		cols = a[mouseLayer][0].length;

		repaint();
	};

	/**
	 * Public draw method. This is the method called by the user and draws the
	 * matrixes received in a layered way, with the first being the bottom one and
	 * the last being the top one
	 * 
	 * @param a array of int matrixes to be drawn. It will draw as a board using the
	 *          options received. It will be assumed as every matrix to be made of
	 *          sprites
	 * @param b array of chars, one for each layer, showing the type of the matrix
	 *          to be drawn. 'c' will mean color, 't' text and 's' sprite
	 * 
	 */
	public void draw(int[][][] a) {
		char[] b = new char[a.length];
		for (int i = 0; i < b.length; i++)
			b[i] = 's';
		draw(a, b);
	};

	/**
	 * Public draw method. This is the method called by the user and draws the
	 * matrixes received in a layered way, with the first being the bottom one and
	 * the last being the top one. Assumes every layer is of the same size
	 * (otherwise zoom would make no sense)
	 * 
	 * @param a  array of int matrixes to be drawn. It will draw as a board using
	 *           the options received. It will be assumed as every matrix to be made
	 *           of sprites
	 * @param b  array of chars, one for each layer, showing the type of the matrix
	 *           to be drawn. 'c' will mean color, 't' text and 's' sprite
	 * @param x1 y1 x2 y2 the four corners of the submatrix to be actually drawn
	 */

	public void draw(int[][][] a, char[] b, int x1, int y1, int x2, int y2) {
		for (int k = 0; k < a.length; k++) {
			int[][] a2 = new int[x2 - x1][y2 - y1];
			for (int i = 0; i < a2.length; i++) {
				for (int j = 0; j < a2[0].length; j++) {
					a2[i][j] = a[k][x1 + i][y1 + j];
				}
			}
			a[k] = a2;
		}
		draw(a, b);
	};

	/**
	 * Public draw method. This is the method called by the user and draws the
	 * matrixes received in a layered way, with the first being the bottom one and
	 * the last being the top one
	 * 
	 * @param a  array of int matrixes to be drawn. It will draw as a board using
	 *           the options received. It will be assumed as every matrix to be made
	 *           of sprites
	 * @param x1 y1 x2 y2 the four corners of the submatrix to be actually drawn
	 */
	public void draw(int[][][] a, int x1, int y1, int x2, int y2) {
		char[] b = new char[a.length];
		for (int i = 0; i < b.length; i++)
			b[i] = 's';
		draw(a, b, x1, y1, x2, y2);
	};

	/**
	 * converts an Integer matrix into an int matrix and draws it.
	 */
	public void draw(Integer[][] a, char c) {
		int[][] b = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				b[i][j] = a[i][j];
			}
		}

		draw(b, c);
	};

	/**
	 * Event handler every time mouse is clicked.
	 */
	private MouseListener ml = new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
			int button = e.getButton();
			Point p = e.getPoint();
			if (!isInGrid(p))
				return;
			double xInc = (double) (getWidth() - 2 * PADDING) / cols;
			double yInc = (double) (getHeight() - 2 * PADDING) / rows;
			int f = (int) ((p.y - PADDING) / yInc);
			int c = (int) ((p.x - PADDING) / xInc);
			if (button == 1) {
				mouseRow = f;
				mouseCol = c;
				currentMouseRow = f;
				currentMouseCol = c;
			} else if (button == 3) {
				rmouseRow = f;
				rmouseCol = c;
				rcurrentMouseRow = f;
				rcurrentMouseCol = c;
			}

			/*
			 * Old method. squares[f][c].mouseClick(); boolean isSelected =
			 * squares[f][c].isSelected(); squares[f][c].setSelected(!isSelected);
			 * repaint();
			 */
		}

	};

	/**
	 * Check whether the clicked point is in the matrix grid.
	 */
	private boolean isInGrid(Point p) {
		Rectangle r = new Rectangle(getWidth(), getHeight());
		r.grow(-PADDING, -PADDING);
		return r.contains(p);
	}

	/*
	 * Getters & Setters. AutoGenerated
	 */

	public int getPadding() {
		return PADDING;
	}

	public void setPadding(int padding) {
		this.PADDING = padding;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public boolean isInit() {
		return init;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

	public boolean isActborder() {
		return actborder;
	}

	public void setActborder(boolean actborder) {
		this.actborder = actborder;
	}

	public int getBorderColor() {
		return borderColor;
	}

	public void setBorder(int border) {
		this.borderColor = border;
	}

	public int getColorbackground() {
		return backgroundColor;
	}

	public void setColorbackground(int colorbackground) {
		this.backgroundColor = colorbackground;
	}

	public boolean isActfreedraw() {
		return actfreedraw;
	}

	public void setActfreedraw(boolean actfreedraw) {
		this.actfreedraw = actfreedraw;
	}

	public double[] getFreedrawx() {
		return freedrawx;
	}

	public void setFreedrawx(double[] freedrawx) {
		this.freedrawx = freedrawx;
		actfreedraw = true;
	}

	public double[] getFreedrawy() {
		return freedrawy;
	}

	public void setFreedrawy(double[] freedrawy) {
		this.freedrawy = freedrawy;
		actfreedraw = true;
	}

	public boolean isActimgbackground() {
		return actimgbackground;
	}

	public void setActimgbackground(boolean actimgbackground) {
		this.actimgbackground = actimgbackground;
	}

	public String getImgbackground() {
		return imgbackground;
	}

	public void setImgbackground(String imgbackground) {
		this.imgbackground = imgbackground;
	}

	public int[] getColors() {
		return colors;
	}

	public void setColors(int[] colors) {
		this.colors = colors;
	}

	public String[] getText() {
		return text;
	}

	public void setText(String[] text) {
		this.text = text;
	}

	public int[] getColortext() {
		return colortext;
	}

	public void setColortext(int[] colortext) {
		this.colortext = colortext;
	}

	public String[] getSprites() {
		return sprites;
	}

	public void setSprites(String[] sprites) {
		this.sprites = sprites;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	/**
	 * get the row of the cell last clicked.
	 */
	public int getMouseRow() {
		return mouseRow;
	}

	/**
	 * get the column of the cell last clicked.
	 */
	public int getMouseCol() {
		return mouseCol;
	}

	/**
	 * get the row of the cell last clicked. Returns -1 if no cell was clicked since
	 * last check.
	 */
	public int getCurrentMouseRow() {
		int tmp = currentMouseRow;
		currentMouseRow = -1;
		return tmp;
	}

	/**
	 * get the column of the cell last clicked. Returns -1 if no cell was clicked
	 * since last check.
	 */
	public int getCurrentMouseCol() {
		int tmp = currentMouseCol;
		currentMouseCol = -1;
		return tmp;
	}

	/**
	 * get the row of the cell last clicked.
	 */
	public int getRightMouseRow() {
		return rmouseRow;
	}

	/**
	 * get the column of the cell last clicked.
	 */
	public int getRightMouseCol() {
		return rmouseCol;
	}

	/**
	 * get the row of the cell last clicked. Returns -1 if no cell was clicked since
	 * last check.
	 */
	public int getCurrentRightMouseRow() {
		int tmp = rcurrentMouseRow;
		rcurrentMouseRow = -1;
		return tmp;
	}

	/**
	 * get the column of the cell last clicked. Returns -1 if no cell was clicked
	 * since last check.
	 */
	public int getCurrentRightMouseCol() {
		int tmp = rcurrentMouseCol;
		rcurrentMouseCol = -1;
		return tmp;
	}

	public ArrayList<BoardSprite> getBoardSprites() {
		return boardSprites;
	}

	public void setBoardSprites(ArrayList<BoardSprite> pixelSprites) {
		this.boardSprites = pixelSprites;
		useboardSprites=true;
	}
	
	public void clearBoardSprites() {
		this.boardSprites = new ArrayList<BoardSprite>();
		useboardSprites=false;
	}
	

	

}

/**
 * Class representing every cell on the Board. Not meant to be directly
 * interacted by the user.
 * 
 * @author Marc Albareda
 */
class Square {
	private final int row;
	private final int col;
	private int value;
	private final double x;
	private final double y;
	private final double xInc;
	private final double yInc;
	private Color border;
	private Board board;

	Rectangle2D.Double rect;

	public Square(int f, int c, Rectangle2D.Double rect, double e, double d, double a, double b, Board board) {
		row = f;
		col = c;
		x = e;
		y = d;
		xInc = a;
		yInc = b;
		this.rect = rect;
		this.board = board;

	}

	/**
	 * Draw every square individually
	 * 
	 * @param g2               The Graphics interfice
	 * @param i                The value of that position in the matrix
	 * @param type             Type (Color, Text or Sprite)
	 * @param colors           Color list
	 * @param actborder        Whether there will be a border between squares
	 * @param borderColor      Border color
	 * @param colorbackground  Background color, if not an img
	 * @param text             Text list
	 * @param colortext        List with the text color
	 * @param sprites          Sprite list
	 * @param actimgbackground Wheteher the background will be an image
	 * @param actfreedraw      Acivate freedraw feature
	 * @param freedrawx        Freedraw: X Weights
	 * @param freedrawy        Freedraw: Y Weights
	 * @param font
	 */
	public void draw(Graphics2D g2, int i, char type, int[] colors, boolean actborder, int borderColor,
			int colorbackground, String[] text, int[] colortext, String[] sprites, boolean actimgbackground,
			boolean actfreedraw, double[] freedrawx, double[] freedrawy, Font font) {
		value = i;
		if (type == 'c') {
			Color inside;
			try {
				inside = new Color(colors[value]);
			} catch (Exception e) {
				System.out.println("COLOR REPRESENTING VALUE " + value + " NOT FOUND. USING BLACK AS PER DEFAULT");
				inside = Color.black;
			}
			g2.setPaint(inside);
			g2.fill(rect);
		}
		if (actborder) {
			border = new Color(borderColor);
			g2.setPaint(border);
			g2.draw(rect);
		}

		if (type == 's') {

			try {
				if (!(sprites[value].equals(""))) { // An empty string represents no image (or transparency)
					Image img;

					img = new ImageIcon((sprites[value])).getImage();
					if (img.getWidth(null) == -1) {
						System.out.println(
								"IMAGE REPRESENTING VALUE " + value + " NOT FOUND. USING BLACK SQUARE AS PER DEFAULT");
						img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
					}

					if (actfreedraw) {
						g2.drawImage(img, (int) (x - (xInc * (freedrawx[value] - 1))),
								(int) (y - (yInc * (freedrawy[value] - 1))), (int) (x + xInc), (int) (y + yInc), 0, 0,
								img.getWidth(null), img.getHeight(null), board);
					} else {
						// g2.drawImage(img, 0, 0, 300, 300, null);

						g2.drawImage(img, (int) x, (int) y, (int) (x + xInc), (int) (y + yInc), 0, 0,
								img.getWidth(null), img.getHeight(null), board);
						// /This starts drawing over the corner. Change the first two parameters for
						// centered image.
					}

				}
			} catch (Exception e) {
				System.out.println("Error on image with value: " + value
						+ " \n possible cause: No sprite array or the sprite array is shorter than the maximum number on the matrix");
				// e.printStackTrace();
			}
		}
		if (type == 't') {
			Color inside;
			try {
				inside = new Color(colortext[value]);
			} catch (Exception e) {
				System.out.println("TEXTCOLOR REPRESENTING VALUE " + value + " NOT FOUND. USING BLACK AS PER DEFAULT");
				inside = Color.black;
			}
			g2.setPaint(inside);
			g2.setFont(font);
			g2.drawString(text[value], (int) (x), (int) ((y + (yInc + y) + font.getSize()) / 2));
			// On drawString the starting point is not the upper left, but the bottom left
			// On bigger fonts that means that if centered will go over the top
			// TODO afegir opcions de centrat??
		}
	}

}