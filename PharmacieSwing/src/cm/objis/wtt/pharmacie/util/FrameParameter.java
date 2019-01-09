package cm.objis.wtt.pharmacie.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * 
 * Classe utilitaire de manipulation des fenêtres
 * @author thierry WADJI
 *
 */
public class FrameParameter {
	
	/**
	 * Méthode qui centre les fenêtres au centre de l'écran.
	 * @param frame est un JFrame
	 */
	public static void centered(JFrame frame) {
		Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - frame.getWidth()) / 2;
        int iCoordY = (objDimension.height - frame.getHeight()) / 2;
        frame.setLocation(iCoordX, iCoordY);
	}

}
