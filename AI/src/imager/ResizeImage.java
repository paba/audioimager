package imager;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * Implements resizing of images.
 * @author Kumaripaba Athukorala
 *
 */
public class ResizeImage {

	private int newHeight, reqHeight;
	private int newWidth, reqWidth;
	private String alignment = null;

	ResizeImage(int height, int width, String position) {
		this.reqHeight = height;
		this.reqWidth = width;
		this.alignment = position;
	}

	public Image resize(BufferedImage buffImage) {
		BufferedImage bufferedImage = null;
		Image i = null;
		Image resizedImage = null;
		try {

			BufferedImage layer = buffImage;
			BufferedImage background;
			if (reqHeight == 90 && reqWidth == 120) {
				background = ImageIO.read(new File("black2.JPG"));
			} else {
				background = ImageIO.read(new File("black.JPG"));
			}

			int iWidth = 1;
			iWidth = layer.getWidth();
			int iHeight = 1;
			iHeight = layer.getHeight();

			int newWidth;

			if ((iWidth / 4) > (iHeight / 3)) {
				// newWidth = 640;
				newWidth = reqWidth;
			} else {
				// newWidth = (iWidth*480)/iHeight;
				newWidth = (iWidth * reqHeight) / iHeight;

			}

			if (alignment.equals("LEFT")) {
				resizedImage = layer.getScaledInstance(120, 90,
						Image.SCALE_SMOOTH);
				return resizedImage;
			}

			resizedImage = layer.getScaledInstance(newWidth,
					(newWidth * iHeight) / iWidth, Image.SCALE_SMOOTH);

			Image image = resizedImage;
			bufferedImage = new BufferedImage(image.getWidth(null), image
					.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufferedImage.createGraphics();
			g.drawImage(image, null, null);
			layer = bufferedImage;

			WritableRaster raster = background.getRaster();
			int width = layer.getWidth();
			int height = layer.getHeight();
			int lPixel, red, green, blue = 0;
			int dispWidth = (reqWidth - width) / 2;
			int dispHeight = (reqHeight - height) / 2;

			for (int w = 0; w < width; w++)
				for (int h = 0; h < height; h++) {
					lPixel = layer.getRGB(w, h);
					red = (int) ((lPixel & 0x00FF0000) >>> 16); // Red level
					green = (int) ((lPixel & 0x0000FF00) >>> 8); // Green level
					blue = (int) (lPixel & 0x000000FF); // Blue level
					raster.setPixel(w + dispWidth, h + dispHeight, new int[] {
							red, green, blue, 255 });
				}

			i = background.getScaledInstance(background.getWidth(), background
					.getHeight(), Image.SCALE_SMOOTH);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public Image resize(URL url) {
		BufferedImage bufferedImage = null;
		Image i = null;
		Image resizedImage = null;
		try {

			// ColorConvertOp cconverter = new ColorConvertOp((RenderingHints)
			// RenderingHints.VALUE_ANTIALIAS_DEFAULT);
			// BufferedImage
			// layer=cconverter.createCompatibleDestImage(ImageIO.read(url),ColorModel.getRGBdefault());

			BufferedImage layer = ImageIO.read(url);
			BufferedImage background;
			if (reqHeight == 90 && reqWidth == 120) {
				background = ImageIO.read(new File("black2.JPG"));
			} else {
				background = ImageIO.read(new File("black.JPG"));
			}

			int iWidth = 1;
			iWidth = layer.getWidth();
			int iHeight = 1;
			iHeight = layer.getHeight();

			int newWidth;

			// TODO
			if ((iWidth / 4) > (iHeight / 3)) {
				// newWidth = 640;
				newWidth = reqWidth;
			} else {
				// newWidth = (iWidth*480)/iHeight;
				newWidth = (iWidth * reqHeight) / iHeight;

			}

			if (alignment.equals("LEFT")) {
				resizedImage = layer.getScaledInstance(120, 90,
						Image.SCALE_SMOOTH);
				return resizedImage;
			}
			resizedImage = layer.getScaledInstance(newWidth,
					(newWidth * iHeight) / iWidth, Image.SCALE_SMOOTH);

			Image image = resizedImage;
			bufferedImage = new BufferedImage(image.getWidth(null), image
					.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufferedImage.createGraphics();
			g.drawImage(image, null, null);
			layer = bufferedImage;

			WritableRaster raster = background.getRaster();
			int width = layer.getWidth();
			int height = layer.getHeight();
			int lPixel, red, green, blue = 0;
			int dispWidth = (reqWidth - width) / 2;
			int dispHeight = (reqHeight - height) / 2;

			for (int w = 0; w < width; w++)
				for (int h = 0; h < height; h++) {
					lPixel = layer.getRGB(w, h);
					red = (int) ((lPixel & 0x00FF0000) >>> 16); // Red level
					green = (int) ((lPixel & 0x0000FF00) >>> 8); // Green level
					blue = (int) (lPixel & 0x000000FF); // Blue level
					raster.setPixel(w + dispWidth, h + dispHeight, new int[] {
							red, green, blue, 255 });
				}

			i = background.getScaledInstance(background.getWidth(), background
					.getHeight(), Image.SCALE_SMOOTH);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return i;
	}

	public Image resize(String path) {
		BufferedImage bufferedImage = null;
		Image i = null;
		Image resizedImage = null;
		try {

			BufferedImage layer = ImageIO.read(new File(path));

			BufferedImage background;

			if (reqHeight == 90 && reqWidth == 120) {
				background = ImageIO.read(new File("black2.JPG"));
			} else {
				background = ImageIO.read(new File("black.JPG"));
			}

			int iWidth = 1;
			iWidth = layer.getWidth();
			int iHeight = 1;
			iHeight = layer.getHeight();

			int newWidth;

			// TODO
			if ((iWidth / 4) > (iHeight / 3)) {
				// newWidth = 640;
				newWidth = reqWidth;
			} else {
				// newWidth = (iWidth*480)/iHeight;
				newWidth = (iWidth * reqHeight) / iHeight;

			}

			if (alignment.equals("LEFT")) {
				resizedImage = layer.getScaledInstance(120, 90,
						Image.SCALE_SMOOTH);
				return resizedImage;
			}

			resizedImage = layer.getScaledInstance(newWidth,
					(newWidth * iHeight) / iWidth, Image.SCALE_SMOOTH);

			Image image = resizedImage;
			bufferedImage = new BufferedImage(image.getWidth(null), image
					.getHeight(null), BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufferedImage.createGraphics();
			g.drawImage(image, null, null);
			layer = bufferedImage;

			WritableRaster raster = background.getRaster();
			int width = layer.getWidth();
			int height = layer.getHeight();
			int lPixel, red, green, blue = 0;
			int dispWidth = (reqWidth - width) / 2;
			int dispHeight = (reqHeight - height) / 2;

			for (int w = 0; w < width; w++)
				for (int h = 0; h < height; h++) {
					lPixel = layer.getRGB(w, h);
					red = (int) ((lPixel & 0x00FF0000) >>> 16); // Red level
					green = (int) ((lPixel & 0x0000FF00) >>> 8); // Green level
					blue = (int) (lPixel & 0x000000FF); // Blue level
					raster.setPixel(w + dispWidth, h + dispHeight, new int[] {
							red, green, blue, 255 });
				}

			i = background.getScaledInstance(background.getWidth(), background
					.getHeight(), Image.SCALE_SMOOTH);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

}
